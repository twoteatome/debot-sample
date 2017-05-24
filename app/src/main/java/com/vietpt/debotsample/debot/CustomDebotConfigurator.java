package com.vietpt.debotsample.debot;

import android.content.Context;

import com.tomoima.debot.DebotStrategies;
import com.tomoima.debot.DebotStrategyBuilder;
import com.tomoima.debot.strategy.CheckAppVersionStrategy;
import com.tomoima.debot.strategy.CheckDpiStrategy;
import com.tomoima.debot.strategy.DebotCallActivityMethodStrategy;
import com.tomoima.debot.strategy.DebotStrategy;
import com.tomoima.debot.strategy.ShowActivityInfoStrategy;

import java.util.ArrayList;

// This is custom menu for Debot
public class CustomDebotConfigurator {
    public static void configureWithDefault(Context context) {
        new DebotStrategies().initialize(createDefaultMenuConfig(context));
    }

    public static void configureWithCustomizedMenu(Context context, ArrayList<DebotStrategy> customList){
        ArrayList<DebotStrategy> registerList = createDefaultMenuConfig(context);
        registerList.addAll(customList);
        new DebotStrategies().initialize(registerList);
    }

    private static ArrayList<DebotStrategy> createDefaultMenuConfig(Context context){
        DebotStrategyBuilder builder = new DebotStrategyBuilder.Builder(context)
                .registerMenu("check dpi", new CheckDpiStrategy())
                .registerMenu("showDebugMenu intent", new ShowActivityInfoStrategy())
                .registerMenu("check App ver", new CheckAppVersionStrategy())
                .build();
        return builder.getStrategyList();
    }
}
