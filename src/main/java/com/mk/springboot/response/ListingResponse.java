package com.mk.springboot.response;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class ListingResponse<A, B, C> {
	private HashMap<A, B> pageInfo = new HashMap<>();
	private C data;
	private Status status;
	// private UserConfiguration.UserConfig defaultUserConfig;
	// private List<UserConfiguration> userConfigList;

	
	public ListingResponse() {
		this.status = new Status("200", true, new ArrayList<HashMap<String, String>>() {
			/**
			*
			*/

			private static final long serialVersionUID = -3493667552191325053L;

			{
				add(new HashMap<String, String>() {
					/**
					*
					*/
					private static final long serialVersionUID = 1L;

					{
						put("displayMessage", "Successfully served");
					}
				});
			}
		});
	}
			 
}