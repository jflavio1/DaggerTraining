package com.jflavio1.daggerexample.core.components.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;

/**
 * ComponentUtils
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since 2/6/2019
 */
public final class ComponentUtils {

    public static void hideSystemKeyboard(Context context, View view) {
        if (view.getWindowToken() != null) {
            ((InputMethodManager) context
                    .getSystemService(Activity.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Sets a background tint to a specific view passed as a parameter.
     *
     * @param view  View that tint is going to be applied.
     * @param color Color to use for tinting this drawable.
     */
    public static void setBackgroundTint(@NonNull View view, @ColorInt int color) {
        Drawable drawable = DrawableCompat.wrap(view.getBackground());
        DrawableCompat.setTint(drawable, color);
    }

    /**
     * Converts a DP unit to Pixel.
     *
     * @param context Context where method is invoked.
     * @param dp      Value as integer of DP to be converted.
     * @return the value measured in pixels.
     */
    public static int dpToPx(Context context, int dp) {
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                Math.round(dp),
                context.getResources().getDisplayMetrics()
        );

        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(px / density);
    }

    /**
     * Converts a Pixel unit to DP.
     *
     * @param context Context where method is invoked.
     * @param px      Value as integer of Pixels to be converted.
     * @return the value measured in DPs depending on the device screen density.
     */
    public static int pxToDp(@NonNull Context context, @NonNull int px) {
        float dp = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_PX,
                Math.round(px),
                context.getResources().getDisplayMetrics());

        float density = context.getResources().getDisplayMetrics().density;

        return Math.round(dp * density);
    }

}
