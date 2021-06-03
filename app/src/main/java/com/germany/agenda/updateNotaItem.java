package com.germany.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class updateNotaItem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//    String spinnerLabel;
    Spinner spinner;
    private TextView IdTxtDate;

    private EditText stringTitle;
    private Button btnGuardar;
    NotaItem vistaNota;
    Calendar date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);
        IdTxtDate = findViewById(R.id.IdTxtDate);
        stringTitle = findViewById(R.id.idTxtTitle);
        btnGuardar = findViewById(R.id.idBtnCrear);
        spinner = findViewById(R.id.idSpinner);
//        date = Calendar.getInstance();

//        String mes_string = Integer.toString(date.get(Calendar.MONTH) + 1);
//        String dia_string = Integer.toString(date.get(Calendar.DAY_OF_MONTH));
//        String anio_string = Integer.toString(date.get(Calendar.YEAR));
//        String fecha_string = getResources().getString(R.string.coger_fecha) + dia_string + " / " + mes_string + " / " + anio_string;
        Intent recibirDato = getIntent();
        int posicion = recibirDato.getIntExtra("Item", 0);
        vistaNota = ListaDatos.listaNotas.get(posicion);



        IdTxtDate.setText(vistaNota.getfechaString());
        stringTitle.setText(vistaNota.getActividad());
        NotaItem.Tipo tipo = vistaNota.getTipoActividad();
        if(tipo == NotaItem.Tipo.URGENTE){
            spinner.setSelection(0);
        }
            if(tipo == NotaItem.Tipo.IMPORTANTE){
                spinner.setSelection(1);
            }
                if(tipo == NotaItem.Tipo.NORMAL){
                       spinner.setSelection(2);
                }
        btnGuardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });


        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.levels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
//             A    pply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
//    DJHJDSDSDHJSDHJ
}