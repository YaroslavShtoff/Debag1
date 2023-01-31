package com.recipe.recipe.recipe.service;


import com.recipe.recipe.recipe.model.Ingredient;
import com.recipe.recipe.recipe.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class ValidateService {

    public boolean isNotValidate(Recipe recipe) {
        return !StringUtils.isEmpty(recipe.getTitle()) ||
                CollectionUtils.isEmpty(recipe.getIngredients()) ||
                CollectionUtils.isEmpty(recipe.getSteps()) ||
                recipe.getCookingTime() <= 0;

    }

    public boolean isNotValidate(Ingredient ingredient) {
        return StringUtils.isEmpty (ingredient.getTitle()) &&
                !StringUtils.isEmpty(ingredient.getMeasureUnit()) &&
                ingredient.getAmount() > 0;

    }

}

