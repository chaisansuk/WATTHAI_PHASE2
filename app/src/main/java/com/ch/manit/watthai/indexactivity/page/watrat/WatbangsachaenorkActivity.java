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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn7Activity;


public class WatbangsachaenorkActivity extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watbangsachaenork_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail7);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn7);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watbangsakaenork1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map7);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news7);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watbangsachaenorkmap = (ImageButton) findViewById(R.id.btn_watbangsachaenorkmap);
        ImageButton btn_watbangsachaenorkmaplocation = (ImageButton) findViewById(R.id.btn_watbangsachaenorkmaplocation);
        ImageButton btn_watbangsachaenorknews = (ImageButton) findViewById(R.id.btn_watbangsachaenorknews);
        ImageButton btn_watbangsachaenorknewswat = (ImageButton) findViewById(R.id.btn_watbangsachaenorknewswat);

        btn_watbangsachaenorkmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.716130);
                i.putExtra("Lng", 100.475819);
                i.putExtra("Title", "วัดบางสะแกนอก");
                i.putExtra("Detail", "วัดราษฏร์, พิกัด 13.716130, 100.475819");
                startActivity(i);
            }
        });
        btn_watbangsachaenorkmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดบางสะแกนอก เขต ธนบุรี กรุงเทพมหานคร";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดบางสะแกนอก" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        btn_watbangsachaenorknews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watbangsachaenorknewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn7Activity.class);
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
