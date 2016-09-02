package com.bambu.mobile.openpayexample;

import android.app.Application;

import mx.openpay.android.Openpay;

/**
 * Created by kenmarquez on 30/08/16.
 */
public class MyApplication extends Application {

    private final Openpay openpay;

    public MyApplication() {
        this.openpay = new Openpay("mkjecedv6ihqi1zpb1gn", "pk_198ba64bbb7c40f499f4032bcae77e7c", false);
    }




    @Override
    public void onCreate() {
        super.onCreate();

    }


    public Openpay getOpenpay() {
        return this.openpay;
    }
}
