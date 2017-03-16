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
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Faei.jpg?alt=media&token=ede3a568-9d3c-4391-b8e9-cf1abf54a525")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ae);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fce.jpg?alt=media&token=cdd2143d-a024-4d75-9a3a-87ba9bb90530")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(civil);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fcs.jpg?alt=media&token=96dbc3c6-ea1c-48ba-aa3c-42ea2b728f3c")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(cs);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fec.jpg?alt=media&token=9c100275-bb85-4123-aff4-aaeeed957cd9")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ec);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Feee.jpg?alt=media&token=13fd22c0-5279-4f6a-844f-0e44c7301a3e")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(eee);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fit.jpg?alt=media&token=751fd97d-653f-447b-9669-1cda30302cff")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(it);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fmech.jpg?alt=media&token=ac76677f-b26d-4a31-82a6-76c9253678b6")
                .placeholder(R.drawable.a3klogo)
                .override(150,200)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mech);

        Glide.with(Events.this)
                .load("https://firebasestorage.googleapis.com/v0/b/rset-63188.appspot.com/o/departments%2Fnon-tech.jpg?alt=media&token=2d80abc7-6a23-4c90-baa4-2cf0af0bf04d")
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
