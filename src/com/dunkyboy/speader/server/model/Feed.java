package com.dunkyboy.speader.server.model;

import java.util.Date;
import java.util.List;

/**
 * Model object representing an [probably-RSS] feed.
 *
 * Created by Duncan on 9/5/16.
 */
public class Feed {
    private final String title;
    private final String url;
    private final Date createdDate;

    private final List<FeedEntry> entries;

    public Feed(String title, String url, Date createdDate, List<FeedEntry> entries) {
        this.title = title;
        this.url = url;
        this.createdDate = createdDate;
        this.entries = entries;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public List<FeedEntry> getEntries() {
        return entries;
    }
}
