package std.androidstudio.reactnative.plugin.geocoder;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.location.Geocoder;
import java.util.*;
import android.location.Address;
import android.util.Log;

public class AANRGeocoderModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public AANRGeocoderModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "NativeGeocoder";
    }

    @ReactMethod
    public void getFullAddress(Double latitude, Double longitude, Callback callback) {
        Geocoder geocoder = new Geocoder(reactContext, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            String fulladdress = addresses.get(0).getAddressLine(0);
            callback.invoke(fulladdress);
        } catch (Exception e) {
            callback.invoke(e.getMessage());
            Log.e("EEROR", e.getMessage());
        }
    }
}
