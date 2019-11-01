package com.sesapp.exampleadmobbannerview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init ads
        MobileAds.initialize(this)
        adView()
    }

    private fun adView(){
        var adView: AdView = findViewById(R.id.adView)
        lateinit var adRequest: AdRequest
        if (BuildConfig.DEBUG){ //Eğer proje debug modunda ise reklamları test olarak başlatacağız.
            adRequest = AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build()
        } else { //Eğer release modunda ise normal başlatıyoruz.
            adRequest = AdRequest.Builder().build()
        }
        adView.loadAd(adRequest)
        adView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d("BannerAdsExample", "onAdLoaded")
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Log.d("BannerAdsExample", "onAdClicked")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.d("BannerAdsExample", "onAdClosed")
            }

            override fun onAdFailedToLoad(p0: Int) {
                super.onAdFailedToLoad(p0)
                Log.d("BannerAdsExample", "onAdFailedToLoad")
            }

            override fun onAdImpression() {
                super.onAdImpression()
                Log.d("BannerAdsExample", "onAdImpression")
            }

            override fun onAdLeftApplication() {
                super.onAdLeftApplication()
                Log.d("BannerAdsExample", "onAdLeftApplication")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Log.d("BannerAdsExample", "onAdOpened")
            }
        }
    }
}
