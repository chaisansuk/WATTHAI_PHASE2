package com.ch.manit.watthai.indexactivity.page.phaaramluang;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.ch.manit.watthai.R;
import com.ch.manit.watthai.indexactivity.map.MapsActivity;
import com.ch.manit.watthai.indexactivity.page.news.NewsActivity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn20Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn21Activity;

public class WatrajakruvoraviharnActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watrajakruvoraviharn_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail21);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn21);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watrajakru1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map21);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news21);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watrajakruvoraviharnmap = (ImageButton) findViewById(R.id.btn_watrajakruvoraviharnmap);
        ImageButton btn_watrajakruvoraviharnmaplocation = (ImageButton) findViewById(R.id.btn_watrajakruvoraviharnmaplocation);
        ImageButton btn_watrajakruvoraviharnnews = (ImageButton) findViewById(R.id.btn_watrajakruvoraviharnnews);
        ImageButton btn_watrajakruvoraviharnnewswat = (ImageButton) findViewById(R.id.btn_watrajakruvoraviharnnewswat);

        btn_watrajakruvoraviharnmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.721798);
                i.putExtra("Lng", 100.479666);
                i.putExtra("Title", "วัดราชคฤห์วรวิหาร");
                i.putExtra("Detail", "พระอารามหลวง, 13.721798, 100.479666");
                startActivity(i);
            }
        });
        btn_watrajakruvoraviharnmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดราชคฤห์วรวิหาร เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดราชคฤห์วรวิหาร" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watrajakruvoraviharnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watrajakruvoraviharnnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn21Activity.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
