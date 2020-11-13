package miri.recipe.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"","/","/index"})
    public String getIndexPage(){
        System.out.println("1,2,3,4");
        return "index";
    }
}
