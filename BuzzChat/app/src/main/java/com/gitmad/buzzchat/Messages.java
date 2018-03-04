package com.gitmad.buzzchat;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.gitmad.buzzchat.dummy.DummyContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Clayton on 3/2/2018.
 */
public class Messages {

    /**
     * TODO 8a: Create instance data for this class. We'll need 2 thiings
     * 1. A public list that will contain message items from #7
     * 2. An private int variable that specifies the size of the list.
     */
    public static final List<MessageItem> ITEMS = new ArrayList<MessageItem>();

    private static final int COUNT = 25;


    public static void setDefaultMessages(String text, Drawable image) {
        // TODO 8b: This method should fill in your list with message items
        for(int i = 0; i < COUNT ; i++) {
            ITEMS.add(new MessageItem(text, image));

        }
    }

    public static void clearItems() {
        // TODO 8c: This method should clear your list of message items
        ITEMS.clear();
    }


    /*
     * TODO 7: Create a static inner class to represent a single message item. It needs to have
     * final instance data for the message's content and user image
     */
    public static class MessageItem {
        public final String mMessageText;
        public final Drawable mUserImage;

        public MessageItem(String messageText, Drawable userImage) {
            mMessageText = messageText;
            mUserImage = userImage;
        }

        @Override
        public String toString() {
            return mMessageText;
        }

    }
}
