package com.example.muthootfinancetest.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.muthootfinancetest.R;
import com.example.muthootfinancetest.databinding.ActivityHomeBinding;
import com.example.muthootfinancetest.login.UserModel;
import com.example.muthootfinancetest.utils.ParamConstants;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setLifecycleOwner(this);

        getDataFromIntent();
    }

    private void getDataFromIntent() {
        binding.setUserModel((UserModel) getIntent().getParcelableExtra(ParamConstants.USER_DETAIL));
    }
}
