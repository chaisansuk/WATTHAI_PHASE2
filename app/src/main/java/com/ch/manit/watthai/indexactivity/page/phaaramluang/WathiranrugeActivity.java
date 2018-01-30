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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn22Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn23Activity;


public class WathiranrugeActivity extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wathiranruge_layout);

        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail23);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn23);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/wathirunruje1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map23);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news23);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_wathiranrugemap = (ImageButton) findViewById(R.id.btn_wathiranrugemap);
        ImageButton btn_wathiranrugemaplocation = (ImageButton) findViewById(R.id.btn_wathiranrugemaplocation);
        ImageButton btn_wathiranrugenews = (ImageButton) findViewById(R.id.btn_wathiranrugenews);
        ImageButton btn_wathiranrugenewswat = (ImageButton) findViewById(R.id.btn_wathiranrugenewswat);

        btn_wathiranrugemap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.728924);
                i.putExtra("Lng", 100.490469);
                i.putExtra("Title", "วัดหิรัญรูจีวรวิหาร");
                i.putExtra("Detail", "พระอารามหลวง, 13.728924, 100.490469");
                startActivity(i);
            }
        });
        btn_wathiranrugemaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดหิรัญรูจีวรวิหาร เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดหิรัญรูจีวรวิหาร" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_wathiranrugenews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_wathiranrugenewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn23Activity.class);
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
