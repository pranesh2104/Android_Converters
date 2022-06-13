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

public class temperature extends AppCompatActivity {

    private String from;
    private String to;
    private double input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        //Getting ID
        EditText in = (EditText) findViewById(R.id.input);
        TextView out = (TextView) findViewById(R.id.output);
        Button convert = (Button)findViewById(R.id.convert);

        // From
        Spinner weight_f = findViewById(R.id.weight_from);
        List<String> from_list = new ArrayList<String>();
        from_list.add("Celcius(C)");
        from_list.add("Fahrenheit(F)");
        from_list.add("Kelvin(K)");
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
        to_list.add("Fahrenheit(F)");
        to_list.add("Celcius(C)");
        to_list.add("Kelvin(K)");
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
                    // Celcius To All
                    if (from.equals("Celcius(C)")) {
                        // Celcius To Fahrenheit
                        if (to.equals("Fahrenheit(F)")) {
                            input = Double.parseDouble(in.getText().toString());
                            double fahrenheit = (input* 9 / 5) + 32;
                            out.setText(input + " C = " + String.format("%.3f",fahrenheit) + " F ");
                        }
                        //Celcius To Kelvin
                        if (to.equals("Kelvin(K)")) {
                            input = Double.parseDouble(in.getText().toString());
                            double kelvin = input + 273.15;
                            out.setText(input + " C = " + String.format("%.3f",kelvin) + " K");
                        }
                        //Celcius To Celcius
                        if (to.equals("Celcius(C)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " C = " + input + " C");
                        }
                    }
                    //Fahrenheit To All
                    if (from.equals("Fahrenheit(F)")) {
                        // Fahrenheit(F) To Fahrenheit(F)
                        if (to.equals("Fahrenheit(F)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " F = " + input + " F ");
                        }
                        //Fahrenheit(F) To Celcius(C)
                        if (to.equals("Celcius(C)")) {
                            input = Double.parseDouble(in.getText().toString());
                            double celcius = (input - 32) * 5 / 9;
                            out.setText(input + " F = " + String.format("%.2f",celcius) + " C");
                        }
                        //Fahrenheit To Kelvin(K)
                        if (to.equals("Kelvin(K)")) {
                            input = Double.parseDouble(in.getText().toString());
                            double kelvin = 273.5 + ((input - 32.0) * (5.0 / 9.0));
                            out.setText(input + " F = " + String.format("%.2f",kelvin) + " K");
                        }

                    }
                    //Kelvin(K) To All
                    if (from.equals("Kelvin(K)")) {
                        // Kelvin(K) To Celcius(C)
                        if (to.equals("Celcius(C)")) {
                            input = Double.parseDouble(in.getText().toString());
                            double celcius = input - 273.15;
                            out.setText(input + " K = " + String.format("%.3f",celcius) + " C ");
                        }
                        //Kelvin(K) To Kelvin(K)
                        if (to.equals("Kelvin(K)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " K = " + input + " K");
                        }
                        //Kelvin(K) To Fahrenheit(F)
                        if (to.equals("Fahrenheit(F)")) {
                            input = Double.parseDouble(in.getText().toString());
                            double fahrenheit = (input - 273.15) * 1.8 + 32;
                            out.setText(input + " K = " + String.format("%.2f",fahrenheit) + " F");
                        }

                    }

                }
            }
        });
    }
}