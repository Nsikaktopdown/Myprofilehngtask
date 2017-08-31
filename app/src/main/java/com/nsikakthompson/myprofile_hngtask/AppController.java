package com.nsikakthompson.myprofile_hngtask;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Nsikak on 8/31/17.
 */

public class AppController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
