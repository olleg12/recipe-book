package oleg.recipe_book.model;



import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Oleg on 18.02.2017.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String login;
    private String pasword;

}
