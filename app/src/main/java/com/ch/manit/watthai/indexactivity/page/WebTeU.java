package com.ch.manit.watthai.indexactivity.page;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ch.manit.watthai.R;

/**
 * Created by MeKa-IT_Nit on 7/24/2017.
 */

public class WebTeU extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webteu);


        WebView webView = (WebView) findViewById(R.id.webViewn008);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        webView.loadUrl("http://cloudmeka.com/demo3/index.php/prapprovep2/pr_project_approve");
        webView.setWebViewClient(new WebViewClient());

    }
}