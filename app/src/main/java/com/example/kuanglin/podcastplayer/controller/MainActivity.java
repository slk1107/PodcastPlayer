package com.example.kuanglin.podcastplayer.controller;

import android.content.res.AssetFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kuanglin.podcastplayer.R;
import com.example.kuanglin.podcastplayer.data.PodcastItem;
import com.example.kuanglin.podcastplayer.data.PodcastManager;
import com.example.kuanglin.podcastplayer.view.PodcastListAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PodcastListAdapter adapter;
    Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        initAdapter();
        bindComponents();
        initViews();
    }

    private void bindComponents() {
        stopButton = findViewById(R.id.stop);
    }

    private void initAdapter() {
        ArrayList<PodcastItem> podcastList = PodcastManager.getInstance().getPodcastList();
        adapter = new PodcastListAdapter(this, podcastList, new PodcastListAdapter.OnItemClickListener() {
            @Override
            public void onClick(String path) {
                playPodCast(path);
            }
        });
    }

    private void initViews() {
        final RecyclerView podcastListView = findViewById(R.id.podcast_list);
        podcastListView.setAdapter(adapter);
        podcastListView.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStopClick();
            }
        });

        showStopButton(false);
    }

    private void onStopClick() {
        PodcastPlayer.getInstance().stopMusic();
        showStopButton(false);
    }

    private void playPodCast(String fileName) {
        try {
            AssetFileDescriptor descriptor = getAssets().openFd(fileName);
            long start = descriptor.getStartOffset();
            long end = descriptor.getLength();
            PodcastPlayer.getInstance().startMusicPlayer(descriptor, start, end);
            showStopButton(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showStopButton(boolean show) {
        stopButton.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}
