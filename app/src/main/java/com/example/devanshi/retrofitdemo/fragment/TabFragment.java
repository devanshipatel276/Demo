package com.example.devanshi.retrofitdemo.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devanshi.retrofitdemo.R;

/**
 * Created by Devanshi on 16-04-2018.
 */

@SuppressLint("ValidFragment")
public class TabFragment extends Fragment
{

    public TabFragment() {
        // Required empty public constructor


    }
    public static TabFragment newInstance(String param1, String param2) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView Data=view.findViewById(R.id.tabTvData);
        String staticdata="This is Your Tab ";
        String Tabnumber=getArguments().getString("TAB");
        Data.setText(staticdata + Tabnumber );


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab, container, false);
        return view;
    }
}
