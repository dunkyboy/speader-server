package com.dunkyboy.speader.server.dao;

import com.dunkyboy.speader.server.model.Feed;
import com.dunkyboy.speader.server.model.FeedEntry;

import java.util.Date;
import java.util.List;

import static java.time.Duration.ofDays;
import static java.time.Instant.now;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

/**
 * DAO for reading and writing feeds to the MongoDB database.
 *
 * Created by Duncan on 9/5/16.
 */
public class FeedDao {
    public List<Feed> getFeedsForUser(String user) {

        // placeholders for now... TODO bring in an actual MongoDB!

        if ( user.trim().toLowerCase().equals("duncan") ) {
            Feed daringFireball = new Feed(
                    "Daring Fireball",
                    "http://daringfireball.net",
                    Date.from( now().minus(ofDays(112)) ),
                    asList(
                            new FeedEntry(
                                    "OMG New iPhone!!!1!!111",
                                    "<html><head/><body>New iPhone is here!!!</body></html>",
                                    Date.from(now().minus(ofDays(2))),
                                    false,
                                    false
                            ),
                            new FeedEntry(
                                    "New MacBook Pros?",
                                    "<html><head/><body>Fat freaking chance :(</body></html>",
                                    Date.from(now().minus(ofDays(3))),
                                    true,
                                    false
                            )
                    )
            );
            Feed xkcd = new Feed(
                    "xkcd",
                    "http://xkcd.com",
                    Date.from( now().minus(ofDays(752)) ),
                    asList(
                            new FeedEntry(
                                    "Funny math joke",
                                    "<html><head/><body><img src=\"http://xkcd.com/1150/\" alt=\"I iz teh funny\"</body></html>",
                                    Date.from(now().minus(ofDays(2))),
                                    true,
                                    false
                            ),
                            new FeedEntry(
                                    "Mathy mathy math math",
                                    "<html><head/><body><img src=\"http://xkcd.com/1149/\" alt=\"I iz teh smart and funny\"</body></html>",
                                    Date.from(now().minus(ofDays(3))),
                                    true,
                                    true
                            )
                    )
            );

            return asList(daringFireball, xkcd);
        }

        return emptyList();
    }
}
