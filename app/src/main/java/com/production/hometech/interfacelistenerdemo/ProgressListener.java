package com.production.hometech.interfacelistenerdemo;

/**
 * Created by Arpit on 05-May-17.
 */

public interface ProgressListener {

    void progressStart();
    void progressStop();
    void getResponse(String response);

}
