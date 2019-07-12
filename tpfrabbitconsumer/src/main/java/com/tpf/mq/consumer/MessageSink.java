package com.tpf.mq.consumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableBinding(MessageSink.InputChannel.class)
public class MessageSink {
	
	@Value("${tpf.config.mq.account.in}")
	String accountMqIn;
	
	@Value("${tpf.config.gateway.host}")
	String host;
	
	@Value("${tpf.config.gateway.port}")
	String port;

    @StreamListener(InputChannel.SINK)
    public void handle(String message) {
        System.out.println("new message:" + message + ", from worker :" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(Objects.nonNull(message) && message.startsWith(accountMqIn)) {
        	exeAccount(message);
        }
        
    }

    public interface InputChannel {
        String SINK = "message-sink";

        @Input(SINK)
        SubscribableChannel sink();
    }
    
    @SuppressWarnings("unchecked")
	private void exeAccount(String mess) {
    	ObjectMapper mapper = new ObjectMapper();
        String json = mess.substring(mess.indexOf("=")+1);

        try {

            // convert JSON string to Map
            Map<String, String> map = mapper.readValue(json, Map.class);
			// it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
            System.out.println(map);
            if(map.get("name") != null && map.get("username") != null && map.get("password") != null) {
            	postData(map.get("name") , map.get("username"), map.get("password"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings({ "deprecation", "resource" })
	private void postData(String name, String username, String password) {
		try {
			StringBuilder uri = new StringBuilder();
			uri.append("http://"+host+":"+port).append("/myService/accounts");
		    HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost(uri.toString());
		    List<NameValuePair> postParameters = new ArrayList<>();
		    postParameters.add(new BasicNameValuePair("name", name));
		    postParameters.add(new BasicNameValuePair("username", username));
		    postParameters.add(new BasicNameValuePair("password", password));

		    httppost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));

		    HttpResponse response = httpclient.execute(httppost);
			System.out.println(response.getEntity());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
