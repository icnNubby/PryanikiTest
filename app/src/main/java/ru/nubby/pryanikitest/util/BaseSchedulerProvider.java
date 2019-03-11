package ru.nubby.pryanikitest.util;

import androidx.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * Provides Rx Schedulers and should be mocked for tests.
 */
public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}

