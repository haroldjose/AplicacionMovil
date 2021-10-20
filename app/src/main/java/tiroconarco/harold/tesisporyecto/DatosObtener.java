package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DatosObtener extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private TextInputEditText campoArquero, campoClub, campoRonda;
    private TextInputLayout inputRonda,inputClub,inputArquero;
    private View btncrear;
    private TextView fecha;
    protected ArrayAdapter<CharSequence> adapter;
    int valor, valor2;
    AdminSQLiteOpenHelper con;
    Long idResultanteRonda, idResultanteTablero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_obtener);
        // flecha ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        con = new AdminSQLiteOpenHelper(DatosObtener.this, Utilidades.NOMBRE_BD, null, 1);

        inputRonda = (TextInputLayout) findViewById(R.id.textInputRonda);
        inputClub = (TextInputLayout) findViewById(R.id.textInputClub);
        inputArquero = (TextInputLayout) findViewById(R.id.textInputArquero);

        campoArquero = (TextInputEditText) findViewById(R.id.textArquero);
        campoClub = (TextInputEditText) findViewById(R.id.textClub);
        campoRonda = (TextInputEditText) findViewById(R.id.textRonda);


        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btncrear = (Button) findViewById(R.id.buttonCrear);
        fecha = (TextView) findViewById(R.id.textFechaVer);

        adapter = ArrayAdapter.createFromResource(DatosObtener.this, R.array.Ronda1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.Arco, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valor2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                valor=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //boton crear al siguiente activity
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit_form();
            }

        });


        //mostrar fecha
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int dia = today.monthDay;
        int mes = today.month;
        int año = today.year;
        mes = mes + 1;
        fecha.setText(dia + "" + "/  " + mes + "" + "/ " + año);
    }



    private void crearTablero() {
        //conexion a la base de datos
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID_RONDA, idResultanteRonda);

        try {
            idResultanteTablero = db.insert(Utilidades.TABLA_PUNTAJE, Utilidades.CAMPO_IDPUNTO, values);
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
        }


    }

    private void registrarRonda() {
        //conexion a la base de datos

        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ARQUERO, campoArquero.getText().toString());// mandamos de utilidades el campo y de aqui lo q se relaciona con el editext
        values.put(Utilidades.CAMPO_CLUB, campoClub.getText().toString());
        values.put(Utilidades.CAMPO_RONDA, campoRonda.getText().toString());
        values.put(Utilidades.CAMPO_FECHA, fecha.getText().toString());
        values.put(Utilidades.CAMPO_TIPORONDA, valor);
        values.put(Utilidades.CAMPO_TIPOARCO, valor2);

        try {
            idResultanteRonda = db.insert(Utilidades.TABLA_RONDA, Utilidades.CAMPO_ID_RONDA, values);
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
        }
    }

    public void requestFocus(View view){
        if(view.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validarArquero(){
        if(campoArquero.getText().toString().trim().isEmpty()){
            inputArquero.setError("El campo arquero esta vacio");
            requestFocus(campoArquero);
            return false;
        }else {
            inputArquero.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validarClub(){
        if(campoClub.getText().toString().trim().isEmpty()){
            inputClub.setError("El campo club esta vacio");
            requestFocus(campoClub);
            return false;
        }else {
            inputClub.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validarRonda(){
        if(campoRonda.getText().toString().trim().isEmpty()){
            inputRonda.setError("El campo ronda esta vacio");
            requestFocus(campoRonda);
            return false;
        }else {
            inputRonda.setErrorEnabled(false);
        }
        return true;
    }

    private void submit_form(){
        if (!validarArquero()){
            return;
        }
        if (!validarClub()){
            return;
        }
        if (!validarRonda()){
            return;
        }

        if (valor == 0) {
            Intent intent = new Intent(DatosObtener.this, TableroPuntos.class);
            registrarRonda();
            crearTablero();
            intent.putExtra("idRonda", idResultanteRonda);
            intent.putExtra("idTablero", idResultanteTablero);
            intent.putExtra("deLista", false);
            startActivity(intent);
        } else if (valor == 1) {
            Intent intent = new Intent(DatosObtener.this, TableroPuntos2.class);
            registrarRonda();
            crearTablero();
            intent.putExtra("idRonda", idResultanteRonda);
            intent.putExtra("idTablero", idResultanteTablero);
            intent.putExtra("deLista", false);
            startActivity(intent);
        } else if (valor == 2) {
            Intent intent = new Intent(DatosObtener.this, TableroPuntos3.class);
            registrarRonda();
            crearTablero();
            intent.putExtra("idRonda", idResultanteRonda);
            intent.putExtra("idTablero", idResultanteTablero);
            intent.putExtra("deLista", false);

            startActivity(intent);
        } else if (valor == 3) {
            Intent intent = new Intent(DatosObtener.this, TableroPuntos4.class);
            registrarRonda();
            crearTablero();
            intent.putExtra("idRonda", idResultanteRonda);
            intent.putExtra("idTablero", idResultanteTablero);
            intent.putExtra("deLista", false);
            startActivity(intent);
        }
    }



}
