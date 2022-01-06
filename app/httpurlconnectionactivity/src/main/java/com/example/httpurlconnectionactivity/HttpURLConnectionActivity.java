package com.example.httpurlconnectionactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HttpURLConnectionActivity extends AppCompatActivity {
    private String target="";
    EditText content;
    Button button01;
    TextView outputText;
    String output;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_urlconnection);

        content = findViewById(R.id.input_text01);
        button01 = findViewById(R.id.button01);
        outputText = findViewById(R.id.output_text01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("".equals(content.getText().toString())){
                    Toast.makeText(HttpURLConnectionActivity.this, "请输入要发表的内容！", Toast.LENGTH_SHORT).show();
                    content.requestFocus();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send();
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage( Message msg) {
                if(output != null){
                    outputText.setText(output);
                    content.setText("");
                }
                super.handleMessage(msg);
            }
        };
    }

    public void send(){
        String target;
        target = "http://10.0.2.2:8080/blog/index.jsp?content=aaaa";
                //+base64(content.getText().toString().trim());
        try {
            URL url = new URL(target);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader buffer = new BufferedReader(in);
            String inputLine = "";
            while((inputLine = buffer.readLine()) != null){
                output += inputLine + "\n";
            }
            in.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String base64(String content){
        content = Base64.encodeToString(content.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
        content = URLEncoder.encode(content);
        return content;
    }

}