package com.example.sophiahon.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_txt_amount, edt_txt_percent, edt_txt_tip, edt_txt_total;
    TextView tv_tip, tv_total;
    SeekBar sb_percent;

    Integer max = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_txt_amount = findViewById(R.id.edt_txt_amount);
        edt_txt_percent = findViewById(R.id.edt_txt_percent);
        edt_txt_tip = findViewById(R.id.edt_txt_tip);
        edt_txt_total = findViewById(R.id.edt_txt_total);

        tv_tip = findViewById(R.id.tv_tip);
        tv_total = findViewById(R.id.tv_total);

        sb_percent = findViewById(R.id.sb_percent);

        sb_percent.setMax(max);
        sb_percent.setProgress(max);

//        final Integer amount;
//
//        if (edt_txt_amount.getText() == null){
//            amount = 0;
//        }
//        else {
//            amount = Integer.parseInt(edt_txt_amount.getText().toString());
//        }

        sb_percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                edt_txt_percent.setText(String.valueOf(i)+ "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String P = String.valueOf(sb_percent.getProgress());
                Integer percent = Integer.parseInt(P);
                Double amount;
                if (edt_txt_amount.getText().toString().trim().equals("")){
                    //System.out.println("\n\n*** null   " + edt_txt_amount.getText());
                    amount = 0.0;
                }
                else {
                    //System.out.println("\n\n!!!!" + edt_txt_amount.getText());
                    amount = Double.parseDouble(edt_txt_amount.getText().toString());
                }
                Double tip = amount * percent / 100;
                edt_txt_tip.setText(String.valueOf(tip));
                Double total = tip + amount;
                edt_txt_total.setText(String.valueOf(total));
            }
        });

    }
}
