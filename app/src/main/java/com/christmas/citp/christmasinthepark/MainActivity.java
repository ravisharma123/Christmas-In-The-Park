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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton donateButton =(ImageButton) findViewById(R.id.imageButton7);
        ImageButton fbButton =(ImageButton) findViewById(R.id.imageButton8);
        ImageButton twitterButton = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton instaButton = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton uTubeButton = (ImageButton) findViewById(R.id.imageButton11);


        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/us/cgi-bin/webscr?cmd=_flow&SESSION=p2L6x-x6A_Udwj90TXXXNmKJD0G3ufdFrJKkwfB_ODoou6X4BfBuzkJCi4q&dispatch=5885d80a13c0db1f8e263663d3faee8de62a88b92df045c56447d40d60b23a7c"));
                startActivity(i);
            }
        });
        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/183825781669765"));
                Intent chooser = Intent.createChooser(i,"facebook");
                startActivity(chooser);
            }
        });
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/xmasintheparksj"));
                startActivity(i);
            }
        });
        instaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/christmasintheparksj"));
                startActivity(i);
            }
        });
        uTubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/xmasinthepark"));
                startActivity(i);
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
