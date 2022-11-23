package com.example.muthootfinancetest.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.muthootfinancetest.R;
import com.example.muthootfinancetest.databinding.ActivityLoginBinding;
import com.example.muthootfinancetest.home.HomeActivity;
import com.example.muthootfinancetest.utils.ParamConstants;

public class LoginActivity extends AppCompatActivity {

    public LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setViewModel(loginViewModel);

        setUpObservers();
    }

    private void setUpObservers() {
        loginViewModel.emailError.observe(this, integer -> {
            if (integer == null)
                binding.etEmail.setError(null);
            else
                binding.etEmail.setError(getString(integer));
        });
        loginViewModel.passwordError.observe(this, integer -> {
            if (integer == null)
                binding.etPassword.setError(null);
            else
                binding.etPassword.setError(getString(integer));
        });
        loginViewModel.user.observe(this, userModel -> {
            startActivity(new Intent(this, HomeActivity.class)
                    .putExtra(ParamConstants.USER_DETAIL, userModel));
        });
    }
}