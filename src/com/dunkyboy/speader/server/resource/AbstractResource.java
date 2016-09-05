package com.dunkyboy.speader.server.resource;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Duncan on 9/5/16.
 */
public class AbstractResource extends AbstractHandler {

    private final String targetUrl;

    protected AbstractResource(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
