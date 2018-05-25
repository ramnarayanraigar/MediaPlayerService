package raigar.ramnarayan.mediaplayerservice.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;

import raigar.ramnarayan.mediaplayerservice.R;

/**
 * Created by kriscent on 23/5/18.
 */

public class MediaPlayerService extends Service {
    private static final String TAG = MediaPlayerService.class.getSimpleName();
    private MediaPlayer mMediaPlayer = new MediaPlayer();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startSong();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        mMediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void startSong() {
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer = MediaPlayer.create(this, R.raw.a);
        mMediaPlayer.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    mMediaPlayer.stop();
                } catch (Exception e) {

                }
            }
        }, 10000);
    }
}
