package com.vietpt.debotsample.application;

import android.app.Application;

import com.tomoima.debot.DebotConfigurator;
import com.tomoima.debot.DebotStrategyBuilder;
import com.tomoima.debot.strategy.DebotCallActivityMethodStrategy;
import com.vietpt.debotsample.debot.CustomDebotConfigurator;
import com.vietpt.debotsample.debot.CustomDebotStrategy;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Register Debot
        DebotStrategyBuilder builder = new DebotStrategyBuilder.Builder(this)
                .registerMenu("Hahaha", new CustomDebotStrategy())
                .registerMenu("Make Toast text", new DebotCallActivityMethodStrategy("showToast"))
                .registerMenu("Show log", new DebotCallActivityMethodStrategy("showLog"))
                .registerMenu("Don't click", new DebotCallActivityMethodStrategy("resetLog"))
                .registerMenu("Show variable here", new DebotCallActivityMethodStrategy("showVariable"))
                .build();
        CustomDebotConfigurator.configureWithCustomizedMenu(this, builder.getStrategyList());
    }
}
