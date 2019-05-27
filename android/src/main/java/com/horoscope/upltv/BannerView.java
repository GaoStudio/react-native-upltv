package com.horoscope.upltv;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.views.view.ReactViewGroup;
import com.up.ads.UPBannerAd;
import com.up.ads.UPRectangleAd;
import com.up.ads.wrapper.banner.UPBannerAdListener;
import com.up.ads.wrapper.interstitial.UPInterstitialLoadCallback;

import java.util.logging.Handler;

/**
 * author: gaoweivf@aliyun.com
 * created on: 2019/5/23 15:36
 * description:
 */
public class BannerView extends LinearLayout {
    private static final String TAG = "BannerView";
    LinearLayout linearLayout;

    public BannerView(Context context) {
        super(context);
    }

    public void setAdid(final Context context) {

        UPBannerAd mRectangleAd = new UPBannerAd(context, "default");
        addView(mRectangleAd.getBannerView(), new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        final RelativeLayout finalView = (RelativeLayout) view;
//        mRectangleAd.setUpBannerAdListener(new UPBannerAdListener() {
//            @Override
//            public void onClicked() {
//                Log.e(TAG, "mBannerAd is clicked");
//            }
//
//            @Override
//            public void onDisplayed() {
//                //startThread(context);
//                //RelativeLayout relativeLayout = (RelativeLayout) ;
//                //relativeLayout.setBackgroundColor(Color.GRAY);
//                //mRectangleAd.getBannerView().measure(getMeasuredWidth(),getMeasuredHeight());
//                Log.e(TAG, ""+finalView.getLayoutParams());
//            }
//        });
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
        post(measureAndLayout);
    }

    private final Runnable measureAndLayout = new Runnable() {
        @Override
        public void run() {
            measure(
                    MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
    };
}
