package com.example.httpclientconnection;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientConnection extends AppCompatActivity {
    private Button button01;
    private TextView resultTV;
    private String result;
    private Handler handler;
    private HttpClient httpclient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client_connection);

        button01 = findViewById(R.id.button);
        resultTV  =findViewById(R.id.result);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send();
                        Message ms = handler.obtainMessage();
                        handler.sendMessage(ms);
                    }
                }).start();
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(result != null){
                    resultTV.setText(result);
                }
                super.handleMessage(msg);
            }
        };
    }

//    public void send(){
//        String target = "http://10.0.2.2:8080/blog/deal_httpclient.jsp?param=get";
//        try {
//            httpclient = new DefaultHttpClient();
//            HttpGet httpGet = new HttpGet(target);
//            HttpResponse hResponse = httpclient.execute(httpGet);
//            if(hResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
//                result = EntityUtils.toString(hResponse.getEntity());
//            }
//        } catch (ClientProtocolException clientProtocolException){
//            clientProtocolException.printStackTrace();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    public void send() {
        String target = "http://10.0.2.2:8080/blog/deal_httpclient.jsp?param=get";	//????????????????????????
        HttpClient httpclient = new DefaultHttpClient();//??????HttpClient??????
        HttpGet httpRequest = new HttpGet(target);	//??????HttpGet????????????
        HttpResponse httpResponse;
        try {
            httpResponse = httpclient.execute(httpRequest);	//??????HttpClient??????
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                result = EntityUtils.toString(httpResponse.getEntity());	//????????????????????????
            }else{
                result="???????????????";
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}