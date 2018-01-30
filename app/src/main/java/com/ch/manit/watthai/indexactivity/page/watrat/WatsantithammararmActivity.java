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
import com.ch.manit.watthai.indexactivity.page.news.NewsWatn13Activity;

public class WatsantithammararmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watsantithammararm_layout);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_detail = tabHost.newTabSpec ("DEATAIL");
        tab_detail.setIndicator ("ความเป็นมา");
        tab_detail.setContent (R.id.detail13);
        tabHost.addTab (tab_detail);
        WebView webView = (WebView) findViewById(R.id.webViewn13);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://watthaiapp.6te.net/watsantitummaram1.html");

        TabHost.TabSpec tab_map = tabHost.newTabSpec ("MAP");
        tab_map.setIndicator ("แผนที่");
        tab_map.setContent (R.id.map13);
        tabHost.addTab (tab_map);

        TabHost.TabSpec tab_news = tabHost.newTabSpec ("NEWS");
        tab_news.setIndicator ("ข่าวสาร");
        tab_news.setContent (R.id.news13);
        tabHost.addTab (tab_news);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        ImageButton btn_watsantithammararmmap = (ImageButton) findViewById(R.id.btn_watsantithammararmmap);
        ImageButton btn_watsantithammararmmaplocation = (ImageButton) findViewById(R.id.btn_watsantithammararmmaplocation);
        ImageButton btn_watsantithammararmnews = (ImageButton) findViewById(R.id.btn_watsantithammararmnews);
        ImageButton btn_watsantithammararmnewswat = (ImageButton) findViewById(R.id.btn_watsantithammararmnewswat);


        btn_watsantithammararmmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("Lat", 13.706977);
                i.putExtra("Lng", 100.488643);
                i.putExtra("Title", "วัดสันติธรรมาราม");
                i.putExtra("Detail", "วัดราษฏร์, 13.706977, 100.488643");
                startActivity(i);
            }
        });
        btn_watsantithammararmmaplocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String latlng = "วัดสันติธรรมาราม เขต ธนบุรี กรุงเทพมหานคร 10600";
                String strUri = "http://maps.google.com/maps?q=loc:" + latlng + " (" + "วัดสันติธรรมาราม" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        btn_watsantithammararmnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(i);
            }
        });

        btn_watsantithammararmnewswat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NewsWatn13Activity.class);
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
