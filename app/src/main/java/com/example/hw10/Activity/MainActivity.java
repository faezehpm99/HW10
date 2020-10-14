package com.example.hw10.Activity;

import androidx.fragment.app.Fragment;

import com.example.hw10.Fragment.LoginFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}

