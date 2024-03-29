package org.development.aihd.app.forms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import org.development.aihd.app.R;
import org.development.aihd.app.app.CustomDividerItemDecoration;
import org.development.aihd.app.common.NavigationDrawerShare;
import org.development.aihd.app.model.Forms;
import org.development.aihd.app.adapters.models.FormAdapter;

import java.util.ArrayList;
import java.util.List;

public class DM_HTN_Forms extends AppCompatActivity {

    //private String TAG = MainActivity.class.getSimpleName();

    private List<Forms> formList;
    private List<Forms> allFormsList;
    private FormAdapter adapter;
    private String patient_id;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patients);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationDrawerShare navigate = new NavigationDrawerShare(this);
        navigate.createDrawer(toolbar);

        Intent intent = getIntent();
        patient_id = intent.getStringExtra("patient_id");
        Log.d("patient_id", "Patient ID: "+patient_id);

        EditText inputSearch = findViewById(R.id.input_search);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        allFormsList = new ArrayList<>();
        formList = new ArrayList<>();

        adapter = new FormAdapter(this, allFormsList);

        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 36));
        recyclerView.setAdapter(adapter);

        getPatients();

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


    }


    public void getPatients() {
        // Reading all contacts
        Log.d("Reading: ", "Reading all forms..");

        try {

            List<Forms> forms = Forms.findWithQuery(Forms.class, "SELECT * FROM FORMS WHERE patientid = ? ORDER BY date DESC", patient_id);

            for (Forms fn : forms) {
                // adding each child node to HashMap key => value
                Forms form = new Forms();
                form.setForm_id(fn.getForm_id());
                form.setForm_name(fn.getForm_name());
                form.setForm_type(fn.getForm_type());
                form.setStatus(fn.getStatus());
                form.setDate(fn.getDate());
                allFormsList.add(form);

                Log.d("Type", fn.getForm_type());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void filter(String text) {
        @SuppressWarnings("unchecked") List<Forms> temp = new ArrayList();
        formList = allFormsList;
        for (Forms f : formList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            String name = f.getForm_name();
            if (name.toLowerCase().contains(text.toLowerCase())) {
                temp.add(f);
            }
        }
        //update recyclerview
        adapter.searchList(temp);
    }


}