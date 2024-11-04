package com.elkoki.controlspinner;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1, et2;
    private TextView txtview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner1 = findViewById(R.id.spinner);
        et1 = findViewById(R.id.txt_value1);
        et2 = findViewById(R.id.txt_value2);
        txtview1 = findViewById(R.id.txtview_results);

        String [] Options = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Options);
        spinner1.setAdapter(adapter);
    }

    //Metodo del boton
    public void calcular(View view) {
    String valor1_string = et1.getText().toString();
    String valor2_string = et2.getText().toString();

    int valor1Int = Integer.parseInt(valor1_string);
    int valor2Int = Integer.parseInt(valor2_string);

    String selection = spinner1.getSelectedItem().toString();
    if (selection.equals("Sumar")) {
        int sum = valor1Int + valor2Int;
        txtview1.setText(String.valueOf(sum));
    } else if (selection.equals("Restar")) {
        int rest = valor1Int - valor2Int;
        txtview1.setText(String.valueOf(rest));
    }
    else if (selection.equals("Multiplicar")) {
        int mult = valor1Int * valor2Int;
        txtview1.setText(String.valueOf(mult));
    }
    else if (selection.equals("Dividir")) {
        if (valor2Int != 0) {
            int div = valor1Int / valor2Int;
            txtview1.setText(String.valueOf(div));
        }
        else {
            txtview1.setText("No se puede dividir entre 0");
        }
    }
    }
}