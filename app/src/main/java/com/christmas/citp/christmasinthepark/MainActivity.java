package com.christmas.citp.christmasinthepark;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.logging.Handler;


public class MainActivity extends ActionBarActivity {

    // Button Variables
    private ImageButton mFB;
    private ImageButton mInsta;
    private ImageButton mTwitter;
    private ImageButton mYT;
    private ImageButton mDonate;

    // Ornament Button Variables
    private ImageButton mOrn1;
    private ImageButton mOrn2;
    private ImageButton mOrn3;
    private ImageButton mOrn4;
    private ImageButton mOrn5;
    private ImageButton mOrn6;
    private ImageButton mOrn7;
    private ImageButton mOrn8;
    private ImageButton mOrn9;

    // Navigation Drawer Variables
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ACTION BAR MODIFICATIONS
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // DRAWER
        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        addDrawerItems();
        setupDrawer();

        // BUTTONS
        mFB = (ImageButton) findViewById(R.id.fb_icon);
        mFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CHECK IF FB IS INSTALLED. If not, open page in Browser
                boolean installed = appInstalledOrNot("com.facebook.katana");
                if (installed) {
                    // Ravi's FB Chooser
                    Intent fb = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/183825781669765"));
                    Intent chooser = Intent.createChooser(fb, "facebook");
                    startActivity(chooser);
                } else {
                    Intent fb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ChristmasintheParkSJ"));
                    startActivity(fb);
                }
            }
        });

        mTwitter = (ImageButton) findViewById(R.id.twitter_icon);
        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/xmasintheparksj"));
                startActivity(twitter);
            }
        });

        mYT = (ImageButton) findViewById(R.id.yt_icon);
        mYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/xmasinthepark"));
                startActivity(yt);
            }
        });

        mInsta = (ImageButton) findViewById(R.id.insta_icon);
        mInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ravi's Instagram Link
                Intent insta = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/christmasintheparksj"));
                startActivity(insta);
            }
        });

        mDonate = (ImageButton) findViewById(R.id.donate_icon); // Ravi's version cleaned up
        mDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.giveffect.com/charities/704"));
                startActivity(donate);
            }
        });

        // ORNAMENTS
        mOrn1 = (ImageButton) findViewById(R.id.ornament1);

        mOrn2 = (ImageButton) findViewById(R.id.ornament2);

        mOrn3 = (ImageButton) findViewById(R.id.ornament3);

        mOrn4 = (ImageButton) findViewById(R.id.ornament4);

        mOrn5 = (ImageButton) findViewById(R.id.ornament5);

        mOrn6 = (ImageButton) findViewById(R.id.ornament6);

        mOrn7 = (ImageButton) findViewById(R.id.ornament7);

        mOrn8 = (ImageButton) findViewById(R.id.ornament8);

        mOrn9 = (ImageButton) findViewById(R.id.ornament9);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    // Keep objects in sync when rotating landscape/portrait
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Checking if the user clicked on the Navigation Drawer
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // HELPER METHODS
    private void addDrawerItems() {
        String[] navArray = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navArray);
        mDrawerList.setAdapter(mAdapter);
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    // Check if FB is installed on device.
    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
}