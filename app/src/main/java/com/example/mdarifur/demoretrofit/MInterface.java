package com.example.mdarifur.demoretrofit;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by MD.Arifur on 8/10/2016.
 */
public interface MInterface {
    @GET("/users/mobilesiri")
    void getUser(Callback<Pojo> nothing);
}
