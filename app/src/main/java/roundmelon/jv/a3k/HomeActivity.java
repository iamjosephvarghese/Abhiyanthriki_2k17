package roundmelon.jv.a3k;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    final private int STORAGE_PERMISSION_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        Button fbbutton = (Button)findViewById(R.id.fbbutton);
        Button deadButton = (Button)findViewById(R.id.deadbutton);
        Button sitebutton = (Button)findViewById(R.id.sitebutton);






        fbbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isWriteStorageAllowed()){
                    //If permission is already having then showing the toast
                    // Toast.makeText(Upload.this,"You already have the permission",Toast.LENGTH_LONG).show();
                    //Existing the method with return
                    Intent fbIntent = new Intent(HomeActivity.this,Fb.class);
                    startActivity(fbIntent);

                    return;
                }

                //If the app has not the permission then asking for the permission
                requestStoragePermission();

            }
        });
        deadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deadIntent = new Intent(HomeActivity.this,Deadlock.class);
                startActivity(deadIntent);

            }
        });

        sitebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.a3k.in"));
                startActivity(browserIntent);
            }
        });




        Typeface bebas = Typeface.createFromAsset(getAssets(),  "fonts/bebasneue.ttf");


        fbbutton.setTypeface(bebas);
        deadButton.setTypeface(bebas);
        sitebutton.setTypeface(bebas);




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
    private boolean isWriteStorageAllowed() {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }
    //Requesting permission
    private void requestStoragePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
            Toast.makeText(this,"This permission is required to store the badge on your device.",Toast.LENGTH_LONG).show();
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity)this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION_CODE : {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent fbIntent = new Intent(HomeActivity.this,Fb.class);
                    startActivity(fbIntent);


                } else {
                    Toast.makeText(this,"Please grant the permission to access this feature.",Toast.LENGTH_LONG).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
