package oleg.recipe_book.controller;

import oleg.recipe_book.model.Recipe;
import oleg.recipe_book.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Oleg on 19.02.2017.
 */
@RestController
@RequestMapping(value = "recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    private ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe){
           recipeService.add(recipe);
           return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }
}
