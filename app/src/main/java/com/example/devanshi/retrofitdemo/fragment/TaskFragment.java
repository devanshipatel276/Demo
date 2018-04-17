package com.example.devanshi.retrofitdemo.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.adapter.TaskAdapter;
import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.model.Label;
import com.example.devanshi.retrofitdemo.model.Task;
import com.example.devanshi.retrofitdemo.util.CustomItemClickListener;
import com.example.devanshi.retrofitdemo.util.Mypref;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TaskFragment extends Fragment
{
    RecyclerView recyclerView;
    ArrayList<Task> list = new ArrayList<>();

    private Task task;
   private CheckBox checkBox;
     TaskAdapter adapter;
  private   DataBaseHandler db;
  private Button btn;
    private Mypref mypref=new Mypref();
    private static final String TAG="TaskFragment";


    public TaskFragment()
    {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        return inflater.inflate(R.layout.fragment_todo, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        db = new DataBaseHandler(getActivity());
        recyclerView = view.findViewById(R.id.todo_recyclerview);


        mypref.SharedPreferenceUtils(getActivity());
        String task_name=mypref.getStringValue("Name","");
        list=db.getAllTodo();
      // list=db.Taskjoin(task_name);
       adapter = new TaskAdapter(getContext(), list);
        adapter = new TaskAdapter(getContext(), list, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                checkBox = v.findViewById(R.id.checkbox_todo);

                if (checkBox.isChecked())
                {
                    checkBox.setChecked(false);

                }
                else
                {
                    checkBox.setChecked(true);
                }
            }

        });


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(layoutManager);

        adapter.setCustomObjectListener(new TaskAdapter.MyListener() {
            @Override
            public void refresh(ArrayList<Task> arrayList) {
                adapter = new TaskAdapter(getContext(), arrayList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

    }


}
