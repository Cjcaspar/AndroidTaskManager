package com.connercaspar.taskmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class TabFragmentComplete extends Fragment {


    int position;
    private Callback callback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_complete, container, false);
    }

    @OnClick(R.id.add_task_button_complete)
    protected void addTaskButtonClicked() {callback.addTaskFragment();}

    public void attachParent(Callback callback) {this.callback = callback;}

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragmentComplete tabFragment = new TabFragmentComplete();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    public interface Callback {
        void addTaskFragment();
    }

    public static TabFragmentComplete newInstance() {
        Bundle args = new Bundle();

        TabFragmentComplete fragment = new TabFragmentComplete();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
