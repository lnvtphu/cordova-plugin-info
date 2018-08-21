package com.info;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;
import android.os.Bundle;

public class AndroidInfo extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("show".equals(action)) {
            show(args.getString(0), callbackContext);
            return true;
        }

        return false;
    }

    private void show(String msg, CallbackContext callbackContext) {
        if (msg == null || msg.length() == 0) {
            callbackContext.error("Empty message!");
        } else {
            String SDkVersion = "Info device: " + String.valueOf(android.os.Build.VERSION.SDK_INT);
            Toast.makeText(webView.getContext(), SDkVersion, Toast.LENGTH_LONG).show();
            callbackContext.success(msg);
        }
    }
}