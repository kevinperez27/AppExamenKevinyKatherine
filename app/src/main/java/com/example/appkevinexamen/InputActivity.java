package com.example.appkevinexamen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    private EditText nombreEditText;
    private EditText apellidoEditText;
    private EditText paisEditText;
    private EditText posicionEditText;
    private EditText edadEditText;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        nombreEditText = findViewById(R.id.nombreEditText);
        apellidoEditText = findViewById(R.id.apellidoEditText);
        paisEditText = findViewById(R.id.paisEditText);
        posicionEditText = findViewById(R.id.posicionEditText);
        edadEditText = findViewById(R.id.edadEditText);
        Button guardarButton = findViewById(R.id.guardarButton);

        databaseHelper = new DatabaseHelper(this);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreEditText.getText().toString();
                String apellido = apellidoEditText.getText().toString();
                String pais = paisEditText.getText().toString();
                String posicion = posicionEditText.getText().toString();
                int edad = Integer.parseInt(edadEditText.getText().toString());

                databaseHelper.insertFutbolista(nombre, apellido, pais, posicion, edad);

                Toast.makeText(InputActivity.this, "Futbolista guardado exitosamente", Toast.LENGTH_SHORT).show();

                nombreEditText.setText("");
                apellidoEditText.setText("");
                paisEditText.setText("");
                posicionEditText.setText("");
                edadEditText.setText("");
            }
        });
    }
}



