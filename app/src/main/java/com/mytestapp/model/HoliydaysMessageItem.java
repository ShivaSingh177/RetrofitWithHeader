package com.mytestapp.model;

import com.google.gson.annotations.SerializedName;

public class HoliydaysMessageItem {
	@SerializedName("holiday_date")
	private String holidayDate;
	@SerializedName("holiday_name")
	private String holidayName;

	public void setHolidayDate(String holidayDate){
		this.holidayDate = holidayDate;
	}

	public String getHolidayDate(){
		return holidayDate;
	}

	public void setHolidayName(String holidayName){
		this.holidayName = holidayName;
	}

	public String getHolidayName(){
		return holidayName;
	}
}
