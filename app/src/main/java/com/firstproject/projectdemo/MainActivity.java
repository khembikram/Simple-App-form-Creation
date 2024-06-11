package com.firstproject.projectdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editEmail, editPhone;
    private Spinner employeetype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        employeetype = findViewById(R.id.employeetype);
        Button explicitButton = findViewById(R.id.buttonExplicit);
        Button submitButton = findViewById(R.id.submit_button);

        // Setting up the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.example_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employeetype.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();
                String spinnerItem = employeetype.getSelectedItem().toString();

                String message = "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nSelected: ";
                String message2 = "Your Employee Type is : " + spinnerItem;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, message2, Toast.LENGTH_LONG).show();
//                Creating object of intent -> Views after action is performed
                Intent intent = new Intent(Intent.ACTION_VIEW);
//                parsing Uri
                intent.setData(Uri.parse("https://www.google.com"));
//                passes the intentc
                startActivity(intent);

            }
        });
        explicitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("message", "Message from first");
                intent.putExtra("nextMessage",editName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
