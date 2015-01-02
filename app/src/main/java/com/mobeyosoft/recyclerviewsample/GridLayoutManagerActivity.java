package com.mobeyosoft.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GridLayoutManagerActivity extends ActionBarActivity {
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_manager);
        initComponents();
    }

    private void initComponents(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Grid Layout");
        String[] myDataset={" One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
        int[]myImages = {R.drawable.img1 ,R.drawable.img2 ,R.drawable.img3, R.drawable.img4 ,R.drawable.img5 ,R.drawable.img6 ,R.drawable.img7 ,R.drawable.img8 ,R.drawable.img9};
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset,myImages);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] mDataset;
        private int[] mImages;

        public  class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;
            public ImageView mImageView;
            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView)v.findViewById(R.id.txt);
                mImageView = (ImageView)v.findViewById(R.id.img);
            }
        }

        public MyAdapter(String[] myDataset, int[] myImages) {
            mDataset = myDataset;
            mImages = myImages;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view_grid, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset[position]);
            holder.mImageView.setImageResource(mImages[position]);
        }

        public int getItemCount() {
            return mDataset.length;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
