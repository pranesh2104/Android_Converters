package com.example.converters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);

    }



    // Open the Drawer
    public void ClickMenu(View view){
        //Toast.makeText(this,"Stack", Toast.LENGTH_SHORT).show();
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.open();
        //drawerLayout.openDrawer(GravityCompat.START);
    }

    //Close The Drawer
    public  void ClickLogo(View view){

        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }

    }

    //Back
    public void ClickBack(View view){

        MainActivity.redirectActivity(this,MainActivity.class);
    }
    // Home
    public void ClickHome(View view){

        recreate();
    }

    //Share
    public  void ClickShare(View view){

        share();
    }

    //About
    public void ClickAbout(View view){

        setContentView(R.layout.about);
    }

    private void share() {

        ApplicationInfo api=getApplicationContext().getApplicationInfo();
        String apkpath=api.publicSourceDir;
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        Uri file=Uri.parse(apkpath);
//        i.putExtra(Intent.EXTRA_STREAM, file);
        i.putExtra(Intent.EXTRA_TEXT,"Click Here:  https://drive.google.com/file/d/1rmPt4BK89a-YThOl3Lc1zoXS7tye5kPD/view?usp=sharing");
        startActivity(Intent.createChooser(i,"Share app Using"));

    }

    // Redirect Files
    public void energy_con(View view) {

        redirectActivity(this,energy.class);
    }

    public void number_con(View view) {

        redirectActivity(this,number.class);
    }

    public void weight_con(View view) {

        redirectActivity(this,weight.class);
    }

    public void length_con(View view) {
        redirectActivity(this,length.class);
    }

    public void stack_con(View view) {
        //Toast.makeText(this,"Stack",Toast.LENGTH_SHORT).show();
        redirectActivity(this,stack.class);
    }

    public static void redirectActivity(Activity activity, Class aclass) {

        Intent i=new Intent(activity,aclass);
        //set Flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        activity.startActivity(i);
    }

    //Logout
    public void ClickLogout(View view){

        logout(this);
    }
    //Logout Function
    public static void logout(Activity activity) {

        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Logout");

        builder.setMessage("Are You Sure You Want To Logout ?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });
        builder.show();
    }
}