package com.example.lbrary;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,pw,pw2;
    Button reg;
    TextView tv;

    DatabaseHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new DatabaseHelper(this);

        email=(EditText) findViewById(R.id.email);
        pw=(EditText) findViewById(R.id.pw1);
        pw2=(EditText) findViewById(R.id.pw2);
        reg=(Button) findViewById(R.id.register);
        tv=(TextView) findViewById(R.id.tw);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"deneme",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this,Login.class);

                startActivity(intent);
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=email.getText().toString();
                String s2=pw.getText().toString();
                String s3=pw2.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(s2.equals(s3))
                    {
                        Boolean checkmail=db.checkmail(s1);
                        if(checkmail==true)
                        {
                            Boolean insert=db.insert(s1,s2);

                            if(insert==true)
                            {
                                Toast.makeText(getApplicationContext(),"Succesfull",Toast.LENGTH_SHORT).show();


                                Intent intent=new Intent(MainActivity.this,Login.class);

                                startActivity(intent);
                            }
                        }
                        else

                        {
                            Toast.makeText(getApplicationContext(),"mail already exist",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });




    }
}
