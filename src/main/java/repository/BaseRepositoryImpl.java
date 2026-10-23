package repository;

import entity.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Number> implements BaseRepository<E, ID> {

    protected EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(E entity) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            throw new RuntimeException("error in save", e);
        }
    }

    public void update(E entity) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {

            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();

        } catch (Exception e) {

            transaction.rollback();
            throw new RuntimeException("error in update", e);
        }
    }
}
