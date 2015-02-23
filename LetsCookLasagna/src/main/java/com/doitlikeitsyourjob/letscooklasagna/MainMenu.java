package com.doitlikeitsyourjob.letscooklasagna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.pollfish.constants.Position;
import com.pollfish.main.PollFish;
//import com.jirbo.adcolony.AdColony;
//import com.jirbo.adcolony.AdColonyVideoAd;

//import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by ndRandall on 07/10/13.
 */
public class MainMenu extends Activity {

    //private InterstitialAd interstitial;

    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.home);
        super.onCreate(savedInstanceState);


        //interstitial = new InterstitialAd(this);
        //interstitial.setAdUnitId("ca-app-pub-4138902309000465/1630839631");

        //AdRequest adRequest = new AdRequest.Builder()
        //        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
        //        .addTestDevice("3244EEFC41AB498C0365FD48218D1D96")  // My HTC One X test phone
        //        .build();

        //interstitial.loadAd(adRequest);

        setupAdvert();
        //setupAdColony();
        setupUIEvents();
        setupPollfish();

    }
    private void setupPollfish() {
            PollFish.init(this, "a3176c23-1d94-498c-a9cf-76ff9de66ed3", Position.TOP_LEFT, 5);
        }


    // private void setupAdColony() {
   //     AdColony.configure(this, "version:1.3,store:google", "app5ca64a9c0956446b89", "vzb7284253eca949fbbc");
   //     AdColonyVideoAd ad = new AdColonyVideoAd();
   //     ad.show();
   // }

    private void setupAdvert() {
        // Look up the AdView as a resource and load a request.
        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("4C67C373883EA1BA088AA0DD0B2D4BBE")  // My HTC One X test phone
                .build();
        adView.loadAd(adRequest);

        //Add advert but everything else gets removed
        ////Working
        //private AdView mAdView;
        //private static final String AD_UNIT_ID = "ca-app-pub-4138902309000465/2451232836";
        //LinearLayout layout = new LinearLayout(this);
        //// Create a banner ad. The ad size and ad unit ID must be set before calling loadAd.
        //mAdView = new AdView(this);
        //mAdView.setAdSize(AdSize.SMART_BANNER);
        //mAdView.setAdUnitId("ca-app-pub-4138902309000465/2451232836");
        //AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        //// Create an ad request.
        //AdRequest adRequest = new AdRequest.Builder().build();
        //// Optionally populate the ad request builder.
        //adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        //// Add the AdView to the view hierarchy.
        //layout.addView(mAdView);
        //// Start loading the ad.
        //mAdView.loadAd(adRequestBuilder.build());
        ////mAdView.loadAd(adRequest);
        //setContentView(layout);
    }

    void setupUIEvents() {

        Button thebutton = (Button) findViewById(R.id.buttonIngredients);
        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonIngredientsClick();
            }
        });

        Button thebuttonCook = (Button) findViewById(R.id.buttonCooking);
        thebuttonCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonCookClick();
            }
        });

    }

    void handleButtonCookClick() {
        Intent intent = new Intent(this, ScreenSlideActivity.class);
        startActivity(intent);

        //interstitial.show();
    }

    void handleButtonIngredientsClick() {
        Intent intent = new Intent(this, IngredientsDBList.class);
        startActivity(intent);

        //interstitial.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Boolean handled = true;

        int id = item.getItemId();

        switch (id) {
            case R.id.actionExit:
                onClickMenuExit(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    public void onClickMenuExit(MenuItem item) {
        finish();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
