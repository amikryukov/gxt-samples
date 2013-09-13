package com.mur.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MurService")
public interface MurService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use MurService.App.getInstance() to access static instance of MurServiceAsync
     */
    public static class App {
        private static MurServiceAsync ourInstance = GWT.create(MurService.class);

        public static synchronized MurServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
