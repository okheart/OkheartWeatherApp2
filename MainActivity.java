package com.studio.okheart.okheartweatherapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.studio.okheart.okheartweatherapp.adapter.CityItemAdapter;
import com.studio.okheart.okheartweatherapp.dialog_fragment.DialogFragmentSelectCity;
import com.studio.okheart.okheartweatherapp.models.CityItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<CityItemModel> cityList;
    private CityItemAdapter cityItemAdapter;
    private FloatingActionButton fabAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragmentSelectCity.newInstance().show(getSupportFragmentManager(), "dialog");
            }
        });

        initRecyclerView();

        if(cityList != null && cityList.size() != 0) {
            cityItemAdapter.setItem(cityList);
        }else {
            cityList = new ArrayList<>();
        }
    }

    private void initRecyclerView(){
        RecyclerView rvCityList = findViewById(R.id.rv_city_list);
        rvCityList.setLayoutManager(new LinearLayoutManager(this));

        cityItemAdapter = new CityItemAdapter();
        rvCityList.setAdapter(cityItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_clear:
                allItemClear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void allItemClear(){
        cityList.clear();
        cityItemAdapter.clearItem();
    }

    public void addItem(String city){
        cityList.add(new CityItemModel(city));
        cityItemAdapter.setItem(cityList);
    }
}
