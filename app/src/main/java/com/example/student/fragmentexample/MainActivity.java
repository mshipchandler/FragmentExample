package com.example.student.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting a reference to the activity fragment manager
        FragmentManager manager = getFragmentManager();

        // Getting a reference to a fragment transaction
        FragmentTransaction transaction = manager.beginTransaction();

        // Creating two new fragment objects by instantiating the two fragment classes
        FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();

        // Adding the two fragments to the transaction
        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.add(R.id.fragView, fragTwo, "Fragment2");

        // Committing the transactions
        transaction.commit();
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

    int swapDecision = 1;
    public void buttonSwitchHit(View view)
    {
        //System.out.println("Switch Hit: " + swapDecision);

        // Clearing the linear layout
        // Code inspired from http://stackoverflow.com/questions/9614240/android-empty-linear-layout-contents
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fragView);
        linearLayout.removeAllViews();
        // --------------------------------------------------------------------------------------------------

        // Swap operation code
        // Getting a reference to the activity fragment manager
        FragmentManager manager = getFragmentManager();

        // Getting a reference to a fragment transaction
        FragmentTransaction transaction = manager.beginTransaction();

        // Creating two new fragment objects by instantiating the two fragment classes
        FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();

        if(swapDecision == 1)
        {
            // Adding the two fragments to the transaction
            transaction.add(R.id.fragView, fragTwo, "Fragment2");
            transaction.add(R.id.fragView, fragOne, "Fragment1");
            swapDecision = 0;
        }
        else if(swapDecision == 0)
        {
            // Adding the two fragments to the transaction
            transaction.add(R.id.fragView, fragOne, "Fragment2");
            transaction.add(R.id.fragView, fragTwo, "Fragment1");
            swapDecision = 1;
        }

        // Committing the transactions
        transaction.commit();
    }
}
