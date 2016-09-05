package com.dunkyboy.speader.server.resource.json;

import com.dunkyboy.speader.server.dao.FeedDao;
import com.dunkyboy.speader.server.model.Feed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.util.Collections.singletonMap;

/**
 * JSON resource providing the RSS Feeds.
 *
 * Created by Duncan on 9/3/16.
 */
public class JsonFeedsResource extends AbstractJsonResource {

    private static final String PARAM_USER = "u";

    private final FeedDao feedDao;
    private final ObjectWriter jsonWriter;

    public JsonFeedsResource(FeedDao feedDao) {
        super("feeds");
        this.feedDao = feedDao;
        this.jsonWriter = new ObjectMapper().writer().forType(Feed.class);
    }

    @Override
    protected Map<String, String> getParameters(HttpServletRequest httpRequest) {
        String user = httpRequest.getParameter(PARAM_USER);
        return singletonMap(PARAM_USER, user);
    }

    @Override
    protected String getJson(Map<String, String> params) throws JsonProcessingException {
        Feed feed = feedDao.getFeedForUser( params.get(PARAM_USER) );
        return jsonWriter.writeValueAsString(feed);
    }
}
