package com.example.scitmaster.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        edit = findViewById(R.id.url);
        WebSettings settings = webView.getSettings();
        //Javascript 사용가능 여부 설정
        settings.setJavaScriptEnabled(true);
        //Javascript에서 새창 열기 가능 여부
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        // alert과 같은것 실행용
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeclient());
        webView.loadUrl("Http://m.nate.com/");
    }
    public void btnOnClick(View view) {
        String url = edit.getText().toString();

        if (url.equals("")) return;
        if (!url.startsWith("http://") || !url.startsWith("https://")) {
            url = "https://"+url;
        }
        webView.loadUrl(url);
    }
}
