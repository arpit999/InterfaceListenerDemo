package com.production.hometech.interfacelistenerdemo;

import android.os.AsyncTask;
import android.speech.tts.Voice;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Arpit on 05-May-17.
 */

public class JsonResponse extends AsyncTask<Void, Void, String> {

    ProgressListener listener;

    public void setProgressListener(ProgressListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (listener != null)
            listener.progressStart();

    }

    @Override
    protected String doInBackground(Void... voids) {

        String responseString = null;

        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url("http://api.androidhive.info/json/movies.json")
                .post(formBody)
                .build();

        try {

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            {

                responseString = response.body().string();
                System.out.println(responseString);
                response.body().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseString;
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);

        if (listener != null) {
            listener.progressStop();
            listener.getResponse(string);
        }

    }


}
