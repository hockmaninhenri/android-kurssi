package fi.jamk.widgetdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.Random;


public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        String lat = MainActivity.getLat();
        String lng = MainActivity.getLng();

        // Get all ids
        ComponentName thisWidget = new ComponentName(context,
                WidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {


            Intent widget = new Intent(context, WidgetProvider.class);
            PendingIntent pendingIntent1 = PendingIntent.getBroadcast(context, 0, widget, PendingIntent.FLAG_UPDATE_CURRENT);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            views.setTextViewText(R.id.TextView02, "Latitude: " + String.valueOf(lat));
            views.setTextViewText(R.id.TextView04, "Longitude: " + String.valueOf(lng));
            widget.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            widget.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            views.setOnClickPendingIntent(R.id.button2, pendingIntent1);
            //views.setOnClickPendingIntent(R.id.button2, pendingIntent1);


            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(widgetId, views);

        }
    }
}
