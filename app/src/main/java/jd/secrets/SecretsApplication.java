package jd.secrets;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class SecretsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "d3a2Z4QuMss5YZeYfR6IqAUB5dPmphNXQ6JUfezk", "qXl5ZYLwehBW8AqWqtFZu2QhguxNNdstkzERyhzL");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }

}
