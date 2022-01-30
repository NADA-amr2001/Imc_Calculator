package com.example.imccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;

public class imc extends AppCompatActivity {

    Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;

   // float intheight,intweight;
   float mweight=MainActivity.intweight;
   float mheight=Float.parseFloat(MainActivity.mintprogress);
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

       /* getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);*/

        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

       /* mheight=Float.parseFloat(height);
        mweight=Float.parseFloat(weight);*/

        mheight=mheight/100;

        intbmi=mweight/(mheight*mheight);
        //System.out.println(intbmi);


        mbmi=String.valueOf(intbmi);
        mbmidisplay.setText(mbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("R9iiiii9(a) bzzzf ");
            mbackground.setBackgroundColor(Color.BLUE);
            mimageview.setImageResource(R.drawable.cross);
        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Chwi r9iiii9(a)");
            mbackground.setBackgroundColor(Color.BLUE);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("R9iii9(a) f les normes");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<25 && intbmi>18.4)
        {
            mbmicategory.setText("trés belle taille 'ki sbaa3' ");
            mbackground.setBackgroundColor(Color.GRAY);
            mimageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi<29.4 && intbmi>25)
        {
            mbmicategory.setText("OverWeight'lzm tna9as chwi'");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicategory.setText("Obese ! 'lzm dir régime ");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


       // getSupportActionBar().hide();
        //mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}