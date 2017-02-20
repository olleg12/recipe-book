package oleg.recipe_book.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Oleg on 18.02.2017.
 */
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
}
