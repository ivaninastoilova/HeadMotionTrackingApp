package com.example.userinterface.userinterface;

import android.content.Context;
import android.util.Log;

import com.st.BlueSTSDK.Node;

/**
 * Created by Ivanina on 10.8.2016 г..
 */
public class MyManager {

        private static MyManager instance = null;
        private Context mContext;
        private Node mNode;
        MyNodeListener listener = new MyNodeListener();


    public static MyManager getInstance() {
        if (instance == null) {
            instance = new MyManager();
        }
        return instance;
    }
        public Node getNode() {
            return mNode;
        }

        public void setNode(Node mNode) {
            this.mNode = mNode;
        }

        public void setContext(Context context) {
            mContext = context;
        }

        public Context getContext() {
            return mContext;
        }

        public MyNodeListener getListener(){
            return listener;
        }

        public void setNewNodeListener ()
        {
            mNode.removeNodeStateListener(listener);
            MyNodeListener listenerNode = new MyNodeListener();
            mNode.addNodeStateListener(listenerNode);
            listener = listenerNode;
        }



        public void onNodeDiscovered(final Node node) {
                Log.d("Node ----", "Discovered");
                setNode(node);
            MyNodeListener listenerNode = new MyNodeListener();
            mNode.addNodeStateListener(listenerNode);
            listener = listenerNode;
            mNode.connect(mContext);
        }

    }




