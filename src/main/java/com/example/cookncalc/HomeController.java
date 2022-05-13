package com.example.cookncalc;

import com.example.cookncalc.ingredient.IngredientDTO;
import com.example.cookncalc.json.RecipeWithIngredientsDTO;
import com.example.cookncalc.recipes.Recipe;
import com.example.cookncalc.recipes.RecipeDTO;
import com.example.cookncalc.recipes.RecipeRepository;
import com.example.cookncalc.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    private final RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    @Autowired
    public HomeController(RecipeRepository recipeRepository,
                          RecipeService recipeService){
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
    }

    @GetMapping("/api")
    public List<RecipeDTO> home(){
        return recipeService.showRecipes();
    }

    @GetMapping("/api/recipe/{id}")
    public RecipeWithIngredientsDTO detail(@PathVariable Long id){
        return recipeService.showDetailRecipe(id);
    }

    @PostMapping("/api/addRecipe")
    public void add(@RequestBody RecipeWithIngredientsDTO dto){
        recipeService.addRecipe(dto);
    }

    @GetMapping("/api/ingredients")
    public List<IngredientDTO> fillDropdown() {
        return recipeService.ingredientsForDropdown();
    }

    @DeleteMapping("/api/deleteRecipe/{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
    }
}