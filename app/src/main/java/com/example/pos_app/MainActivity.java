package com.example.pos_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spin_x,spin_y;
    String str,test;
    RadioButton rb_M,rb_L;
    RadioGroup RG_size;
    Button btn_next;
    TextView textview6;
    int c;

    /*String[] drink1=new  String[]{"茶類","果汁"};
    String[] drink2=new  String[]{"紅茶","綠茶"};
    String[] drink3=new  String[]{"柳橙汁","芭樂汁"};
*/
    ArrayAdapter<CharSequence> adp,adp2,adp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin_x = (Spinner) findViewById(R.id.spin_x);
        spin_y = (Spinner) findViewById(R.id.spin_y);

        adp =  ArrayAdapter.createFromResource(this, R.array.drink1, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adp2 =  ArrayAdapter.createFromResource(this, R.array.drink2, android.R.layout.simple_spinner_item);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adp3 =  ArrayAdapter.createFromResource(this, R.array.drink3, android.R.layout.simple_spinner_item);
        adp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_x.setAdapter(adp);

        spin_x.setOnItemSelectedListener(myspin);
        spin_y.setOnItemSelectedListener(youspin);


/*
        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,drink1);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_x.setAdapter(adp);

        ArrayAdapter<CharSequence> adp2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,drink2);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_y.setAdapter(adp2);

        ArrayAdapter<CharSequence> adp3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,drink3);
        adp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_y.setAdapter(adp3);
*/

        textview6 = (TextView) findViewById(R.id.textView6);

        RG_size = (RadioGroup) findViewById(R.id.RG_size);

        rb_M = (RadioButton) findViewById(R.id.rb_M);
        rb_L = (RadioButton) findViewById(R.id.rb_L);

        RG_size.setOnCheckedChangeListener(myradio);


        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("data", str);
                intent.putExtra("bun", bundle);
                startActivity(intent);
            }
        });
    }

    private final Spinner.OnItemSelectedListener myspin = new Spinner.OnItemSelectedListener ()
    {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            if (spin_x.getSelectedItem().toString().equals("茶類"))
            {
                adp2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.drink2, android.R.layout.simple_spinner_item);
                rb_L.setChecked(false);
                rb_M.setChecked(false);
            }
            else
            {
                adp2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.drink3,android.R.layout.simple_spinner_item);
                rb_L.setChecked(false);
                rb_M.setChecked(false);
            }
            adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_y.setAdapter(adp2);
            adp2.notifyDataSetChanged();
        }

        public void onNothingSelected(AdapterView<?> parent) {}
    };

    private final Spinner.OnItemSelectedListener youspin = new Spinner.OnItemSelectedListener ()
    {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            textview6.setText("");
            rb_L.setChecked(false);
            rb_M.setChecked(false);


            switch (spin_y.getSelectedItem().toString()){


                case "紅茶":{

                    c =20;
                    //String x= Integer.toString(c);
                    textview6.setText("紅茶");

                    break;
                }
                case "綠茶":{

                    c =25;
                    //String x= Integer.toString(c);
                    textview6.setText("綠茶");

                    break;
                }
                case "奶茶":{

                    c =30;
                    String x= Integer.toString(c);
                    textview6.setText("奶茶");

                    break;
                }
                case "柳橙汁":{

                    c =20;
                    String x= Integer.toString(c);
                    textview6.setText("柳橙汁");

                    break;
                }
                case "芭樂汁":{

                    c =25;
                    String x= Integer.toString(c);
                    textview6.setText("芭樂汁");

                    break;
                }
                case "蔓越莓汁":{

                    c =30;
                    //String x= Integer.toString(c);
                    textview6.setText("蔓越莓汁");

                    break;
                }


            }
            test = textview6.getText().toString();
        }

        public void onNothingSelected(AdapterView<?> parent) {}
    };

    private final RadioGroup.OnCheckedChangeListener myradio = new RadioGroup.OnCheckedChangeListener()
    {
        public void onCheckedChanged (RadioGroup group , int checkedID)
        {
            RadioButton rb = (RadioButton) findViewById(checkedID);

            switch (rb.getId()){
                case R.id.rb_M:{
                    //int x = 20;
                    String res= Integer.toString(c);
                    textview6.setText(test+"  $"+res);
                    break;
                }

                case R.id.rb_L:{
                    int y = c+5;
                    String res1= Integer.toString(y);
                    textview6.setText(test+"  $"+res1);
                    break;
                }
            }
        }
    };



    /*private View.OnClickListener mybutton = new View.OnClickListener()
    {
      public void onClick(View v)
      {
          Intent intent = new Intent(MainActivity.this,MainActivity2.class);
          startActivity(intent);
      }
    };*/

}