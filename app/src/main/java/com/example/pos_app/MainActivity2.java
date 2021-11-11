package com.example.pos_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btn_out,btn_reduce,btn_plus;
    RadioGroup RG_sugar,RG_ice;
    CheckBox chk1,chk2,chk3,chk4,chk5;
    TextView txt,sum,txa;
    String intent1;
    int s = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_out = (Button) findViewById(R.id.btn_out);
        btn_reduce = (Button) findViewById(R.id.btn_reduce);
        btn_plus = (Button) findViewById(R.id.btn_plus);

        RG_sugar = (RadioGroup) findViewById(R.id.RG_sugar);
        RG_ice = (RadioGroup) findViewById(R.id.RG_ice);

        chk1 = (CheckBox) findViewById(R.id.checkBox2);
        chk2 = (CheckBox) findViewById(R.id.checkBox3);
        chk3 = (CheckBox) findViewById(R.id.checkBox4);
        chk4 = (CheckBox) findViewById(R.id.checkBox5);
        chk5 = (CheckBox) findViewById(R.id.checkBox6);

        sum = (TextView) findViewById(R.id.sum);
        txt = (TextView)findViewById(R.id.textView3);
        txa = (TextView)findViewById(R.id.textView4);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String str = bundle.getString("data");
        txa.setText(str);

        btn_out.setOnClickListener(new View.OnClickListener(){

             @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainMarket.class);
                String str = intent.getStringExtra("data");
                startActivity(intent);
            }
        });

        btn_reduce.setOnClickListener(mybtn);
        btn_plus.setOnClickListener(mybtn);
        RG_sugar.setOnCheckedChangeListener(myrg);
        RG_ice.setOnCheckedChangeListener(myrg);
        chk1.setOnCheckedChangeListener(mychk1);
        chk2.setOnCheckedChangeListener(mychk1);
        chk3.setOnCheckedChangeListener(mychk1);
        chk4.setOnCheckedChangeListener(mychk1);
        chk5.setOnCheckedChangeListener(mychk1);

    }

    private View.OnClickListener mybtn = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch (v.getId()){
                case 0:{
                }
                case R.id.btn_plus:{
                    s = s + 1 ;
                    String x = Integer.toString(s);
                    sum.setText(x);
                    break;
                }
                case R.id.btn_reduce:{
                    if (s>0){
                        s = s - 1 ;
                        String x = Integer.toString(s);
                        sum.setText(x);
                    }
                    break;
                }
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener myrg = new RadioGroup.OnCheckedChangeListener(){
        String x ="";
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            RadioButton rb = (RadioButton) findViewById(checkedId);
            x += 1;
        }
    };

    private RadioGroup.OnCheckedChangeListener myrg2 = new RadioGroup.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            RadioButton rb = (RadioButton) findViewById(checkedId);
        }
    };

    private CompoundButton.OnCheckedChangeListener mychk1 = new CompoundButton.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            String result = "";
            if (chk1.isChecked())
            {
                result += " 珍珠 ";
            }
            if (chk2.isChecked())
            {
                result += " 椰果 ";
            }
            if (chk3.isChecked())
            {
                result += " 仙草 ";
            }
            if (chk4.isChecked())
            {
                result += " 布丁 ";
            }
            if (chk5.isChecked())
            {
                result += " 芋圓 ";
            }
            txt.setText(result);
        }
    };

}