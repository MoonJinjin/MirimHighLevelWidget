package kr.hs.emirim.s2019s11.mirimhighlevelwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate, radioTime;
    DatePicker calendar1;
    TimePicker timePick;
    Chronometer chrono;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        radioDate = findViewById(R.id.radio_date);
        radioTime = findViewById(R.id.radio_time);
        calendar1 = findViewById(R.id.calendar1);
        timePick = findViewById(R.id.time_pick);
        radioDate.setOnClickListener(radioListener);
        radioTime.setOnClickListener(radioListener);
        chrono = findViewById(R.id.chrono1);
        textResult = findViewById(R.id.text_result);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
        calendar1.setOnClickListener(btnListener);
    }

    View.OnClickListener radioListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.radio_date:
                    calendar1.setVisibility(View.VISIBLE);
                    timePick.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_time:
                    timePick.setVisibility(View.VISIBLE);
                    calendar1.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();
                    chrono.setTextColor(Color.RED);
                    break;
                case R.id.btn_stop:
                    chrono.stop();
                    chrono.setTextColor(Color.BLUE);
                    textResult.setText(timePick.getCurrentHour() + "시 " + timePick.getCurrentMinute() + "분");
                    break;
            }
        }
    };

    String dateStr = "";
    CalendarView.OnDateChangeListener calendarListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            dateStr = year + "년 " + (month+1) + "월 " + dayOfMonth + "일 ";
        }
    };
}