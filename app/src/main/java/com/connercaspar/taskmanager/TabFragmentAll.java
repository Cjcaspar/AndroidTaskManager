package com.connercaspar.taskmanager;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class TabFragmentAll extends Fragment {

    private int position;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_all, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static TabFragmentAll newInstance() {

        Bundle args = new Bundle();
        TabFragmentAll fragment = new TabFragmentAll();
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragmentAll tabFragment = new TabFragmentAll();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


}
