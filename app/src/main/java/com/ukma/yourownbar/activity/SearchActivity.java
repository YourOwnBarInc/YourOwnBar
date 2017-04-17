package com.ukma.yourownbar.activity;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ukma.yourownbar.R;
import com.ukma.yourownbar.entity.Ingredient;
import com.ukma.yourownbar.service.api.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ListView listView;
    private IngredientAdapter adapter;
    private EditText inputSearch;
    private SearchService searchService;
    private List<Ingredient> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initSearchView();
        adapter = new IngredientAdapter(this, ingredients);
        listView.setAdapter(adapter);
    }

    private void initSearchView() {
        listView = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
    }


    private class IngredientAdapter extends BaseAdapter implements Filterable {

        private List<Ingredient> originalValues;
        private List<Ingredient> displayedValues;
        private LayoutInflater inflater;

        private class IngredientViewHolder {
            private LinearLayout container;
            private TextView ingredientName,ingredientAbv;

            TextView getIngredientAbv() {
                return ingredientAbv;
            }

            void setIngredientAbv(TextView ingredientAbv) {
                this.ingredientAbv = ingredientAbv;
            }

            TextView getIngredientName() {
                return ingredientName;
            }

            void setIngredientName(TextView ingredientName) {
                this.ingredientName = ingredientName;
            }

            LinearLayout getContainer() {
                return container;
            }

            void setContainer(LinearLayout container) {
                this.container = container;
            }
        }

        IngredientAdapter(Context context, List<Ingredient> ingredientList) {
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            IngredientViewHolder holder;
            if (convertView == null) {
                holder = new IngredientViewHolder();
                convertView = inflater.inflate(R.layout.list_item, null);
                holder.setContainer((LinearLayout)convertView.findViewById(R.id.container));
                holder.setIngredientName((TextView) convertView.findViewById(R.id.ingredient_name));
                holder.setIngredientAbv((TextView) convertView.findViewById(R.id.ingredient_abv));
                convertView.setTag(holder);
            } else {
                holder = (IngredientViewHolder) convertView.getTag();
            }
            holder.getIngredientName().setText(displayedValues.get(position).getName());
            holder.getIngredientAbv().setText(displayedValues.get(position).getAbv().toString());

            holder.getContainer().setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {

                    Toast.makeText(SearchActivity.this, displayedValues.get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        @Override
        public Filter getFilter() {
            return new Filter() {

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint,FilterResults results) {
                    displayedValues = (List<Ingredient>) results.values;
                    notifyDataSetChanged();
                }

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();
                    List<Ingredient> FilteredArrList = new ArrayList<>();

                    if (originalValues == null) {
                        originalValues = new ArrayList<>(displayedValues);
                    }
                    if (constraint == null || constraint.length() == 0) {
                        results.count = originalValues.size();
                        results.values = originalValues;
                    } else {
                        constraint = constraint.toString().toLowerCase();
                        for (int i = 0; i < originalValues.size(); i++) {
                            String data = originalValues.get(i).getName();
                            if (data.toLowerCase().startsWith(constraint.toString())) {
                                FilteredArrList.add(originalValues.get(i));
                            }
                        }
                        results.count = FilteredArrList.size();
                        results.values = FilteredArrList;
                    }
                    return results;
                }
            };
        }
    }

}
