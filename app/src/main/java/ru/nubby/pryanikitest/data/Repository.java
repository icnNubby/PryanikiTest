package ru.nubby.pryanikitest.data;

import io.reactivex.Single;
import ru.nubby.pryanikitest.model.BaseResponse;

public interface Repository {

    /**
     * Gets data from repository, full structure can be viewed
     * <a href ="https://prnk.blob.core.windows.net/tmp/JSONSample.json">here</a>:
     * @return {@link BaseResponse} object, containing ordered views to display and content
     */
    Single<BaseResponse> getData();
}
