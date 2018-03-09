package com.gitmad.buzzchat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A fragment representing a list of Items.
 */
public class MessageFragment extends Fragment {

    // Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // Customize parameters
    private int mColumnCount = 1;

    private EditText mTextBox;
    private Button mSendButton;
    private MessageRecyclerViewAdapter mAdapter;
    private String mUserName;

    // TODO 19a: Initialize Firebase reference
    private FirebaseDatabase mFirebaseRef;
    private DatabaseReference mDatabaseRef;

    private static final String MESSAGES_CHILD = "messages";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MessageFragment() {
    }

    // Customize parameter initialization
    @SuppressWarnings("unused")
    public static MessageFragment newInstance(int columnCount) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            // TODO 20d: Unpack the bundle and initialize mUserName
            mUserName = getArguments().getString("username");

        }
        // TODO 17a: Initialize mAdapter to a new MessageRecyclerViewAdapter
        mAdapter = new MessageRecyclerViewAdapter(Messages.ITEMS);

        // TODO 19b: Initialize the variables from 19a
        mFirebaseRef = FirebaseDatabase.getInstance();
        mDatabaseRef = mFirebaseRef.getReference(MESSAGES_CHILD);

        // TODO 21a: Add a child event listener so we can update our messages list when there is a
        // new message.
        mDatabaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HashMap<String, String> map = (HashMap) dataSnapshot.getValue();
                String text =  map.get("mMessageText");
                String username = map.get("mUserName");
                Drawable image = getResources().getDrawable(R.drawable.default_user_image2, null);
                Messages.addMessageItem(new Messages.MessageItem(username, text, image));
                mAdapter.notifyDataSetChanged();
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
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        Log.d("MessageFragment", "RecyclerView Init");
        // TODO 17b: Initialize mTextBox and mSendButton. This will be similar to what you did in #2
        // and #3, but you'll need to use the "view" variable here.
        mTextBox = view.findViewById(R.id.fragment_message_textbox);
        mSendButton = view.findViewById(R.id.fragment_message_send_button);

        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        /*
         * TODO 17c: Modify the button's onClick method so clicking it adds a new message to your
         * message list rather than modify the old TextView which should be removed by now.
         * 1. Add a add a message item to your list in Messages.java
         * 2. Make sure the mTextBox resets (Hint: empty string is useful here)
         * 3. Notify mAdapter that it's data set has changed so it can update the list with the new
         * message.
         */


        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageText = mTextBox.getText().toString();
                if (!messageText.isEmpty()) {
                    Drawable image = getResources().getDrawable(R.drawable.default_user_image2);
                    // TODO 20e: Now that we have the username, make sure to use it in the messages
                    // list too so we don't have anonymous users.

                    //TODO 21b: Remove the addMessageItem line since we do it in 21b

                    /*
                     * TODO 19c: Push new messages to the "messages" child of your database instance
                     * 1. Create a new MessageItem from the mTextBox text (you can pass null for the image)
                     * 2. Get the reference to the messages child and push the new value
                     * 3. Run the app and check the Firebase console to see your messages saved
                     */
                    mDatabaseRef.push().setValue(
                            new Messages.MessageItem(mUserName, messageText, null));

                    mTextBox.setText("");
                    mAdapter.notifyDataSetChanged();
                }

            }
        });
        /*
         *TODO 13: Fill the messages list and set the recycler view's adapter to a new
         * MessageRecyclerViewAdapter.
         *
         * Hint: You can create a Drawable with getResources().getDrawable(...)
         */

        /*
         * TODO 17d: Remove the code the filled the message list here and keep the line that sets
         * the adapter
         */
        recyclerView.setAdapter(mAdapter);
        Log.d("MessageFragment", "Adapter Set");

        return view;
    }
}
