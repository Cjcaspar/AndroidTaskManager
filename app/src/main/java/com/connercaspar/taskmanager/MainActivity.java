package com.connercaspar.taskmanager;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AddTaskFragment.AddTaskCallback, TaskDao {


    private AddTaskFragment addTaskFragment;
    private TaskDatabase taskDatabase;
    private List<Task> taskList;

    private ArrayList<Task> completedTasks;
    private ArrayList<Task> incompleteTasks;

    public static final String TASK = "task";


    @BindView(R.id.tabs)
    protected TabLayout tabLayout;

    @BindView(R.id.viewpager)
    protected ViewPager viewPager;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ViewPageAdapter tabAdapter = new ViewPageAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(tabAdapter);


        tabLayout.setupWithViewPager(viewPager);

        taskDatabase = TaskDatabase.getDatabase(this);





        setupLists();


    }

    @Override
    public List<Task> getTasks() {
        return taskDatabase.taskDao().getTasks();
    }

    @Override
    public void addTask(Task task) {
        taskDatabase.taskDao().addTask(task);
        getSupportFragmentManager().beginTransaction().remove(addTaskFragment).commit();
        Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateTasks(Task task) {
        taskDatabase.taskDao().updateTasks(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskDatabase.taskDao().deleteTask(task);
    }

    @OnClick(R.id.add_task_button)
    protected void launchAddTaskFragment() {
        addTaskFragment = AddTaskFragment.newInstance();
        addTaskFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, addTaskFragment).commit();
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setupLists() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStart() {
        super.onStart();
        taskList = taskDatabase.taskDao().getTasks();
    }

}
