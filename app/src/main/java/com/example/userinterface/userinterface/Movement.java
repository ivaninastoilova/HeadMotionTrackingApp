package com.example.userinterface.userinterface;

import android.util.Log;

/**
 * Created by Ivanina on 14.8.2016 г..
 */
public class Movement {

    public float getMaxValue (float value)
    {
       float maxValue = 0;
       if (value>maxValue)
       {
           maxValue = value;
       }
       return maxValue;
    }

    public float getMinValue (float value)
    {
        float minValue = 0;
        if (minValue>value)
        {
            minValue = value;
        }
        return minValue;
    }

    public void detectTiltRight(float minGyroZ)
    {
        if (minGyroZ<(-30))
        {
            Log.d("1","This was a tilt to the right.");
        }
        else
        {
            Log.d("2","Please try again.");
        }
    }

    public void detectTiltLeft(float maxGyroZ)
    {
        if (maxGyroZ>30)
        {
            Log.d("1","This was a tilt to the left.");
        }
        else
        {
            Log.d("2","Please try again.");
        }
    }

    public void detectMoveForwards(float maxGyroX)
    {
        if (maxGyroX>40)
        {
            Log.d("1","This was a move forwards.");
        }
        else
        {
            Log.d("2","Please try again.");
        }
    }

    public void detectMoveBackwards(float minGyroX)
    {
        if (minGyroX<(-40))
        {
            Log.d("1","This was a move backwards.");
        }
        else
        {
            Log.d("2","Please try again.");
        }
    }

    public void detectMoveRight(float maxGyroY)
    {
        if (maxGyroY>50)
        {
            Log.d("1","This was a move to the right.");
        }
        else
        {
            Log.d("2","Please try again.");
        }
    }

    public void detectMoveLeft(float minGyroY)
    {
        if (minGyroY<(-40))
        {
            Log.d("1","This was a move to the left.");
        }
        else
        {
            Log.d("2","Please try again.");
        }
    }
}
