package com.example.lbrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,pw;
    Button lg;
    TextView tv2;

    DatabaseHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db= new DatabaseHelper(this);

        email=(EditText) findViewById(R.id.email2);
        pw=(EditText) findViewById(R.id.pword2);
        lg=(Button) findViewById(R.id.login2);
        tv2=(TextView) findViewById(R.id.tv2);

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a=new Intent(Login.this,MainActivity.class);

                startActivity(a);
            }
        });

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail= email.getText().toString();
                String pword= pw.getText().toString();

                Boolean check=db.checklog(mail,pword);

                if(check==true)
                {
                    Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(Login.this,MainPage.class);

                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
