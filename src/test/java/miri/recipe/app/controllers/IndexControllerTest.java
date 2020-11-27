package miri.recipe.app.controllers;

import com.sun.javaws.JnlpxArgs;
import miri.recipe.app.domain.Recipe;
import miri.recipe.app.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IndexControllerTest {

    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    IndexController controller;

    @BeforeAll
    public void setUp()throws Exception{
        MockitoAnnotations.initMocks(this);

        controller= new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());

        //when(recipeService.getRecipes().thenReturn(recipes));

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = controller.getIndexPage(model);

        assertEquals("index",viewName);



    }

}