package fi.jamk.notification_example;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int notification_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchNotification(View view){
        // create a implicit intent
        Intent actionIntent = new Intent (Intent.ACTION_VIEW);
        actionIntent.setData(Uri.parse("http://www.jamk.fi"));

        //create a pending intent
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this,0,actionIntent,0);

        // create a notification
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("JAMK Notification")
                .setContentText("Click to see our new WWW-page")
                .setSmallIcon(R.drawable.ic_bug)
                .setAutoCancel(true)
                .setContentIntent(actionPendingIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();

        // connect notification manager
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        // make a notification
        notificationManager.notify(notification_ID, notification);
    }
}
