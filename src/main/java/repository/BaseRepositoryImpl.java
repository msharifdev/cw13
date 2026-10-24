package repository;

import entity.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

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


    public E findById(ID id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
         return entityManager.createQuery("SELECT e FROM  " + getEntityClass() + " e ",getEntityClass())
                .getResultList();


    }

    @Override
    public void deleteById(ID id) {
        EntityTransaction transaction = entityManager.getTransaction();
        E entity = entityManager.find(getEntityClass(), id);
        if (entity == null) {
            return;
        }

        try {
            transaction.begin();

            entityManager.remove(entity);
            transaction.commit();


        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error in delete", e);
        }
    }

    protected abstract Class<E> getEntityClass();

}
