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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabFragmentIncomplete extends Fragment implements TaskDao{

    @BindView(R.id.incomplete_recycler_view)
    protected RecyclerView recyclerViewIncomplete;

    private TaskDatabase taskDatabase;
    private Adapter incompleteAdapter;
    private List<Task> incompleteTasks;
    private List<Task> taskList;

    int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_incomplete, container, false);
        ButterKnife.bind(this, view);

        taskList = taskDatabase.taskDao().getTasks();
        incompleteTasks = getIncompleteTasks(taskList);

        setupList();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onStart() {
        super.onStart();
        incompleteAdapter.notifyDataSetChanged();
    }

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragmentIncomplete tabFragment = new TabFragmentIncomplete();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
        taskDatabase = TaskDatabase.getDatabase(getContext());

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

    private void setupList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());


        incompleteAdapter = new Adapter(incompleteTasks);
        recyclerViewIncomplete.setAdapter(incompleteAdapter);

        recyclerViewIncomplete.setLayoutManager(linearLayoutManager);

        incompleteAdapter.notifyDataSetChanged();
    }

    private ArrayList<Task> getIncompleteTasks(List<Task> taskList) {

        ArrayList<Task> incompleteTasks = new ArrayList<>();

        for (Task task : taskList) {
            if (!task.isComplete()) {
                incompleteTasks.add(task);
            }
        }

        return incompleteTasks;
    }
}
