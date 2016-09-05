package com.dunkyboy.speader.server;

import com.dunkyboy.speader.server.resource.json.JsonFeedsResource;
import com.dunkyboy.speader.server.resource.json.JsonIndexResource;
import com.dunkyboy.speader.server.svc.FeedsSvc;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

import static javax.servlet.http.HttpServletResponse.SC_NOT_IMPLEMENTED;

/**
 * Created by Duncan on 9/3/16.
 */
public class ServerMain extends AbstractHandler {

    public static void main(String[] args) throws Exception {

        TopLevelResource topLevelResource = new TopLevelResource();
        JsonIndexResource jsonIndexResource = new JsonIndexResource();
        JsonFeedsResource jsonFeedsResource = new JsonFeedsResource( new FeedsSvc() );

        Server server = new Server(8080);
        server.setHandler( new ServerMain(topLevelResource, jsonIndexResource, jsonFeedsResource) );

        server.start();
        server.join();
    }

    private final TopLevelResource topLevelResource;

    private final JsonIndexResource jsonIndexResource;
    private final JsonFeedsResource jsonFeedsResource;

    private ServerMain(TopLevelResource topLevelResource, JsonIndexResource jsonIndexResource, JsonFeedsResource jsonFeedsResource) {
        this.topLevelResource = topLevelResource;
        this.jsonIndexResource = jsonIndexResource;
        this.jsonFeedsResource = jsonFeedsResource;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Received request: target=" + target);

        Handler resource = getResourceForTarget(target);
        if (resource == null) {
            System.out.println("No resource for target: " + target);
            response.setStatus(SC_NOT_IMPLEMENTED);
            baseRequest.setHandled(true);
            return;
        }

        resource.handle(target, baseRequest, request, response);
    }

    private Handler getResourceForTarget(String target) {

        StringTokenizer targetTokens = new StringTokenizer(target, "/");

        if ( !targetTokens.hasMoreTokens() ) {
            return topLevelResource;
        }

        ResourceType resourceType = ResourceType.fromStr( targetTokens.nextToken() );
        switch (resourceType) {
            case WEB:
                return null;  // TODO implement web UI
            case JSON:
                return getJsonResourceForTarget(targetTokens);
            default:
                return null;
        }
    }

    private enum ResourceType {
        WEB, JSON;

        static ResourceType fromStr(String string) {
            return ResourceType.valueOf( string.trim().toUpperCase() );
        }
    }
}
