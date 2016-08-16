//http://www.jameselsey.co.uk/blogs/techblog/android-a-really-easy-tutorial-on-how-to-use-text-to-speech-tts-and-how-you-can-enter-text-and-have-it-spoken/
package com.example.userinterface.userinterface;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.st.BlueSTSDK.Manager;
import com.st.BlueSTSDK.Utils.NodeScanActivity;

import java.util.Locale;

public class MainActivity extends NodeScanActivity  {

    private final static int SCAN_TIME_MS = 10 * 1000;
    private MyManagerListener myManagerListener = new MyManagerListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyManager.getInstance().setContext(this);
        mManager.addListener(myManagerListener);
        startNodeDiscovery(SCAN_TIME_MS);
    }

    public void restartDiscovery()
    {
        mManager.resetDiscovery();
    }

    public void setNewManagerListener ()
    {
        mManager.removeListener(myManagerListener);
        myManagerListener = new MyManagerListener();
        mManager.addListener(myManagerListener);
    }

    public void trainingRoundStart(View view) {
       Intent intent = new Intent(this,TrainingRound.class);
        this.startActivity(intent);

    }

    public void gamesLevelsStart(View view) {
        Intent intent = new Intent(this,GamesLevels.class);
        this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }



}
