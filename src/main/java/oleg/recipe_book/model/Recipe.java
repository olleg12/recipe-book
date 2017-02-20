package oleg.recipe_book.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Oleg on 18.02.2017.
 */

@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    @ElementCollection
    private Map<Product,Integer> ingredients;

}
