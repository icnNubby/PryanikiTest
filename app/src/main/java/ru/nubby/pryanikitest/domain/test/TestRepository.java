package ru.nubby.pryanikitest.domain.test;

import com.google.gson.Gson;

import io.reactivex.Single;
import ru.nubby.pryanikitest.domain.Repository;
import ru.nubby.pryanikitest.model.BaseResponse;

public class TestRepository implements Repository {
    private final String JSON = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"name\": \"hz\",\n" +
            "      \"data\": {\n" +
            "        \"text\": \"тринитротолуол\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"picture\",\n" +
            "      \"data\": {\n" +
            "        \"url\": \"https://cdnbeta.pryaniky.com/content/img/opportunities_8_talents.png\",\n" +
            "        \"text\": \"Голова\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"selector\",\n" +
            "      \"data\": {\n" +
            "        \"selectedId\": 1,\n" +
            "        \"variants\": [\n" +
            "          {\n" +
            "            \"id\": 0,\n" +
            "            \"text\": \"Вариант 1\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1,\n" +
            "            \"text\": \"Вариант 2\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 2,\n" +
            "            \"text\": \"Вариант 777\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 3,\n" +
            "            \"text\": \"Вариант 1001\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"view\": [\n" +
            "    \"hz\",\n" +
            "    \"selector\",\n" +
            "    \"picture\",\n" +
            "    \"hz\",\n" +
            "    \"selector\",\n" +
            "    \"picture\",\n" +
            "    \"selector\",\n" +
            "    \"selector\",\n" +
            "    \"hz\",\n" +
            "    \"selector\",\n" +
            "    \"hz\",\n" +
            "    \"picture\",\n" +
            "    \"selector\",\n" +
            "    \"selector\"\n" +
            "  ]\n" +
            "}\n" +
            "\n";

    @Override
    public Single<BaseResponse> getData() {
        BaseResponse response = new Gson().fromJson(JSON, BaseResponse.class);
        return Single.just(response);
    }
}
