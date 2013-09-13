package com.mur.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mur.client.MurService;

public class MurServiceImpl extends RemoteServiceServlet implements MurService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}