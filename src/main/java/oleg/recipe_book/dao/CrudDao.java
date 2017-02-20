package oleg.recipe_book.dao;

/**
 * Created by Oleg on 19.02.2017.
 */
public interface CrudDao<E> {
    void add(E entity);
    void update(E entity);
    void delete(E entity);
    void getById(Long id);

}
