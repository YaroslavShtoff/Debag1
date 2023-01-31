package com.recipe.recipe.recipe.controllers;

import com.recipe.recipe.recipe.service.RecipeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

  /*  @PostMapping
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
    }*/
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(){
        byte[] data = recipeService.download();
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .contentLength(data.length)
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipes.txt\"")
                .body(data);
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> export(){
        byte[] data = recipeService.export();
        if (data == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok()
                .contentLength(data.length)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipes.json\"")
                .body(data);
    }
    @PostMapping("/import")
    public void importData(@RequestParam("file") MultipartFile multipartFile) {
        try {
            recipeService.importData(multipartFile.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
