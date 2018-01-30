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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn14Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn15Activity;

public class WatmaiyueynuiActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watmaiyueynui_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail15);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn15);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watmaiyueynui1.html");


        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map15);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news15);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watmaiyueynuimap = (ImageButton) findViewById(R.id.btn_watmaiyueynuimap);
        ImageButton btn_watmaiyueynuimaplocation = (ImageButton) findViewById(R.id.btn_watmaiyueynuimaplocation);
        ImageButton btn_watmaiyueynuinews = (ImageButton) findViewById(R.id.btn_watmaiyueynuinews);
        ImageButton btn_watmaiyueynuinewswat = (ImageButton) findViewById(R.id.btn_watmaiyueynuinewswat);

        btn_watmaiyueynuimap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.711961);
                i.putExtra("Lng", 100.468449);
                i.putExtra("Title", "วัดใหม่ยายนุ้ย");
                i.putExtra("Detail", "วัดราษฏร์, 13.711961, 100.468449");
                startActivity(i);
            }
        });
        btn_watmaiyueynuimaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดใหม่ยายนุ้ย เขต ธนบุรี กรุงเทพมหานคร 10600";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดใหม่ยายนุ้ย" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watmaiyueynuinews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watmaiyueynuinewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn15Activity.class);
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
