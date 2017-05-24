package com.vietpt.debotsample.debot;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.tomoima.debot.strategy.DebotStrategy;
import com.tomoima.debot.util.DialogUtil;

// This is common function for debot, run with all activity
public class CustomDebotStrategy extends DebotStrategy {
    @Override
    public void startAction(@NonNull Activity activity) {
        DialogUtil.showDialog(activity, activity.getClass().getSimpleName(), activity.getPackageName());
    }
}
