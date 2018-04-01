package com.app.ray.testtransmitthread;

import android.app.Activity;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final int MESSAGE_READ = 1;

    private Button btnServer;
    private ArrayList<ClientData> arrData = new ArrayList<ClientData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnServer = (Button) findViewById(R.id.btn_server);
        btnServer.setOnClickListener(this);
        for (int i = 0; i < 3; i++) {
            LoadingData(i);
        }
    }

    private void LoadingData(int x) {
        BluetoothSocket socket = null;
//        ConnectedThread server = new ConnectedThread(mHandler, socket);
        ClientData clientData = new ClientData();
        clientData.setClientName("Name: " + x);
        clientData.setClinetAddress("Address: " + x);
        clientData.setSocket(socket);
        arrData.add(clientData);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_server:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("DATA", arrData);
                startActivity(intent);
                break;
        }
    }
}