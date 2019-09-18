package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
  WebView myweb;
  ProgressBar Prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       myweb =findViewById(R.id.WebView);
       Prog = findViewById(R.id.poggers_bar);
       myweb.setWebViewClient(new myWebClient());
       myweb.getSettings().setJavaScriptEnabled(true);
       myweb.loadUrl("https://smkn4bdg.sch.id/");



    }

    public class myWebClient extends WebViewClient{

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Prog.setVisibility(view.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myweb.canGoBack()){
            myweb.goBack();
            return true;
        }


        return super.onKeyDown(keyCode, event);
    }
}
