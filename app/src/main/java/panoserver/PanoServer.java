package panoserver;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by ed on 01.08.2016.
 */
public class PanoServer extends NanoHTTPD {
    public PanoServer(String hostname, int port) {
        super(hostname, port);
    }
    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1>\n";
        msg += "<p>We serve " + session.getUri() + " !</p>";
        return new Response( msg + "</body></html>\n" );
    }

}
