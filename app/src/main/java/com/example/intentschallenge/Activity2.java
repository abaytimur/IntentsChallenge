package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText etName,etPhone,etWeb,etMap;
    ImageView ivSad,ivNeutural,ivHappy;
    public int smile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etWeb=findViewById(R.id.etWeb);
        etMap=findViewById(R.id.etMap);
        ivSad=findViewById(R.id.ivSad);
        ivNeutural=findViewById(R.id.ivNeutural);
        ivHappy=findViewById(R.id.ivHappy);



        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty() || etMap.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity2.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }
                else
                {


                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String map = etMap.getText().toString();
                String web = etWeb.getText().toString().trim();
                int smile= 1;
                Intent intent=new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phone);
                    intent.putExtra("map",map);
                    intent.putExtra("web",web);
                    intent.putExtra("smile",smile);

                setResult(RESULT_OK,intent);

                Activity2.this.finish();
                }
            }
        });

        ivNeutural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty() || etMap.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity2.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }
                else
                {


                    String name = etName.getText().toString().trim();
                    String phone = etPhone.getText().toString().trim();
                    String map = etMap.getText().toString();
                    String web = etWeb.getText().toString().trim();
                    int smile=2;
                    Intent intent=new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phone);
                    intent.putExtra("map",map);
                    intent.putExtra("web",web);
                    intent.putExtra("smile",smile);

                    setResult(RESULT_OK,intent);

                    Activity2.this.finish();

                }
            }
        });

        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty() || etWeb.getText().toString().isEmpty() || etMap.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity2.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }
                else
                {


                    String name = etName.getText().toString().trim();
                    String phone = etPhone.getText().toString().trim();
                    String map = etMap.getText().toString();
                    String web = etWeb.getText().toString().trim();
                    int smile=3;
                    Intent intent=new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phone);
                    intent.putExtra("map",map);
                    intent.putExtra("web",web);
                    intent.putExtra("smile",smile);

                    setResult(RESULT_OK,intent);
                    Activity2.this.finish();
                }
            }
        });

    }
}
