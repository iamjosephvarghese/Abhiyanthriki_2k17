package roundmelon.jv.a3k;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Events extends AppCompatActivity {

    private ImageView ae;
    private ImageView civil;
    private ImageView cs;
    private ImageView ec;
    private ImageView eee;
    private ImageView it;
    private ImageView mech;
    private ImageView gen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
/*
make images 300 x 300 and reupload to firebase

then change the link of each

change order
look site and update
 */



        ae = (ImageView)findViewById(R.id.ae);
        civil = (ImageView)findViewById(R.id.civil);
        cs = (ImageView)findViewById(R.id.cs);
        ec = (ImageView)findViewById(R.id.ec);
        eee = (ImageView)findViewById(R.id.eee);
        it = (ImageView)findViewById(R.id.it);
        mech = (ImageView)findViewById(R.id.mech);
        gen = (ImageView)findViewById(R.id.gen);


        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Faei.jpg?alt=media&token=b7878987-182a-4f58-b103-2994e12557ce")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ae);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fce.jpg?alt=media&token=41ade3cb-2689-4f34-9aa3-ecdf40b7535a")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(civil);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fcs.jpg?alt=media&token=41591e2e-ebf4-4e85-9172-1e1fe71f069e")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(cs);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fec.jpg?alt=media&token=d03a893b-cfaa-4cd4-9c75-ac7af5f154e2")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ec);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Feee.jpg?alt=media&token=893e30ab-0f59-4615-9363-44657af555d3")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(eee);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fit.jpg?alt=media&token=1a17eab1-f19e-4d81-a1af-c9509094e0c0")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(it);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fmech.jpg?alt=media&token=4b515fc7-517a-4fab-814e-a1f0b70be46f")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mech);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fnon-tech.jpg?alt=media&token=52bbeb7a-36b7-4987-b61f-21fc5e4b33c5")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(gen);



        ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String link = "https://a3k.in/events/index.html?dept=aei";
                Intent aeIntent = new Intent(Events.this,Web.class);
                aeIntent.putExtra("weblink",link);
                startActivity(aeIntent);


            }
        });


        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=ce";
                Intent civilIntent = new Intent(Events.this,Web.class);
                civilIntent.putExtra("weblink",link);
                startActivity(civilIntent);

            }
        });

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=cs";
                Intent csIntent = new Intent(Events.this,Web.class);
                csIntent.putExtra("weblink",link);
                startActivity(csIntent);

            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=ec";
                Intent ecIntent = new Intent(Events.this,Web.class);
                ecIntent.putExtra("weblink",link);
                startActivity(ecIntent);

            }
        });
        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=eee";
                Intent eeeIntent = new Intent(Events.this,Web.class);
                eeeIntent.putExtra("weblink",link);
                startActivity(eeeIntent);

            }
        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=it";
                Intent itIntent = new Intent(Events.this,Web.class);
                itIntent.putExtra("weblink",link);
                startActivity(itIntent);

            }
        });
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=mech";
                Intent mechIntent = new Intent(Events.this,Web.class);
                mechIntent.putExtra("weblink",link);
                startActivity(mechIntent);

            }
        });
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://a3k.in/events/index.html?dept=non-tech";
                Intent genIntent = new Intent(Events.this,Web.class);
                genIntent.putExtra("weblink",link);
                startActivity(genIntent);

            }
        });




    }
}
