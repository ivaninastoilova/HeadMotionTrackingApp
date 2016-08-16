package com.example.userinterface.userinterface;

import android.util.Log;
import com.st.BlueSTSDK.Feature;
import com.st.BlueSTSDK.Features.FeatureAcceleration;
import com.st.BlueSTSDK.Features.FeatureGyroscope;
import com.st.BlueSTSDK.Features.FeatureMemsSensorFusion;
import com.st.BlueSTSDK.Manager;
import com.st.BlueSTSDK.Node;
import java.util.List;
import android.util.Log;
import com.st.BlueSTSDK.Feature;
import com.st.BlueSTSDK.Features.FeatureAcceleration;
import com.st.BlueSTSDK.Node;
import com.st.BlueSTSDK.Utils.NodeScanActivity;

import java.util.List;

/**
 * Created by Ivanina on 1.8.2016 г..
 */
public class MyNodeListener implements Node.NodeStateListener {
    @Override
    public void onStateChange(final Node node, Node.State newState, Node.State prevState) {
        if (newState == Node.State.Connected)
        {
            ((MainActivity) MyManager.getInstance().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    Log.d("OK", "OK");
                    if (node != null) {
                        List<Feature> features = node.getFeatures();
                        for (Feature f : features) {
                            if (f.isEnabled()) {
                                Log.d(f.getName(), String.valueOf(f.getSample()));
                            }
                        }
                    }
                }
            });

            //node.addNodeStateListener(listener);
            node.enableNotification(node.getFeature(FeatureGyroscope.class));
            node.getFeature(FeatureGyroscope.class).addFeatureListener(new GyroscopeListener());
           node.enableNotification(node.getFeature(FeatureAcceleration.class));
            node.getFeature(FeatureAcceleration.class).addFeatureListener(new AccelerometerListener());
            node.enableNotification(node.getFeature(FeatureMemsSensorFusion.class));
            node.getFeature(FeatureMemsSensorFusion.class).addFeatureListener(new FusionListener());
            Log.d("---------------------", String.valueOf (node.isEnableNotification(node.getFeature(FeatureGyroscope.class))));


        }
        else if(newState == Node.State.Connecting)
        {
            Log.d("Node ---", "Connecting");
        }
        else if (newState == Node.State.Unreachable ||
                    newState == Node.State.Dead ||
                    newState == Node.State.Lost)
        {
            node.disconnect();
            ((MainActivity)MyManager.getInstance().getContext()).restartDiscovery();
            ((MainActivity)MyManager.getInstance().getContext()).startNodeDiscovery(10000);
            Log.d("Node ---", "Lost connection. Reconnecting...");

        }


    }
}
