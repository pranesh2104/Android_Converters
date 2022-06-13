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
import java.util.Stack;

class StackConvert{
    char a[]=new char[100];
    int top=-1;
    void push(char c)
    {
        try
        {
            a[++top]= c;
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("Stack full, no room to push, size=100");
            System.exit(0);
        }
    }
    char pop()
    {
        return a[top--];
    }
    boolean isEmpty()
    {
        return (top==-1)?true:false;
    }
    char peek()
    {
        return a[top];
    }

}

class InfixToPrefix {

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String infix) {
        String prefix = "";
        Stack<Character> operators = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; --i) {
            char ch = infix.charAt(i);

            if (precedence(ch) > 0) {
                while (operators.isEmpty() == false && precedence(operators.peek()) > precedence(ch)) {
                    prefix += operators.pop();
                }
                operators.push(ch);
            } else if (ch == '(') {

                char x = operators.pop();
                while (x != ')') {
                    prefix += x;
                    x = operators.pop();
                }

            } else if (ch == ')') {
                operators.push(ch);
            } else {
                prefix += ch;
            }
            System.out.println(prefix);
        }

        while (!operators.isEmpty()) {
            prefix += operators.pop();
        }

        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }
}
public class stack extends AppCompatActivity {

    private String from;
    private String to;
    private String input;
    private String output;

    static StackConvert operators = new StackConvert();
    static InfixToPrefix infixToPrefix = new InfixToPrefix();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        //Getting ID
        EditText in = (EditText) findViewById(R.id.input);
        TextView out = (TextView) findViewById(R.id.output);
        Button convert = (Button)findViewById(R.id.convert);

        // From
        Spinner weight_f = findViewById(R.id.weight_from);
        List<String> from_list = new ArrayList<String>();
        from_list.add("Infix");
        from_list.add("Prefix");
        from_list.add("Postfix");
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
        to_list.add("Prefix");
        to_list.add("Infix");
        to_list.add("Postfix");
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
                }
                else{
                    out.setTextColor(Color.parseColor("#3dc421"));
                    //Infix To All
                    if (from.equals("Infix")) {
                        //Infix To Postfix
                        if (to.equals("Postfix")) {
                            input = in.getText().toString().replaceAll(" ","");
                            output = toPostfix(input);
                            out.setText("Postfix : "+ output );
                        }
                        //Infix To Infix
                        if (to.equals("Infix")) {
                            input = in.getText().toString();
                            out.setText("Infix : " + input );
                        }
                        //Infix To Prefix
                        if (to.equals("Prefix")) {
                            input = in.getText().toString().replaceAll(" ","");

                            output = infixToPrefix.infixToPrefix(input);
                            out.setText("Prefix : "+output);
                        }
                    }
                    //Gram To All
                    if(from.equals("Gram(g)")){
                        //Gram To Kilogram
                        if(to.equals("Kilogram(kg)")){
                            input = in.getText().toString();

                            out.setText(input + " g = " + String.format("%.2f",output) + " kg ");
                        }
                        //Gram To Gram
                        if (to.equals("Gram(g)")) {
                            input = in.getText().toString();
                            out.setText(input + " g = " + input + " g");
                        }
                        //Gram To Pound
                        if (to.equals("Pound(lb)")) {
                            input = in.getText().toString();

                            out.setText(input + " g = " + String.format("%.4f",output) + " lb");
                        }

                    }
                    //Pounds To All
                    if(from.equals("Pound(lb)")){
                        //Pound To Pound
                        if (to.equals("Pound(lb)")) {
                            input = in.getText().toString();
                            out.setText(input + " lb = " + input + " lb");
                        }
                        //Pound To Kilogram
                        if(to.equals("Kilogram(kg)")){
                            input = in.getText().toString();

                            out.setText(input + " lb = " + String.format("%.2f",output) + " kg ");
                        }
                        //Pound To Gram
                        if (to.equals("Gram(g)")) {
                            input = in.getText().toString();

                            out.setText(input + " lb = " + String.format("%.2f",output) + " g ");
                        }

                    }
                }

            }
        });
    }
    //Infix To Postfix
    private static String toPostfix(String infix)
    //converts an infix expression to postfix
    {
        char symbol;
        String postfix = "";
        for(int i=0;i<infix.length();++i)
        //while there is input to be read
        {
            symbol = infix.charAt(i);
            //if it's an operand, add it to the string
            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol=='(')
            //push (
            {
                operators.push(symbol);
            }
            else if (symbol==')')
            //push everything back to (
            {
                while (operators.peek() != '(')
                {
                    postfix = postfix + operators.pop();
                }
                operators.pop();        //remove '('
            }
            else
            //print operators occurring before it that have greater precedence
            {
                while (!operators.isEmpty() && !(operators.peek()=='(') && prec(symbol) <= prec(operators.peek()))
                    postfix = postfix + operators.pop();
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty())
            postfix = postfix + operators.pop();
        return postfix;
    }
    static int prec(char x)
    {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
    

}
