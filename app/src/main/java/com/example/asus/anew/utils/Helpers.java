package com.example.asus.anew.utils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.example.asus.anew.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Helpers {
    public static String parseDateToDMY(String time, Context context) {
        String inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        String outputPattern = "h:mm a dd-MMM-yyyy ";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Locale current = context.getResources().getConfiguration().locale;
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, current);
        outputFormat.setTimeZone(TimeZone.getDefault());

        Date date;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static Spannable fontColor(Context context, String wholeText, String text) {
        Spannable raw = new SpannableString(wholeText);
        int begin_index = TextUtils.indexOf(raw, text);

        while (begin_index >= 0) {
            int finish_index = TextUtils.indexOf(raw, " ", begin_index);
            if (finish_index > 0) {
                raw.setSpan(new ForegroundColorSpan(context.getColor(R.color.colorAccent)), begin_index, finish_index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                begin_index = TextUtils.indexOf(raw, text, finish_index);

            } else {
                raw.setSpan(new ForegroundColorSpan(context.getColor(R.color.colorAccent)), begin_index, raw.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                break;
            }
        }
        return raw;
    }
}
