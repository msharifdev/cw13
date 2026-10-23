package repository;

import entity.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Number> {

    void save(E entity);

    void update(E entity);

    E findById(ID id);

    List<E> findAll();

    void deleteById(ID id);
}
