package ru.nubby.pryanikitest.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider implements BaseSchedulerProvider {

    @Nullable
    private static SchedulerProvider sInstance;

    private SchedulerProvider() {
    }

    public static synchronized SchedulerProvider getInstance() {
        if (sInstance == null) {
            sInstance = new SchedulerProvider();
        }
        return sInstance;
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
