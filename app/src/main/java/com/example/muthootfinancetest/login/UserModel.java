package com.example.muthootfinancetest.login;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {

    UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    String email, password;

    protected UserModel(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(password);
    }
}
