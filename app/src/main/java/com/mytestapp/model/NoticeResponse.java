package com.mytestapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NoticeResponse{

	@SerializedName("message")
	private List<NoticeMessageItem> message;
	@SerializedName("status")
	private String status;

	public void setMessage(List<NoticeMessageItem> message){
		this.message = message;
	}

	public List<NoticeMessageItem> getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}