package com.dunkyboy.speader.server;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_OK;

/**
 * Created by Duncan on 9/5/16.
 */
public class TopLevelResource extends AbstractHandler {
    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setStatus(SC_OK);
        response.getWriter().println(
                "<html>" +
                        "<head/>" +
                        "<body>Append 'web' or 'json' to your URL</body>" +
                "</html>");

        baseRequest.setHandled(true);
    }
}
