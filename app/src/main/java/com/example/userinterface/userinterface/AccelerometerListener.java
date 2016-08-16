package com.example.userinterface.userinterface;

import android.util.Log;

import com.st.BlueSTSDK.Feature;
import com.st.BlueSTSDK.Features.FeatureAccelerationEvent;

/**
 * Created by Ivanina on 11.8.2016 г..
 */
public class AccelerometerListener implements FeatureAccelerationEvent.FeatureAccelerationEventListener {
        @Override
        public void onDetectableEventChange(FeatureAccelerationEvent f, FeatureAccelerationEvent.DetectableEvent event, boolean newStatus) {

        }

        @Override
        public void onUpdate(Feature f, final Feature.Sample sample) {

        }
    }

