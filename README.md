# Requirements
SDK requires Android SDK version 9 (14 with latest Google Play Services)
# Installation
* Download aar library
* Go to Files->New->New module->Import .JAR/.AAR Package and select path and name for module
* Then include module to your app dependencies. Open File->Project Structure. Click on your app module at left column, then go to tab `Dependencies`, click on `+` and select library module
### Use Google Advertising ID (optional)
To force SDK use advertise id instead of android id you should include Google Play Services in your dependencies. 
In your app `build.gradle` add line
```
dependencies {
    //Your dependencies
    compile  'com.google.android.gms:play-services-ads:10.0.0'
}
```
To read more about Advertising ID usage read [this article](http://www.androiddocs.com/google/play-services/id.html)
#### Note. 
If you use version `10.0.0` minimal Android SDK version would be 9, for newer version of Play Services SDK minimal version is 14
### Use location (optional)
For more ad targeting accuracy it's recommended to use location. SDK provides gathering of coarse location. To send location add permission to your app's Manifest
```
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
```
and in `build.gradle` include line
```
dependencies {
    //Your dependencies
    compile  'com.google.android.gms:play-services-location:10.0.0'
}
```

# Usage
Initialize SDK
 ```    
        MobileAds.initialize(this,"your app id here");
 ```

## Show banner

 Add banner to XML
 ```
 <?xml version="1.0" encoding="utf-8"?>
       <LinearLayout 
           xmlns:android="http://schemas.android.com/apk/res/android"
           xmlns:xendiz="http://schemas.android.com/apk/res-auto"
           android:layout_width="match_parent"
           android:layout_height="match_parent">
       
           <com.xendiz.ads.AdView
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               xendiz:size="BANNER_320_50"
               xendiz:placementId="1"
               android:id="@+id/banner"/>
       
       
       </LinearLayout>
 ```
 
 
 ##### Available tags:
* xendiz:size - size of banner(enum)
* xendiz:placementId - banner id
* xendiz:refresh - Optional. Seconds between reloading advertise(integer). Should be in range from 20 to 60
 
 ##### Available sizes:
* BANNER_320_50
* BANNER_300_50
* BANNER_320_250
* BANNER_320_480
* BANNER_300_400
* BANNER_320_320
* BANNER_728_90

Then load banner in code

```

public class MainActivity extends Activity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"00000000-0000-0000-0000-000000000001");

        adView = findViewById(R.id.banner);
        adView.loadAd();
    }

    @Override
    protected void onPause() {
        super.onPause();
        adView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adView.onResume();
    }
}
```
 