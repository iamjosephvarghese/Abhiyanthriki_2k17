package roundmelon.jv.a3k;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class Edit extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    private NavigationView navView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.startFlipping();



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent selfiIntent = new Intent(Edit.this,Selfie.class);
//                startActivity(selfiIntent);
//;
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_registration) {

            String link = "https://a3k.in/reg";
            Intent regIntent = new Intent(Edit.this,Web.class);
            regIntent.putExtra("weblink",link);
            startActivity(regIntent);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_selfie) {
            Intent selfieIntent = new Intent(Edit.this,Selfie.class);
            startActivity(selfieIntent);

        } else if (id == R.id.nav_selfiegallery) {
            Intent galleryIntent = new Intent(Edit.this,SelfieGallery.class);
            startActivity(galleryIntent);

        }
//        else if (id == R.id.nav_live) {
//            ///
//
//        } else if (id == R.id.nav_updates) {
//
//            //
//        }
        else if (id == R.id.nav_events) {

            Intent eventIntent = new Intent(Edit.this,Events.class);
            startActivity(eventIntent);
        } else if (id == R.id.nav_rank) {
            Intent rankIntent = new Intent(Edit.this,Results.class);
            startActivity(rankIntent);

        }else if (id == R.id.nav_register) {
            String link = "https://a3k.in/reg";
            Intent regIntent = new Intent(Edit.this,Web.class);
            regIntent.putExtra("weblink",link);
            startActivity(regIntent);

        }else if (id == R.id.nav_badge) {
            Intent fbIntent = new Intent(Edit.this,Fb.class);
            startActivity(fbIntent);

        }
//        else if (id == R.id.nav_share) {
//
//            //share intent
//
//        }else if (id == R.id.nav_about) {
//
//            //make a new activity
//
//        }
//        else if (id == R.id.nav_video) {
//
//            Intent videoIntent = new Intent(Edit.this,Video.class);
//            startActivity(videoIntent);
//
//        }
        else if (id == R.id.nav_gallery) {

        Intent videoIntent = new Intent(Edit.this,Gallery.class);
        startActivity(videoIntent);

    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/bebasneue.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

}
