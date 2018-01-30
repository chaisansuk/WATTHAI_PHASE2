package com.ch.manit.watthai.indexactivity.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.ch.manit.watthai.R;


public class MainStartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_main);

        Button PortalNext = (Button) findViewById(R.id.start);
        PortalNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextPage = new Intent(MainStartActivity.this, HomeActivity.class);
                startActivity(nextPage);
            }
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Exit");
        dialog.setIcon(R.drawable.icon1);
        dialog.setCancelable(true);
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.show();
    }
}
