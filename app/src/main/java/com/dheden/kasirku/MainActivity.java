package com.dheden.kasirku;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextMessage = findViewById(R.id.editNL);
        EditText editTextMessage2 = findViewById(R.id.editEmail);
        EditText editTextMessage3 = findViewById(R.id.editalamat);
        Spinner spinnerOptions = findViewById(R.id.gender);
        Button buttonShowToast = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.name_app, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);
        buttonShowToast.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Ambil teks dari EditText
                String message = editTextMessage.getText().toString();
                String message2 = editTextMessage2.getText().toString();
                String message3 = editTextMessage3.getText().toString();
                DatePicker datePicker = findViewById(R.id.tanggal);
                String selectedOption = spinnerOptions.getSelectedItem().toString();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1; // bulan ditambah 1 karena 0-indexed
                int year = datePicker.getYear();
                String pesan = "Halo " + message + "\n" +
                        "Email " + message2 + "\n" +
                        "Alamat " + message3 + "\n" +
                        "Gender " + selectedOption ;


                String date = "\n Tanggal: "+ day + "/" + month + "/" + year;


                // Tampilkan Toast dengan pesan dari EditText
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(pesan + date)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("Yes", (dialog, which) -> {
                            // Handle positive button click
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Handle negative button click
                        })
                        .show();
            }


        });

    }

    }

