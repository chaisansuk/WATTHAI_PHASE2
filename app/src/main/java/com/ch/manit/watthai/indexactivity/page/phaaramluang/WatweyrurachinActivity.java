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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn21Activity;
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn22Activity;

public class WatweyrurachinActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watweyrurachin_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail22);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn22);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watweyrurachin1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map22);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news22);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watweyrurachinmap = (ImageButton) findViewById(R.id.btn_watweyrurachinmap);
        ImageButton btn_watweyrurachinmaplocation = (ImageButton) findViewById(R.id.btn_watweyrurachinmaplocation);
        ImageButton btn_watweyrurachinnews = (ImageButton) findViewById(R.id.btn_watweyrurachinnews);
        ImageButton btn_watweyrurachinnewswat = (ImageButton) findViewById(R.id.btn_watweyrurachinnewswat);

        btn_watweyrurachinmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.725190);
                i.putExtra("Lng", 100.486169);
                i.putExtra("Title", "วัดเวฬุราชิณ");
                i.putExtra("Detail", "พระอารามหลวง, 13.725190, 100.486169");
                startActivity(i);
            }
        });
        btn_watweyrurachinmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดเวฬุราชิณ เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดเวฬุราชิณ" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watweyrurachinnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watweyrurachinnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn22Activity.class);
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
