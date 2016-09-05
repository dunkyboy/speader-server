package com.dunkyboy.speader.server.resource.json;

import com.dunkyboy.speader.server.resource.AbstractResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;

/**
 * Abstract superclass of all JSON resource classes, providing boilerplate handling of JSON HTTP comms.
 *
 * Created by Duncan on 9/5/16.
 */
abstract class AbstractJsonResource extends AbstractResource {

    AbstractJsonResource(String targetUrl) {
        super(targetUrl);
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/json");

        Map<String, String> params = getParameters(request);

        try {
            String json = getJson(params);

            response.setStatus(SC_OK);
            response.getWriter().println(json);

        } catch (RuntimeException re) {
            System.out.println("Error retrieving JSON for target: \"" + getTargetUrl() + "\", params: " + params);
            response.setStatus(SC_INTERNAL_SERVER_ERROR);
        }

        baseRequest.setHandled(true);
    }

    protected abstract Map<String, String> getParameters(HttpServletRequest httpRequest);
    protected abstract String getJson(Map<String, String> params) throws JsonProcessingException;
}
