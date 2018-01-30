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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn18Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn19Activity;

public class WatprayutrawongsarvarsvoraviharnActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watprayutrawongsarvarsvoraviharn_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail19);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn19);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watprayutrawong1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map19);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news19);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watprayutrawongsarvarsvoraviharnmap = (ImageButton) findViewById(R.id.btn_watprayutrawongsarvarsvoraviharnmap);
        ImageButton btn_watprayutrawongsarvarsvoraviharnmaplocation = (ImageButton) findViewById(R.id.btn_watprayutrawongsarvarsvoraviharnmaplocation);
        ImageButton btn_watprayutrawongsarvarsvoraviharnnews = (ImageButton) findViewById(R.id.btn_watprayutrawongsarvarsvoraviharnnews);
        ImageButton btn_watprayutrawongsarvarsvoraviharnnewswat = (ImageButton) findViewById(R.id.btn_watprayutrawongsarvarsvoraviharnnewswat);


        btn_watprayutrawongsarvarsvoraviharnmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.737324);
                i.putExtra("Lng", 100.495369);
                i.putExtra("Title", "วัดประยุรวงศาวาสวรวิหาร");
                i.putExtra("Detail", "พระอารามหลวง, 13.737324, 100.495369");
                startActivity(i);
            }
        });
        btn_watprayutrawongsarvarsvoraviharnmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดประยุรวงศาวาสวรวิหาร เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดประยุรวงศาวาสวรวิหาร" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watprayutrawongsarvarsvoraviharnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watprayutrawongsarvarsvoraviharnnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn19Activity.class);
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
