package com.germany.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class crearNota extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String spinnerLabel;
    Spinner spinner;
    private TextView IdTxtDate;

    private EditText stringTitle;
    private Button btnGuardar;

    Calendar date;

//    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);

        IdTxtDate = findViewById(R.id.IdTxtDate);
      date = Calendar.getInstance();

        String mes_string = Integer.toString(date.get(Calendar.MONTH) + 1);
        String dia_string = Integer.toString(date.get(Calendar.DAY_OF_MONTH));
        String anio_string = Integer.toString(date.get(Calendar.YEAR));
        String fecha_string = getResources().getString(R.string.coger_fecha) + dia_string + " / " + mes_string + " / " + anio_string;

        IdTxtDate.setText(fecha_string);

        stringTitle = findViewById(R.id.idTxtTitle);
        btnGuardar = findViewById(R.id.idBtnCrear);
         spinner = findViewById(R.id.idSpinner);

             btnGuardar.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View v) {

                     guardarDatos();
                 }


             });


        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.levels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
//             Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    private void guardarDatos() {

        String tipo = spinner.getSelectedItem().toString();
        int img =0;
        NotaItem.Tipo auxtipo =NotaItem.Tipo.IMPORTANTE ;

        switch (tipo) {
            case "Important":
                auxtipo = NotaItem.Tipo.IMPORTANTE;
                img= R.drawable.importante;
                break;
            case "Urgente":
                auxtipo = NotaItem.Tipo.URGENTE;
                img= R.drawable.urgente;
                break;
            case "Normal":
                auxtipo = NotaItem.Tipo.NORMAL;
                img= R.drawable.normal;
                break;
            default:
                break;
        }


        NotaItem notaItem = new NotaItem(img, stringTitle.getText().toString(), date, auxtipo );
        ListaDatos.listaNotas.add(notaItem);
        finish();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerLabel = parent.getItemAtPosition(position).toString();

        Toast.makeText(this, spinnerLabel, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void seleccionarFecha(int year, int month, int day) {

        String mes_string = Integer.toString(month + 1);
        String dia_string = Integer.toString(day);
        String anio_string = Integer.toString(year);
        String fecha_string = getResources().getString(R.string.coger_fecha) + dia_string + " / " + mes_string + " / " + anio_string;

        IdTxtDate.setText(fecha_string);
        Toast.makeText(this, fecha_string, Toast.LENGTH_LONG).show();

        date.set(year,month, day);
    }

    public void regresarMainActivity(View view) {
        Intent regresaMainActivity = new Intent( crearNota.this, MainActivity.class);
        startActivity(regresaMainActivity);
    }

    public void selectDate(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.coger_fecha));
    }
}