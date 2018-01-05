package com.greenfox.kalendaryo.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lica on 2018. 01. 04..
 */

public class KalPref {
    private SharedPreferences sharedPref;
    private List<String> accounts;


    public KalPref(Context context) {
        this.sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String list = this.sharedPref.getString("accountslist", "");
        if (list.equals("")) {
            this.accounts = new ArrayList<>();
        } else {
            Gson gson = new Gson();
            this.accounts = gson.fromJson(list, ArrayList.class);
        }
    }

    public void putSting(String key, String value) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return this.sharedPref.getString(key, "");
    }

    public void putAuth(String key, KalAuth kalAuth) {
        Gson gson = new Gson();
        String value = gson.toJson(kalAuth);
        this.putSting(key, value);
    }

    public KalAuth getAuth(String key) {
        Gson gson = new Gson();
        String value = this.getString(key);
        KalAuth kalAuth = gson.fromJson(value, KalAuth.class);
        return kalAuth;
    }

    public void addAccount(String accountName) {
        Gson gson = new Gson();
        accounts.add(accountName);
        String value = gson.toJson(accounts);
        this.putSting("accountslist", value);
    }

    public void removeAccount(String accountName) {
        Gson gson = new Gson();
        accounts.remove(accountName);
        String value = gson.toJson(accounts);
        this.putSting("accountslist", value);
    }

    public List<String> getAccounts() {
        return this.accounts;
    }



}
