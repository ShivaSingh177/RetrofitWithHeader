package com.mytestapp.model;

import com.google.gson.annotations.SerializedName;

public class NoticeMessageItem {
	@SerializedName("notice_date")
	private String noticeDate;
	@SerializedName("notice")
	private String notice;

	public void setNoticeDate(String noticeDate){
		this.noticeDate = noticeDate;
	}

	public String getNoticeDate(){
		return noticeDate;
	}

	public void setNotice(String notice){
		this.notice = notice;
	}

	public String getNotice(){
		return notice;
	}
}
