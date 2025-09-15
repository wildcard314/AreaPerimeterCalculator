package com.example.areaperimetercalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity
{
    //globals

    //rect and square
    //area = length and width
    //perimeter = length and width

    //circle
    //area = radius
    //circumference = radus

    //triangle
    //perimeter = side a, side b side c
    //area =

    EditText et_j_length;
    EditText et_j_width;
    ConstraintLayout cons_j_squareRectangleView;
    Spinner sp_j_shapes;
    TextView tv_j_areaPermiter;

    ArrayAdapter<String> spinneradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_j_length = findViewById(R.id.et_v_length);
        et_j_width = findViewById(R.id.et_v_width);
        cons_j_squareRectangleView = findViewById(R.id.cont_v_squareRectable);
        sp_j_shapes = findViewById(R.id.sp_v_shapes);
        tv_j_areaPermiter = findViewById(R.id.tv_v_resultsSquare);

        //becasue we are makiing a simple dropdown menu (Spinner) that will only contain
        // strings as options. ew can use a string array with the built in array adapter
        // to populate the spinner

        //we will use this to populte the spinner
        String[] shapes = new String[] {"Square", "Rectangle", "Circle", "Triangle"};

        //adapter is what links the java code with the xml for the spinner

        spinneradapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,shapes);

        sp_j_shapes.setAdapter(spinneradapter);
        setupSpinnerChangeListener();

        textchangeListenerSquareRect();




    }

    // Functions

    public void setupSpinnerChangeListener()
    {
        sp_j_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //0-3 indexes
                if(position == 0)
                {
                    //square
                    cons_j_squareRectangleView.setVisibility(View.VISIBLE);


                }
                else if (position == 1)
                {
                    //rectangle
                    cons_j_squareRectangleView.setVisibility(View.VISIBLE);

                }
                else if (position == 2)
                {
                    //circle

                    hideConstraintView(cons_j_squareRectangleView);
                }
                else if (position == 3)
                {
                    //triangle

                    hideConstraintView(cons_j_squareRectangleView);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void hideConstraintView(ConstraintLayout cl)
    {
        cl.setVisibility(View.INVISIBLE);


    }

    public void textchangeListenerSquareRect()
    {
        et_j_width.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeterSquareRect(et_j_length.getText().toString(), et_j_width.getText().toString());
            }
        });

        et_j_length.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeterSquareRect(et_j_length.getText().toString(), et_j_width.getText().toString());
            }
        });

    }

    public void setAreaAndPerimeterSquareRect(String lengthS, String widthS)
    {
        if(lengthS.isEmpty() || widthS.isEmpty())
        {
            return;
        }

        double length = Double.parseDouble(lengthS);
        double width = Double.parseDouble(widthS);

        double area = length * width;
        double perimeter = length + length + width + width;

        tv_j_areaPermiter.setText(("Area = " + area + "\nPerimeter = " + perimeter));


    }



}