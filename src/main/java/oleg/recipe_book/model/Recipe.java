package oleg.recipe_book.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
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
    @Cascade(CascadeType.ALL)
    private Map<String,Integer> ingredients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }
}
