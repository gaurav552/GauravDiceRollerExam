package com.example.gauravdicerollerexam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private int side = 4;
    private TextView result;
    private Button once, twice;
    private RadioButton  ten,four, lastChecked;
    private CheckBox tensided;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        once = findViewById(R.id.once);
        twice = findViewById(R.id.twice);
        result = findViewById(R.id.result);
        tensided = findViewById(R.id.tenSided);
        ten = findViewById(R.id.ten);
        lastChecked = findViewById(R.id.four);
        four = findViewById(R.id.four);

        tensided.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getBaseContext(), "True mode Enabled", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "True mode Disabled", Toast.LENGTH_SHORT).show();
                }

            }
        });
        four.setChecked(true);
        result.setText("0");
        tenTrue();
    }

    public void RadClick(View v){
        int checkedId = v.getId();
        lastChecked.setChecked(false);
        lastChecked = findViewById(checkedId);
        lastChecked.setChecked(true);

        if (checkedId == R.id.four){
            side = 4;
        } else if (checkedId == R.id.six){
            side = 6;
        } else if (checkedId == R.id.eight){
            side = 8;
        } else if (checkedId == R.id.ten){
            side = 10;
        } else if (checkedId == R.id.twelve){
            side = 12;
        } else if (checkedId == R.id.twenty){
            side = 20;
        }
        tenTrue();
    }

    public void tenTrue(){
        if (!ten.isChecked()){
            tensided.setVisibility(View.INVISIBLE);
            tensided.setChecked(false);
        } else {
            tensided.setVisibility(View.VISIBLE);
        }
    }

    public void roll(View v){
        int[] output = {0,0};
        if (v.getId() == once.getId()){
            output[0] = !tensided.isChecked() ? (int)(Math.random() * side) + 1 : (int)(Math.random() * side)  ;
            result.setText(Integer.toString(output[0]));
        } else if (v.getId() == twice.getId()){
            output[0] = !tensided.isChecked() ? (int)(Math.random() * side) + 1 : (int)(Math.random() * side)  ;

            output[1] = !tensided.isChecked() ? (int)(Math.random() * side) + 1 : (int)(Math.random() * side)  ;
            result.setText(Integer.toString(output[0]) +"     "+ Integer.toString(output[1]));
        }
    }

}
