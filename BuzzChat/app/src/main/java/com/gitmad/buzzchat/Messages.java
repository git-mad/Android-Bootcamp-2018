package com.gitmad.buzzchat;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clayton on 3/2/2018.
 */
public class Messages {

    /**
     * TODO 8a: Create instance data for this class. We'll need 2 things
     * 1. A public list that will contain message items from #7
     * 2. An private int variable that specifies the size of the list (SIZE)
     */


    // TODO 8b: Create a static method that adds a single message item to your list


    public static void setDefaultMessages(String text, Drawable image) {
        // TODO 8c: This method should fill in your list with <SIZE> message items

    }

    public static void clearItems() {
        // TODO 8d: This method should clear your list of message items

    }

    /*
     * TODO 7: Create a static inner class MessageItem to represent a single message item. It needs to have
     * final instance data for the message's content, user image, and username.
     *
     * There should be a default constructor with no args that sets the text to "Default", username
     * to "Anonymous", and image to null
     *
     * There should be another constructor that creates a message item when all three parameters are
     * present
     */
    public static class MessageItem {

    }


}
