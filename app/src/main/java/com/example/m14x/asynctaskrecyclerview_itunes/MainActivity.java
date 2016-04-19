package com.example.m14x.asynctaskrecyclerview_itunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.m14x.asynctaskrecyclerview_itunes.Controller.DownloadTask;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private  URL url;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm2);
        recyclerView.setHasFixedSize(true);
        try {
            getData();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void getData() throws MalformedURLException {
        url = new URL("http://itunes.apple.com/search?term=rock");
        DownloadTask task = new DownloadTask(recyclerView,getApplicationContext());
        task.execute(url);
    }
}
