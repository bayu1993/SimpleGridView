package com.bayu1993.simplegridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;

public class StaggeredGridActivity extends AppCompatActivity {
    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "https://s-media-cache-ak0.pinimg.com/originals/3c/91/28/3c9128672d9d23a12061ea2ec6b73702.jpg",
            "http://upload2.inven.co.kr/upload/2017/04/24/bbs/i14320163803.jpg",
            "https://s3.amazonaws.com/lowres.cartoonstock.com/caricatures-jurgen_klopp-lfc-liverpool_football_club-football_manager-football_coach-pkin117_low.jpg",
            "http://www.caricatures.ie/wp-content/uploads/2015/10/Jurgen-Klopp-liverpool.jpg",
            "https://www.toonpool.com/user/21238/files/klopp_3_liverpool_2793345.jpg",
            "http://i.dailymail.co.uk/i/pix/2015/10/12/13/2D545EED00000578-3269408-image-m-6_1444653944402.jpg",
            "https://scontent.cdninstagram.com/t51.2885-15/s480x480/e35/12145109_1170269239669254_1991061154_n.jpg?ig_cache_key=MTExMDQ1NDQwNzkzNTMxNjQxMg%3D%3D.2",
            "https://res.cloudinary.com/teepublic/image/private/s--71FHkTtW--/t_Preview/b_rgb:c62b29,c_limit,f_auto,h_313,q_90,w_313/v1462561073/production/designs/504703_1",
            "http://orig13.deviantart.net/1135/f/2016/028/e/f/klopp_wpap2_by_wahyuwidiyanto-d9pmboi.jpg",
            "https://i.pinimg.com/236x/ab/cd/24/abcd247ece0ba42eb2bcc4a2c2e38726--liverpool-tattoo-ronaldinho-poster.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);

        getSupportActionBar().setTitle("Jurgen Klopp Designs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView)findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(StaggeredGridActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //handle action bar item clicks here. The action bar will
//        automatically handle click on the home/up button, so long
//        as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();

//        noninspection SimplifiableIfStatement
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(Context context){
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }
}
