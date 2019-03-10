package ru.nubby.pryanikitest.domain;

import io.reactivex.Single;
import ru.nubby.pryanikitest.model.ViewElementList;

public interface Repository {

    /**
     * Gets data from repository, full structure can be viewed
     * <a href ="https://prnk.blob.core.windows.net/tmp/JSONSample.json>here</a>:
     * @return List of {@link ViewElementList} objects
     */
    Single<ViewElementList> getData();
}
