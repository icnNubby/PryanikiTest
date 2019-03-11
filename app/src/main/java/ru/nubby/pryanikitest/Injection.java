package ru.nubby.pryanikitest;

import ru.nubby.pryanikitest.data.remote.RemoteApi;
import ru.nubby.pryanikitest.data.remote.RemoteRepository;
import ru.nubby.pryanikitest.data.Repository;
import ru.nubby.pryanikitest.data.test.TestRepository;
import ru.nubby.pryanikitest.util.BaseSchedulerProvider;
import ru.nubby.pryanikitest.util.SchedulerProvider;

/**
 * Enables injection of mock implementations for
 * {@link Repository} at compile time.
 */
public class Injection {

    public static Repository provideRepository() {
        return new RemoteRepository(RemoteApi.getInstance());
    }

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    public static Repository provideTestRepository() {
        return new TestRepository();
    }

}
