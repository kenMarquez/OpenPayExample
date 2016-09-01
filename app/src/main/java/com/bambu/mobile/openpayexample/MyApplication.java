package com.bambu.mobile.openpayexample;

import android.app.Application;

import mx.openpay.android.Openpay;

/**
 * Created by kenmarquez on 30/08/16.
 */
public class MyApplication extends Application {

    private final Openpay openpay;

    public MyApplication() {

        this.openpay = new Openpay("mkjecedv6ihqi1zpb1gn", "sk_afe81e7e43d448f1b89a768528a4c775", false);
    }



    @Override
    public void onCreate() {
        super.onCreate();

    }


    public Openpay getOpenpay() {
        return this.openpay;
    }
}
