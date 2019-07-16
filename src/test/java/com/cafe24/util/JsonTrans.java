package com.cafe24.util;

import java.io.UnsupportedEncodingException;

import org.springframework.test.web.servlet.MvcResult;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonTrans {
	
	public static JsonObject JsonToObject(MvcResult result) {
		String json;
		JsonObject elementData = null;
		try {
			
			json = result.getResponse().getContentAsString();
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(json);
			elementData = (JsonObject)element.getAsJsonObject().get("data");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		return elementData;
		//vo.setNo(elementData.get("no").getAsLong());
	}
}
