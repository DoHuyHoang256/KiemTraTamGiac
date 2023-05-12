package com.example.kiemtratamgiac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC, edtKQ;
    Button btnCCL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        edtKQ = findViewById(R.id.edtKQ);
        btnCCL = findViewById(R.id.btnCCL);
        btnCCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sA = edtA.getText().toString();
                String sB = edtB.getText().toString();
                String sC = edtC.getText().toString();
                if (sA.matches("") || sB.matches("") || sC.matches("")) {
                    Toast.makeText(MainActivity.this,"Please enter all three sides",Toast.LENGTH_SHORT).show();
                    return;
                }
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = Integer.parseInt(edtC.getText().toString());
                if(a > 2147483647 || a == 0 || b > 2147483647 || b == 0 || c == 2147483647 || c == 0 ){
                    Toast.makeText(MainActivity.this,"syntax error",Toast.LENGTH_SHORT).show();
                    return;
                }
                if( a<b+c && b<a+c && c<a+b ){
                    if( a*a==b*b+c*c || b*b==a*a+c*c || c*c== a*a+b*b)
                        edtKQ.setText("This is a right triangle");
                    else if(a==b && b==c)
                        edtKQ.setText("This is an equilateral triangle");
                    else if(a==b || a==c || b==c)
                        edtKQ.setText("This is an isosceles triangle");
                    else if(a*a > b*b+c*c || b*b > a*a+c*c || c*c > a*a+b*b)
                        edtKQ.setText("This is an obtuse triangle");
                    else
                        edtKQ.setText("This is an acute triangle");
                }
                else
                    edtKQ.setText("Not triangles");
            }
        });
    }
}