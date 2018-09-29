package com.studio.okheart.okheartweatherapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.studio.okheart.okheartweatherapp.R;
import com.studio.okheart.okheartweatherapp.models.CityItemModel;

import java.util.ArrayList;

public class CityItemAdapter extends RecyclerView.Adapter<CityItemAdapter.CityItemHolder> {

    private ArrayList<CityItemModel> itemList = new ArrayList<>();

    public void setItem(ArrayList<CityItemModel> items) {
        itemList.clear();
        itemList.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItem() {
        itemList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final CityItemHolder cityItemHolder = new CityItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item_view, parent, false));
        return cityItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CityItemHolder holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class CityItemHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

         private TextView tvCityItemName;

        public void bind(CityItemModel item){
            tvCityItemName.setText(item.getNameCity());
        }

        CityItemHolder(View view) {
            super(view);
            tvCityItemName = view.findViewById(R.id.tv_city_item_view);
            tvCityItemName.setOnLongClickListener(this);
            tvCityItemName.setOnClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
