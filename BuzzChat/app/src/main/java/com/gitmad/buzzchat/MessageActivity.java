package com.gitmad.buzzchat;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    // TODO 2: Declare member variables for the EditText, Button, and TextView from todo 1
    private EditText mTextBox;
    private Button mSendButton;
    private TextView mDisplayMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // TODO 6: if savedInstanceState is null, commit a fragment transaction to MessageFragment
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MessageFragment fragment = new MessageFragment();
            transaction.replace(R.id.activity_message_fragment_frame, fragment);
            transaction.commit();
        }

        // TODO 3: Initialize the variables from todo 3
        mTextBox = findViewById(R.id.activity_message_textbox);
        mSendButton = findViewById(R.id.activity_message_send_button);
        mDisplayMessageView = findViewById(R.id.activity_message_textview);

        /*
         * TODO 4: When we click the send button, we want to update the display text view to show
         * the message that was typed in. Add an OnClickListener to the send button so this is
         * possible.
         */
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = mTextBox.getText().toString();
                if (!messageText.isEmpty()) {
                    mDisplayMessageView.setText(messageText);
                }

            }
        });
    }
}
