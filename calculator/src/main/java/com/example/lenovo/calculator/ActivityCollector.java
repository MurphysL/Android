package com.example.lenovo.calculator;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivityCollector
 *
 * @author: lenovo
 * @time: 2016/2/29 18:03
 */

public class ActivityCollector {

    public final static String TAG = "Calculator";

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        Log.i(TAG, "--------addActivity--------");
        activities.add(activity);
    }

    /**
     * 移除List中所有活动
     * @param activity
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**
     * 销毁全部活动
     */
    public static void finishAll(){
        Log.i(TAG, "--------finishActivity--------");
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
