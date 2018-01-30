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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatActivity;


public class WatgheycheesuphanActivity extends Activity{
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watgheycheesuphan_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);

        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ประวัติ");
        tab_detail.setContent (R.id.detail0);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn0);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watgheysresuphan1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map0);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news0);
        tabHost.addTab (tab_news);


        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost


        ImageButton btn_watgheycheesuphanmap = (ImageButton) findViewById(R.id.btn_watgheycheesuphanmap);
        ImageButton btn_watgheycheesuphanmaplocation = (ImageButton) findViewById(R.id.btn_watgheycheesuphanmaplocation);
        ImageButton btn_watgheycheesuphannews = (ImageButton) findViewById(R.id.btn_watgheycheesuphannews);
        ImageButton btn_watgheycheesuphannewswat = (ImageButton) findViewById(R.id.btn_watgheycheesuphannewswat);


        btn_watgheycheesuphanmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.729771);
                i.putExtra("Lng", 100.488543);
                i.putExtra("Title", "วัดใหญ่ศรีสุพรรณ");
                i.putExtra("Detail", "วัดราษฏร์,13.729771, 100.488543");
                startActivity(i);
            }
        });

        btn_watgheycheesuphanmaplocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String latlng = "วัดใหญ่ศรีสุพรรณ เขต ธนบุรี กรุงเทพมหานคร 10600";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดใหญ่ศรีสุพรรณ เขต ธนบุรี กรุงเทพมหานคร 10600" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        btn_watgheycheesuphannews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watgheycheesuphannewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatActivity.class);
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
