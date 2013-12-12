package com.example.testdatetimepicker;

import java.util.Calendar;
import java.util.Date;

import uit.toannguyen.datetimepicker.*;
import uit.toannguyen.helpers.Helper;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button show_datetime_picker;
	TextView txt_date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		show_datetime_picker = (Button) findViewById(R.id.show_datetime_picker);
		txt_date = (TextView) findViewById(R.id.txt_datetime);

		show_datetime_picker.setOnClickListener(onclick_obj);
	}

	OnClickListener onclick_obj = new OnClickListener() {

		@Override
		public void onClick(View v) {
			showReminderPicker();
		}
	};

	public void showReminderPicker() {
//		LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
//		View customView = inflater.inflate(R.layout.reminder_picker, null);

		DateTimePickerDialog dtpDialog = new DateTimePickerDialog(
				MainActivity.this);
		
		dtpDialog.setIcon(R.drawable.alarm);
		Calendar c = Calendar.getInstance();

		dtpDialog.setDateTime(c);

		dtpDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Save", dialog_onclick);
		dtpDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Remove",
				dialog_onclick);

		dtpDialog.show();
	}

	DialogInterface.OnClickListener dialog_onclick = new DialogInterface.OnClickListener() {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			try {
				if (dialog.getClass() != DateTimePickerDialog.class) {
					return;
				}
				switch (which) {
					case DialogInterface.BUTTON_POSITIVE:
						DateTimePickerDialog reminderDl = (DateTimePickerDialog) dialog;
	
						Date date = reminderDl.getDate();
						txt_date.setText(Helper.dateToString(date,
								Helper.NORMAL_DAY_OF_WEEK_FORMAT));
	
						break;
					case DialogInterface.BUTTON_NEGATIVE:
						txt_date.setText("Set Date time please!");
						break;
					default:
						break;
				}
			} catch (Exception ex) {
				Log.e("MainActivity", ex.getMessage());
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
