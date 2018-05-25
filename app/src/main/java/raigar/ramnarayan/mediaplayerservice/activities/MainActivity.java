package raigar.ramnarayan.mediaplayerservice.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import raigar.ramnarayan.mediaplayerservice.R;
import raigar.ramnarayan.mediaplayerservice.services.MediaPlayerService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    public  Button mBtnStart;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        initViews();
        clicks();
        //startService();
    }

    private void initViews() {
        mBtnStart = findViewById(R.id.start);
    }

    private void clicks() {
        mBtnStart.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService();
    }

    private void startService() {
        Intent intent = new Intent(MainActivity.this, MediaPlayerService.class);
        startService(intent);
    }

    private void stopService() {
        Intent intent = new Intent(MainActivity.this, MediaPlayerService.class);
        stopService(intent);
    }

    @Override
    public void onClick(View v) {
       if (v == mBtnStart) {
           startService();
           mBtnStart.setEnabled(false);
           enableButton();
       }
    }

   private void enableButton() {
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
            mBtnStart.setEnabled(true);
          }
      }, 10000);
   }
}
