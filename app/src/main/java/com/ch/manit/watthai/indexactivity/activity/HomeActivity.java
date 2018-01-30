package com.ch.manit.watthai.indexactivity.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.ch.manit.watthai.R;
import com.ch.manit.watthai.indexactivity.page.WebhelpMapActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatbangnamchonActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatbangsachaenaiActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatbangsachaenorkActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatbangsaikaiActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatbukkarowActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatbuppharhrmActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatdowkanorngActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatgheycheesuphanActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WathiranrugeActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatintararmvoraviharnActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatjantarrarmvoraviharnActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatkajubphinijActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatkanrayanamitActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatkanthatarararmActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatkrangdowActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatmaiyueynuiActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatphadittharramActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatphonimitsatitmaharsremararmActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatprayutrawongsarvarsvoraviharnActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatrajakruvoraviharnActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatrajwarinActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatsantithammararmActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatsuttharwharsActivity;
import com.ch.manit.watthai.indexactivity.page.watrat.WatwararmartayaphanthasarrararmActivity;
import com.ch.manit.watthai.indexactivity.page.phaaramluang.WatweyrurachinActivity;

public class HomeActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton back = (ImageButton) findViewById(R.id.back);
        ImageButton help = (ImageButton) findViewById(R.id.help);

        help.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching Screen
                Intent i = new Intent(getApplicationContext(), WebhelpMapActivity.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //tabhost
        TabHost tabHost = (TabHost) this.findViewById (R.id.tabhost);
        tabHost.setup ( );

        TabHost.TabSpec tab_watrat = tabHost.newTabSpec ("WATRAT");
        tab_watrat.setIndicator ("วัดราษฏร์");
        tab_watrat.setContent (R.id.watrat);
        tabHost.addTab (tab_watrat);

        TabHost.TabSpec tab_phaaramluang = tabHost.newTabSpec ("PHAARAMLUANG");
        tab_phaaramluang.setIndicator ("พระอารามหลวง");
        tab_phaaramluang.setContent (R.id.phaaramluang);
        tabHost.addTab (tab_phaaramluang);

        TabWidget tabWidget = tabHost.getTabWidget ();
        tabWidget.setEnabled (true);//endtabhost

        // watrat
        ImageButton btn_watgheycheesuphan = (ImageButton) findViewById(R.id.btn_watgheycheesuphan);
        ImageButton btn_watbangsaikai = (ImageButton) findViewById(R.id.btn_watbangsaikai);
        ImageButton btn_watkajubphinij = (ImageButton) findViewById(R.id.btn_watkajubphinij);
        ImageButton btn_watkrangdow = (ImageButton) findViewById(R.id.btn_watkrangdow);
        ImageButton btn_watkanthatarararm = (ImageButton) findViewById(R.id.btn_watkanthatarararm);
        ImageButton btn_watdowkanorng = (ImageButton) findViewById(R.id.btn_watdowkanorng);
        ImageButton btn_watbangnamchon = (ImageButton) findViewById(R.id.btn_watbangnamchon);
        ImageButton btn_watbangsachaenork = (ImageButton) findViewById(R.id.btn_watbangsachaenork);
        ImageButton btn_watbangsachaenai = (ImageButton) findViewById(R.id.btn_watbangsachaenai);
        ImageButton btn_watbukkarow = (ImageButton) findViewById(R.id.btn_watbukkarow);
        ImageButton btn_watphadittharram = (ImageButton) findViewById(R.id.btn_watphadittharram);
        ImageButton btn_watrajwarin = (ImageButton) findViewById(R.id.btn_watrajwarin);
        ImageButton btn_watwararmartayaphanthasarrararm = (ImageButton) findViewById(R.id.btn_watwararmartayaphanthasarrararm);
        ImageButton btn_watsantithammararm = (ImageButton) findViewById(R.id.btn_watsantithammararm);
        ImageButton btn_watsuttharwhars = (ImageButton) findViewById(R.id.btn_watsuttharwhars);
        ImageButton btn_watmaiyueynui= (ImageButton) findViewById(R.id.btn_watmaiyueynui);

        //phaaramluang
        ImageButton btn_watbuppharhrm = (ImageButton) findViewById(R.id.btn_watbuppharhrm);
        ImageButton btn_watkanrayanamit = (ImageButton) findViewById(R.id.btn_watkanrayanamit);
        ImageButton btn_wathiranruge = (ImageButton) findViewById(R.id.btn_wathiranruge);
        ImageButton btn_watjantarrarmvoraviharn = (ImageButton) findViewById(R.id.btn_watjantarrarmvoraviharn);
        ImageButton btn_watprayutrawongsarvarsvoraviharn = (ImageButton) findViewById(R.id.btn_watprayutrawongsarvarsvoraviharn);
        ImageButton btn_watphonimitsatitmaharsremararm = (ImageButton) findViewById(R.id.btn_watphonimitsatitmaharsremararm);
        ImageButton btn_watrajakruvoraviharn = (ImageButton) findViewById(R.id.btn_watrajakruvoraviharn);
        ImageButton btn_watweyrurachin = (ImageButton) findViewById(R.id.btn_watweyrurachin);
        ImageButton btn_watintararmvoraviharn = (ImageButton) findViewById(R.id.btn_watintararmvoraviharn);


        //click watratdetail
        btn_watgheycheesuphan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching Screen
                Intent i = new Intent(getApplicationContext(), WatgheycheesuphanActivity.class);
                startActivity(i);
            }
        });
        btn_watbangsaikai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatbangsaikaiActivity.class);
                startActivity(i);
            }
        });
        btn_watkajubphinij.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatkajubphinijActivity.class);
                startActivity(i);
            }
        });
        btn_watkrangdow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatkrangdowActivity.class);
                startActivity(i);
            }
        });
        btn_watkanthatarararm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatkanthatarararmActivity.class);
                startActivity(i);
            }
        });
        btn_watdowkanorng.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatdowkanorngActivity.class);
                startActivity(i);
            }
        });
        btn_watbangnamchon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatbangnamchonActivity.class);
                startActivity(i);
            }
        });
        btn_watbangsachaenork.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatbangsachaenorkActivity.class);
                startActivity(i);
            }
        });
        btn_watbangsachaenai.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatbangsachaenaiActivity.class);
                startActivity(i);
            }
        });
        btn_watbukkarow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatbukkarowActivity.class);
                startActivity(i);
            }
        });
        btn_watphadittharram.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatphadittharramActivity.class);
                startActivity(i);
            }
        });
        btn_watrajwarin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatrajwarinActivity.class);
                startActivity(i);
            }
        });
        btn_watwararmartayaphanthasarrararm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatwararmartayaphanthasarrararmActivity.class);
                startActivity(i);
            }
        });
        btn_watsantithammararm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatsantithammararmActivity.class);
                startActivity(i);
            }
        });
        btn_watsuttharwhars.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatsuttharwharsActivity.class);
                startActivity(i);
            }
        });
        btn_watmaiyueynui.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatmaiyueynuiActivity.class);
                startActivity(i);
            }
        });
        //end clickwatratdetail


        //click phaaramluangdetail
        btn_watbuppharhrm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatbuppharhrmActivity.class);
                startActivity(i);
            }
        });
        btn_watkanrayanamit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatkanrayanamitActivity.class);
                startActivity(i);
            }
        });
        btn_wathiranruge.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WathiranrugeActivity.class);
                startActivity(i);
            }
        });
        btn_watjantarrarmvoraviharn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatjantarrarmvoraviharnActivity.class);
                startActivity(i);
            }
        });
        btn_watprayutrawongsarvarsvoraviharn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatprayutrawongsarvarsvoraviharnActivity.class);
                startActivity(i);
            }
        });
        btn_watphonimitsatitmaharsremararm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatphonimitsatitmaharsremararmActivity.class);
                startActivity(i);
            }
        });
        btn_watrajakruvoraviharn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatrajakruvoraviharnActivity.class);
                startActivity(i);
            }
        });
        btn_watweyrurachin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatweyrurachinActivity.class);
                startActivity(i);
            }
        });
        btn_watintararmvoraviharn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), WatintararmvoraviharnActivity.class);
                startActivity(i);
            }
        });
        //end clickphaaramluangdetail
    }
}//main
