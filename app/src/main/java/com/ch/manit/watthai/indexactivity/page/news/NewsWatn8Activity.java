package com.ch.manit.watthai.indexactivity.page.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.ch.manit.watthai.R;

public class NewsWatn8Activity extends AppCompatActivity {

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_newswatn8);
            ImageButton back = (ImageButton) findViewById(R.id.back);

            WebView webView = (WebView) findViewById(R.id.webViewn008);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://appwat.16mb.com/news.php?cat=วัดบางสะแกใน");

            back.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }


}


