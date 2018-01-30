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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn15Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn16Activity;


public class WatkanrayanamitActivity extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watkanrayanamit_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail16);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn16);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watkanlayanamit1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map16);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news16);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watkanrayanamitmap = (ImageButton) findViewById(R.id.btn_watkanrayanamitmap);
        ImageButton btn_watkanrayanamitmaplocation = (ImageButton) findViewById(R.id.btn_watkanrayanamitmaplocation);
        ImageButton btn_watkanrayanamitnews = (ImageButton) findViewById(R.id.btn_watkanrayanamitnews);
        ImageButton btn_watkanrayanamitnewswat = (ImageButton) findViewById(R.id.btn_watkanrayanamitnewswat);

        btn_watkanrayanamitmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.739948);
                i.putExtra("Lng", 100.491204);
                i.putExtra("Title", "วัดกัลยาณมิตรวรมหาวิหาร");
                i.putExtra("Detail", "พระอารามหลวง, 13.739948, 100.491204");
                startActivity(i);
            }
        });
        btn_watkanrayanamitmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดกัลยาณมิตรวรมหาวิหาร เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดกัลยาณมิตรวรมหาวิหาร" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watkanrayanamitnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watkanrayanamitnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn16Activity.class);
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
