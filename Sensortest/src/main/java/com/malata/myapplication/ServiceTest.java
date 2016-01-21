package com.malata.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by huangguoxiong on 15-8-18.
 */
public class ServiceTest extends Service{
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }


}
