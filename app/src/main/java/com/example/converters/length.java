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

public class length extends AppCompatActivity {

    private String from;
    private String to;
    private double input;
    private double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        //Getting ID
        EditText in = (EditText) findViewById(R.id.input);
        TextView out = (TextView) findViewById(R.id.output);
        Button convert = (Button)findViewById(R.id.convert);

        // From
        Spinner weight_f = findViewById(R.id.weight_from);
        List<String> from_list = new ArrayList<String>();
        from_list.add("Centimeter(cm)");
        from_list.add("Meter(m)");
        from_list.add("Kilometer(km)");
        from_list.add("Millimeter(mm)");
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
        to_list.add("Meter(m)");
        to_list.add("Centimeter(cm)");
        to_list.add("Kilometer(km)");
        to_list.add("Millimeter(mm)");
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
        //Getting Input From User

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (in.length() == 0) {
                    out.setTextColor(Color.parseColor("#c93c26"));
                    out.setText("Please Enter a Value!!");
                } else {
                    out.setTextColor(Color.parseColor("#3dc421"));
                    // Centimeter To All
                    if (from.equals("Centimeter(cm)")) {
                        // Centimeter To Meter
                        if (to.equals("Meter(m)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/100;
                            out.setText(input + " cm = " + String.format("%.2f",output) + " m ");
                        }
                        //Centimeter To Kilometer
                        if (to.equals("Kilometer(km)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/100000;
                            out.setText(input + " cm = " + String.format("%.2f",output) + " km");
                        }
                        //Centimeter To Centimeter
                        if (to.equals("Centimeter(cm)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " cm = " + input + " cm");
                        }
                        //Centimeter To Millimeter
                        if(to.equals("Millimeter(mm)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input*10;
                            out.setText(input + " cm = " + String.format("%.2f",output) + " mm");
                        }
                    }
                    //Meter To All
                    if (from.equals("Meter(m)")) {
                        // Meter To Meter
                        if (to.equals("Meter(m)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " m = " + input + " m ");
                        }
                        //Meter To Kilometer
                        if (to.equals("Kilometer(km)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/1000;
                            out.setText(input + " m = " + String.format("%.2f",output) + " km");
                        }
                        //Centimeter To Centimeter
                        if (to.equals("Centimeter(cm)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*100;
                            out.setText(input + " m = " + String.format("%.2f",output) + " cm");
                        }
                        //Centimeter To Millimeter
                        if(to.equals("Millimeter(mm)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input*1000;
                            out.setText(input + " m = " + String.format("%.2f",output) + " mm");
                        }
                    }
                    //Kilometer To All
                    if (from.equals("Kilometer(km)")) {
                        // Kilometer To Meter
                        if (to.equals("Meter(m)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*1000;
                            out.setText(input + " km = " + String.format("%.2f",output) + " m ");
                        }
                        //Kilometer To Kilometer
                        if (to.equals("Kilometer(km)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " km = " + input + " km");
                        }
                        //Kilometer To Centimeter
                        if (to.equals("Centimeter(cm)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*100000;
                            out.setText(input + " km = " + String.format("%.2f",output) + " cm");
                        }
                        //Kilometer To Millimeter
                        if(to.equals("Millimeter(mm)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input*1e+6;
                            out.setText(input + " km = " + String.format("%.2f",output) + " mm");
                        }
                    }
                    //Millimeter To All
                    if (from.equals("Millimeter(mm)")) {
                        // Millimeter To Meter
                        if (to.equals("Meter(m)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/1000;
                            out.setText(input + " mm = " + String.format("%.2f",output) + " m ");
                        }
                        //Millimeter To Kilometer
                        if (to.equals("Kilometer(km)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/1e+6;
                            out.setText(input + " mm = " + String.format("%.2f",output) + " km");
                        }
                        //Kilometer To Centimeter
                        if (to.equals("Centimeter(cm)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/10;
                            out.setText(input + " mm = " + String.format("%.2f",output) + " cm");
                        }
                        //Kilometer To Millimeter
                        if(to.equals("Millimeter(mm)")){
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " mm = " + input + " mm");
                        }
                    }

                }
            }
        });

    }
}