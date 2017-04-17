package com.ukma.yourownbar.service.impl;

import com.ukma.yourownbar.entity.Ingredient;
import com.ukma.yourownbar.service.api.SearchService;

import java.util.Collections;
import java.util.List;

/**
 * Created with love.
 */

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Ingredient> getAllIngredients() {
        return Collections.emptyList();
    }

    @Override
    public Ingredient getIngredientById(Integer id) {
        return new Ingredient();
    }
}
