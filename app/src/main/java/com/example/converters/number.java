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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class number extends AppCompatActivity {

    private String from;
    private String to;
    private int input;
    private int output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //Getting ID
        EditText in = (EditText) findViewById(R.id.input);
        TextView out = (TextView) findViewById(R.id.output);
        Button convert = (Button)findViewById(R.id.convert);

        // From
        Spinner weight_f = findViewById(R.id.weight_from);
        List<String> from_list = new ArrayList<String>();
        from_list.add("Binary");
        from_list.add("Decimal");
        from_list.add("Octal");
        from_list.add("HexaDecimal");
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
        to_list.add("Decimal");
        to_list.add("Octal");
        to_list.add("HexaDecimal");
        to_list.add("Binary");
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
                    // Binary To All
                    if (from.equals("Binary")) {
                        // Binary To Binary
                        if (to.equals("Binary")) {
                            String bin = in.getText().toString();
                            output = Integer.parseInt(bin);
                            out.setText("Binary : " + output);
                        }
                        //Binary To Decimal
                        if (to.equals("Decimal")) {
                            input = Integer.parseInt(in.getText().toString());
                            output = Integer.parseInt((input+ "").replace("/[^01]/gi",""),2);
                            out.setText("Decimal : "+ output);
                        }
                        //Binary To Octal
                        if (to.equals("Octal")) {
                            input = Integer.parseInt(in.getText().toString());
                            output = Integer.parseInt((input+ "").replace("/[^01]/gi",""),2);
                            output = Integer.parseInt(Integer.toOctalString(output));
                            out.setText("Octal : " + output);
                        }
                        //Binary To HexaDecimal
                        if(to.equals("HexaDecimal")){
                            input = Integer.parseInt(in.getText().toString());
                            output = Integer.parseInt((input+ "").replace("/[^01]/gi",""),2);
                            String hex = Integer.toHexString(output).toUpperCase();
                            out.setText("HexaDecimal : "+ hex);
                        }
                    }
                    //Decimal To All
                    if (from.equals("Decimal")) {
                        // Decimal To Binary
                        if (to.equals("Binary")) {
                            input = Integer.parseInt(in.getText().toString());
                            output = Integer.parseInt(Integer.toBinaryString(input));
                            out.setText("Binary : "+ output );
                        }
                        //Decimal To Decimal
                        if (to.equals("Decimal")) {
                            input = Integer.parseInt(in.getText().toString());
                            out.setText("Decimal : "+input);
                        }
                        //Decimal To Octal
                        if (to.equals("Octal")) {
                            input = Integer.parseInt(in.getText().toString());
                            output = Integer.parseInt(Integer.toOctalString(input));
                            out.setText("Octal : "+output);
                        }
                        //Decimal To HexaDecimal
                        if(to.equals("HexaDecimal")){
                            input = Integer.parseInt(in.getText().toString());
                            String hex = Integer.toHexString(input);
                            out.setText("HexaDecimal : "+hex.toUpperCase());
                        }
                    }
                    //Octal To All
                    if (from.equals("Octal")) {
                        // Octal To Octal
                        if (to.equals("Octal")) {
                            input = Integer.parseInt(in.getText().toString());
                            out.setText("Octal : "+input );
                        }
                        // Octal To Binary
                        if (to.equals("Binary")) {
                            input = Integer.parseInt(in.getText().toString(),8);
                            output = Integer.parseInt(Integer.toBinaryString(input));
                            out.setText("Binary : "+output);
                        }
                        //Octal To Decimal
                        if (to.equals("Decimal")) {
                            String oct = in.getText().toString();
                            output = Integer.parseInt(oct,8);
                            out.setText("Decimal : "+output);
                        }
                        //Octal To HexaDecimal
                        if(to.equals("HexaDecimal")){
                            input = Integer.parseInt(in.getText().toString(),8);
                            String hex = Integer.toHexString(input).toUpperCase();
                            out.setText("HexaDecimal : "+hex);
                        }
                    }
                    //HexaDecimal To All
                    if (from.equals("HexaDecimal")) {
                        // HexaDecimal To Binary
                        if (to.equals("Binary")) {
                            String hex = in.getText().toString();
                            String bin = new BigInteger(hex,16).toString(2);
                            out.setText("Binary : "+ bin);
                        }
                        //HexaDecimal To Decimal
                        if (to.equals("Decimal")) {
                            String hex = in.getText().toString();
                            output = Integer.parseInt(hex,16);
                            out.setText("Decimal : "+output);
                        }
                        //HexaDecimal To Octal
                        if (to.equals("Octal")) {
                            String hex = in.getText().toString();
                            output = Integer.parseInt(hex,16);
                            String oct = Integer.toOctalString(output);
                            out.setText("Octal : "+oct);
                        }
                        //HexaDecimal To HexaDecimal
                        if(to.equals("HexaDecimal")){
                            String hex = in.getText().toString();
                            out.setText("HexaDecimal : "+hex);
                        }
                    }

                }
            }
        });
    }
}