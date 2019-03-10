package ru.nubby.pryanikitest.domain.remote.service;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;
import ru.nubby.pryanikitest.model.BaseResponse;

public interface ExampleService {
    @GET()
    Single<BaseResponse> getViewElements(@Url String url);
}
