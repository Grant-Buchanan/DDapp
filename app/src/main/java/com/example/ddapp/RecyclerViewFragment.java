package com.example.ddapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragment extends Fragment implements CharacterListAdapter.OnClickListener {

    FragmentManager mFragmentManager;
    CharacterListAdapter mAdapter;
    CharacterRepository repo;
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;

    protected RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    private DetailsViewModel mDetailsViewModel;
    public static final int NEW_CHARACTER_ACTIVITY_REQUEST_CODE = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        rootView.setTag(TAG);



        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new CharacterListAdapter(new CharacterListAdapter.CharDiff(), repo, getContext(), this);

        mDetailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        mRecyclerView.setAdapter(mAdapter);

        mDetailsViewModel.getAllCharacters().observe(getViewLifecycleOwner(), characters -> {
            mAdapter.submitList(characters);
        });


        return rootView;

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onCharacterClick(int position) {
        Bundle bundle = mAdapter.getCharacterData(position);
        DetailsFragment fragment = new DetailsFragment().setInstance(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frag, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
