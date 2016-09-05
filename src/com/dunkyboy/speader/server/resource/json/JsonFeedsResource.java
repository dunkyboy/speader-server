package com.dunkyboy.speader.server.resource.json;

import com.dunkyboy.speader.server.dao.FeedDao;
import com.dunkyboy.speader.server.model.Feed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;

/**
 * JSON resource providing the RSS Feeds.
 *
 * Created by Duncan on 9/3/16.
 */
public class JsonFeedsResource extends AbstractJsonResource {

    private static final String PARAM_USER = "u";
    private static final String PARAM_PRETTY = "p";

    private final FeedDao feedDao;
    private final ObjectWriter jsonWriter;
    private final ObjectWriter jsonWriterPretty;

    public JsonFeedsResource(FeedDao feedDao) {
        super("feeds");
        this.feedDao = feedDao;
        this.jsonWriter = new ObjectMapper().writer();
        this.jsonWriterPretty = new ObjectMapper().writerWithDefaultPrettyPrinter();
    }

    @Override
    protected Map<String, String> getParameters(HttpServletRequest httpRequest) {
        String user = httpRequest.getParameter(PARAM_USER);
        String pretty = httpRequest.getParameter(PARAM_PRETTY);
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_USER, user);
        params.put(PARAM_PRETTY, pretty);
        return params;
    }

    @Override
    protected String getJson(Map<String, String> params) throws JsonProcessingException {
        List<Feed> feed = feedDao.getFeedsForUser( params.get(PARAM_USER) );

        if ( Boolean.valueOf(params.get(PARAM_PRETTY)) )
            return jsonWriterPretty.writeValueAsString(feed);
        return jsonWriter.writeValueAsString(feed);
    }
}
