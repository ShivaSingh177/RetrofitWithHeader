package com.mytestapp.util;

import com.mytestapp.model.HolidaysResponse;
import com.mytestapp.model.NoticeResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ConfigURLs {



    @FormUrlEncoded
    @POST("V1/notice")
    Call<NoticeResponse> getNotice(@Header("Content-Type") String key,@Header("SCHOOL-API-KEY") String schoolApiKey,
                                   @Header("X-AUTH-TOKEN") String token, @FieldMap Map<String ,String> stringStringMap);

    @GET("V1/holidays")
    Call<HolidaysResponse> getHolidays(@Header("Content-Type") String key, @Header("SCHOOL-API-KEY") String schoolApiKey,
                                       @Header("X-AUTH-TOKEN") String token);


}
