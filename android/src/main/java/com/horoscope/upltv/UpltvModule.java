package com.horoscope.upltv;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.ironsource.sdk.controller.InterstitialActivity;
import com.up.ads.UPAdsSdk;
import com.up.ads.UPInterstitialAd;
import com.up.ads.UPRewardVideoAd;
import com.up.ads.wrapper.interstitial.UPInterstitialLoadCallback;
import com.up.ads.wrapper.video.UPRewardVideoLoadCallback;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * author: gaoweivf@aliyun.com
 * created on: 2019/5/23 11:40
 * description:
 */
public class UpltvModule extends ReactContextBaseJavaModule {
    private static final String TAG = "UpltvModule";
    public UpltvModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
        UPAdsSdk.setCustomerId(GetAndroid(getReactApplicationContext()));
        UPAdsSdk.init(getReactApplicationContext(), UPAdsSdk.UPAdsGlobalZone.UPAdsGlobalZoneForeign);
        UPAdsSdk.setDebuggable(true);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Upltv";
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        return super.getConstants();

    }
    @ReactMethod
    public void setCustomerId(){

    }
    public static String GetAndroid(Context context){
        final String androidId;
        androidId = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        return androidId;
    }
    @ReactMethod
    public void init(){

    }
    //显示插屏
    @ReactMethod
    public void showInter(){
        final UPInterstitialAd mInterstitialAd = new UPInterstitialAd(getCurrentActivity(), "home_inter");
        final UPInterstitialLoadCallback callback = new UPInterstitialLoadCallback() {
            @Override
            public void onLoadSuccessed(String placement) {
                Log.e(TAG, "onLoadSuccessed: "+placement + mInterstitialAd.isReady());
                if (placement.equals("home_inter")) {
                    if (mInterstitialAd != null && mInterstitialAd.isReady()) {
                        mInterstitialAd.show();
                    }
                }
            }

            @Override
            public void onLoadFailed(String placement) {
                Log.e(TAG, "onLoadFailed: "+placement);
            }
        };
        mInterstitialAd.load(callback);
        mInterstitialAd.showInterstitialDebugActivity(getCurrentActivity());
    }
    @ReactMethod
    public void showVideo(){
        final UPRewardVideoAd mVideoAd = UPRewardVideoAd.getInstance(getCurrentActivity());
        mVideoAd.load(new UPRewardVideoLoadCallback() {
            @Override
            public void onLoadFailed() {
                // code
                // 激励视频加载失败，请等待加载成功
            }

            @Override
            public void onLoadSuccessed() {
                if (mVideoAd != null && mVideoAd.isReady()) {
                    mVideoAd.show("home_video");
                }
            }
        });
        mVideoAd.showVideoDebugActivity(getCurrentActivity());
    }
}
