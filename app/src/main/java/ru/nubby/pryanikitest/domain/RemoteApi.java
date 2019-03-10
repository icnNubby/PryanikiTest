package ru.nubby.pryanikitest.domain;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nubby.pryanikitest.domain.service.ExampleService;

public class RemoteApi {
    private static final String BASE_URL = "https://prnk.blob.core.windows.net/tmp/JSONSample.json";
    private static final int TIMEOUT = 3000;

    private static RemoteApi sRemoteApi;

    private ExampleService mExampleService;

    private RemoteApi(){
        OkHttpClient okHttpClient = provideOkHttpClient();
        Retrofit.Builder retrofitBuilder = provideRetrofitBuilder(okHttpClient);
        mExampleService = retrofitBuilder
                .build()
                .create(ExampleService.class);
    }

    public static RemoteApi getInstance() {
        if (sRemoteApi == null) {
            sRemoteApi = new RemoteApi();
        }
        return sRemoteApi;
    }

    ExampleService getExampleService() {
        return mExampleService;
    }

    private OkHttpClient provideOkHttpClient(){
        return new OkHttpClient().newBuilder()
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    private Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());


    }
}
