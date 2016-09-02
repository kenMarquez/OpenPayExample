package com.bambu.mobile.openpayexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import mx.openpay.android.Openpay;
import mx.openpay.android.OperationCallBack;
import mx.openpay.android.OperationResult;
import mx.openpay.android.exceptions.OpenpayServiceException;
import mx.openpay.android.exceptions.ServiceUnavailableException;
import mx.openpay.android.model.Card;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Card card = new Card();
        card.holderName("Omar ramirez");
        card.cardNumber("4242424242424242");
        card.expirationMonth(11);
        card.expirationYear(19);
        card.cvv2("111");

        Openpay openpay = ((MyApplication) this.getApplication()).getOpenpay();
        String deviceSessionId = openpay.getDeviceCollectorDefaultImpl()
                .setup(this);
        log("deviceId: " + deviceSessionId);

        openpay.createToken(card, new OperationCallBack() {

            @Override
            public void onSuccess(OperationResult arg0) {
                //Handlo in success
//
//               log(arg0.getResult().f);
                log(arg0.getResult().toString());
            }

            @Override
            public void onError(OpenpayServiceException arg0) {
                log("Error: " + arg0.toString());
                log("Error: " + arg0.getMessage());
                log("Error: " + arg0.getCategory());
                log("Error Code: " + arg0.getErrorCode());
                arg0.printStackTrace();
            }

            @Override
            public void onCommunicationError(ServiceUnavailableException arg0) {
                log("ErrorService: " + arg0.toString());
                log("ErrorService: " + arg0.getMessage());
                arg0.printStackTrace();
            }
        });
    }

    public void log(String content) {
        Log.e("myLog", content);
    }
}
