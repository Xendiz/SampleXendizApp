package com.xendiz.samplexendizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.xendiz.ads.AdListener;
import com.xendiz.ads.AdRequest;
import com.xendiz.ads.AdView;
import com.xendiz.ads.MobileAds;

public class MainActivity extends Activity {

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"00000000-0000-0000-0000-000000000001");

        adView = findViewById(R.id.banner);
        adView.loadAd();

        adView.setAdListener(new AdListener(){
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                adView.setVisibility(View.GONE);
            }
        });
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
