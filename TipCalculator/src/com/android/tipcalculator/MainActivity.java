package com.android.tipcalculator;

import com.android.tipcalculator.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity  implements OnSeekBarChangeListener{
	//Team Einsteam
	private SeekBar bar;
	private TextView textTip, totalTip,totalBill;
	private EditText billAmt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bar = (SeekBar)findViewById(R.id.tipSeekBar);
		bar.setOnSeekBarChangeListener(this);
		billAmt = (EditText)findViewById(R.id.billAmount);
		textTip = (TextView)findViewById(R.id.tipPercent);
		totalTip = (TextView)findViewById(R.id.totalTip);
		totalBill = (TextView)findViewById(R.id.totalBill);
		
		billAmt.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				//System.out.println("Vindh1 "+s.toString());
				double billAmount = 0;
				int tipPercent = Integer.parseInt(textTip.getText().toString());
				//System.out.println("Vindh12 ");
				if(!s.toString().isEmpty()){
					billAmount = Double.parseDouble(s.toString());
					double tipValue =  billAmount * tipPercent / 100 ;
					double totalBillVal = tipValue + billAmount;
					totalTip.setText(String.valueOf(tipValue));
					totalBill.setText(String.valueOf(totalBillVal));
				}
				else{
					totalTip.setText("0");
					totalBill.setText("0");
				}

			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			
			}
		});
	}
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		if(!billAmt.getText().toString().isEmpty()){
			double billAmount = Double.parseDouble(billAmt.getText().toString());
			double tipValue =  billAmount * progress / 100 ;
			double totalBillVal = billAmount + tipValue;
			String prog = Integer.toString(progress);
			textTip.setText(prog);
			totalTip.setText(String.valueOf(tipValue));
			totalBill.setText(String.valueOf(totalBillVal));
		}
		else{
			textTip.setText(Integer.toString(progress));
			totalBill.setText("0");
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	
}
