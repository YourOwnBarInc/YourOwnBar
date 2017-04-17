package com.ukma.yourownbar.activity;


import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.ukma.yourownbar.R;
import com.ukma.yourownbar.entity.Ingredient;
import com.ukma.yourownbar.service.api.SearchService;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private EditText inputSearch;
    private SearchService searchService;
    private List<Ingredient> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initSearchView();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.ingredient_name, ingredients);
        listView.setAdapter(adapter);
    }

    private void initSearchView() {
        listView = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
    }
}
