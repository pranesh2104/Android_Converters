package com.example.converters;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class weight extends AppCompatActivity  {

    private String from;
    private String to;
    private double input;
    private double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        //Getting ID
        EditText in = (EditText) findViewById(R.id.input);
        TextView out = (TextView) findViewById(R.id.output);
        Button convert = (Button)findViewById(R.id.convert);

        // From
        Spinner weight_f = findViewById(R.id.weight_from);
        List<String> from_list = new ArrayList<String>();
        from_list.add("Kilogram(kg)");
        from_list.add("Gram(g)");
        from_list.add("Pound(lb)");
        ArrayAdapter<String > fromAdapter = new ArrayAdapter<String>(this,R.layout.spinner_item, from_list);
        weight_f.setAdapter(fromAdapter);
        weight_f.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                from=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(),"from"+from, LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //To
        Spinner weight_t = findViewById(R.id.weight_to);
        List<String> to_list = new ArrayList<String>();
        to_list.add("Gram(g)");
        to_list.add("Kilogram(kg)");
        to_list.add("Pound(lb)");
        ArrayAdapter<String > toAdapter = new ArrayAdapter<String >(this,R.layout.spinner_item, to_list);
        weight_t.setAdapter(toAdapter);
        weight_t.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                to=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(),"to"+to, LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (in.length() == 0) {
                    out.setTextColor(Color.parseColor("#c93c26"));
                    out.setText("Please Enter a Value!!");
                } else {
                    out.setTextColor(Color.parseColor("#3dc421"));
                    //Kilogram To All
                    if (from.equals("Kilogram(kg)")) {
                        //Kilogram To Gram
                        if (to.equals("Gram(g)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*1000;
                            out.setText(input + " kg = " + String.format("%.2f",output) + " g ");
                        }
                        //Kilogram To Kilogram
                        if (to.equals("Kilogram(kg)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " kg = " + input + " kg");
                        }
                        //Pound To Pound
                        if (to.equals("Pound(lb)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*2.205;
                            out.setText(input + " kg = " + String.format("%.4f",output) + " lb");
                        }
                    }
                    //Gram To All
                    if(from.equals("Gram(g)")){
                        //Gram To Kilogram
                        if(to.equals("Kilogram(kg)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input/1000;
                            out.setText(input + " g = " + String.format("%.3f",output) + " kg ");
                        }
                        //Gram To Gram
                        if (to.equals("Gram(g)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " g = " + input + " g");
                        }
                        //Gram To Pound
                        if (to.equals("Pound(lb)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/454;
                            out.setText(input + " g = " + String.format("%.4f",output) + " lb");
                        }

                    }
                    //Pounds To All
                    if(from.equals("Pound(lb)")){
                        //Pound To Pound
                        if (to.equals("Pound(lb)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " lb = " + input + " lb");
                        }
                        //Pound To Kilogram
                        if(to.equals("Kilogram(kg)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input/2.205;
                            out.setText(input + " lb = " + String.format("%.2f",output) + " kg ");
                        }
                        //Pound To Gram
                        if (to.equals("Gram(g)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*453.5;
                            out.setText(input + " lb = " + String.format("%.2f",output) + " g ");
                        }

                    }
                }
            }
        });

    }


}