package com.nsikakthompson.myprofile_hngtask;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

   private ImageView slack_action , github_action;
   private Button hire_me, portfolio;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        slack_action = findViewById(R.id.slack);
        github_action = findViewById(R.id.github);
        portfolio = findViewById(R.id.potfolio);
        hire_me = findViewById(R.id.hire_me);


        slack_action.setOnClickListener(this);
        github_action.setOnClickListener(this);
        portfolio.setOnClickListener(this);
        hire_me.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void intentToBrowswer(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
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

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){
            case R.id.slack:
                Snackbar.make(view, "tom@nsikak", Snackbar.LENGTH_LONG)
                        .setAction("Done", null).show();
                break;
            case R.id.github:
                intentToBrowswer("https://github.com/Nsikaktopdown/");

            case  R.id.potfolio:
                intentToBrowswer("hng.fun/profile/nsikakthompson.php");
                break;
            case R.id.hire_me:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL,  new String[]{"nsikakthompson73@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "I Want to Hire you");
                intent.putExtra(Intent.EXTRA_TEXT, " ");

                startActivity(Intent.createChooser(intent, "Send Email"));
                break;


                default:
                    break;


        }

    }
}
