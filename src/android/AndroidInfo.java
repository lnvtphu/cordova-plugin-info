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

        Info infoDevice = new Info(androidSDK, androidVersion, androidBrand, androidManufacturer, androidModel);
        // Toast.makeText(webView.getContext(), SDkVersion, Toast.LENGTH_LONG).show();
        callbackContext.success(androidBrand);
    }
}

class Info {
    private String androidSDK;
    private String androidVersion;
    private String androidBrand;
    private String androidManufacturer;
    private String androidModel;

    Info(String sdk, String version, String brand, String manufacturer, String model) {
        this.androidSDK = sdk;
        this.androidVersion = version;
        this.androidBrand = brand;
        this.androidManufacturer = manufacturer;
        this.androidModel = model;
    }
}