package com.recipe.recipe.recipe.controllers;

import com.recipe.recipe.recipe.model.Recipe;
import com.recipe.recipe.recipe.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe add(@RequestBody Recipe recipe) {
        return recipeService.add(recipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> get(@PathVariable long id) {
        return ResponseEntity.of(recipeService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable long id, @RequestBody Recipe ingredient) {
        return ResponseEntity.of(recipeService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable long id, @RequestBody Recipe ingredient) {
        return ResponseEntity.of(recipeService.delete(id));
    }

    @GetMapping
    public Map<Long, Recipe> getAll() {
        return recipeService.getAll();
    }
}
