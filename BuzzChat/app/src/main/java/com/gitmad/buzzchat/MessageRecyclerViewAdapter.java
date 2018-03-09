package com.gitmad.buzzchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gitmad.buzzchat.Messages.MessageItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link MessageItem}
 */
public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder> {

    private final List<MessageItem> mValues;

    public MessageRecyclerViewAdapter(List<MessageItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*
         * TODO 12: Inflate the layout that displays a message. Once you have the view from the
         * inflater, create a new ViewHolder based on that view and return it.
         */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        /*
         * Once the ViewHolder is created, the RecyclerView initializes each message item in the
         * mValues list. The index of mValues corresponds to the position in your RecyclerView list.
         */
        holder.mItem = mValues.get(position);
        holder.mMessageTextView.setText(mValues.get(position).mMessageText);
        holder.mUserImageView.setImageDrawable(mValues.get(position).mUserImage);
        holder.mUserNameTextView.setText(mValues.get(position).mUserName);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //A ViewHolder represents a single row in our RecyclerView's list. See message.xml to see
        //what one row will look like

        /*
         * TODO 9a: Create final instance data for this class We'll need 3 things:
         * 1. A View object that will help us find elements in message.xml
         * 2. An ImageView for the user image
         * 3. A TextView for the message's text
         * TODO 9b: Create instance data for your message item (not final)
         */

        public final View mView;
        public final ImageView mUserImageView;
        public final TextView mMessageTextView;
        public final TextView mUserNameTextView;
        public MessageItem mItem;

        public ViewHolder(View view) {
            super(view);
            // TODO 10: Initialize the instance data from #9a only. The message items are generated
            // in a different way
            mView = view;
            mUserImageView = view.findViewById(R.id.message_user_image_view);
            mMessageTextView = view.findViewById(R.id.message_text_text_view);
            mUserNameTextView = view.findViewById(R.id.message_user_name);
        }

        // TODO 11: Override the toString method so it returns the
        @Override
        public String toString() {
            return super.toString() + " '" + mMessageTextView.getText() + "'";
        }
    }
}
