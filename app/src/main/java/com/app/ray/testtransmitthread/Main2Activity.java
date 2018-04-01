package com.app.ray.testtransmitthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    public static final int MESSAGE_READ = 1;
    private ArrayList<ClientData> arrData = new ArrayList<ClientData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        arrData = (ArrayList<ClientData>) bundle.get("DATA");
        for(int i=0;i<arrData.size();i++){
            ClientData clientData = arrData.get(i);
            Log.i("1111", clientData.getClientName());
            Log.i("1111", clientData.getClinetAddress());
            Log.i("1111", clientData.getSocket().getRemoteDevice()+"");
            Log.i("1111", "-");
        }

    }

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_READ:
                    byte[] readBuf = (byte[]) msg.obj;
                    String readMessage = new String(readBuf, 0, msg.arg1);
            }
        }
    };

}
