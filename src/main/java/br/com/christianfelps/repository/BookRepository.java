package br.com.christianfelps.repository;

import br.com.christianfelps.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
