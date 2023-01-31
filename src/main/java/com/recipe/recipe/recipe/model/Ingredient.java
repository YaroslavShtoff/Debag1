package com.recipe.recipe.recipe.model;

import java.util.Objects;

public class Ingredient {
    private String title;
    private int amount;
    private String measureUnit;

    public Ingredient(String title) {
        this.title = title;
    }

    public Ingredient(String title, int amount, String measureUnit) {
        this.title = title;
        this.amount = amount;
        this.measureUnit = measureUnit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return amount == that.amount &&
                Objects.equals(title, that.title) &&
                Objects.equals(measureUnit, that.measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, amount, measureUnit);
    }
}


