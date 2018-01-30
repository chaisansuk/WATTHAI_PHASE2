package com.ch.manit.watthai.indexactivity.page.watrat;

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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn10Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn11Activity;

public class WatrajwarinActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watrajwarin_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail11);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn11);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watratjawarin1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map11);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news11);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watrajwarinmap = (ImageButton) findViewById(R.id.btn_watrajwarinmap);
        ImageButton btn_watrajwarinmaplocation = (ImageButton) findViewById(R.id.btn_watrajwarinmaplocation);
        ImageButton btn_watrajwarinnews = (ImageButton) findViewById(R.id.btn_watrajwarinnews);
        ImageButton btn_watrajwarinnewswat = (ImageButton) findViewById(R.id.btn_watrajwarinnewswat);

        btn_watrajwarinmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.708958);
                i.putExtra("Lng", 100.491758);
                i.putExtra("Title", "วัดราชวรินทร์");
                i.putExtra("Detail", "วัดราษฏร์, 13.708958, 100.491758");
                startActivity(i);
            }
        });
        btn_watrajwarinmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดราชวรินทร์";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng ;
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watrajwarinnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watrajwarinnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn11Activity.class);
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
