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
public class VerifyEmailValidations {
    @Parameterized.Parameter(0)
    public String m1;
    @Parameterized.Parameter(1)
    public boolean result;

    @Spy
    @InjectMocks
    LoginViewModel loginViewModel;

    @Mock
    MutableLiveData<Integer> emailError;

    @Parameterized.Parameters(name = "{index}: Test with m1={0}, result is:{1} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"", false}, {"sdfishefikehfilwhio@sdfk.sdvds", false},
                {"test.com", false}, {"test@gmail.co", false}, {"test@gmail.com", false},
                {"test1!@gmail.com", false}, {"test1@gmail.com", true}};
        return Arrays.asList(data);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkValidations() {
        TestEmailValidation testEmailValidation = new TestEmailValidation();
        Assert.assertEquals("Result", result, testEmailValidation.isEmailValid(m1));
    }

    private class TestEmailValidation {
        public boolean isEmailValid(String email) {
            return loginViewModel.isValidEmail(email);
        }
    }
}
