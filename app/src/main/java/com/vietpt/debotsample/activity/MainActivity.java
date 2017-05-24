package com.vietpt.debotsample.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tomoima.debot.Debot;
import com.tomoima.debot.annotation.DebotAnnotation;
import com.tomoima.debot.util.DialogUtil;
import com.vietpt.debotsample.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Debot mDebot;
    private int mInteger;
    private String mLog = "";

    private final String TAG = "LOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeLog("This is log 1");
        TextView tv = (TextView) findViewById(R.id.tv_nothing);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeLog("Click on textview");
                mInteger++;
            }
        });
        mDebot = Debot.getInstance();
        mDebot.allowShake(getApplicationContext());
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            mDebot.showDebugMenu(this);
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDebot.startSensor(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDebot.stopSensor();
    }

    public void writeLog(String log) {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        mLog = mLog + timeStamp + " " + TAG + ": " + log + "\n";
        Log.d(TAG, log);
    }

    // Function will run on Debot
    @DebotAnnotation("showLog")
    public void showLog() {
        DialogUtil.showDialog(this, TAG, mLog);
    }

    // Function will run on Debot
    @DebotAnnotation("resetLog")
    public void resetLog() {
        mLog = "";
    }

    // Function will run on Debot
    @DebotAnnotation("showVariable")
    public void showVariable() {
        DialogUtil.showDialog(this, "Variables", "mInteger: " + mInteger);
    }

    // Function will run on Debot
    @DebotAnnotation("showToast")
    public void showToast() {
        Toast.makeText(this, "This is text", Toast.LENGTH_LONG).show();
    }
}
