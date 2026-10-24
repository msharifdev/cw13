package repository;

import entity.Book;

import java.util.List;

public interface BookRepository extends BaseRepository<Book,Integer> {

    Book findByIsbn(String isbn);
 List<Book> getMostBorrowedBooks();

}
