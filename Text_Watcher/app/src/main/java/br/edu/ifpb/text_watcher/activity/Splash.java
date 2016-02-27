package br.edu.ifpb.text_watcher.activity;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import br.edu.ifpb.text_watcher.MainActivity;
import br.edu.ifpb.text_watcher.R;

public class Splash extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handle = new Handler();
        handler.postDelayed(Splash.this, 3500);
    }
    public void run(){
        startActivity(new Intent(Splash.this, MainActivity.class));
        finish();
    }
}
