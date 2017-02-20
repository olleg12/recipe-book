package oleg.recipe_book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Oleg on 18.02.2017.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/k",method = GET)
    private String main(){
        return "index.html";
    }
}
