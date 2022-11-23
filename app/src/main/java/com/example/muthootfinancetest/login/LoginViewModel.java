package com.example.muthootfinancetest.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.muthootfinancetest.R;

import java.util.regex.Pattern;

public class LoginViewModel extends ViewModel {

    public String email = "", password = "";

    MutableLiveData<Integer> emailError = new MutableLiveData<>();
    MutableLiveData<Integer> passwordError = new MutableLiveData<>();
    MutableLiveData<UserModel> user = new MutableLiveData<>();
    public static final Pattern EMAIL_PATTERN = Pattern.compile("(?=^.{7,20}$)[a-zA-Z0-9]+[0-9]+([A-Za-z0-9]*)*@[A-Za-z0-9]+.com$");
    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%)(^&*-]).{8,}$");


    boolean isValidEmail(String email) {
        if (!EMAIL_PATTERN.matcher(email).find()) {
            emailError.postValue(R.string.email_should_be_valid);
            return false;
        } else {
            emailError.postValue(null);
            return true;
        }
    }

    boolean isValidPassword(String password) {
        if (!PASSWORD_PATTERN.matcher(password).find()) {
            passwordError.postValue(R.string.password_should_be_valid);
            return false;
        } else {
            passwordError.postValue(null);
            return true;
        }
    }

    public void loginClick() {
        if (isValidEmail(email) && isValidPassword(password)) {
            user.postValue(new UserModel(email, password));
        }
    }

}
