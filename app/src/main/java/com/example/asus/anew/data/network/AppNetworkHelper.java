package com.example.asus.anew.data.network;

import android.util.Log;

import com.example.asus.anew.data.network.model.Response;
import com.example.asus.anew.utils.Constants;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppNetworkHelper implements NetworkHelper {
    private ApiHeader header;

    @Inject
    public AppNetworkHelper(ApiHeader apiHeader) {
        header = apiHeader;
    }

    public Single<Response> fetchStories(String last_id) {
        Log.i("ooooooo","last id"+last_id);
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_STORIES)
                .addHeaders("Authorization", header.getToken())
                .addQueryParameter("count", String.valueOf(Constants.PAGINATION_ITEMS_COUNT))
                .addQueryParameter("last_id", last_id)
                .build()
                .getObjectSingle(Response.class);
    }
}
