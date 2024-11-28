package com.example.group07_w09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    GridView sites;
    String[] sitesList = {"VNExpress", "Dantri", "Tienphong"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sites = findViewById(R.id.sites);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.site_item, sitesList);
        sites.setAdapter(adapter);
        sites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent callShowChannel = new Intent(MainActivity.this, ShowChannel.class);
                Bundle bundle = new Bundle();
                bundle.putString("siteName", sitesList[i]);
                callShowChannel.putExtras(bundle);
                startActivity(callShowChannel);
            }
        });
    }
}