package com.example.cookncalc.recipes;

import com.example.cookncalc.recipeIngredient.RecipeIngredient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredient> recipeIngredient = new HashSet<>();

    private String description;

    private String preparation;

    private Instant createdAt;

    public Recipe(){
        this.createdAt = Instant.now();
    }

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdAt = Instant.now();
    }

    public Recipe(String title, String description, String preparation) {
        this.title = title;
        this.description = description;
        this.preparation = preparation;
        this.createdAt = Instant.now();
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Set<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(Set<RecipeIngredient> recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
