package com.example.userinterface.userinterface;

import android.util.Log;

import com.st.BlueSTSDK.Manager;
import com.st.BlueSTSDK.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivanina on 10.8.2016 г..
 */
public class MyManagerListener implements Manager.ManagerListener {
        private List<Node> nodes = new ArrayList<Node>();
        private Node node;
        private String name;
        @Override

        public void onDiscoveryChange(Manager m, final boolean enabled) {
            ((MainActivity)MyManager.getInstance().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (enabled)
                        Log.d("Discovery", "started" );
                    else {
                        Log.d("Discovery", "stopped");

                    }
                }
            });
        }

        @Override
        public void onNodeDiscovered(Manager m, final Node node) {
                MyManager.getInstance().onNodeDiscovered(node);
        }
    }

