package com.example.devanshi.retrofitdemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.model.Task;
import com.example.devanshi.retrofitdemo.util.Mypref;

import static com.example.devanshi.retrofitdemo.util.Mypref.Name;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment
{
   private TextView name;
   private Button list;
   private Mypref mypref=new Mypref();



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_home, container, false);
        name=view.findViewById(R.id.tv_name_home);
        list=view.findViewById(R.id.btnHomefragement);
            return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mypref.SharedPreferenceUtils(getActivity());
        name.setText(mypref.getStringValue(Name,""));
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                android.support.v4.app.FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container_1,new TaskFragment());
                ft.commit();
            }
        });
    }
}
