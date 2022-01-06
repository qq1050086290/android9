package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Weather extends AppCompatActivity implements View.OnClickListener {
    WebView webView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        webView01 = findViewById(R.id.webView01);
        webView01.getSettings().setJavaScriptEnabled(true);
        webView01.setWebChromeClient(new WebChromeClient());
        webView01.setWebViewClient(new WebViewClient());
        webView01.loadUrl("https://m.weather.com.cn/mweather/101010100.shtml");
        webView01.scrollTo(0, 95);

        Button bj = findViewById(R.id.bj);
        Button sh = findViewById(R.id.sh);
        Button cc = findViewById(R.id.cc);
        Button sy = findViewById(R.id.sy);
        Button gz = findViewById(R.id.gz);
        Button heb = findViewById(R.id.heb);

        bj.setOnClickListener(this::onClick);
        sh.setOnClickListener(this::onClick);
        cc.setOnClickListener(this::onClick);
        sy.setOnClickListener(this::onClick);
        gz.setOnClickListener(this::onClick);
        heb.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bj:
                openUrl("101010100");
                break;
            case R.id.sh:
                openUrl("101020100");
                break;
            case R.id.heb:
                openUrl("101050101");
                break;
            case R.id.cc:
                openUrl("101060101");
                break;
            case R.id.sy:
                openUrl("101070101");
                break;
            case R.id.gz:
                openUrl("101280101");
                break;
        }
    }

    public void openUrl(String str){
        webView01.loadUrl("https://m.weather.com.cn/mweather/" + str +".shtml");
    }
}