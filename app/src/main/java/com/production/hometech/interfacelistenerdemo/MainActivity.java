package com.production.hometech.interfacelistenerdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ProgressListener {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new JsonResponse().execute();

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setProgressListener(this);
        jsonResponse.execute();

        //Progg

        // prog stopp

        // response


    }


    @Override
    public void progressStart() {

        pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("Loading....");
        pd.show();

    }

    @Override
    public void progressStop() {
        pd.cancel();
    }

    @Override
    public void getResponse(String response) {

        Toast.makeText(this, "Response "+response, Toast.LENGTH_SHORT).show();

    }
}
