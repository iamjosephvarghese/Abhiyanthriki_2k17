package roundmelon.jv.a3k;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    private Button event1;
    private Button event2;
    private Button event3;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        event1 = (Button)findViewById(R.id.event1);
        event2 = (Button)findViewById(R.id.event2);
        event3 = (Button)findViewById(R.id.event3);
        textResult = (TextView)findViewById(R.id.textResult);

        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent event1Intent = new Intent(Results.this,Terrain.class);
//                startActivity(event1Intent);


                Intent intent = new Intent(Results.this,Terrain.class);
                intent.putExtra("root","terrainresult");
                intent.putExtra("num","terrainover");
                startActivity(intent);

            }
        });


        event2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent event2Intent = new Intent(Results.this,Typing.class);
//                startActivity(event2Intent);

                Intent intent = new Intent(Results.this,Terrain.class);
                intent.putExtra("root","typingresult");
                intent.putExtra("num","typingover");
                startActivity(intent);

            }
        });

        event3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Results.this,Terrain.class);
                intent.putExtra("root","deadresult");
                intent.putExtra("num","deadover");
                startActivity(intent);

            }
        });

        Typeface bebas = Typeface.createFromAsset(getAssets(),  "fonts/bebasneue.ttf");
        textResult.setTypeface(bebas);
        event1.setTypeface(bebas);
        event2.setTypeface(bebas);
        event3.setTypeface(bebas);



    }
}
