package com.connercaspar.taskmanager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.OnClick;

import static com.connercaspar.taskmanager.MainActivity.TASK;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final Callback callback;
    private EditTaskFragment editTaskFragment;
    List<Task> taskList;

    public Adapter(List<Task> taskList, Callback callback) {
        this.taskList = taskList;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(position);
        holder.layout.setOnClickListener(holder.onItemClicked(taskList.get(position)));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void updateList(List<Task> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView taskTitle;
        private TextView dueDate;
        private ConstraintLayout layout;


        public ViewHolder(View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.item_title);
            dueDate = itemView.findViewById(R.id.item_due_date);
            layout = itemView.findViewById(R.id.item_row_layout);
            //root = dueDate.getRootView();
        }

        public void bind(int position) {
            taskTitle.setText(taskList.get(position).getTitle());
            dueDate.setText(taskList.get(position).getDueDate());
//            if (taskList.get(position).isPriority()) {
//                root.setBackgroundColor(ContextCompat.getColor(root.getContext(), R.color.colorAccent));
//            }
        }




        private void fragmentJump(Task task) {
//            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
//            editTaskFragment = new EditTaskFragment();
//            Bundle bundle = new Bundle();
//            bundle.putParcelable(TASK, task);
//            editTaskFragment.setArguments(bundle);
//
//            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, editTaskFragment).addToBackStack(null).commit();


        }


        public View.OnClickListener onItemClicked(final Task task) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onTaskClicked(task);
                }
            };
        }
    }

    interface Callback {
        void onTaskClicked(Task task);
    }

}
