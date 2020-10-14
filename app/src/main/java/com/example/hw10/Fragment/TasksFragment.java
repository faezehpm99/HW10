package com.example.hw10.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hw10.Model.Job;
import com.example.hw10.R;

import java.util.ArrayList;
import java.util.List;


public class TasksFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private Job mJob;
    private int number;
    String name;
    List<Job> jobs;
    LinearLayout mLayout;

    public TasksFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         name = getActivity().getIntent().getStringExtra("name");
         number = getActivity().getIntent().getIntExtra("number",0);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
         jobs = new ArrayList(number);
        for (int i = 0; i <number ; i++) {
            Job job = new Job();
            job.setmJobName(name);
            job.setmState("doing");
            jobs.add(job);

        }
        mRecyclerView = view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TaskAdapter mAdapter =new TaskAdapter(jobs);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    private class TaskHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewName;
        private TextView mTextViewNumber;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.name);
            mTextViewNumber = itemView.findViewById(R.id.state);
            mLayout=itemView.findViewById(R.id.layout);

        }
        public void bindJob(Job job){
            mJob=job;
            job.setmJobName(jobs.get(0).getmJobName());
            job.setmState(job.getmState());
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Job> mJobs;

        public List<Job> getJobs() {
            return mJobs;
        }

        public void setJobs(List<Job> jobs) {
            this.mJobs = jobs;
        }

        public TaskAdapter(List<Job> jobs) {
            mJobs = jobs;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.list_row, parent, false);
            TaskHolder holder = new TaskHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        Job job=mJobs.get(position);
        holder.bindJob(job);
        holder.mTextViewName.setText(name);
        if(position%2==0){
            holder.mTextViewName.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        if(position%3==0){
            holder.mTextViewNumber.setText("doing");


        }
        if (position%3==1){
            holder.mTextViewNumber.setText("done");
        }

            if (position%3==2){
                holder.mTextViewNumber.setText("todo");

            }
        }

        @Override
        public int getItemCount() {
            return mJobs.size();
        }
    }
}