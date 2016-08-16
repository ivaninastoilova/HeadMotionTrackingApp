package com.example.userinterface.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Ivanina on 8.8.2016 г..
 */
public class GamesLevels extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_levels);
        String [] levels = getResources().getStringArray(R.array.levels);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,levels);

        ListView lv = (ListView) findViewById(R.id.listView2);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if (position == 0) {
                   Intent intent = new Intent(GamesLevels.this, LevelOne.class);
                   GamesLevels.this.startActivity(intent);
               }
                    else if (position ==1 ) {
                   Intent intent1 = new Intent(GamesLevels.this, LevelTwo.class);
                   GamesLevels.this.startActivity(intent1);
               }
                   else if (position == 2){
                        Intent intent2 = new Intent(GamesLevels.this, LevelThree.class);
                        GamesLevels.this.startActivity(intent2);
                }
                }
            });
        }
    }

