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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn12Activity;

public class WatwararmartayaphanthasarrararmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watwararmartayaphanthasarrararm_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail12);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn12);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watvoramatayaphan1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map12);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news12);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watwararmartayaphanthasarrararmmap = (ImageButton) findViewById(R.id.btn_watwararmartayaphanthasarrararmmap);
        ImageButton btn_watwararmartayaphanthasarrararmmaplocation = (ImageButton) findViewById(R.id.btn_watwararmartayaphanthasarrararmmaplocation);
        ImageButton btn_watwararmartayaphanthasarrararmnews = (ImageButton) findViewById(R.id.btn_watwararmartayaphanthasarrararmnews);
        ImageButton btn_watwararmartayaphanthasarrararmnewswat = (ImageButton) findViewById(R.id.btn_watwararmartayaphanthasarrararmnewswat);

        btn_watwararmartayaphanthasarrararmmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.719772);
                i.putExtra("Lng", 100.470898);
                i.putExtra("Title", "วัดวรามาตยภัณฑสาราราม");
                i.putExtra("Detail", "วัดราษฏร์, 13.719772, 100.470898");
                startActivity(i);
            }
        });
        btn_watwararmartayaphanthasarrararmmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดวรามาตยภัณฑสาราราม เขต ธนบุรี กรุงเทพมหานคร 10600";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดวรามาตยภัณฑสาราราม" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        btn_watwararmartayaphanthasarrararmnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watwararmartayaphanthasarrararmnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn12Activity.class);
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
