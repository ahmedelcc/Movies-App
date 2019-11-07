package com.example.movieshow;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {  private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static final String KEY_EMAIl="email";
    private static final String KEY_PASSWORD="password";
    private static final String PREF_NAME ="UserPref";
    private static final String IS_LOGIN ="IsLogedIn";

    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        pref =context.getSharedPreferences(PREF_NAME,0);
        editor = pref.edit();
    }
     public void createLoginSession(String email, String pass ){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_EMAIl,email);
        editor.putString(KEY_PASSWORD,pass);
        //editor.putString(PREF_NAME,name);
        editor.commit();
    }



    public boolean checkLogin(){
        return this.IsLoggedIn();
    }
    private boolean IsLoggedIn() {
        return pref.getBoolean(IS_LOGIN,false);
    }

    public HashMap<String,String> getUserDetails(){
        HashMap<String,String> user =new HashMap<>();
        user.put(KEY_EMAIl,pref.getString(KEY_EMAIl,null));
        user.put(KEY_PASSWORD,pref.getString(KEY_PASSWORD,null));
        //user.put(PREF_NAME,pref.getString(PREF_NAME,null));
        return user;
    }
    public void logoutUser(){

        editor.clear();
        editor.commit();
    }


}

