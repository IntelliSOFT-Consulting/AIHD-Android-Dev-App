package org.development.aihd.app.resources;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.development.aihd.app.R;
import org.development.aihd.app.common.NavigationDrawerShare;

public class HelpdeskActivity extends AppCompatActivity {

    Button btn_ticket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesk);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);


        btn_ticket=(Button)findViewById(R.id.ticket);

        btn_ticket.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String url = "https://ncdems.on.spiceworks.com/portal/tickets";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

}
