package com.mobeyosoft.recyclerviewsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
   TextView txtLinear;
    TextView txtGrid;
    TextView txtStaggered;
    private Toolbar mToolbar;
    CardView cardGridLayout;
    CardView cardLinearLayout;
    CardView cardStaggeredGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setListeners();
    }
    private void initComponents(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        txtLinear = (TextView)findViewById(R.id.txt_linear);
        txtGrid = (TextView)findViewById(R.id.txt_grid);
        txtStaggered = (TextView)findViewById(R.id.txt_staggered);
        cardLinearLayout = (CardView) findViewById(R.id.cardLinearLayout);
        cardGridLayout = (CardView) findViewById(R.id.cardGridLayout);
        cardStaggeredGridLayout = (CardView) findViewById(R.id.cardStaggeredGridLayout);
    }
    private void setListeners(){
        cardLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LinearLayoutManagerActivity.class);
                startActivity(i);
            }
        });

        cardGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GridLayoutManagerActivity.class);
                startActivity(i);
            }
        });

        cardStaggeredGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StaggeredGridLayoutManagerActivity.class);
                startActivity(i);
            }
        });
    }
}
