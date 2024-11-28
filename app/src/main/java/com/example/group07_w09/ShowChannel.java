package com.example.group07_w09;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowChannel extends AppCompatActivity {
    String[] topicsList = {"Suckhoe", "Doisong", "Khoahoc", "Xe", "Thethao"};
    ListView topics;
    String[] topicUrlList = {"https://vnexpress.net/rss/suc-khoe.rss", "https://vnexpress.net/rss/gia-dinh.rss", "https://vnexpress.net/rss/khoa-hoc.rss", "https://vnexpress.net/rss/oto-xe-may.rss", "https://vnexpress.net/rss/the-thao.rss"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_layout);
        topics = findViewById(R.id.topics);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.site_item, topicsList);
        topics.setAdapter(adapter);
        topics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent callShowHeadline = new Intent(ShowChannel.this, ShowHeadline.class);
                Bundle bundle = new Bundle();
                bundle.putString("urlCaption", topicsList[i]);
                bundle.putString("urlAddress", topicUrlList[i]);
                callShowHeadline.putExtras(bundle);
                startActivity(callShowHeadline);
            }
        });
    }
}
