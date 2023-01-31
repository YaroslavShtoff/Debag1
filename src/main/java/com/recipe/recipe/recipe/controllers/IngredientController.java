package com.recipe.recipe.recipe.controllers;


import com.recipe.recipe.recipe.model.Ingredient;
import com.recipe.recipe.recipe.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public Ingredient add(@RequestBody Ingredient ingredient) {
        return ingredientService.add(ingredient);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> get(@PathVariable long id) {
        return ResponseEntity.of(ingredientService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient>  update(@PathVariable long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.get(id));    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable long id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.of(ingredientService.delete(id));
    }
    @GetMapping
    public Map<Long,Ingredient> getAll() {
        return ingredientService.getAll();
    }

    @PostMapping("/import")
    public void importData(@RequestParam("file") MultipartFile multipartFile) {
        try {
            ingredientService.importData(multipartFile.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
