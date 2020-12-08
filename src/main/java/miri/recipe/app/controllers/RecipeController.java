package miri.recipe.app.controllers;

import miri.recipe.app.commands.RecipesCommand;
import miri.recipe.app.services.RecipeService;
import miri.recipe.app.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe",recipeService.findById(new Long(id)));
        return "/recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe",new RecipesCommand());
        return "/recipe/recipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

    @PostMapping("recipe/")
    public String saveOrUpdate(@ModelAttribute RecipesCommand command){
        RecipesCommand savedCommand= recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show/" + savedCommand.getId();
    }
}
