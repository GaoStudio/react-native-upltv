package com.horoscope.upltv;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;
import com.up.ads.UPBannerAd;
import com.up.ads.wrapper.banner.UPBannerAdListener;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.facebook.react.views.scroll.ReactScrollViewCommandHelper.COMMAND_SCROLL_TO;

/**
 * author: gaoweivf@aliyun.com
 * created on: 2019/5/23 15:34
 * description:
 */
public class BannerViewManager extends SimpleViewManager<BannerView> {
    private static final String TAG = "BannerViewManager";
    public static final int COMMAND_LOAD = 1;
    Context activity;
    public BannerViewManager(Context activity){
        this.activity = activity;
    }
    @Nonnull
    @Override
    public String getName() {
        return "AdBannerView";
    }

    @Nonnull
    @Override
    protected BannerView createViewInstance(@Nonnull ThemedReactContext reactContext) {
        return new BannerView(reactContext);
    }
    @ReactProp(name = "adid")
    public void setAdid(BannerView view, @Nullable String adid) {
        view.setAdid(activity);
    }
}
