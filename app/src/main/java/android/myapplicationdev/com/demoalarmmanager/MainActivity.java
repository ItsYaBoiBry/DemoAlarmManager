package android.myapplicationdev.com.demoalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_set_alarm;
    AlarmManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_set_alarm = (Button) findViewById(R.id.btn_set_time);

        btn_set_alarm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND,5);

                Intent intent = new Intent(MainActivity.this, AlarmRecieverActivity.class);
                int requestCode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent,PendingIntent.FLAG_CANCEL_CURRENT);

                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
            }
        });


    }
}
