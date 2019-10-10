package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo,tvName;
    ImageView ivResult, ivCall, ivMap, ivWeb;
    Button btnCreate;
    final int ACTIVITY2=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo=findViewById(R.id.tvInfo);
        tvName=findViewById(R.id.tvName);
        ivResult=findViewById(R.id.ivResult);
        ivCall=findViewById(R.id.ivCall);
        ivWeb=findViewById(R.id.ivWeb);
        ivMap=findViewById(R.id.ivMap);
        btnCreate=findViewById(R.id.btnCreate);



        ivResult.setVisibility(View.GONE);
        tvName.setVisibility(View.GONE);
        ivCall.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivMap.setVisibility(View.GONE);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, com.example.intentschallenge.Activity2.class);
                startActivityForResult(intent,ACTIVITY2);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ACTIVITY2)
        {
            ivCall.setVisibility(View.VISIBLE);
            ivResult.setVisibility(View.VISIBLE);
            ivWeb.setVisibility(View.VISIBLE);
            ivMap.setVisibility(View.VISIBLE);
            tvName.setVisibility(View.VISIBLE);

            if(resultCode==RESULT_OK)
            {
                tvName.setText("Hello "+ data.getStringExtra("name"));


                String web=data.getStringExtra("web");
                final String WEBFINAL=web;

                String map=data.getStringExtra("map");
                final String MAPFINAL=map;

                String iphone=data.getStringExtra("phone");
                final String PHONE= iphone;

                int i= data.getIntExtra("smile",0);
                if(i==1)
                {
                    ivResult.setImageResource(R.drawable.sad);
                }
                if(i==2)
                {
                    ivResult.setImageResource(R.drawable.neutural);

                }
                if(i==3)
                {
                    ivResult.setImageResource(R.drawable.happy);
                }



                ivCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+PHONE));
                        startActivity(intent);
                    }
                });

                ivWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+ WEBFINAL));
                        startActivity(intent);
                    }
                });

                ivMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+ MAPFINAL));
                        startActivity(intent);
                    }
                });



            }
            if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(MainActivity.this, "Somethings went wrong!", Toast.LENGTH_SHORT).show();
            }

        }

    }


}
