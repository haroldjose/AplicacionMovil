package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PracticaInicio extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<CheckDia> number;
    AdminSQLiteOpenHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_inicio);

        //flecha para ir hacia atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        conn = new AdminSQLiteOpenHelper(getApplicationContext(),Utilidades.NOMBRE_BD, null,1);
        llenarListaDeDias();
        gridView=(GridView)findViewById(R.id.gridViewPractica);

        MyAdapter adapter=new MyAdapter(this,R.layout.grid_item,number);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                actualizarVisita(position);
                Intent intent=new Intent(PracticaInicio.this,PracticaDiario.class);
                intent.putExtra("1",position);
                // iniciamoa
                startActivity(intent);
            }
        });


    }
    private void actualizarVisita(int position) {
        SQLiteDatabase db = conn.getReadableDatabase();
        int llave = position+1;
        String[] parametros = {llave+""};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_CHECKDIAPRACTICA,"1");

        db.update(Utilidades.TABLA_PRACTICA,values,Utilidades.CAMPO_IDPRACTICA+"=?",parametros);
        db.close();
    }

    private void llenarListaDeDias() {
        SQLiteDatabase db = conn.getReadableDatabase();
        number = new ArrayList<CheckDia>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.TABLA_PRACTICA,null);

        while (cursor.moveToNext()){
            CheckDia dia = new CheckDia();
            dia.setId(cursor.getInt(0));
            dia.setNumeroDia(cursor.getString(1));
            dia.setCheckDia(cursor.getString(2));
            number.add(dia);
        }
    }

    //para que el boton de ir asia atraz del celular no funcione
    @Override
    public void onBackPressed(){

    }
}
