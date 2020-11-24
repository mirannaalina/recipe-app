package miri.recipe.app.controllers;

import miri.recipe.app.domain.Category;
import miri.recipe.app.domain.UnitOfMeasure;
import miri.recipe.app.repositories.CategoryRepository;
import miri.recipe.app.repositories.UnitOfMeasureRepository;
import miri.recipe.app.services.RecipeSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {


    private final RecipeSevice recipeSevice;

    public IndexController(RecipeSevice recipeSevice) {
        this.recipeSevice=  recipeSevice;
    }

    @GetMapping({"","/","/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes",recipeSevice.getRecipes());

        return "index";
    }


}
