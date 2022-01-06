package com.example.webtest01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Wettest01 extends AppCompatActivity {
    private EditText urlIn;
    private WebView webView01;
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webtest01);

        Button forwardButton = findViewById(R.id.button01);
        Button backButton = findViewById(R.id.button02);
        goButton = findViewById(R.id.button03);
        urlIn = findViewById(R.id.urlIn);
        webView01 = findViewById(R.id.webView01);
        webView01.getSettings().setJavaScriptEnabled(true);
        webView01.setWebChromeClient(new WebChromeClient());
        webView01.setWebViewClient(new WebViewClient());

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView01.goForward();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView01.goBack();
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"".equals(urlIn.getText().toString())){
                    openBrowser();
                } else{
                    showDialog();
                }
            }
        });

        urlIn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode == KeyEvent.KEYCODE_ENTER) {
                    if(!"".equals(urlIn.getText().toString())){
                        openBrowser();
                    } else{
                        showDialog();
                    }
                }
                return false;
            }
        });
    }

    public void openBrowser(){
        webView01.loadUrl(urlIn.getText().toString());
        Toast.makeText(Wettest01.this, "正在加载:" + urlIn.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    private void showDialog(){
        new AlertDialog.Builder(Wettest01.this).setTitle("网页浏览器").setMessage("请输入网址").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("WebView", "单击确定按钮");
            }
        }).show();
    }
}