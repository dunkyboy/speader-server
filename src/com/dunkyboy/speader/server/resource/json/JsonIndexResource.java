package com.dunkyboy.speader.server.resource.json;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.util.Collections.emptyMap;

/**
 * JSON resource providing the top-level index content.
 *
 * Created by Duncan on 9/5/16.
 */
public class JsonIndexResource extends AbstractJsonResource {

    public JsonIndexResource() {
        super("");
    }

    @Override
    protected Map<String, String> getParameters(HttpServletRequest httpRequest) {
        return emptyMap();
    }

    @Override
    protected String getJson(Map<String, String> params) throws JsonProcessingException {
        return "{}";  // TODO
    }
}
