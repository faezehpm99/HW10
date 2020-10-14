package com.example.hw10.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hw10.Activity.TasksActivity;
import com.example.hw10.R;

public class LoginFragment extends Fragment {
private EditText mNameEditText;
private EditText mNumberEditText;
private Button mBuildButton;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        findViews(view);
        mBuildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent= new Intent(getActivity(),mNameEditText.getText().toString(),Integer.parseInt(mNumberEditText.getText().toString()) );*/
                Intent intent= new Intent(getActivity(), TasksActivity.class);
                Intent intent1= new Intent(getActivity(),TasksActivity.class);
                intent.putExtra("name",mNameEditText.getText().toString());
                intent.putExtra("number",Integer.parseInt(mNumberEditText.getText().toString()));
                startActivity(intent);
               /* startActivity(intent1);*/
            }
        });
        return view;
    }

    private void findViews(View view) {
        mNameEditText=view.findViewById(R.id.NameEditText);
        mNumberEditText=view.findViewById(R.id.NumberEditText);
        mBuildButton=view.findViewById(R.id.buildBtn);
    }
}