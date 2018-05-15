package com.connercaspar.taskmanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.connercaspar.taskmanager.MainActivity.TASK;

public class EditTaskFragment extends Fragment {

//    private EditTaskCallback callback;
//
//    private Task task;

//    @BindView(R.id.title_textview)
//    public TextView titleTextView;
//
//    @BindView(R.id.detail_textview)
//    public TextView detailTextView;
//
//    @BindView(R.id.due_date_textview)
//    public TextView dueDateTextView;
//
//    @BindView(R.id.priority_textview)
//    public TextView priorityTextView;
//
//    @BindView(R.id.title_edittext)
//    public TextInputEditText titleEditText;
//
//    @BindView(R.id.detail_edittext)
//    public TextInputEditText detailEditText;
//
//    @BindView(R.id.due_date_edittext)
//    public TextInputEditText dueDateEditText;
//
//    @BindView(R.id.priority_edittext)
//    public TextInputEditText priorityEditText;
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_edit_task, container, false);
//        ButterKnife.bind(this, view);
//        return view;
//    }
//
//    public static EditTaskFragment newInstance() {
//
//        Bundle args = new Bundle();
//        EditTaskFragment fragment = new EditTaskFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getArguments();
//    }
//
//    public void attachParent(EditTaskCallback callback) {
//        this.callback = callback;
//    }
//
//    public interface EditTaskCallback {
//        void editTask();
//        void markComplete(Task task);
//    }
}
