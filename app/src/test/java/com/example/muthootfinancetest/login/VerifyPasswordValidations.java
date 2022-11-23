package com.example.muthootfinancetest.login;

import androidx.lifecycle.MutableLiveData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class VerifyPasswordValidations {
    @Parameterized.Parameter(0)
    public String m1;
    @Parameterized.Parameter(1)
    public boolean result;

    @Spy
    @InjectMocks
    LoginViewModel loginViewModel;

    @Mock
    MutableLiveData<Integer> passwordError;

    @Parameterized.Parameters(name = "{index}: Test with m1={0}, result is:{1} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"", false}, {"asasd", false},
                {"AKDKA", false}, {"JAIWed", false}, {"JAIWed1", false},
                {"ASDsd1(", false}, {"ASDasd1()", true}};
        return Arrays.asList(data);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkValidations() {
        TestPasswordValidation testPasswordValidation = new TestPasswordValidation();
        Assert.assertEquals("Result", result, testPasswordValidation.isPasswordValid(m1));
    }

    private class TestPasswordValidation {
        public boolean isPasswordValid(String email) {
            return loginViewModel.isValidPassword(email);
        }
    }
}
