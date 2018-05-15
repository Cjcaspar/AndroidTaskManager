package com.connercaspar.taskmanager;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabFragmentComplete extends Fragment implements TaskDao{

    @BindView(R.id.complete_recycler_view)
    protected RecyclerView recyclerViewComplete;

    private TaskDatabase taskDatabase;
    private Adapter completeAdapter;
    private ArrayList<Task> completedTasks;
    private List<Task> taskList;
    int position;

    public static final String COMPLETE = "complete";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_complete, container, false);
        ButterKnife.bind(this, view);

        taskList = taskDatabase.taskDao().getTasks();
        completedTasks = getCompletedTasks(taskList);

        setupList();



        return view;

    }



    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragmentComplete tabFragment = new TabFragmentComplete();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


    public static TabFragmentComplete newInstance() {
        Bundle args = new Bundle();

        TabFragmentComplete fragment = new TabFragmentComplete();
        fragment.setArguments(args);
        return fragment;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
        taskDatabase = TaskDatabase.getDatabase(getContext());


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setupList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        completeAdapter = new Adapter(completedTasks);
        recyclerViewComplete.setAdapter(completeAdapter);

        recyclerViewComplete.setLayoutManager(linearLayoutManager);
        completeAdapter.notifyDataSetChanged();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onStart() {
        super.onStart();

    }

    private ArrayList<Task> getCompletedTasks(List<Task> taskList) {

        ArrayList<Task> completedTasks = new ArrayList<>();

        for (Task task : taskList) {
            if (task.isComplete()) {
                completedTasks.add(task);
            }
        }

        return completedTasks;
    }

    @Override
    public List<Task> getTasks() {
        return taskDatabase.taskDao().getTasks();
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void updateTasks(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }


}
