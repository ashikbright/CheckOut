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

public class MainActivity extends AppCompatActivity  {
    EditText editNoWorkers;
    EditText editNoDays;
    EditText editLocation;
    Button button;
    Spinner spinner;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNoWorkers = findViewById(R.id.edtnWorkers);
        editNoDays = findViewById(R.id.edtNDays);
        editLocation = findViewById(R.id.edtLocation);
        button = findViewById(R.id.BtnSave);
        spinner = findViewById(R.id.wtype);

        databaseReference = FirebaseDatabase.getInstance().getReference("Checkout");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkoutdata();
                //clearing data
                editNoWorkers.getText().clear();
                editNoDays.getText().clear();
                editLocation.getText().clear();
            }

        });

    }
    private  void checkoutdata(){

        String worker_type = spinner.getSelectedItem().toString();
        String nworkers  = editNoWorkers.getText().toString();
        String ndays = editNoDays.getText().toString();
        String location = editLocation.getText().toString();


        Worker worker = new Worker(worker_type, nworkers, ndays, location);
        databaseReference.push().setValue(worker,  new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Log.d("checkoutMsg" , "Data could not be saved " + databaseError.getMessage());
                } else {
                    Log.d("checkoutMsg" ,"Data saved successfully.");
                    Toast.makeText(getApplicationContext(), "CheckOut Done...", Toast.LENGTH_SHORT).show();
                }
            }
        });


            

    }

}