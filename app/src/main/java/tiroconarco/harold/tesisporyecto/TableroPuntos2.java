package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TableroPuntos2 extends AppCompatActivity {

    private EditText et1_1_1,et1_1_2,et1_1_3,et1_1_4,et1_1_5,et1_1_6,et1_2_1,et1_2_2,et1_2_3,et1_2_4,et1_2_5,et1_2_6,et1_3_1,et1_3_2,et1_3_3,et1_3_4,et1_3_5,et1_3_6,et1_4_1,et1_4_2,et1_4_3,et1_4_4,et1_4_5,et1_4_6,et1_5_1,et1_5_2,et1_5_3,et1_5_4,et1_5_5,et1_5_6,et1_6_1,et1_6_2,et1_6_3,et1_6_4,et1_6_5,et1_6_6,
                     et2_1_1,et2_1_2,et2_1_3,et2_1_4,et2_1_5,et2_1_6,et2_2_1,et2_2_2,et2_2_3,et2_2_4,et2_2_5,et2_2_6,et2_3_1,et2_3_2,et2_3_3,et2_3_4,et2_3_5,et2_3_6,et2_4_1,et2_4_2,et2_4_3,et2_4_4,et2_4_5,et2_4_6,et2_5_1,et2_5_2,et2_5_3,et2_5_4,et2_5_5,et2_5_6,et2_6_1,et2_6_2,et2_6_3,et2_6_4,et2_6_5,et2_6_6;

    private TextView sub1_1,total1_1,sub1_2,total1_2,sub1_3,total1_3,sub1_4,total1_4,sub1_5,total1_5,sub1_6,total1_6,
                     sub2_1,total2_1,sub2_2,total2_2,sub2_3,total2_3,sub2_4,total2_4,sub2_5,total2_5,sub2_6,total2_6;

    AdminSQLiteOpenHelper con;
    Long idTablero, idRonda;
    boolean deLista;

    private Template3PDF template3PDF;
    private String[]header={"n°","1","2","3","4","5","6","subtotal","total"};
    private String shortText="nombre ronda:   ";
    private String longText="nombre del club:   ";
    String ronda,club,fecha,nombreArquero,tipoArco, arco;
    int idPunto;
    MyKeyboard keyboard;
    String v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,
            v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,v35,v36,v37,v38,v39,v40,
            v41,v42,v43,v44,v45,v46,v47,v48,v49,v50,v51,v52,v53,v54,v55,v56,v57,v58,v59,v60,
            v61,v62,v63,v64,v65,v66,v67,v68,v69,v70,v71,v72,
            s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,
            t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    int cantidadDisparos=72;
    int disparos=0;
    int puntaje=0;
    int acierto=0;
    int media=0;
    int uno=0;
    int dos=0;
    int tres=0;
    int cuatro=0;
    int cinco=0;
    int x=0;
    int seis=0;
    int siete=0;
    int ocho=0;
    int nueve=0;
    int diez=0;
    int m=0;
    int ronda1=0;
    int ronda2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero_puntos2);

        // flecha ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        con= new AdminSQLiteOpenHelper(getApplicationContext(),Utilidades.NOMBRE_BD,null,1);
        idTablero = getIntent().getLongExtra("idTablero",100);
        idRonda = getIntent().getLongExtra("idRonda",100);
        deLista = getIntent().getBooleanExtra("deLista",false);

        aniadirAccionesEInstancias();
        habilitarTeclado();
        if(deLista) {
            consultarPuntos();
            consultar();
        }
    }

    private void habilitarTeclado() {

        primeroRonda();
        segundaRonda();
    }

    private void primeroRonda() {
        et1_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_1_1=et1_1_1.onCreateInputConnection(new EditorInfo());
                    et1_1_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1_1);
                }
            }
        });
        et1_1_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_1_2=et1_1_2.onCreateInputConnection(new EditorInfo());
                    et1_1_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1_2);
                }
            }
        });
        et1_1_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_1_3=et1_1_3.onCreateInputConnection(new EditorInfo());
                    et1_1_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1_3);
                }
            }
        });
        et1_1_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_1_4=et1_1_4.onCreateInputConnection(new EditorInfo());
                    et1_1_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1_4);
                }
            }
        });
        et1_1_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_1_5=et1_1_5.onCreateInputConnection(new EditorInfo());
                    et1_1_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1_5);
                }
            }
        });
        et1_1_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_1_6=et1_1_6.onCreateInputConnection(new EditorInfo());
                    et1_1_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1_6);
                }
            }
        });


        et1_2_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_2_1=et1_2_1.onCreateInputConnection(new EditorInfo());
                    et1_2_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2_1);
                }
            }
        });
        et1_2_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_2_2=et1_2_2.onCreateInputConnection(new EditorInfo());
                    et1_2_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2_2);
                }
            }
        });
        et1_2_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_2_3=et1_2_3.onCreateInputConnection(new EditorInfo());
                    et1_2_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2_3);
                }
            }
        });
        et1_2_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_2_4=et1_2_4.onCreateInputConnection(new EditorInfo());
                    et1_2_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2_4);
                }
            }
        });
        et1_2_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_2_5=et1_2_5.onCreateInputConnection(new EditorInfo());
                    et1_2_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2_5);
                }
            }
        });
        et1_2_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_2_6=et1_2_6.onCreateInputConnection(new EditorInfo());
                    et1_2_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2_6);
                }
            }
        });

        et1_3_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_3_1=et1_3_1.onCreateInputConnection(new EditorInfo());
                    et1_3_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3_1);
                }
            }
        });
        et1_3_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_3_2=et1_3_2.onCreateInputConnection(new EditorInfo());
                    et1_3_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3_2);
                }
            }
        });
        et1_3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_3_3=et1_3_3.onCreateInputConnection(new EditorInfo());
                    et1_3_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3_3);
                }
            }
        });
        et1_3_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_3_4=et1_3_4.onCreateInputConnection(new EditorInfo());
                    et1_3_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3_4);
                }
            }
        });
        et1_3_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_3_5=et1_3_5.onCreateInputConnection(new EditorInfo());
                    et1_3_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3_5);
                }
            }
        });
        et1_3_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_3_6=et1_3_6.onCreateInputConnection(new EditorInfo());
                    et1_3_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3_6);
                }
            }
        });


        et1_4_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_4_1=et1_4_1.onCreateInputConnection(new EditorInfo());
                    et1_4_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4_1);
                }
            }
        });
        et1_4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_4_2=et1_4_2.onCreateInputConnection(new EditorInfo());
                    et1_4_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4_2);
                }
            }
        });
        et1_4_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_4_3=et1_4_3.onCreateInputConnection(new EditorInfo());
                    et1_4_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4_3);
                }
            }
        });
        et1_4_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_4_4=et1_4_4.onCreateInputConnection(new EditorInfo());
                    et1_4_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4_4);
                }
            }
        });
        et1_4_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_4_5=et1_4_5.onCreateInputConnection(new EditorInfo());
                    et1_4_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4_5);
                }
            }
        });
        et1_4_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_4_6=et1_4_6.onCreateInputConnection(new EditorInfo());
                    et1_4_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4_6);
                }
            }
        });

        et1_5_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_5_1=et1_5_1.onCreateInputConnection(new EditorInfo());
                    et1_5_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5_1);
                }
            }
        });
        et1_5_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_5_2=et1_5_2.onCreateInputConnection(new EditorInfo());
                    et1_5_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5_2);
                }
            }
        });
        et1_5_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_5_3=et1_5_3.onCreateInputConnection(new EditorInfo());
                    et1_5_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5_3);
                }
            }
        });
        et1_5_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_5_4=et1_5_4.onCreateInputConnection(new EditorInfo());
                    et1_5_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5_4);
                }
            }
        });
        et1_5_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_5_5=et1_5_5.onCreateInputConnection(new EditorInfo());
                    et1_5_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5_5);
                }
            }
        });
        et1_5_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_5_6=et1_5_6.onCreateInputConnection(new EditorInfo());
                    et1_5_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5_6);
                }
            }
        });

        et1_6_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_6_1=et1_6_1.onCreateInputConnection(new EditorInfo());
                    et1_6_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6_1);
                }
            }
        });
        et1_6_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_6_2=et1_6_2.onCreateInputConnection(new EditorInfo());
                    et1_6_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6_2);
                }
            }
        });
        et1_6_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_6_3=et1_6_3.onCreateInputConnection(new EditorInfo());
                    et1_6_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6_3);
                }
            }
        });
        et1_6_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_6_4=et1_6_4.onCreateInputConnection(new EditorInfo());
                    et1_6_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6_4);
                }
            }
        });
        et1_6_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_6_5=et1_6_5.onCreateInputConnection(new EditorInfo());
                    et1_6_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6_5);
                }
            }
        });
        et1_6_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_6_6=et1_6_6.onCreateInputConnection(new EditorInfo());
                    et1_6_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6_6);
                }
            }
        });

    }
    private void segundaRonda() {
        et2_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_1_1=et2_1_1.onCreateInputConnection(new EditorInfo());
                    et2_1_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1_1);
                }
            }
        });
        et2_1_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_1_2=et2_1_2.onCreateInputConnection(new EditorInfo());
                    et2_1_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1_2);
                }
            }
        });
        et2_1_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_1_3=et2_1_3.onCreateInputConnection(new EditorInfo());
                    et2_1_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1_3);
                }
            }
        });
        et2_1_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_1_4=et2_1_4.onCreateInputConnection(new EditorInfo());
                    et2_1_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1_4);
                }
            }
        });
        et2_1_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_1_5=et2_1_5.onCreateInputConnection(new EditorInfo());
                    et2_1_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1_5);
                }
            }
        });
        et2_1_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_1_6=et2_1_6.onCreateInputConnection(new EditorInfo());
                    et2_1_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1_6);
                }
            }
        });


        et2_2_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_2_1=et2_2_1.onCreateInputConnection(new EditorInfo());
                    et2_2_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2_1);
                }
            }
        });
        et2_2_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_2_2=et2_2_2.onCreateInputConnection(new EditorInfo());
                    et2_2_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2_2);
                }
            }
        });
        et2_2_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_2_3=et2_2_3.onCreateInputConnection(new EditorInfo());
                    et2_2_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2_3);
                }
            }
        });
        et2_2_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_2_4=et2_2_4.onCreateInputConnection(new EditorInfo());
                    et2_2_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2_4);
                }
            }
        });
        et2_2_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_2_5=et2_2_5.onCreateInputConnection(new EditorInfo());
                    et2_2_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2_5);
                }
            }
        });
        et2_2_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_2_6=et2_2_6.onCreateInputConnection(new EditorInfo());
                    et2_2_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2_6);
                }
            }
        });

        et2_3_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_3_1=et2_3_1.onCreateInputConnection(new EditorInfo());
                    et2_3_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3_1);
                }
            }
        });
        et2_3_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_3_2=et2_3_2.onCreateInputConnection(new EditorInfo());
                    et2_3_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3_2);
                }
            }
        });
        et2_3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_3_3=et2_3_3.onCreateInputConnection(new EditorInfo());
                    et2_3_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3_3);
                }
            }
        });
        et2_3_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_3_4=et2_3_4.onCreateInputConnection(new EditorInfo());
                    et2_3_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3_4);
                }
            }
        });
        et2_3_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_3_5=et2_3_5.onCreateInputConnection(new EditorInfo());
                    et2_3_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3_5);
                }
            }
        });
        et2_3_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_3_6=et2_3_6.onCreateInputConnection(new EditorInfo());
                    et2_3_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3_6);
                }
            }
        });

        et2_4_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_4_1=et2_4_1.onCreateInputConnection(new EditorInfo());
                    et2_4_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4_1);
                }
            }
        });
        et2_4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_4_2=et2_4_2.onCreateInputConnection(new EditorInfo());
                    et2_4_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4_2);
                }
            }
        });
        et2_4_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_4_3=et2_4_3.onCreateInputConnection(new EditorInfo());
                    et2_4_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4_3);
                }
            }
        });
        et2_4_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_4_4=et2_4_4.onCreateInputConnection(new EditorInfo());
                    et2_4_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4_4);
                }
            }
        });
        et2_4_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_4_5=et2_4_5.onCreateInputConnection(new EditorInfo());
                    et2_4_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4_5);
                }
            }
        });
        et2_4_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_4_6=et2_4_6.onCreateInputConnection(new EditorInfo());
                    et2_4_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4_6);
                }
            }
        });

        et2_5_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_5_1=et2_5_1.onCreateInputConnection(new EditorInfo());
                    et2_5_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5_1);
                }
            }
        });
        et2_5_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_5_2=et2_5_2.onCreateInputConnection(new EditorInfo());
                    et2_5_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5_2);
                }
            }
        });
        et2_5_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_5_3=et2_5_3.onCreateInputConnection(new EditorInfo());
                    et2_5_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5_3);
                }
            }
        });
        et2_5_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_5_4=et2_5_4.onCreateInputConnection(new EditorInfo());
                    et2_5_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5_4);
                }
            }
        });
        et2_5_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_5_5=et2_5_5.onCreateInputConnection(new EditorInfo());
                    et2_5_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5_5);
                }
            }
        });
        et2_5_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_5_6=et2_5_6.onCreateInputConnection(new EditorInfo());
                    et2_5_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5_6);
                }
            }
        });

        et2_6_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_6_1=et2_6_1.onCreateInputConnection(new EditorInfo());
                    et2_6_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6_1);
                }
            }
        });
        et2_6_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_6_2=et2_6_2.onCreateInputConnection(new EditorInfo());
                    et2_6_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6_2);
                }
            }
        });
        et2_6_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_6_3=et2_6_3.onCreateInputConnection(new EditorInfo());
                    et2_6_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6_3);
                }
            }
        });
        et2_6_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_6_4=et2_6_4.onCreateInputConnection(new EditorInfo());
                    et2_6_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6_4);
                }
            }
        });
        et2_6_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_6_5=et2_6_5.onCreateInputConnection(new EditorInfo());
                    et2_6_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6_5);
                }
            }
        });
        et2_6_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_6_6=et2_6_6.onCreateInputConnection(new EditorInfo());
                    et2_6_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6_6);
                }
            }
        });
    }

    private void consultar() {
        SQLiteDatabase db=con.getReadableDatabase();
        String[] parametros = {idRonda.toString()};
        String[] campos={Utilidades.CAMPO_ARQUERO,Utilidades.CAMPO_CLUB,Utilidades.CAMPO_RONDA,Utilidades.CAMPO_FECHA,Utilidades.CAMPO_TIPOARCO};
        try {
            Cursor cursor=db.query(Utilidades.TABLA_RONDA,campos,Utilidades.CAMPO_ID_RONDA+ " =? ", parametros,null,null,null);
            cursor.moveToFirst();
            nombreArquero=cursor.getString(0);
            club=cursor.getString(1);
            ronda=cursor.getString(2);
            fecha=cursor.getString(3);
            arco=cursor.getString(4);
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
        }
    }

    private void consultarPuntos() {
        SQLiteDatabase db= con.getReadableDatabase();
        String[] parametros ={idTablero.toString()};
        String[] otro={Utilidades.CAMPO_IDPUNTO,
                Utilidades.CAMPO_N1,Utilidades.CAMPO_N2,Utilidades.CAMPO_N3,Utilidades.CAMPO_N4,Utilidades.CAMPO_N5,Utilidades.CAMPO_N6,Utilidades.CAMPO_N7,Utilidades.CAMPO_N8,Utilidades.CAMPO_N9,Utilidades.CAMPO_N10
                ,Utilidades.CAMPO_N11,Utilidades.CAMPO_N12,Utilidades.CAMPO_N13,Utilidades.CAMPO_N14,Utilidades.CAMPO_N15,Utilidades.CAMPO_N16,Utilidades.CAMPO_N17,Utilidades.CAMPO_N18,Utilidades.CAMPO_N19,Utilidades.CAMPO_N20
                ,Utilidades.CAMPO_N21,Utilidades.CAMPO_N22,Utilidades.CAMPO_N23,Utilidades.CAMPO_N24,Utilidades.CAMPO_N25,Utilidades.CAMPO_N26,Utilidades.CAMPO_N27,Utilidades.CAMPO_N28,Utilidades.CAMPO_N29,Utilidades.CAMPO_N30
                ,Utilidades.CAMPO_N31,Utilidades.CAMPO_N32,Utilidades.CAMPO_N33,Utilidades.CAMPO_N34,Utilidades.CAMPO_N35,Utilidades.CAMPO_N36,Utilidades.CAMPO_N37,Utilidades.CAMPO_N38,Utilidades.CAMPO_N39,Utilidades.CAMPO_N40
                ,Utilidades.CAMPO_N41,Utilidades.CAMPO_N42,Utilidades.CAMPO_N43,Utilidades.CAMPO_N44,Utilidades.CAMPO_N45,Utilidades.CAMPO_N46,Utilidades.CAMPO_N47,Utilidades.CAMPO_N48,Utilidades.CAMPO_N49,Utilidades.CAMPO_N50
                ,Utilidades.CAMPO_N51,Utilidades.CAMPO_N52,Utilidades.CAMPO_N53,Utilidades.CAMPO_N54,Utilidades.CAMPO_N55,Utilidades.CAMPO_N56,Utilidades.CAMPO_N57,Utilidades.CAMPO_N58,Utilidades.CAMPO_N59,Utilidades.CAMPO_N60
                ,Utilidades.CAMPO_N61,Utilidades.CAMPO_N62,Utilidades.CAMPO_N63,Utilidades.CAMPO_N64,Utilidades.CAMPO_N65,Utilidades.CAMPO_N66,Utilidades.CAMPO_N67,Utilidades.CAMPO_N68,Utilidades.CAMPO_N69,Utilidades.CAMPO_N70
                ,Utilidades.CAMPO_N71,Utilidades.CAMPO_N72

                ,Utilidades.CAMPO_S1,Utilidades.CAMPO_S2,Utilidades.CAMPO_S3,Utilidades.CAMPO_S4,Utilidades.CAMPO_S5,Utilidades.CAMPO_S6,Utilidades.CAMPO_S7,Utilidades.CAMPO_S8,Utilidades.CAMPO_S9,Utilidades.CAMPO_S10
                ,Utilidades.CAMPO_S11,Utilidades.CAMPO_S12

                ,Utilidades.CAMPO_T1,Utilidades.CAMPO_T2,Utilidades.CAMPO_T3,Utilidades.CAMPO_T4,Utilidades.CAMPO_T5,Utilidades.CAMPO_T6,Utilidades.CAMPO_T7,Utilidades.CAMPO_T8,Utilidades.CAMPO_T9,Utilidades.CAMPO_T10
                ,Utilidades.CAMPO_T11,Utilidades.CAMPO_T12};
        try {
            Cursor cursor=db.query(Utilidades.TABLA_PUNTAJE,otro,Utilidades.CAMPO_IDPUNTO+ " =?",parametros,null,null,null);
            cursor.moveToFirst();
            idPunto=cursor.getInt(0);
            v1=cursor.getString(1);
            v2=cursor.getString(2);
            v3=cursor.getString(3);
            v4=cursor.getString(4);
            v5=cursor.getString(5);
            v6=cursor.getString(6);
            v7=cursor.getString(7);
            v8=cursor.getString(8);
            v9=cursor.getString(9);
            v10=cursor.getString(10);
            v11=cursor.getString(11);
            v12=cursor.getString(12);
            v13=cursor.getString(13);
            v14=cursor.getString(14);
            v15=cursor.getString(15);
            v16=cursor.getString(16);
            v17=cursor.getString(17);
            v18=cursor.getString(18);
            v19=cursor.getString(19);
            v20=cursor.getString(20);
            v21=cursor.getString(21);
            v22=cursor.getString(22);
            v23=cursor.getString(23);
            v24=cursor.getString(24);
            v25=cursor.getString(25);
            v26=cursor.getString(26);
            v27=cursor.getString(27);
            v28=cursor.getString(28);
            v29=cursor.getString(29);
            v30=cursor.getString(30);
            v31=cursor.getString(31);
            v32=cursor.getString(32);
            v33=cursor.getString(33);
            v34=cursor.getString(34);
            v35=cursor.getString(35);
            v36=cursor.getString(36);
            v37=cursor.getString(37);
            v38=cursor.getString(38);
            v39=cursor.getString(39);
            v40=cursor.getString(40);
            v41=cursor.getString(41);
            v42=cursor.getString(42);
            v43=cursor.getString(43);
            v44=cursor.getString(44);
            v45=cursor.getString(45);
            v46=cursor.getString(46);
            v47=cursor.getString(47);
            v48=cursor.getString(48);
            v49=cursor.getString(49);
            v50=cursor.getString(50);
            v51=cursor.getString(51);
            v52=cursor.getString(52);
            v53=cursor.getString(53);
            v54=cursor.getString(54);
            v55=cursor.getString(55);
            v56=cursor.getString(56);
            v57=cursor.getString(57);
            v58=cursor.getString(58);
            v59=cursor.getString(59);
            v60=cursor.getString(60);
            v61=cursor.getString(61);
            v62=cursor.getString(62);
            v63=cursor.getString(63);
            v64=cursor.getString(64);
            v65=cursor.getString(65);
            v66=cursor.getString(66);
            v67=cursor.getString(67);
            v68=cursor.getString(68);
            v69=cursor.getString(69);
            v70=cursor.getString(70);
            v71=cursor.getString(71);
            v72=cursor.getString(72);
            s1=cursor.getString(73);
            s2=cursor.getString(74);
            s3=cursor.getString(75);
            s4=cursor.getString(76);
            s5=cursor.getString(77);
            s6=cursor.getString(78);
            s7=cursor.getString(79);
            s8=cursor.getString(80);
            s9=cursor.getString(81);
            s10=cursor.getString(82);
            s11=cursor.getString(83);
            s12=cursor.getString(84);

            t1=cursor.getString(85);
            t2=cursor.getString(86);
            t3=cursor.getString(87);
            t4=cursor.getString(88);
            t5=cursor.getString(89);
            t6=cursor.getString(90);
            t7=cursor.getString(91);
            t8=cursor.getString(91);
            t9=cursor.getString(93);
            t10=cursor.getString(94);
            t11=cursor.getString(95);
            t12=cursor.getString(96);

            db.close();
            cursor.close();
            if(deLista){
                llenarTablero();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            Log.e("posible error",e.getMessage());
        }
    }

    private void llenarTablero() {
        et1_1_1.setText(v1);
        et1_1_2.setText(v2);
        et1_1_3.setText(v3);
        et1_1_4.setText(v4);
        et1_1_5.setText(v5);
        et1_1_6.setText(v6);
        et1_2_1.setText(v7);
        et1_2_2.setText(v8);
        et1_2_3.setText(v9);
        et1_2_4.setText(v10);
        et1_2_5.setText(v11);
        et1_2_6.setText(v12);
        et1_3_1.setText(v13);
        et1_3_2.setText(v14);
        et1_3_3.setText(v15);
        et1_3_4.setText(v16);
        et1_3_5.setText(v17);
        et1_3_6.setText(v18);
        et1_4_1.setText(v19);
        et1_4_2.setText(v20);
        et1_4_3.setText(v21);
        et1_4_4.setText(v22);
        et1_4_5.setText(v23);
        et1_4_6.setText(v24);
        et1_5_1.setText(v25);
        et1_5_2.setText(v26);
        et1_5_3.setText(v27);
        et1_5_4.setText(v28);
        et1_5_5.setText(v29);
        et1_5_6.setText(v30);
        et1_6_1.setText(v31);
        et1_6_2.setText(v32);
        et1_6_3.setText(v33);
        et1_6_4.setText(v34);
        et1_6_5.setText(v35);
        et1_6_6.setText(v36);

        et2_1_1.setText(v37);
        et2_1_2.setText(v38);
        et2_1_3.setText(v39);
        et2_1_4.setText(v40);
        et2_1_5.setText(v41);
        et2_1_6.setText(v42);
        et2_2_1.setText(v43);
        et2_2_2.setText(v44);
        et2_2_3.setText(v45);
        et2_2_4.setText(v46);
        et2_2_5.setText(v47);
        et2_2_6.setText(v48);
        et2_3_1.setText(v49);
        et2_3_2.setText(v50);
        et2_3_3.setText(v51);
        et2_3_4.setText(v52);
        et2_3_5.setText(v53);
        et2_3_6.setText(v54);
        et2_4_1.setText(v55);
        et2_4_2.setText(v56);
        et2_4_3.setText(v57);
        et2_4_4.setText(v58);
        et2_4_5.setText(v59);
        et2_4_6.setText(v60);
        et2_5_1.setText(v61);
        et2_5_2.setText(v62);
        et2_5_3.setText(v63);
        et2_5_4.setText(v64);
        et2_5_5.setText(v65);
        et2_5_6.setText(v66);
        et2_6_1.setText(v67);
        et2_6_2.setText(v68);
        et2_6_3.setText(v69);
        et2_6_4.setText(v70);
        et2_6_5.setText(v71);
        et2_6_6.setText(v72);

        sub1_1.setText(s1);
        total1_1.setText(t1);
        sub1_2.setText(s2);
        total1_2.setText(t2);
        sub1_3.setText(s3);
        total1_3.setText(t3);
        sub1_4.setText(s4);
        total1_4.setText(t4);
        sub1_5.setText(s5);
        total1_5.setText(t5);
        sub1_6.setText(s6);
        total1_6.setText(t6);

        sub2_1.setText(s7);
        total2_1.setText(t7);
        sub2_2.setText(s8);
        total2_2.setText(t8);
        sub2_3.setText(s9);
        total2_3.setText(t9);
        sub2_4.setText(s10);
        total2_4.setText(t10);
        sub2_5.setText(s11);
        total2_5.setText(t11);
        sub2_6.setText(s12);
        total2_6.setText(t12);
    }

    private void aniadirAccionesEInstancias() {
        keyboard=(MyKeyboard) findViewById(R.id.keyboard);
        et1_1_1=(EditText) findViewById(R.id.editText1_1);
        et1_1_2=(EditText) findViewById(R.id.editText1_2);
        et1_1_3=(EditText) findViewById(R.id.editText1_3);
        et1_1_4=(EditText) findViewById(R.id.editText1_4);
        et1_1_5=(EditText) findViewById(R.id.editText1_5);
        et1_1_6=(EditText) findViewById(R.id.editText1_6);
        sub1_1=(TextView) findViewById(R.id.textViewSubTotal1);
        total1_1=(TextView) findViewById(R.id.textViewTotal1);

        et1_1_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_1_1));
        et1_1_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_1_2));
        et1_1_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_1_3));
        et1_1_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_1_4));
        et1_1_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_1_5));
        et1_1_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_1_6));

        et1_2_1=(EditText) findViewById(R.id.editText2_1);
        et1_2_2=(EditText) findViewById(R.id.editText2_2);
        et1_2_3=(EditText) findViewById(R.id.editText2_3);
        et1_2_4=(EditText) findViewById(R.id.editText2_4);
        et1_2_5=(EditText) findViewById(R.id.editText2_5);
        et1_2_6=(EditText) findViewById(R.id.editText2_6);
        sub1_2=(TextView) findViewById(R.id.textViewSubTotal2);
        total1_2=(TextView) findViewById(R.id.textViewTotal2);

        et1_2_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_2_1));
        et1_2_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_2_2));
        et1_2_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_2_3));
        et1_2_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_2_4));
        et1_2_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_2_5));
        et1_2_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_2_6));

        et1_3_1=(EditText) findViewById(R.id.editText3_1);
        et1_3_2=(EditText) findViewById(R.id.editText3_2);
        et1_3_3=(EditText) findViewById(R.id.editText3_3);
        et1_3_4=(EditText) findViewById(R.id.editText3_4);
        et1_3_5=(EditText) findViewById(R.id.editText3_5);
        et1_3_6=(EditText) findViewById(R.id.editText3_6);
        sub1_3=(TextView) findViewById(R.id.textViewSubTotal3);
        total1_3=(TextView) findViewById(R.id.textViewTotal3);

        et1_3_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_3_1));
        et1_3_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_3_2));
        et1_3_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_3_3));
        et1_3_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_3_4));
        et1_3_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_3_5));
        et1_3_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_3_6));

        et1_4_1=(EditText) findViewById(R.id.editText4_1);
        et1_4_2=(EditText) findViewById(R.id.editText4_2);
        et1_4_3=(EditText) findViewById(R.id.editText4_3);
        et1_4_4=(EditText) findViewById(R.id.editText4_4);
        et1_4_5=(EditText) findViewById(R.id.editText4_5);
        et1_4_6=(EditText) findViewById(R.id.editText4_6);
        sub1_4=(TextView) findViewById(R.id.textViewSubTotal4);
        total1_4=(TextView) findViewById(R.id.textViewTotal4);

        et1_4_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_4_1));
        et1_4_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_4_2));
        et1_4_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_4_3));
        et1_4_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_4_4));
        et1_4_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_4_5));
        et1_4_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_4_6));

        et1_5_1=(EditText) findViewById(R.id.editText5_1);
        et1_5_2=(EditText) findViewById(R.id.editText5_2);
        et1_5_3=(EditText) findViewById(R.id.editText5_3);
        et1_5_4=(EditText) findViewById(R.id.editText5_4);
        et1_5_5=(EditText) findViewById(R.id.editText5_5);
        et1_5_6=(EditText) findViewById(R.id.editText5_6);
        sub1_5=(TextView) findViewById(R.id.textViewSubTotal5);
        total1_5=(TextView) findViewById(R.id.textViewTotal5);

        et1_5_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_5_1));
        et1_5_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_5_2));
        et1_5_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_5_3));
        et1_5_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_5_4));
        et1_5_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_5_5));
        et1_5_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_5_6));

        et1_6_1=(EditText) findViewById(R.id.editText6_1);
        et1_6_2=(EditText) findViewById(R.id.editText6_2);
        et1_6_3=(EditText) findViewById(R.id.editText6_3);
        et1_6_4=(EditText) findViewById(R.id.editText6_4);
        et1_6_5=(EditText) findViewById(R.id.editText6_5);
        et1_6_6=(EditText) findViewById(R.id.editText6_6);
        sub1_6=(TextView) findViewById(R.id.textViewSubTotal6);
        total1_6=(TextView) findViewById(R.id.textViewTotal6);

        et1_6_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_6_1));
        et1_6_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_6_2));
        et1_6_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_6_3));
        et1_6_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_6_4));
        et1_6_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_6_5));
        et1_6_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et1_6_6));

        et2_1_1=(EditText) findViewById(R.id.editText2_1_1);
        et2_1_2=(EditText) findViewById(R.id.editText2_1_2);
        et2_1_3=(EditText) findViewById(R.id.editText2_1_3);
        et2_1_4=(EditText) findViewById(R.id.editText2_1_4);
        et2_1_5=(EditText) findViewById(R.id.editText2_1_5);
        et2_1_6=(EditText) findViewById(R.id.editText2_1_6);
        sub2_1=(TextView) findViewById(R.id.textViewSubTotal2_1);
        total2_1=(TextView) findViewById(R.id.textViewTotal2_1);

        et2_1_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_1_1));
        et2_1_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_1_2));
        et2_1_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_1_3));
        et2_1_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_1_4));
        et2_1_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_1_5));
        et2_1_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_1_6));

        et2_2_1=(EditText) findViewById(R.id.editText2_2_1);
        et2_2_2=(EditText) findViewById(R.id.editText2_2_2);
        et2_2_3=(EditText) findViewById(R.id.editText2_2_3);
        et2_2_4=(EditText) findViewById(R.id.editText2_2_4);
        et2_2_5=(EditText) findViewById(R.id.editText2_2_5);
        et2_2_6=(EditText) findViewById(R.id.editText2_2_6);
        sub2_2=(TextView) findViewById(R.id.textViewSubTotal2_2);
        total2_2=(TextView) findViewById(R.id.textViewTotal2_2);

        et2_2_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_2_1));
        et2_2_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_2_2));
        et2_2_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_2_3));
        et2_2_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_2_4));
        et2_2_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_2_5));
        et2_2_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_2_6));

        et2_3_1=(EditText) findViewById(R.id.editText2_3_1);
        et2_3_2=(EditText) findViewById(R.id.editText2_3_2);
        et2_3_3=(EditText) findViewById(R.id.editText2_3_3);
        et2_3_4=(EditText) findViewById(R.id.editText2_3_4);
        et2_3_5=(EditText) findViewById(R.id.editText2_3_5);
        et2_3_6=(EditText) findViewById(R.id.editText2_3_6);
        sub2_3=(TextView) findViewById(R.id.textViewSubTotal2_3);
        total2_3=(TextView) findViewById(R.id.textViewTotal2_3);

        et2_3_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_3_1));
        et2_3_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_3_2));
        et2_3_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_3_3));
        et2_3_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_3_4));
        et2_3_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_3_5));
        et2_3_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_3_6));

        et2_4_1=(EditText) findViewById(R.id.editText2_4_1);
        et2_4_2=(EditText) findViewById(R.id.editText2_4_2);
        et2_4_3=(EditText) findViewById(R.id.editText2_4_3);
        et2_4_4=(EditText) findViewById(R.id.editText2_4_4);
        et2_4_5=(EditText) findViewById(R.id.editText2_4_5);
        et2_4_6=(EditText) findViewById(R.id.editText2_4_6);
        sub2_4=(TextView) findViewById(R.id.textViewSubTotal2_4);
        total2_4=(TextView) findViewById(R.id.textViewTotal2_4);

        et2_4_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_4_1));
        et2_4_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_4_2));
        et2_4_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_4_3));
        et2_4_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_4_4));
        et2_4_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_4_5));
        et2_4_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_4_6));

        et2_5_1=(EditText) findViewById(R.id.editText2_5_1);
        et2_5_2=(EditText) findViewById(R.id.editText2_5_2);
        et2_5_3=(EditText) findViewById(R.id.editText2_5_3);
        et2_5_4=(EditText) findViewById(R.id.editText2_5_4);
        et2_5_5=(EditText) findViewById(R.id.editText2_5_5);
        et2_5_6=(EditText) findViewById(R.id.editText2_5_6);
        sub2_5=(TextView) findViewById(R.id.textViewSubTotal2_5);
        total2_5=(TextView) findViewById(R.id.textViewTotal2_5);

        et2_5_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_5_1));
        et2_5_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_5_2));
        et2_5_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_5_3));
        et2_5_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_5_4));
        et2_5_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_5_5));
        et2_5_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_5_6));

        et2_6_1=(EditText) findViewById(R.id.editText2_6_1);
        et2_6_2=(EditText) findViewById(R.id.editText2_6_2);
        et2_6_3=(EditText) findViewById(R.id.editText2_6_3);
        et2_6_4=(EditText) findViewById(R.id.editText2_6_4);
        et2_6_5=(EditText) findViewById(R.id.editText2_6_5);
        et2_6_6=(EditText) findViewById(R.id.editText2_6_6);
        sub2_6=(TextView) findViewById(R.id.textViewSubTotal2_6);
        total2_6=(TextView) findViewById(R.id.textViewTotal2_6);

        et2_6_1.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_6_1));
        et2_6_2.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_6_2));
        et2_6_3.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_6_3));
        et2_6_4.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_6_4));
        et2_6_5.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_6_5));
        et2_6_6.addTextChangedListener(new TableroPuntos2.GenericTextWatcher(et2_6_6));
    }


    private class GenericTextWatcher implements TextWatcher{
        private View view;
        private GenericTextWatcher(View view){
            this.view=view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){
                case  R.id.editText1_1:
                case  R.id.editText1_2:
                case  R.id.editText1_3:
                case  R.id.editText1_4:
                case  R.id.editText1_5:
                case  R.id.editText1_6:
                    operacionFilaUno();
                    guardarDatos();
                    break;
                case R.id.editText2_1:
                case R.id.editText2_2:
                case R.id.editText2_3:
                case R.id.editText2_4:
                case R.id.editText2_5:
                case R.id.editText2_6:
                    operacionFilaDos();
                    guardarDatos();
                    break;
                case R.id.editText3_1:
                case R.id.editText3_2:
                case R.id.editText3_3:
                case R.id.editText3_4:
                case R.id.editText3_5:
                case R.id.editText3_6:
                    operacionFilaTres();
                    guardarDatos();
                    break;
                case R.id.editText4_1:
                case R.id.editText4_2:
                case R.id.editText4_3:
                case R.id.editText4_4:
                case R.id.editText4_5:
                case R.id.editText4_6:
                    operacionFilaCuatro();
                    guardarDatos();
                    break;
                case R.id.editText5_1:
                case R.id.editText5_2:
                case R.id.editText5_3:
                case R.id.editText5_4:
                case R.id.editText5_5:
                case R.id.editText5_6:
                    operacionFilaCinco();
                    guardarDatos();
                    break;
                case R.id.editText6_1:
                case R.id.editText6_2:
                case R.id.editText6_3:
                case R.id.editText6_4:
                case R.id.editText6_5:
                case R.id.editText6_6:
                    operacionFilaSeis();
                    guardarDatos();
                    break;
                case R.id.editText2_1_1:
                case R.id.editText2_1_2:
                case R.id.editText2_1_3:
                case R.id.editText2_1_4:
                case R.id.editText2_1_5:
                case R.id.editText2_1_6:
                    operacionFilaSiete();
                    guardarDatos();
                    break;
                case R.id.editText2_2_1:
                case R.id.editText2_2_2:
                case R.id.editText2_2_3:
                case R.id.editText2_2_4:
                case R.id.editText2_2_5:
                case R.id.editText2_2_6:
                    operacionFilaOcho();
                    guardarDatos();
                    break;
                case R.id.editText2_3_1:
                case R.id.editText2_3_2:
                case R.id.editText2_3_3:
                case R.id.editText2_3_4:
                case R.id.editText2_3_5:
                case R.id.editText2_3_6:
                    operacionFilaNueve();
                    guardarDatos();
                    break;
                case R.id.editText2_4_1:
                case R.id.editText2_4_2:
                case R.id.editText2_4_3:
                case R.id.editText2_4_4:
                case R.id.editText2_4_5:
                case R.id.editText2_4_6:
                    operacionFilaDiez();
                    guardarDatos();
                    break;
                case R.id.editText2_5_1:
                case R.id.editText2_5_2:
                case R.id.editText2_5_3:
                case R.id.editText2_5_4:
                case R.id.editText2_5_5:
                case R.id.editText2_5_6:
                    operacionFilaOnce();
                    guardarDatos();
                    break;
                case R.id.editText2_6_1:
                case R.id.editText2_6_2:
                case R.id.editText2_6_3:
                case R.id.editText2_6_4:
                case R.id.editText2_6_5:
                case R.id.editText2_6_6:
                    operacionFilaDoce();
                    guardarDatos();
                    break;

            }

        }
    }

    private void operacionFilaUno() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_1_1.getText().toString();
        String dos = et1_1_2.getText().toString();
        String tres = et1_1_3.getText().toString();
        String cuatro = et1_1_4.getText().toString();
        String cinco = et1_1_5.getText().toString();
        String seis = et1_1_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        int subTotal = filaResultado(fila);
        sub1_1.setText(subTotal+"");
        total1_1.setText(subTotal+"");
        operacionFilaDos();
    }

    private void operacionFilaDos() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_2_1.getText().toString();
        String dos = et1_2_2.getText().toString();
        String tres = et1_2_3.getText().toString();
        String cuatro = et1_2_4.getText().toString();
        String cinco = et1_2_5.getText().toString();
        String seis = et1_2_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_2.setText("");
            total1_2.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub1_2.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total1_1.getText().toString());
            total1_2.setText(total+"");
        }
        operacionFilaTres();
    }

    private void operacionFilaTres() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_3_1.getText().toString();
        String dos = et1_3_2.getText().toString();
        String tres = et1_3_3.getText().toString();
        String cuatro = et1_3_4.getText().toString();
        String cinco = et1_3_5.getText().toString();
        String seis = et1_3_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_3.setText("");
            total1_3.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub1_3.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total1_2.getText().toString());
            total1_3.setText(total+"");
        }
        operacionFilaCuatro();
    }

    private void operacionFilaCuatro() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_4_1.getText().toString();
        String dos = et1_4_2.getText().toString();
        String tres = et1_4_3.getText().toString();
        String cuatro = et1_4_4.getText().toString();
        String cinco = et1_4_5.getText().toString();
        String seis = et1_4_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_4.setText("");
            total1_4.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub1_4.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total1_3.getText().toString());
            total1_4.setText(total+"");
        }
        operacionFilaCinco();
    }

    private void operacionFilaCinco() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_5_1.getText().toString();
        String dos = et1_5_2.getText().toString();
        String tres = et1_5_3.getText().toString();
        String cuatro = et1_5_4.getText().toString();
        String cinco = et1_5_5.getText().toString();
        String seis = et1_5_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_5.setText("");
            total1_5.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub1_5.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total1_4.getText().toString());
            total1_5.setText(total+"");
        }
        operacionFilaSeis();
    }

    private void operacionFilaSeis() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_6_1.getText().toString();
        String dos = et1_6_2.getText().toString();
        String tres = et1_6_3.getText().toString();
        String cuatro = et1_6_4.getText().toString();
        String cinco = et1_6_5.getText().toString();
        String seis = et1_6_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_6.setText("");
            total1_6.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub1_6.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total1_5.getText().toString());
            total1_6.setText(total+"");
        }
        operacionFilaSiete();
    }

    private void operacionFilaSiete() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_1_1.getText().toString();
        String dos = et2_1_2.getText().toString();
        String tres = et2_1_3.getText().toString();
        String cuatro = et2_1_4.getText().toString();
        String cinco = et2_1_5.getText().toString();
        String seis = et2_1_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_1.setText("");
            total2_1.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub2_1.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total1_6.getText().toString());
            total2_1.setText(total+"");
        }
        operacionFilaOcho();
    }

    private void operacionFilaOcho() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_2_1.getText().toString();
        String dos = et2_2_2.getText().toString();
        String tres = et2_2_3.getText().toString();
        String cuatro = et2_2_4.getText().toString();
        String cinco = et2_2_5.getText().toString();
        String seis = et2_2_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_2.setText("");
            total2_2.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub2_2.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total2_1.getText().toString());
            total2_2.setText(total+"");
        }
        operacionFilaNueve();
    }

    private void operacionFilaNueve() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_3_1.getText().toString();
        String dos = et2_3_2.getText().toString();
        String tres = et2_3_3.getText().toString();
        String cuatro = et2_3_4.getText().toString();
        String cinco = et2_3_5.getText().toString();
        String seis = et2_3_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_3.setText("");
            total2_3.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub2_3.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total2_2.getText().toString());
            total2_3.setText(total+"");
        }
        operacionFilaDiez();
    }

    private void operacionFilaDiez() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_4_1.getText().toString();
        String dos = et2_4_2.getText().toString();
        String tres = et2_4_3.getText().toString();
        String cuatro = et2_4_4.getText().toString();
        String cinco = et2_4_5.getText().toString();
        String seis = et2_4_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_4.setText("");
            total2_4.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub2_4.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total2_3.getText().toString());
            total2_4.setText(total+"");
        }
        operacionFilaOnce();
    }

    private void operacionFilaOnce() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_5_1.getText().toString();
        String dos = et2_5_2.getText().toString();
        String tres = et2_5_3.getText().toString();
        String cuatro = et2_5_4.getText().toString();
        String cinco = et2_5_5.getText().toString();
        String seis = et2_5_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_5.setText("");
            total2_5.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub2_5.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total2_4.getText().toString());
            total2_5.setText(total+"");
        }
        operacionFilaDoce();
    }

    private void operacionFilaDoce() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_6_1.getText().toString();
        String dos = et2_6_2.getText().toString();
        String tres = et2_6_3.getText().toString();
        String cuatro = et2_6_4.getText().toString();
        String cinco = et2_6_5.getText().toString();
        String seis = et2_6_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_6.setText("");
            total2_6.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub2_6.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total2_5.getText().toString());
            total2_6.setText(total+"");
        }
    }


    private int filaResultado(ArrayList<String> fila) {
        ArrayList<Integer> subTotalSuma = new ArrayList<>();
        int res = 0;
        for (int i =0; i<fila.size(); i++){
            String aux = fila.get(i);
            int valor =0;
            if(aux.equals("X")){
                valor = 10;
            }if(!aux.isEmpty()&& !aux.equals("M")){
                valor = Integer.parseInt(aux);
            }
            subTotalSuma.add(valor);
        }

        for (int j =0; j<subTotalSuma.size(); j++){
            res = res+subTotalSuma.get(j);
        }
        return res;
    }

    private void guardarDatos() {
        SQLiteDatabase db=con.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_N1,et1_1_1.getText().toString());
        values.put(Utilidades.CAMPO_N2,et1_1_2.getText().toString());
        values.put(Utilidades.CAMPO_N3,et1_1_3.getText().toString());
        values.put(Utilidades.CAMPO_N4,et1_1_4.getText().toString());
        values.put(Utilidades.CAMPO_N5,et1_1_5.getText().toString());
        values.put(Utilidades.CAMPO_N6,et1_1_6.getText().toString());
        values.put(Utilidades.CAMPO_S1,sub1_1.getText().toString());
        values.put(Utilidades.CAMPO_T1,total1_1.getText().toString());

        values.put(Utilidades.CAMPO_N7,et1_2_1.getText().toString());
        values.put(Utilidades.CAMPO_N8,et1_2_2.getText().toString());
        values.put(Utilidades.CAMPO_N9,et1_2_3.getText().toString());
        values.put(Utilidades.CAMPO_N10,et1_2_4.getText().toString());
        values.put(Utilidades.CAMPO_N11,et1_2_5.getText().toString());
        values.put(Utilidades.CAMPO_N12,et1_2_6.getText().toString());
        values.put(Utilidades.CAMPO_S2,sub1_2.getText().toString());
        values.put(Utilidades.CAMPO_T2,total1_2.getText().toString());

        values.put(Utilidades.CAMPO_N13,et1_3_1.getText().toString());
        values.put(Utilidades.CAMPO_N14,et1_3_2.getText().toString());
        values.put(Utilidades.CAMPO_N15,et1_3_3.getText().toString());
        values.put(Utilidades.CAMPO_N16,et1_3_4.getText().toString());
        values.put(Utilidades.CAMPO_N17,et1_3_5.getText().toString());
        values.put(Utilidades.CAMPO_N18,et1_3_6.getText().toString());
        values.put(Utilidades.CAMPO_S3,sub1_3.getText().toString());
        values.put(Utilidades.CAMPO_T3,total1_3.getText().toString());

        values.put(Utilidades.CAMPO_N19,et1_4_1.getText().toString());
        values.put(Utilidades.CAMPO_N20,et1_4_2.getText().toString());
        values.put(Utilidades.CAMPO_N21,et1_4_3.getText().toString());
        values.put(Utilidades.CAMPO_N22,et1_4_4.getText().toString());
        values.put(Utilidades.CAMPO_N23,et1_4_5.getText().toString());
        values.put(Utilidades.CAMPO_N24,et1_4_6.getText().toString());
        values.put(Utilidades.CAMPO_S4,sub1_4.getText().toString());
        values.put(Utilidades.CAMPO_T4,total1_4.getText().toString());

        values.put(Utilidades.CAMPO_N25,et1_5_1.getText().toString());
        values.put(Utilidades.CAMPO_N26,et1_5_2.getText().toString());
        values.put(Utilidades.CAMPO_N27,et1_5_3.getText().toString());
        values.put(Utilidades.CAMPO_N28,et1_5_4.getText().toString());
        values.put(Utilidades.CAMPO_N29,et1_5_5.getText().toString());
        values.put(Utilidades.CAMPO_N30,et1_5_6.getText().toString());
        values.put(Utilidades.CAMPO_S5,sub1_5.getText().toString());
        values.put(Utilidades.CAMPO_T5,total1_5.getText().toString());

        values.put(Utilidades.CAMPO_N31,et1_6_1.getText().toString());
        values.put(Utilidades.CAMPO_N32,et1_6_2.getText().toString());
        values.put(Utilidades.CAMPO_N33,et1_6_3.getText().toString());
        values.put(Utilidades.CAMPO_N34,et1_6_4.getText().toString());
        values.put(Utilidades.CAMPO_N35,et1_6_5.getText().toString());
        values.put(Utilidades.CAMPO_N36,et1_6_6.getText().toString());
        values.put(Utilidades.CAMPO_S6,sub1_6.getText().toString());
        values.put(Utilidades.CAMPO_T6,total1_6.getText().toString());

        values.put(Utilidades.CAMPO_N37,et2_1_1.getText().toString());
        values.put(Utilidades.CAMPO_N38,et2_1_2.getText().toString());
        values.put(Utilidades.CAMPO_N39,et2_1_3.getText().toString());
        values.put(Utilidades.CAMPO_N40,et2_1_4.getText().toString());
        values.put(Utilidades.CAMPO_N41,et2_1_5.getText().toString());
        values.put(Utilidades.CAMPO_N42,et2_1_6.getText().toString());
        values.put(Utilidades.CAMPO_S7,sub2_1.getText().toString());
        values.put(Utilidades.CAMPO_T7,total2_1.getText().toString());

        values.put(Utilidades.CAMPO_N43,et2_2_1.getText().toString());
        values.put(Utilidades.CAMPO_N44,et2_2_2.getText().toString());
        values.put(Utilidades.CAMPO_N45,et2_2_3.getText().toString());
        values.put(Utilidades.CAMPO_N46,et2_2_4.getText().toString());
        values.put(Utilidades.CAMPO_N47,et2_2_5.getText().toString());
        values.put(Utilidades.CAMPO_N48,et2_2_6.getText().toString());
        values.put(Utilidades.CAMPO_S8,sub2_2.getText().toString());
        values.put(Utilidades.CAMPO_T8,total2_2.getText().toString());

        values.put(Utilidades.CAMPO_N49,et2_3_1.getText().toString());
        values.put(Utilidades.CAMPO_N50,et2_3_2.getText().toString());
        values.put(Utilidades.CAMPO_N51,et2_3_3.getText().toString());
        values.put(Utilidades.CAMPO_N52,et2_3_4.getText().toString());
        values.put(Utilidades.CAMPO_N53,et2_3_5.getText().toString());
        values.put(Utilidades.CAMPO_N54,et2_3_6.getText().toString());
        values.put(Utilidades.CAMPO_S9,sub2_3.getText().toString());
        values.put(Utilidades.CAMPO_T9,total2_3.getText().toString());

        values.put(Utilidades.CAMPO_N55,et2_4_1.getText().toString());
        values.put(Utilidades.CAMPO_N56,et2_4_2.getText().toString());
        values.put(Utilidades.CAMPO_N57,et2_4_3.getText().toString());
        values.put(Utilidades.CAMPO_N58,et2_4_4.getText().toString());
        values.put(Utilidades.CAMPO_N59,et2_4_5.getText().toString());
        values.put(Utilidades.CAMPO_N60,et2_4_6.getText().toString());
        values.put(Utilidades.CAMPO_S10,sub2_4.getText().toString());
        values.put(Utilidades.CAMPO_T10,total2_4.getText().toString());

        values.put(Utilidades.CAMPO_N61,et2_5_1.getText().toString());
        values.put(Utilidades.CAMPO_N62,et2_5_2.getText().toString());
        values.put(Utilidades.CAMPO_N63,et2_5_3.getText().toString());
        values.put(Utilidades.CAMPO_N64,et2_5_4.getText().toString());
        values.put(Utilidades.CAMPO_N65,et2_5_5.getText().toString());
        values.put(Utilidades.CAMPO_N66,et2_5_6.getText().toString());
        values.put(Utilidades.CAMPO_S11,sub2_5.getText().toString());
        values.put(Utilidades.CAMPO_T11,total2_5.getText().toString());

        values.put(Utilidades.CAMPO_N67,et2_6_1.getText().toString());
        values.put(Utilidades.CAMPO_N68,et2_6_2.getText().toString());
        values.put(Utilidades.CAMPO_N69,et2_6_3.getText().toString());
        values.put(Utilidades.CAMPO_N70,et2_6_4.getText().toString());
        values.put(Utilidades.CAMPO_N71,et2_6_5.getText().toString());
        values.put(Utilidades.CAMPO_N72,et2_6_6.getText().toString());
        values.put(Utilidades.CAMPO_S12,sub2_6.getText().toString());
        values.put(Utilidades.CAMPO_T12,total2_6.getText().toString());
        String[] parametros1 = {idTablero.toString()};

        db.update(Utilidades.TABLA_PUNTAJE,values,Utilidades.CAMPO_IDPUNTO+" =? ",parametros1);
        db.close();

    }

    private ArrayList<String []> getPuntos(){
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v1,v2,v3,v4,v5,v6,s1,t1});
        rows.add(new String[]{"2",v7,v8,v9,v10,v11,v12,s2,t2});
        rows.add(new String[]{"3",v13,v14,v15,v16,v17,v18,s3,t3});
        rows.add(new String[]{"4",v19,v20,v21,v22,v23,v24,s4,t4});
        rows.add(new String[]{"5",v25,v26,v27,v28,v29,v30,s5,t5});
        rows.add(new String[]{"6",v31,v32,v33,v34,v35,v36,s6,t6});
        return rows;
    }
    private ArrayList<String []> getPuntos2(){
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v37,v38,v39,v40,v41,v42,s7,t7});
        rows.add(new String[]{"2",v43,v44,v45,v46,v47,v48,s8,t8});
        rows.add(new String[]{"3",v49,v50,v51,v52,v53,v54,s9,t9});
        rows.add(new String[]{"4",v55,v56,v57,v58,v59,v60,s10,t10});
        rows.add(new String[]{"5",v61,v62,v63,v64,v65,v66,s11,t11});
        rows.add(new String[]{"6",v67,v68,v69,v70,v71,v72,s12,t12});
        return rows;
    }

    // metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_puntaje, menu);
        return true;
    }
    // menu para activar las funciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id == R.id.estadistica){
            verNumeros();
            verTotal();
            verTotalRonda1();
            verTotalRonda2();
            Intent intent=new Intent(TableroPuntos2.this,Estadistica.class);
            intent.putExtra("disparos",disparos);
            intent.putExtra("puntaje",puntaje);
            intent.putExtra("acierto",acierto);
            intent.putExtra("media",media);
            intent.putExtra("cantidadDisparos",cantidadDisparos);
            Bundle bundle=new Bundle();
            bundle.putFloat("uno",uno);
            bundle.putFloat("dos",dos);
            bundle.putFloat("tres",tres);
            bundle.putFloat("cuatro",cuatro);
            bundle.putFloat("cinco",cinco);
            bundle.putFloat("seis",seis);
            bundle.putFloat("siete",siete);
            bundle.putFloat("ocho",ocho);
            bundle.putFloat("nueve",nueve);
            bundle.putFloat("diez",diez);
            bundle.putFloat("x",x);
            bundle.putFloat("m",m);
            bundle.putFloat("ronda1",ronda1);
            bundle.putFloat("ronda2",ronda2);
            intent.putExtras(bundle);
            startActivity(intent);
        }else if(id==R.id.generarPdf){
            consultar();
            consultarPuntos();
            instanciarPdf();
            template3PDF.appViewPDF(this);
            Toast.makeText(TableroPuntos2.this,"El pdf se guardo en la carpeta 'Archery'",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void instanciarPdf() {
        template3PDF=new Template3PDF(getApplicationContext());
        template3PDF.openDocument();
        template3PDF.adMetaData("Datos para el control de puntaje del arquero",club,ronda);
        template3PDF.addTitles("Distancia de diparo 70 metros","Puntaje total a 70 metros es 720 puntos",fecha);
        template3PDF.addParagraph(shortText+ronda);
        if(arco.equals("0")){
            tipoArco = "Recurvo";
        }else{
            tipoArco = "Compuesto";
        }

        template3PDF.addParagraph(longText+club+"                "+"Tipo de arco: "+tipoArco);
        template3PDF.addParagraph("Nombre del arquero:  "+nombreArquero);
        template3PDF.createTable(header,getPuntos());
        template3PDF.createTable(header,getPuntos2());
        template3PDF.closeDocument();
    }
    private void verTotal() {
        consultarPuntos();
        ArrayList<String> total=new ArrayList<>();
        ArrayList<Integer> totalEnteros =new ArrayList<>();
        total.add(t1);
        total.add(t2);
        total.add(t3);
        total.add(t4);
        total.add(t5);
        total.add(t6);
        total.add(t7);
        total.add(t8);
        total.add(t9);
        total.add(t10);
        total.add(t11);
        total.add(t12);

        for (int j=0;j<total.size();j++){
            String aux = total.get(j);
            if(!aux.equals("")){
                totalEnteros.add(Integer.valueOf(aux));
            }
        }
        int valorMayor =0;
        for(int j=0;j<totalEnteros.size();j++){
            if(valorMayor<totalEnteros.get(j)){
                valorMayor = totalEnteros.get(j);
            }
        }
        puntaje = valorMayor;
        media=totalEnteros.size();
    }

    private void verNumeros(){
        consultarPuntos();
        ArrayList<String> valores=new ArrayList<>();
        valores.add(v1);
        valores.add(v2);
        valores.add(v3);
        valores.add(v4);
        valores.add(v5);
        valores.add(v6);
        valores.add(v7);
        valores.add(v8);
        valores.add(v9);
        valores.add(v10);
        valores.add(v11);
        valores.add(v12);
        valores.add(v13);
        valores.add(v14);
        valores.add(v15);
        valores.add(v16);
        valores.add(v17);
        valores.add(v18);
        valores.add(v19);
        valores.add(v20);
        valores.add(v21);
        valores.add(v22);
        valores.add(v23);
        valores.add(v24);
        valores.add(v25);
        valores.add(v26);
        valores.add(v27);
        valores.add(v28);
        valores.add(v29);
        valores.add(v30);
        valores.add(v31);
        valores.add(v32);
        valores.add(v33);
        valores.add(v34);
        valores.add(v35);
        valores.add(v36);
        valores.add(v37);
        valores.add(v38);
        valores.add(v39);
        valores.add(v40);
        valores.add(v41);
        valores.add(v42);
        valores.add(v43);
        valores.add(v44);
        valores.add(v45);
        valores.add(v46);
        valores.add(v47);
        valores.add(v48);
        valores.add(v49);
        valores.add(v50);
        valores.add(v51);
        valores.add(v52);
        valores.add(v53);
        valores.add(v54);
        valores.add(v55);
        valores.add(v56);
        valores.add(v57);
        valores.add(v58);
        valores.add(v59);
        valores.add(v60);
        valores.add(v61);
        valores.add(v62);
        valores.add(v63);
        valores.add(v64);
        valores.add(v65);
        valores.add(v66);
        valores.add(v67);
        valores.add(v68);
        valores.add(v69);
        valores.add(v70);
        valores.add(v71);
        valores.add(v72);
        for (int i=0;i<valores.size();i++){
            //cantidad de los numeros
            String valorActual = valores.get(i);
            if(valorActual.equals("1")){
                uno=uno+1;
            }
            if(valorActual.equals("2")){
                dos=dos+1;
            }
            if(valorActual.equals("3")){
                tres=tres+1;
            }
            if(valorActual.equals("4")){
                cuatro=cuatro+1;
            }
            if(valorActual.equals("5")){
                cinco=cinco+1;
            }
            if(valorActual.equals("X")){
                x=x+1;
            }
            if(valorActual.equals("6")){
                seis=seis+1;
            }
            if(valorActual.equals("7")){
                siete=siete+1;
            }
            if(valorActual.equals("8")){
                ocho=ocho+1;
            }
            if(valorActual.equals("9")){
                nueve=nueve+1;
            }
            if(valorActual.equals("10")){
                diez=diez+1;
            }
            if(valorActual.equals("M")){
                m=m+1;
            }
            // aciertos mientras no sea vacio o M
            if(!valorActual.equals("M") && !valorActual.equals("")){
                acierto=acierto+1;
            }
            //disparos todos los valores incluyendo el valor M
            if(!valorActual.equals("")){
                disparos=disparos+1;
            }
        }

    }

    private void verTotalRonda2() {
        consultarPuntos();
        ArrayList<String> totalRonada2=new ArrayList<>();
        ArrayList<Integer> totalEnterosRonda2 =new ArrayList<>();
        totalRonada2.add(t7);
        totalRonada2.add(t8);
        totalRonada2.add(t9);
        totalRonada2.add(t10);
        totalRonada2.add(t11);
        totalRonada2.add(t12);

        for (int j=0;j<totalRonada2.size();j++){
            String aux = totalRonada2.get(j);
            if(!aux.equals("")){
                totalEnterosRonda2.add(Integer.valueOf(aux));
            }
        }
        int valorMayor =0;
        for(int j=0;j<totalEnterosRonda2.size();j++){
            if(valorMayor<totalEnterosRonda2.get(j)){
                valorMayor = totalEnterosRonda2.get(j);
            }
        }
        ronda2 = valorMayor;

    }

    private void verTotalRonda1() {
        consultarPuntos();
        ArrayList<String> totalRonda1=new ArrayList<>();
        ArrayList<Integer> totalEnterosRonda1 =new ArrayList<>();
        totalRonda1.add(t1);
        totalRonda1.add(t2);
        totalRonda1.add(t3);
        totalRonda1.add(t4);
        totalRonda1.add(t5);
        totalRonda1.add(t6);

        for (int j=0;j<totalRonda1.size();j++){
            String aux = totalRonda1.get(j);
            if(!aux.equals("")){
                totalEnterosRonda1.add(Integer.valueOf(aux));
            }
        }
        int valorMayor =0;
        for(int j=0;j<totalEnterosRonda1.size();j++){
            if(valorMayor<totalEnterosRonda1.get(j)){
                valorMayor = totalEnterosRonda1.get(j);
            }
        }
        ronda1 = valorMayor;
    }

    //para que el boton de ir asia atraz del celular no funcione
    @Override
    public void onBackPressed(){

    }
}
