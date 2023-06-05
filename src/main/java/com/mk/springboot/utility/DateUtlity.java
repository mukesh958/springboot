package com.mk.springboot.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateUtlity {
	
	public static LocalDate convertStringToLocalDate(String date) {
		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate local_date_1 = LocalDate.parse(date, formatter_1);
		return local_date_1;
	} 
	public static LocalDateTime convertDateToLocalDate(String date) {
		DateTimeFormatter formatter_ = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime local_date_1 = LocalDateTime.parse(date, formatter_);
		return local_date_1;
	} 

}
