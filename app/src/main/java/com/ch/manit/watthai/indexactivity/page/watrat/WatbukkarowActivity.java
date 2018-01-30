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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn9Activity;


public class WatbukkarowActivity extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watbukkarow_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail9);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn9);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watbukkalow1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map9);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news9);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watbukkarowmap = (ImageButton) findViewById(R.id.btn_watbukkarowmap);
        ImageButton btn_watbukkarowmaplocation = (ImageButton) findViewById(R.id.btn_watbukkarowmaplocation);
        ImageButton btn_watbukkarownews = (ImageButton) findViewById(R.id.btn_watbukkarownews);
        ImageButton btn_watbukkarownewswat = (ImageButton) findViewById(R.id.btn_watbukkarownewswat);

        btn_watbukkarowmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.718941);
                i.putExtra("Lng", 100.479304);
                i.putExtra("Title", "วัดบุคคโล");
                i.putExtra("Detail", "วัดราษฏร์, พิกัด 13.699800, 100.488770");
                startActivity(i);
            }
        }); btn_watbukkarowmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดบุคคโล เขต ธนบุรี กรุงเทพมหานคร 10600";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดบุคคโล เขต ธนบุรี กรุงเทพมหานคร 10600" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watbukkarownews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watbukkarownewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn9Activity.class);
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
