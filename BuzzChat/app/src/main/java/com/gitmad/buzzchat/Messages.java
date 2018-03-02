package com.gitmad.buzzchat;

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
     * An array of sample message items.
     */
    public static final List<MessageItem> ITEMS = new ArrayList<MessageItem>();

    /**
     * A map of sample message items, by ID.
     */
    public static final Map<String, DummyContent.DummyItem> ITEM_MAP = new HashMap<String, DummyContent.DummyItem>();

    private static final int COUNT = 25;

    public static class MessageItem {

    }
}
