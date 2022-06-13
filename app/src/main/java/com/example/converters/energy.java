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

public class energy extends AppCompatActivity {

    private String from;
    private String to;
    private double input;
    private double output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);

        //Getting ID
        EditText in = (EditText) findViewById(R.id.input);
        TextView out = (TextView) findViewById(R.id.output);
        Button convert = (Button)findViewById(R.id.convert);

        // From
        Spinner weight_f = findViewById(R.id.weight_from);
        List<String> from_list = new ArrayList<String>();
        from_list.add("watt-hour(Wh)");
        from_list.add("kilowatt-hour(kWh)");
        from_list.add("joules(J)");
        from_list.add("kilojoules(kJ)");
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
        to_list.add("joules(J)");
        to_list.add("kilojoules(kJ)");
        to_list.add("watt-hour(Wh)");
        to_list.add("kilowatt-hour(kWh)");
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
                    // watt-hour TO All
                    if (from.equals("watt-hour(Wh)")) {
                        // Centimeter To Meter
                        if (to.equals("watt-hour(Wh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " Wh = " + input + " Wh");
                        }
                        //watt-hour To Kilowatt-hour
                        if (to.equals("kilowatt-hour(kWh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/1000;
                            out.setText(input + " Wh = " + String.format("%.3f",output) + " kWh");
                        }
                        //watt-hour To Joules
                        if (to.equals("joules(J)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*3600;
                            out.setText(input + " Wh = " + output + " J");
                        }
                        //watt-hour To kilojoules
                        if(to.equals("kilojoules(kJ)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input*3.6;
                            out.setText(input + " Wh = " + String.format("%.3f",output) + " kJ");
                        }
                    }
                    //kilowatt-hour To All
                    if (from.equals("kilowatt-hour(kWh)")) {
                        // kilowatt-hour To Kilowatt-hour
                        if (to.equals("kilowatt-hour(kWh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " kWh = " + input + " kWh");
                        }
                        //kilowatt-hour To watt-hour
                        if (to.equals("watt-hour(Wh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*1000;
                            out.setText(input + " kWh = " + String.format("%.2f",output) + " Wh");
                        }
                        //kilowatt-hour To joules
                        if (to.equals("joules(J)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*3600000;
                            out.setText(input + " kWh = " + String.format("%.2f",output) + " J");
                        }
                        //kilowatt-hour To kilojoules
                        if(to.equals("kilojoules(kJ)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input*3600;
                            out.setText(input + " kWh = " + String.format("%.3f",output) + " kJ");
                        }
                    }
                    //Joules To All
                    if (from.equals("joules(J)")) {
                        // Joules To Joules
                        if (to.equals("joules(J)")) {
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " J = " + input + " J");
                        }
                        //Joules To watt-hour
                        if (to.equals("watt-hour(Wh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/3600;
                            out.setText(input + " J = " + String.format("%.5f",output) + " Wh");
                        }
                        //Joules To kilojoules
                        if (to.equals("kilojoules(kJ)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/1000;
                            out.setText(input + " J = " + String.format("%.3f",output) + " kJ");
                        }
                        //Joules To kilowatt-hour

                        if(to.equals("kilowatt-hour(kWh)")){
                            input = Double.parseDouble(in.getText().toString());
                            output = input/3600000;
                            out.setText(input + " J = " + output + " kWh");
                        }
                    }
                    //Kilojoules To All
                    if (from.equals("kilojoules(kJ)")) {
                        // kilojoules To joules
                        if (to.equals("joules(J)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input*1000;
                            out.setText(input + " kJ = " + String.format("%.2f",output) + " J");
                        }
                        // kilojoules To watt-hour
                        if (to.equals("watt-hour(Wh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/3.6;
                            out.setText(input + " kJ = " + String.format("%.3f",output) + " Wh");
                        }
                        // kilojoules To kilowatt-hour
                        if (to.equals("kilowatt-hour(kWh)")) {
                            input = Double.parseDouble(in.getText().toString());
                            output = input/3600;
                            out.setText(input + " kJ = " + String.format("%.5f",output) + " kWh");
                        }
                        // kilojoules To kilojoules
                        if(to.equals("kilojoules(kJ)")){
                            input = Double.parseDouble(in.getText().toString());
                            out.setText(input + " kJ = " + input + " kJ");
                        }
                    }

                }
            }
        });

    }
}