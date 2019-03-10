package ru.nubby.pryanikitest.domain;

import io.reactivex.Single;
import ru.nubby.pryanikitest.model.ViewElementList;

public class RemoteRepository implements Repository {

    private final RemoteApi mRemoteApi;

    public RemoteRepository(RemoteApi remoteApi){
        mRemoteApi = remoteApi;
    }

    @Override
    public Single<ViewElementList> getData() {
        return mRemoteApi
                .getExampleService()
                .getViewElements();
    }
}
