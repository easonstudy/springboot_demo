package com.gmh.converter;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String url = "http://localhost/mall/api/boxlog.do";
        Gson gson = new Gson();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("equipmentId"    , "00000345");
        paramMap.put("name"  		  , "aa");
        paramMap.put("type"  	  	  , "DEBUG");
        paramMap.put("time"   		  , "2017-09-05 13:47:00");
        paramMap.put("content"   	  , "i am content Log");

        String json = gson.toJson(paramMap);
        String content = RequestUtil.doPostByJson(url, json);
        System.out.println(content);
    }
}
