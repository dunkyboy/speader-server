package com.dunkyboy.speader.server.svc;

import com.dunkyboy.speader.server.dao.FeedDao;
import com.dunkyboy.speader.server.model.Feed;

/**
 * Service composing logic for reading, manipulating, and writing {@link Feed} model objects.
 *
 * Created by Duncan on 9/5/16.
 */
public class FeedsSvc {
    private final FeedDao feedDao;

    public FeedsSvc(FeedDao feedDao) {
        this.feedDao = feedDao;
    }

    public Feed getFeedForUser(String user) {
        return null;  // TODO
    }
}
