package com.ch.manit.watthai.indexactivity.page;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabWidget;


import com.ch.manit.watthai.R;

public class WebhelpMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_help_map);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ที่มา");
        tab_detail.setContent (R.id.webViewdetail1);
        tabHost.addTab (tab_detail);
        WebView webView1 = (WebView) findViewById(R.id.webViewdetail);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.loadUrl("http://watthaiapp.6te.net/index.html");


        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("MAP");
        tab_map.setContent (R.id.webViewmap1);
        tabHost.addTab (tab_map);
        WebView webView4 = (WebView) findViewById(R.id.webViewmap);
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.loadUrl("http://watthaiapp.6te.net/map.html");

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
