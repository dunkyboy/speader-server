package com.dunkyboy.speader.server.resource;

import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * Abstract superclass of all resources, whether web, JSON, or other.
 *
 * Created by Duncan on 9/5/16.
 */
public abstract class AbstractResource extends AbstractHandler {

    private final String targetUrl;

    protected AbstractResource(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }
}
