package repository;

import entity.BaseEntity;

import javax.swing.text.html.parser.Entity;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Number> {

    void save(E entity);

    void update(E entity);

}
