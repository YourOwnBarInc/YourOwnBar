package com.ukma.yourownbar.service.api;

import com.ukma.yourownbar.entity.Ingredient;

import java.util.List;

/**
 * Created with love.
 */

public interface SearchService {

    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(Integer id);
}

