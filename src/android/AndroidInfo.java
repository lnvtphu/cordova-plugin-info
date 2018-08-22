package com.info;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidInfo extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("getInfo".equals(action)) {
            getInfo(callbackContext);
            return true;
        }

        return false;
    }

    private void getInfo(CallbackContext callbackContext) {
        String androidSDK = String.valueOf(android.os.Build.VERSION.SDK_INT);
        String androidVersion = String.valueOf(android.os.Build.VERSION.RELEASE);
        String androidBrand = String.valueOf(android.os.Build.BRAND);
        String androidManufacturer = String.valueOf(android.os.Build.MANUFACTURER);
        String androidModel = String.valueOf(android.os.Build.MODEL);

        // Toast.makeText(webView.getContext(), SDkVersion, Toast.LENGTH_LONG).show();
        JSONObject infoDevice = new JSONObject();
        try {
            infoDevice.put("androidSDK", androidSDK);
            infoDevice.put("androidVersion", androidVersion);
            infoDevice.put("androidBrand", androidBrand);
            infoDevice.put("androidManufacturer", androidManufacturer);
            infoDevice.put("androidModel", androidModel);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        callbackContext.success(infoDevice);
    }
}