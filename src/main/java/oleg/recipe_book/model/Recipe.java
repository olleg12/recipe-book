package oleg.recipe_book.model;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Oleg on 18.02.2017.
 */
@Component
public class Recipe {
    private String name;
    private Map<Product,Integer> ingredients;
    private  long id;
}
