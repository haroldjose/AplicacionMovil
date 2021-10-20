package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarAnotacion extends AppCompatActivity {

    private EditText campoArquero,campoClub,campoRonda;
    private Button btnEditar;
    AdminSQLiteOpenHelper con;
    DatosRonda ronda=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anotacion);
        con= new AdminSQLiteOpenHelper(getApplicationContext(),Utilidades.NOMBRE_BD,null,1);

        campoArquero=(EditText)findViewById(R.id.editarNombreArquero);
        campoClub=(EditText)findViewById(R.id.editarNombreClub);
        campoRonda=(EditText)findViewById(R.id.editarNombreRonda);
        btnEditar=(Button)findViewById(R.id.buttonEditar);

        Bundle objetoEnviado=getIntent().getExtras();

        if(objetoEnviado!=null){
            ronda=(DatosRonda)objetoEnviado.getSerializable("ronda");
            campoArquero.setText(ronda.getNombreArquero());
            campoClub.setText(ronda.getNombreClub());
            campoRonda.setText(ronda.getNombreRonda());
        }
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarUsuario();
                Intent intent=new Intent(EditarAnotacion.this,AnotacionInicio.class);
                Toast.makeText(EditarAnotacion.this,"Cambio Exitoso",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }

    private void editarUsuario() {
        SQLiteDatabase db=con.getWritableDatabase();
        String[] parametro={ronda.getId().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ARQUERO,campoArquero.getText().toString());
        values.put(Utilidades.CAMPO_CLUB,campoClub.getText().toString());
        values.put(Utilidades.CAMPO_RONDA,campoRonda.getText().toString());
        db.update(Utilidades.TABLA_RONDA,values,Utilidades.CAMPO_ID_RONDA +"=?",parametro);
        db.close();
    }


}
