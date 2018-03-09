package com.gitmad.buzzchat;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gitmad.buzzchat.dummy.DummyFragment;

public class MessageActivity extends AppCompatActivity {

    // TODO 2: Declare member variables for the EditText, Button, and TextView from todo 1

    /*
     * We will now move the layout from MessageActivity to MessageFragment.
     * TODO 16b: Remove the instance variables from #2
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        // TODO 14: Set this to true and run the app to see your message items be displayed
        boolean todoComplete = false;


        if (savedInstanceState == null) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment fragment = new DummyFragment();

            if (todoComplete){
                fragment = new MessageFragment();
                //TODO 20c: Get the username from the Intent that got you here and put the username
                // into a Bundle. Then set the fragment arguments to that bundle.

            }
            // TODO 6: Commit the dummy fragment transaction to MessageFragments

        }

        // TODO 3: Initialize the variables from #2

        // TODO 16c: Make sure to remove the variables from #3

        /*
         * TODO 4: When we click the send button, we want to update the display text view to show
         * the message that was typed in. Add an OnClickListener to the send button so this is
         * possible. When you're done, run the app and see if it works.
         */

        // TODO 16c: Make sure to remove the button and it's onclick code (can copy and paste for #17)


    }
}
