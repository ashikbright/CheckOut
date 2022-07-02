package com.ashik.checkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editNworker,editNdays,editLocation;
    Button button;
    Spinner spinner;
    DatabaseReference databaseReference;
    String item;
    Worker worker;
    String[] wTypes={"Choose Worker Type","Mistri","Tiles/Marbel Mistri","Painter","Plumber","Furniture Works","Electrician","Welder"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNworker=findViewById(R.id.edtnWorkers);
        editNdays=findViewById(R.id.edtndays);
        editLocation=findViewById(R.id.edtLocation);
        button=findViewById(R.id.BtnSave);
        spinner=findViewById(R.id.wtype);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("value");
        spinner.setOnItemSelectedListener(this);

        //worker=new Worker();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,wTypes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveValue(item);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item=spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    void SaveValue(String item){
        if(item=="Choose Worker Type"){
            Toast.makeText(this, "Please Select a Worker Type", Toast.LENGTH_SHORT).show();
        }
        else{
            worker.setwType(item);
            String id=databaseReference.push().getKey();
            databaseReference.child(id).setValue(worker);
            Toast.makeText(this, "Check Out Done", Toast.LENGTH_SHORT).show();
        }
        String nworkers=editNworker.getText().toString();
        String ndays=editNdays.getText().toString();
        String location=editLocation.getText().toString();

        worker=new Worker(nworkers,ndays,location);
        databaseReference.push().setValue(value);
    }
}