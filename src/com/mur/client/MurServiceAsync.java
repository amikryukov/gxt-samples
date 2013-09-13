package com.mur.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MurServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
