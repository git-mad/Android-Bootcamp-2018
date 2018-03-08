package com.gitmad.buzzchat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        }
        // TODO 17a: Initialize mAdapter to a new MessageRecyclerViewAdapter
        mAdapter = new MessageRecyclerViewAdapter(Messages.ITEMS);
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
                    Drawable image = getResources().getDrawable(R.drawable.default_user_image);
                    Messages.addMessageItem(messageText, image);
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
