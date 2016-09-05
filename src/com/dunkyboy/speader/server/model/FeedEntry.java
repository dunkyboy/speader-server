package com.dunkyboy.speader.server.model;

import java.util.Date;

/**
 * Model class representing an entry for a single article in a {@link Feed}.
 *
 * Created by Duncan on 9/5/16.
 */
public class FeedEntry {
    private final String headline;
    private final String bodyHtml;

    private final Date postedDate;

    private boolean isRead;
    private boolean isSaved;

    public FeedEntry(String headline, String bodyHtml, Date postedDate, boolean isRead, boolean isSaved) {
        this.headline = headline;
        this.bodyHtml = bodyHtml;
        this.postedDate = postedDate;
        this.isRead = isRead;
        this.isSaved = isSaved;
    }

    public String getHeadline() {
        return headline;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
