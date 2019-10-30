package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    private DatePickerDialog.OnDateSetListener mDateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.date_picker_edit_text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar lCal = Calendar.getInstance();
                int lYear = lCal.get(Calendar.YEAR);
                int lMonth = lCal.get(Calendar.MONTH);
                int lDay = lCal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog lDialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateListener,
                        lYear, lMonth, lDay);
                lDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                lDialog.show();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int aYear, int aMonth, int aDay) {
                Log.w("MainActivity", "DatePicker: "+aYear+ "/" +aMonth + "/" +aDay);
                aMonth = aMonth + 1;
                String lString = aYear + "/" + aMonth + "/" + aDay;
                mTextView.setText(lString);
            }
        };

    }
}
