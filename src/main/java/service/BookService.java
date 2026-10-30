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

    public BookService(EntityManager entityManager, BookRepository bookRepository) {

        this.entityManager = entityManager;
        this.transactionManager = new TransactionManager(entityManager);
        this.bookRepository = bookRepository;
    }
    public void addBook (Book book){


    }
}
