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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn19Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn20Activity;

/**
 * Created by Manit on 6/3/2559.
 */
public class WatphonimitsatitmaharsremararmActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watphonimitsatitmaharsremararm_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail20);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn20);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watphonimit1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map20);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news20);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watphonimitsatitmaharsremararmmap = (ImageButton) findViewById(R.id.btn_watphonimitsatitmaharsremararmmap);
        ImageButton btn_watphonimitsatitmaharsremararmmaplocation = (ImageButton) findViewById(R.id.btn_watphonimitsatitmaharsremararmmaplocation);
        ImageButton btn_watphonimitsatitmaharsremararmnews = (ImageButton) findViewById(R.id.btn_watphonimitsatitmaharsremararmnews);
        ImageButton btn_watphonimitsatitmaharsremararmnewswat = (ImageButton) findViewById(R.id.btn_watphonimitsatitmaharsremararmnewswat);


        btn_watphonimitsatitmaharsremararmmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.720930);
                i.putExtra("Lng", 100.484056);
                i.putExtra("Title", "วัดโพธินิมิตสถิตมหาสีมาราม");
                i.putExtra("Detail", "พระอารามหลวง, 13.720930, 100.484056");
                startActivity(i);
            }
        });
        btn_watphonimitsatitmaharsremararmmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดโพธินิมิตสถิตมหาสีมาราม เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดโพธินิมิตสถิตมหาสีมาราม" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watphonimitsatitmaharsremararmnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watphonimitsatitmaharsremararmnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn20Activity.class);
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
