package org.development.aihd.app.resources;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.development.aihd.app.R;
import org.development.aihd.app.app.Variables;
import org.development.aihd.app.common.NavigationDrawerShare;

public class ResourcesActivity extends AppCompatActivity {

    Button btn_pdf1, btn_pdf2, btn_pdf3, btn_pdf4, btn_pdf5, btn_pdf6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        btn_pdf1 = findViewById(R.id.pdf1);
        btn_pdf2 = findViewById(R.id.pdf2);
        btn_pdf3 = findViewById(R.id.pdf3);
        btn_pdf4 = findViewById(R.id.pdf4);
        btn_pdf5 = findViewById(R.id.pdf5);
        btn_pdf6 = findViewById(R.id.pdf6);


        btn_pdf1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Variables.RESOURCE_URL + "sops.page"));
                startActivity(intent);
            }
        });

        btn_pdf2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Variables.RESOURCE_URL + "faqs.page"));
                startActivity(intent);

            }
        });

        btn_pdf3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Variables.RESOURCE_URL + "terms.page"));
                startActivity(intent);
            }
        });

        btn_pdf4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Variables.RESOURCE_URL + "diabetesClinical.page"));
                startActivity(intent);
            }
        });

        btn_pdf5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Variables.RESOURCE_URL + "cardiovascular.page"));
                startActivity(intent);
            }
        });

        btn_pdf6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Variables.BASE_URL+"/resources/NCD_EMS_Mobile_App_User_Manual.pdf"));
                startActivity(intent);
            }
        });
    }
}
