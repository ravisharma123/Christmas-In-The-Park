package com.christmas.citp.christmasinthepark;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    private ImageButton mFB;
    private ImageButton mInsta;
    private ImageButton mTwitter;
    private ImageButton mYT;
    private ImageButton mDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFB = (ImageButton) findViewById(R.id.fbicon);
        mFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fb = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/183825781669765"));
                Intent chooser = Intent.createChooser(fb, "Facebook"); // Ravi's
                startActivity(chooser);
            }
        });

        mTwitter = (ImageButton) findViewById(R.id.twtricon);
        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=292451521"));
                startActivity(twitter);
            }
        });

        mYT = (ImageButton) findViewById(R.id.yticon);
        mYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/xmasinthepark"));
                startActivity(yt);
            }
        });

        mInsta = (ImageButton) findViewById(R.id.instaicon);
        mInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ravi's Instagram Link
                Intent insta = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/christmasintheparksj"));
                startActivity(insta);
            }
        });

        mDonate = (ImageButton) findViewById(R.id.donate); // Ravi's version cleaned up
        mDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ravi's Donate Link
                Intent donate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/us/cgi-bin/webscr?cmd=_flow&SESSION=p2L6x-x6A_Udwj90TXXXNmKJD0G3ufdFrJKkwfB_ODoou6X4BfBuzkJCi4q&dispatch=5885d80a13c0db1f8e263663d3faee8de62a88b92df045c56447d40d60b23a7c"));
                startActivity(donate);
            }
        });
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

        return super.onOptionsItemSelected(item);
    }
}
