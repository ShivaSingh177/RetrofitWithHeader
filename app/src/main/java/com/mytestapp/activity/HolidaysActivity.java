package com.mytestapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mytestapp.NoticeRequest;
import com.mytestapp.R;
import com.mytestapp.adapter.RecyclerAdapter;
import com.mytestapp.model.HolidaysResponse;
import com.mytestapp.model.HoliydaysMessageItem;
import com.mytestapp.model.NoticeMessageItem;
import com.mytestapp.model.NoticeResponse;
import com.mytestapp.util.APIUtil;
import com.mytestapp.util.ConfigURLs;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidaysActivity extends AppCompatActivity implements RecyclerAdapter.ReturnView{

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ConfigURLs configURLs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configURLs= APIUtil.appConfig();
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        callApi();
    }

    private void callApi() {
        Call<HolidaysResponse> call=configURLs.getHolidays("application/x-www-form-urlencoded","304f88-ab9969-a34c92-990b94-977d8d",
                "92c43a8c6475290a25546f7d740b56e9");
        call.enqueue(new Callback<HolidaysResponse>() {
            @Override
            public void onResponse(Call<HolidaysResponse> call, Response<HolidaysResponse> response) {
                HolidaysResponse noticeResponse=response.body();
                if (noticeResponse.getStatus().equalsIgnoreCase("success")){
                    List<HoliydaysMessageItem> messageItems=noticeResponse.getMessage();
                    setData(messageItems);
                }
            }

            @Override
            public void onFailure(Call<HolidaysResponse> call, Throwable t) {

            }
        });
    }

    private void setData(List<HoliydaysMessageItem> messageItems) {

        recyclerAdapter=new RecyclerAdapter(messageItems,this,R.layout.new_main_activity,this,0);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void getAdapterView(View view, List object, int position, int from) {
        TextView txt_notice=(TextView)view.findViewById(R.id.txt_notice);
        TextView txt_notice_date=(TextView)view.findViewById(R.id.txt_notice_date);

        txt_notice.setText(((HoliydaysMessageItem)object.get(position)).getHolidayName());
        txt_notice_date.setText(((HoliydaysMessageItem)object.get(position)).getHolidayDate());

    }
}
