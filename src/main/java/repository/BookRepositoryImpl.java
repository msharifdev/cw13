package repository;

import entity.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book,Integer> implements BookRepository {

    public BookRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return entityManager.find(getEntityClass(), isbn);

    }

    @Override
    public List<Book> getMostBorrowedBooks() {
        return entityManager.createQuery("",Book.class).getResultList();



    }
}





