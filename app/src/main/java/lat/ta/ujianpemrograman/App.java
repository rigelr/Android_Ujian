package lat.ta.ujianpemrograman;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.facebook.stetho.Stetho;

public class App extends Application {

    private static SharedPreferences sharedPreferences;

    public static final String KEY_VERSION = "KEY_VERSION";
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_VERSION_DETAIL = "KEY_VERSION_DETAIL";

    public static int getVersion() {
        return sharedPreferences.getInt(KEY_VERSION, -1);
    }

    public static String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public static int getVersionDetail() {
        return sharedPreferences.getInt(KEY_VERSION_DETAIL, -1);
    }

    public static void setSharedPreferences(String key, Object obj) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj).apply();
        } else if (obj instanceof String) {
            editor.putString(key, (String) obj).apply();
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj).apply();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
}
