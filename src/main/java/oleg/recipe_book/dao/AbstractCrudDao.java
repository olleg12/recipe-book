package oleg.recipe_book.dao;

import oleg.recipe_book.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractCrudDao<E> implements CrudDao<E> {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(E entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(E entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(E entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void getById(Long id) {
        getCurrentSession().get(Product.class, id);
    }
}
