package com.bayu1993.simplegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private String[] images = new String[]{
            "https://s-media-cache-ak0.pinimg.com/originals/3c/91/28/3c9128672d9d23a12061ea2ec6b73702.jpg",
            "http://1.bp.blogspot.com/_aZZHHFanjGc/SgMByK1761I/AAAAAAAAANA/FHjCAIrfP1k/s400/caricature_stevieg.jpg",
            "https://i2.wp.com/skybacherslocker.com/wp-content/uploads/2014/10/sturridge_liverpool1.jpg?resize=282%2C402",
            "https://s-media-cache-ak0.pinimg.com/736x/66/e8/b2/66e8b2a04cf4247c3e99bf26c8026a8d--football-pics-football-players.jpg",
            "https://www.trollfootball.me/upload/thumb/1234561_984414054932144_439463606_n.jpg",
            "https://ih1.redbubble.net/image.316203544.9689/flat,800x800,075,f.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRauLN_y1syk3FdsF4YLGBACozPpcivAeVDbPl5oMhas-yB1L2",
            "https://scontent.cdninstagram.com/t51.2885-15/e35/13704122_1748840265363510_740236767_n.jpg?ig_cache_key=MTMxMjYxODAxNjk2NTY4NjAyMQ%3D%3D.2",
            "https://www.toonpool.com/user/21238/files/lovren_liverpool_2890465.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/1f/fe/a7/1ffea75af91234f0574ed56707b17f2d--football-players-liverpool.jpg"
    };
    private GridView gridItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Liverpool Grapich");
        gridItem = (GridView)findViewById(R.id.grid_item);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, images);
        gridItem.setAdapter(itemGridAdapter);
        gridItem.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position,
                                    long id){
                DetailImageActivity.toDetailImageActivity(MainActivity.this, images[position]);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_straggered){
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
