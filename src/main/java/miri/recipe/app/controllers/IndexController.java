package miri.recipe.app.controllers;

import miri.recipe.app.domain.Category;
import miri.recipe.app.domain.UnitOfMeasure;
import miri.recipe.app.repositories.CategoryRepository;
import miri.recipe.app.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is "+ categoryOptional.get().getId());
        System.out.println("UOM ID is "+ unitOfMeasureOptional.get().getId());
        return "index";
    }


}
