package com.geekster.fechdata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FetchdataJava2Application {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		URL getUrl=new URL("https://api.zippopotam.us/us/33162");
		HttpURLConnection connection=(HttpURLConnection)getUrl.openConnection();
		
		connection.setRequestMethod("GET");
		int responceCode=connection.getResponseCode();
		
		if(responceCode==200) {
			
			BufferedReader in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder json=new StringBuilder();
			String readline=null;
			
			while((readline=in.readLine())!=null) {
				
				json.append(readline);
				
			}
			
			in.close();
			JSONObject masterData=new JSONObject(json.toString());
			System.out.println(masterData.toString());
			
		}else {
			System.out.println(responceCode);
		}
		

	}
}
