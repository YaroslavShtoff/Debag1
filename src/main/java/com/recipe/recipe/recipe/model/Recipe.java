package com.recipe.recipe.recipe.model;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private String title;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;

    public Recipe(String title) {
        this.title = title;
    }

    public Recipe(String title, int cookingTime, List<Ingredient> ingredients, List<String> steps) {
        this.title = title;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTime == recipe.cookingTime &&
                Objects.equals(title, recipe.title) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(steps, recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cookingTime, ingredients, steps);
    }
}
