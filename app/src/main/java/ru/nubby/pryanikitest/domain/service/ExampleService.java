package ru.nubby.pryanikitest.domain.service;

import io.reactivex.Single;
import retrofit2.http.GET;
import ru.nubby.pryanikitest.model.ViewElementList;

public interface ExampleService {
    @GET()
    Single<ViewElementList> getViewElements();
}
