package br.com.christianfelps.mapper.custom;

import br.com.christianfelps.data.dto.BookDTO;
import br.com.christianfelps.model.Book;

public class BookMapper {
    
    public BookDTO convertEntityToDTO (Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setLaunchDate(book.getLaunchDate());
        dto.setPrice(book.getPrice());
        return dto;
    }
    public Book convertDTOToEntity (BookDTO book) {
        Book entity = new Book();
        entity.setId(book.getId());
        entity.setAuthor(book.getAuthor());
        entity.setTitle(book.getTitle());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        return entity;
    }
    
}
