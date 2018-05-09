package com.connercaspar.taskmanager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AddTaskFragment.AddTaskCallback{

    private AddTaskFragment addTaskFragment;

    @BindView(R.id.tabs)
    protected TabLayout tabLayout;

    @BindView(R.id.viewpager)
    protected ViewPager viewPager;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
   }

   @Override
   public void addTask() {

   }

   private void launchAddTaskFragment() {
        addTaskFragment = AddTaskFragment.newInstance();
        addTaskFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, addTaskFragment).commit();
   }
}
