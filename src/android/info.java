package cordova.plugin.info;
import android.os.Bundle;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class FooLe extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getInfo")) {
            String SDkVersion = "Info device: " + String.valueOf(android.os.Build.VERSION.SDK_INT);
            callbackContext.success(SDkVersion);

            return true;

        } else {
            
            return false;

        }
    }
}