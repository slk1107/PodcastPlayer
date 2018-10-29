package com.example.kuanglin.podcastplayer.controller;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class PodcastPlayer {

    private MediaPlayer mediaPlayer;
    private static PodcastPlayer instance;

    public static PodcastPlayer getInstance () {
        if(instance == null) {
            instance = new PodcastPlayer();
        }
        return instance;
    }

    private PodcastPlayer() {
        mediaPlayer = new MediaPlayer();
    }

    void startMusicPlayer(AssetFileDescriptor descriptor, long start, long end) {
        stopMusicPlayer();

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), start, end);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Throwable e) { // setDataSource() or prepare() may throws
            stopMusicPlayer();
        }
    }

    void stopMusicPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(null);
            mediaPlayer.setOnSeekCompleteListener(null);
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

//        mMusicPlayProgressHandler.removeCallbacks(mUpdateMusicProgressRunnable);
    }

    void stopMusic() {
        stopMusicPlayer();
    }
}
