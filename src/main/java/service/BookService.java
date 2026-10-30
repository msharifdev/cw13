package service;

import entity.Book;
import entity.Loan;
import jakarta.persistence.EntityManager;
import repository.BookRepository;
import util.TransactionManager;

public class BookService {

    private final EntityManager entityManager;
    private final TransactionManager transactionManager;
    private final BookRepository bookRepository;

    public BookService(EntityManager entityManager, BookRepository bookRepository,TransactionManager transactionManager) {

        this.entityManager = entityManager;
        this.transactionManager =transactionManager;
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        Book fetchBook = bookRepository.findByIsbn(book.getIsbn());
        if (fetchBook != null) {
            throw new IllegalArgumentException("already exists");
        }
        transactionManager.execute(
                () -> {
                    bookRepository.save(book);
                    return book;
                }
        );


    }
}
