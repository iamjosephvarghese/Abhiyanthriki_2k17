package roundmelon.jv.a3k;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView textView4;
    public TextView textView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        textView4 = (TextView)findViewById(R.id.textView4);
        textView6 = (TextView)findViewById(R.id.textView6);

        Typeface bebas = Typeface.createFromAsset(getAssets(),  "fonts/bebasneue.ttf");
        Typeface condensed = Typeface.createFromAsset(getAssets(), "fonts/condensedlight.ttf");

        textView4.setTypeface(bebas);
        textView6.setTypeface(condensed);


        final Animation an1= AnimationUtils.loadAnimation(getBaseContext(),R.anim.idle);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        final ConstraintLayout rl=(ConstraintLayout) findViewById(R.id.cl);
        rl.startAnimation(an1);
        an1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {



                //rl.startAnimation(an2);
                finish();




                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);


            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

}
