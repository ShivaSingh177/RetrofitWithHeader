package com.mytestapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mytestapp.NoticeRequest;
import com.mytestapp.R;
import com.mytestapp.adapter.RecyclerAdapter;
import com.mytestapp.model.NoticeMessageItem;
import com.mytestapp.model.NoticeResponse;
import com.mytestapp.util.APIUtil;
import com.mytestapp.util.ConfigURLs;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ReturnView{

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
        HashMap<String ,String > mapValue=new HashMap<>();
        NoticeRequest noticeRequest=new NoticeRequest();
        mapValue.put(noticeRequest.getStudent_id(),"4");
        Call<NoticeResponse> call=configURLs.getNotice("application/x-www-form-urlencoded","304f88-ab9969-a34c92-990b94-977d8d",
                "92c43a8c6475290a25546f7d740b56e9",mapValue);
        call.enqueue(new Callback<NoticeResponse>() {
            @Override
            public void onResponse(Call<NoticeResponse> call, Response<NoticeResponse> response) {
                NoticeResponse noticeResponse=response.body();
                if (noticeResponse.getStatus().equalsIgnoreCase("success")){
                    List<NoticeMessageItem> messageItems=noticeResponse.getMessage();
                    setData(messageItems);
                }
            }

            @Override
            public void onFailure(Call<NoticeResponse> call, Throwable t) {

            }
        });
    }

    private void setData(List<NoticeMessageItem> messageItems) {

        recyclerAdapter=new RecyclerAdapter(messageItems,this,R.layout.new_main_activity,this,0);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void getAdapterView(View view, List object, int position, int from) {
        CardView card_view=(CardView) view.findViewById(R.id.card_view);
        TextView txt_notice=(TextView)view.findViewById(R.id.txt_notice);
        TextView txt_notice_date=(TextView)view.findViewById(R.id.txt_notice_date);

        txt_notice_date.setText(((NoticeMessageItem)object.get(position)).getNoticeDate());
        txt_notice.setText(((NoticeMessageItem)object.get(position)).getNotice());


        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HolidaysActivity.class);
                startActivity(intent);
            }
        });
    }
}
