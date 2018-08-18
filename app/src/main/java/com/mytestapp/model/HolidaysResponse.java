package com.mytestapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolidaysResponse{
	@SerializedName("message")
	private List<HoliydaysMessageItem> message;
	@SerializedName("status")
	private String status;

	public void setMessage(List<HoliydaysMessageItem> message){
		this.message = message;
	}

	public List<HoliydaysMessageItem> getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}


}