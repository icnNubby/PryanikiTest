package ru.nubby.pryanikitest.domain.remote;

import io.reactivex.Single;
import ru.nubby.pryanikitest.domain.Repository;
import ru.nubby.pryanikitest.model.BaseResponse;

public class RemoteRepository implements Repository {

    private final RemoteApi mRemoteApi;
    private final String TEST_DATA = "tmp/JSONSample.json";

    public RemoteRepository(RemoteApi remoteApi){
        mRemoteApi = remoteApi;
    }

    @Override
    public Single<BaseResponse> getData() {
        return mRemoteApi
                .getExampleService()
                .getViewElements(TEST_DATA);
    }
}
