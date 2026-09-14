package br.com.christianfelps.service;

import br.com.christianfelps.controllers.BookController;
import br.com.christianfelps.data.dto.BookDTO;
import br.com.christianfelps.exception.RequiredObjectIsNullException;
import br.com.christianfelps.model.Book;
import br.com.christianfelps.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.christianfelps.mapper.ObjectMapper.parseListObjects;
import static br.com.christianfelps.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {
    private final Logger logger = Logger.getLogger(BookService.class.getName());
    @Autowired
    BookRepository repository;






    public List<BookDTO> findAll() {
        logger.info("Finding all book");
        var book = parseListObjects(repository.findAll(), BookDTO.class);
        book.forEach(BookService::addHateoasLinks);
        return book;
    }



    public BookDTO findById(Long id) {
        logger.info("Finding one book");

        var entity = repository.findById(id)
                .orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        var dto =  parseObject(entity, BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public BookDTO create (BookDTO book) {

        if(book == null) throw new RequiredObjectIsNullException();
        logger.info("Creating a new book");
        var entity = parseObject(book, Book.class);
        var dto = parseObject(repository.save(entity), BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }


    public BookDTO update (BookDTO book) {
        if(book == null) throw new RequiredObjectIsNullException();
        logger.info("Updating a new book");
        Book entity = repository.findById(book.getId()).orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        entity.setAuthor(book.getAuthor());
        entity.setTitle(book.getTitle());
        entity.setPrice(book.getPrice());
        entity.setLaunchDate(book.getLaunchDate());

        var dto = parseObject(repository.save(entity), BookDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting a book");
        Book entity = repository.findById(id)
                .orElseThrow(() -> new RequiredObjectIsNullException("No records found for this ID"));
        repository.delete(entity);

    }

    private static void addHateoasLinks(BookDTO dto) {
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }

}
