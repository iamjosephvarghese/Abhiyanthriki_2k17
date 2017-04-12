package roundmelon.jv.a3k;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Terrain extends AppCompatActivity {
    ListView listresult;

    Firebase resultRef;
    ProgressDialog pDialog;
    String[] dummy;
    int countover = 0;
    int count;



    String pName[] = new String[101];
    String pTime[] = new String[101];
    String pRank[] = new String[101];
    String pClg[] = new String[101];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrain);

        Intent intent = getIntent();
        String root = intent.getExtras().getString("root");
        String num = intent.getExtras().getString("num");









        pDialog = new ProgressDialog(this);


        Firebase.setAndroidContext(this);

        Firebase mRootRef = new Firebase("https://rset-63188.firebaseio.com/");

//        resultRef = mRootRef.child("terrainresult");
//        Firebase numberRef = mRootRef.child("terrainover");


        resultRef = mRootRef.child(root);
        Firebase numberRef = mRootRef.child(num);

        pDialog.setMessage("Updating Data...");
        pDialog.show();
       // pDialog.setCancelable(false);


        numberRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                countover = Integer.parseInt(dataSnapshot.getValue(String.class));
                dummy= new String[countover];
                count = 0;
                resultRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Log.d("DEBUG","onChildAdded");
                        String res = dataSnapshot.getValue(String.class);
                        String pa[] = res.split("-");

                        pRank[count] = pa[0];
                        pName[count] = pa[1];
                        pTime[count] = pa[2];
                        pClg[count] = pa[3];

                        count++;
                        if(count == countover )
                            trigger();

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }

                });

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





    }





    private void trigger() {

        Log.d("DEBUG","Triggered");
        TerrainList adapter2 = new
                TerrainList(Terrain.this,pName,pTime,pRank,pClg,dummy);
        listresult=(ListView)findViewById(R.id.listViewTerrain);
        listresult.setAdapter(adapter2);

        if(pDialog.isShowing())
            pDialog.dismiss();

    }
}
