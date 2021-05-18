package com.example.ddapp;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class DDAdapter extends RecyclerView.Adapter<DDAdapter.DDViewHolder> {

    private String[] localDataSet;
    private FragmentManager mfragmentManager;
    private Context mContext;
    private boolean fTest = true;

    public DDAdapter(Context context, FragmentManager fragmentManager){
        mfragmentManager = fragmentManager;
        mContext = context;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class DDViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;



        public DDViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public DDAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DDViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new DDViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(DDViewHolder ddViewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        final String id = localDataSet[position];
        ddViewHolder.getTextView().setText(localDataSet[position]);
        ddViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                Bundle bundle = getChar(id);
                mfragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.nav_host_fragment, DetailsFragment.setInstance(bundle))
                        .commit();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    //Bundle
    public Bundle getChar(String id){

        Bundle textBundle = new Bundle();
        textBundle.putString("id", id);
        return textBundle;
    }
}
