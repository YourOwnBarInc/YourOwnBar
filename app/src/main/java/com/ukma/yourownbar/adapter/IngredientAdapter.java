package com.ukma.yourownbar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.ukma.yourownbar.entity.Ingredient;

import java.util.List;

/**
 * Created with love.
 */

public class IngredientAdapter extends BaseAdapter implements Filterable {

    private List<Ingredient> originalValues;
    private List<Ingredient> displayedValues;
    private LayoutInflater inflater;

    public IngredientAdapter(Context context, List<Ingredient> ingredientList) {
        this.originalValues = ingredientList;
        this.displayedValues = ingredientList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return displayedValues.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
