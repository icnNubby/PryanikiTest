package ru.nubby.pryanikitest.domain.remote.service;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;
import ru.nubby.pryanikitest.model.ViewElementList;

public interface ExampleService {
    @GET()
    Single<ViewElementList> getViewElements(@Url String url);
}
