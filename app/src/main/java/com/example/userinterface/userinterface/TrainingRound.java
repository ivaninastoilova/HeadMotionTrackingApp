package com.example.userinterface.userinterface;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.st.BlueSTSDK.Feature;
import com.st.BlueSTSDK.Features.FeatureAcceleration;
import com.st.BlueSTSDK.Features.FeatureAccelerationEvent;
import com.st.BlueSTSDK.Features.FeatureGyroscope;
import com.st.BlueSTSDK.Features.FeatureMemsSensorFusion;
import com.st.BlueSTSDK.Log.FeatureLogDB;
import com.st.BlueSTSDK.Manager;
import com.st.BlueSTSDK.Node;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Ivanina on 8.8.2016 г..
 */
public class TrainingRound extends AppCompatActivity {

    Timer myTimer = new Timer();
    float maxValue = 0;
    float minValue = 0;
    Movement m = new Movement ();

    private void TimerMethod()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_round);

        String [] movements = getResources().getStringArray(R.array.movements);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,movements);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0) {
                    myTimer.scheduleAtFixedRate(new TimerTask() {
                        long t0 = System.currentTimeMillis();
                        @Override
                        public void run() {
                            if (System.currentTimeMillis() - t0 < 5000) {

                                minValue = m.getMinValue((FeatureGyroscope.getGyroZ(MyManager.getInstance().getNode().getFeature(FeatureGyroscope.class).getSample())));
                                Log.d("data", String.valueOf(minValue));
                            }
                             else {
                                cancel();
                            }
                        }
                    }, 0, 500);
                    Movement m = new Movement();
                    m.detectTiltRight(minValue);
                }

            }

            });


        }

    }
