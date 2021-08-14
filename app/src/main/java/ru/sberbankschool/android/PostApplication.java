package ru.sberbankschool.android;

import android.app.Application;
import android.content.Context;

import com.example.android.BuildConfig;

import ru.sberbankschool.android.di.AppComponent;
import ru.sberbankschool.android.di.AppModule;
import ru.sberbankschool.android.di.DaggerAppComponent;

public class PostApplication extends Application {

    private AppComponent mAppComponent;

    public static AppComponent getAppComponent(Context context) {
        return ((PostApplication) context.getApplicationContext()).mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.factory().create(BuildConfig.BASE_URL);
    }
}
