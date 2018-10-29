package com.example.kuanglin.podcastplayer.data;

public class PodcastItem {
    private String title;
    private String fileName;

    PodcastItem(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTitle() {
        return title;
    }
}
