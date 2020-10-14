package com.example.hw10.Activity;

import androidx.fragment.app.Fragment;

import com.example.hw10.Fragment.TasksFragment;

public class TasksActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new TasksFragment();
    }
/*    public static Intent newIntent(Context context,String name,int number){
        Intent intent = new Intent(context, TasksActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("number",number);
        return intent;
    }*/
}