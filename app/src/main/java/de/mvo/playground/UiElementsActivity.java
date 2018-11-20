package de.mvo.playground;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import de.mvo.playground.pickers.TimePickerFragment;

public class UiElementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_elements);
    }

    public void setCurrentDateOnTap(View view) {
        final EditText dateTo = findViewById(R.id.currentDateSetter);
        dateTo.setText(new Date().toString());
    }

    public void openDatePicker(View view) {
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final Date newDate = new Date(year, month, dayOfMonth);
                        final EditText dateFrom = findViewById(R.id.dateSelector);
                        dateFrom.setText(newDate.toString());
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void openTimePickerAsFragment(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}
