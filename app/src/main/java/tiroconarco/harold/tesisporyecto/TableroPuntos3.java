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

import java.sql.ParameterMetaData;
import java.util.ArrayList;

public class TableroPuntos3 extends AppCompatActivity {

    private EditText et1_1_1,et1_1_2,et1_1_3,et1_2_1,et1_2_2,et1_2_3,et1_3_1,et1_3_2,et1_3_3,et1_4_1,et1_4_2,et1_4_3,et1_5_1,et1_5_2,et1_5_3,et1_6_1,et1_6_2,et1_6_3,et1_7_1,et1_7_2,et1_7_3,et1_8_1,et1_8_2,et1_8_3,et1_9_1,et1_9_2,et1_9_3,et1_10_1,et1_10_2,et1_10_3,
                     et2_1_1,et2_1_2,et2_1_3,et2_2_1,et2_2_2,et2_2_3,et2_3_1,et2_3_2,et2_3_3,et2_4_1,et2_4_2,et2_4_3,et2_5_1,et2_5_2,et2_5_3,et2_6_1,et2_6_2,et2_6_3,et2_7_1,et2_7_2,et2_7_3,et2_8_1,et2_8_2,et2_8_3,et2_9_1,et2_9_2,et2_9_3,et2_10_1,et2_10_2,et2_10_3;
    private TextView sub1_1,total1_1,sub1_2,total1_2,sub1_3,total1_3,sub1_4,total1_4,sub1_5,total1_5,sub1_6,total1_6,sub1_7,total1_7,sub1_8,total1_8,sub1_9,total1_9,sub1_10,total1_10,
                     sub2_1,total2_1,sub2_2,total2_2,sub2_3,total2_3,sub2_4,total2_4,sub2_5,total2_5,sub2_6,total2_6,sub2_7,total2_7,sub2_8,total2_8,sub2_9,total2_9,sub2_10,total2_10;

    AdminSQLiteOpenHelper con;
    Long idTablero, idRonda;
    boolean deLista;

    private Template3PDF template3PDF;
    private String[]header={"n°","1","2","3","subtotal","total"};
    private String shortText="nombre ronda:   ";
    private String longText="nombre del club:   ";
    String ronda,club,fecha,nombreArquero,tipoArco, arco;
    int idPunto;
    MyKeyboard keyboard;
    String v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,
           v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,v35,v36,v37,v38,v39,v40,
            v41,v42,v43,v44,v45,v46,v47,v48,v49,v50,v51,v52,v53,v54,v55,v56,v57,v58,v59,v60,
            s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,
            t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
    int cantidadDisparos=60;
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
        setContentView(R.layout.activity_tablero_puntos3);

        // flecha ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        con= new AdminSQLiteOpenHelper(getApplicationContext(),Utilidades.NOMBRE_BD,null,1);

        idTablero = getIntent().getLongExtra("idTablero",100);
        idRonda = getIntent().getLongExtra("idRonda",100);
        deLista = getIntent().getBooleanExtra("deLista",false);

        aniadirAccionesEInstancias();
        habilitarTeclado();

        if(deLista){
            consultarPuntos();
            consultar();
        }
    }
    private void habilitarTeclado() {

        primeraRonda();
        segundaRonda();
    }

    private void primeraRonda() {
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

        et1_7_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_7_1=et1_7_1.onCreateInputConnection(new EditorInfo());
                    et1_7_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_7_1);
                }
            }
        });
        et1_7_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_7_2=et1_7_2.onCreateInputConnection(new EditorInfo());
                    et1_7_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_7_2);
                }
            }
        });
        et1_7_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_7_3=et1_7_3.onCreateInputConnection(new EditorInfo());
                    et1_7_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_7_3);
                }
            }
        });

        et1_8_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_8_1=et1_8_1.onCreateInputConnection(new EditorInfo());
                    et1_8_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_8_1);
                }
            }
        });
        et1_8_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_8_2=et1_8_2.onCreateInputConnection(new EditorInfo());
                    et1_8_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_8_2);
                }
            }
        });
        et1_8_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_8_3=et1_8_3.onCreateInputConnection(new EditorInfo());
                    et1_8_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_8_3);
                }
            }
        });

        et1_9_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_9_1=et1_9_1.onCreateInputConnection(new EditorInfo());
                    et1_9_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_9_1);
                }
            }
        });
        et1_9_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_9_2=et1_9_2.onCreateInputConnection(new EditorInfo());
                    et1_9_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_9_2);
                }
            }
        });
        et1_9_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_9_3=et1_9_3.onCreateInputConnection(new EditorInfo());
                    et1_9_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_9_3);
                }
            }
        });

        et1_10_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_10_1=et1_10_1.onCreateInputConnection(new EditorInfo());
                    et1_10_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_10_1);
                }
            }
        });
        et1_10_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_10_2=et1_10_2.onCreateInputConnection(new EditorInfo());
                    et1_10_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_10_2);
                }
            }
        });
        et1_10_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_10_3=et1_10_3.onCreateInputConnection(new EditorInfo());
                    et1_10_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_10_3);
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




        et2_7_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_7_1=et2_7_1.onCreateInputConnection(new EditorInfo());
                    et2_7_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_7_1);
                }
            }
        });
        et2_7_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_7_2=et2_7_2.onCreateInputConnection(new EditorInfo());
                    et2_7_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_7_2);
                }
            }
        });
        et2_7_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_7_3=et2_7_3.onCreateInputConnection(new EditorInfo());
                    et2_7_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_7_3);
                }
            }
        });

        et2_8_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_8_1=et2_8_1.onCreateInputConnection(new EditorInfo());
                    et2_8_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_8_1);
                }
            }
        });
        et2_8_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_8_2=et2_8_2.onCreateInputConnection(new EditorInfo());
                    et2_8_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_8_2);
                }
            }
        });
        et2_8_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_8_3=et2_8_3.onCreateInputConnection(new EditorInfo());
                    et2_8_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_8_3);
                }
            }
        });

        et2_9_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_9_1=et2_9_1.onCreateInputConnection(new EditorInfo());
                    et2_9_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_9_1);
                }
            }
        });
        et2_9_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_9_2=et2_9_2.onCreateInputConnection(new EditorInfo());
                    et2_9_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_9_2);
                }
            }
        });
        et2_9_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_9_3=et2_9_3.onCreateInputConnection(new EditorInfo());
                    et2_9_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_9_3);
                }
            }
        });

        et2_10_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic2_10_1=et2_10_1.onCreateInputConnection(new EditorInfo());
                    et2_10_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_10_1);
                }
            }
        });
        et2_10_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_10_2=et2_10_2.onCreateInputConnection(new EditorInfo());
                    et2_10_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_10_2);
                }
            }
        });
        et2_10_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_10_3=et2_10_3.onCreateInputConnection(new EditorInfo());
                    et2_10_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_10_3);
                }
            }
        });

    }

    private void aniadirAccionesEInstancias() {
        keyboard=(MyKeyboard) findViewById(R.id.keyboard);
        et1_1_1=(EditText) findViewById(R.id.edit1_1_1);
        et1_1_2=(EditText) findViewById(R.id.edit1_1_2);
        et1_1_3=(EditText) findViewById(R.id.edit1_1_3);
        sub1_1=(TextView) findViewById(R.id.textViewSubTotal1_1);
        total1_1=(TextView) findViewById(R.id.textViewTotal1_1);

        et1_1_1.addTextChangedListener(new GenericTextWatcher(et1_1_1));
        et1_1_2.addTextChangedListener(new GenericTextWatcher(et1_1_2));
        et1_1_3.addTextChangedListener(new GenericTextWatcher(et1_1_3));


        et1_2_1=(EditText) findViewById(R.id.edit1_2_1);
        et1_2_2=(EditText) findViewById(R.id.edit1_2_2);
        et1_2_3=(EditText) findViewById(R.id.edit1_2_3);
        sub1_2=(TextView) findViewById(R.id.textViewSubTotal1_2);
        total1_2=(TextView) findViewById(R.id.textViewTotal1_2);

        et1_2_1.addTextChangedListener(new GenericTextWatcher(et1_2_1));
        et1_2_2.addTextChangedListener(new GenericTextWatcher(et1_2_2));
        et1_2_3.addTextChangedListener(new GenericTextWatcher(et1_2_3));


        et1_3_1=(EditText) findViewById(R.id.edit1_3_1);
        et1_3_2=(EditText) findViewById(R.id.edit1_3_2);
        et1_3_3=(EditText) findViewById(R.id.edit1_3_3);
        sub1_3=(TextView) findViewById(R.id.textViewSubTotal1_3);
        total1_3=(TextView) findViewById(R.id.textViewTotal1_3);

        et1_3_1.addTextChangedListener(new GenericTextWatcher(et1_3_1));
        et1_3_2.addTextChangedListener(new GenericTextWatcher(et1_3_2));
        et1_3_3.addTextChangedListener(new GenericTextWatcher(et1_3_3));

        et1_4_1=(EditText) findViewById(R.id.edit1_4_1);
        et1_4_2=(EditText) findViewById(R.id.edit1_4_2);
        et1_4_3=(EditText) findViewById(R.id.edit1_4_3);
        sub1_4=(TextView) findViewById(R.id.textViewSubTotal1_4);
        total1_4=(TextView) findViewById(R.id.textViewTotal1_4);

        et1_4_1.addTextChangedListener(new GenericTextWatcher(et1_4_1));
        et1_4_2.addTextChangedListener(new GenericTextWatcher(et1_4_2));
        et1_4_3.addTextChangedListener(new GenericTextWatcher(et1_4_3));

        et1_5_1=(EditText) findViewById(R.id.edit1_5_1);
        et1_5_2=(EditText) findViewById(R.id.edit1_5_2);
        et1_5_3=(EditText) findViewById(R.id.edit1_5_3);
        sub1_5=(TextView) findViewById(R.id.textViewSubTotal1_5);
        total1_5=(TextView) findViewById(R.id.textViewTotal1_5);

        et1_5_1.addTextChangedListener(new GenericTextWatcher(et1_5_1));
        et1_5_2.addTextChangedListener(new GenericTextWatcher(et1_5_2));
        et1_5_3.addTextChangedListener(new GenericTextWatcher(et1_5_3));

        et1_6_1=(EditText) findViewById(R.id.edit1_6_1);
        et1_6_2=(EditText) findViewById(R.id.edit1_6_2);
        et1_6_3=(EditText) findViewById(R.id.edit1_6_3);
        sub1_6=(TextView) findViewById(R.id.textViewSubTotal1_6);
        total1_6=(TextView) findViewById(R.id.textViewTotal1_6);

        et1_6_1.addTextChangedListener(new GenericTextWatcher(et1_6_1));
        et1_6_2.addTextChangedListener(new GenericTextWatcher(et1_6_2));
        et1_6_3.addTextChangedListener(new GenericTextWatcher(et1_6_3));

        et1_7_1=(EditText) findViewById(R.id.edit1_7_1);
        et1_7_2=(EditText) findViewById(R.id.edit1_7_2);
        et1_7_3=(EditText) findViewById(R.id.edit1_7_3);
        sub1_7=(TextView) findViewById(R.id.textViewSubTotal1_7);
        total1_7=(TextView) findViewById(R.id.textViewTotal1_7);

        et1_7_1.addTextChangedListener(new GenericTextWatcher(et1_7_1));
        et1_7_2.addTextChangedListener(new GenericTextWatcher(et1_7_2));
        et1_7_3.addTextChangedListener(new GenericTextWatcher(et1_7_3));

        et1_8_1=(EditText) findViewById(R.id.edit1_8_1);
        et1_8_2=(EditText) findViewById(R.id.edit1_8_2);
        et1_8_3=(EditText) findViewById(R.id.edit1_8_3);
        sub1_8=(TextView) findViewById(R.id.textViewSubTotal1_8);
        total1_8=(TextView) findViewById(R.id.textViewTotal1_8);

        et1_8_1.addTextChangedListener(new GenericTextWatcher(et1_8_1));
        et1_8_2.addTextChangedListener(new GenericTextWatcher(et1_8_2));
        et1_8_3.addTextChangedListener(new GenericTextWatcher(et1_8_3));

        et1_9_1=(EditText) findViewById(R.id.edit1_9_1);
        et1_9_2=(EditText) findViewById(R.id.edit1_9_2);
        et1_9_3=(EditText) findViewById(R.id.edit1_9_3);
        sub1_9=(TextView) findViewById(R.id.textViewSubTotal1_9);
        total1_9=(TextView) findViewById(R.id.textViewTotal1_9);

        et1_9_1.addTextChangedListener(new GenericTextWatcher(et1_9_1));
        et1_9_2.addTextChangedListener(new GenericTextWatcher(et1_9_2));
        et1_9_3.addTextChangedListener(new GenericTextWatcher(et1_9_3));

        et1_10_1=(EditText) findViewById(R.id.edit1_10_1);
        et1_10_2=(EditText) findViewById(R.id.edit1_10_2);
        et1_10_3=(EditText) findViewById(R.id.edit1_10_3);
        sub1_10=(TextView) findViewById(R.id.textViewSubTotal1_10);
        total1_10=(TextView) findViewById(R.id.textViewTotal1_10);

        et1_10_1.addTextChangedListener(new GenericTextWatcher(et1_10_1));
        et1_10_2.addTextChangedListener(new GenericTextWatcher(et1_10_2));
        et1_10_3.addTextChangedListener(new GenericTextWatcher(et1_10_3));

        et2_1_1=(EditText) findViewById(R.id.edit2_1_1);
        et2_1_2=(EditText) findViewById(R.id.edit2_1_2);
        et2_1_3=(EditText) findViewById(R.id.edit2_1_3);
        sub2_1=(TextView) findViewById(R.id.textViewSubTotal2_1);
        total2_1=(TextView) findViewById(R.id.textViewTotal2_1);

        et2_1_1.addTextChangedListener(new GenericTextWatcher(et2_1_1));
        et2_1_2.addTextChangedListener(new GenericTextWatcher(et2_1_2));
        et2_1_3.addTextChangedListener(new GenericTextWatcher(et2_1_3));

        et2_2_1=(EditText) findViewById(R.id.edit2_2_1);
        et2_2_2=(EditText) findViewById(R.id.edit2_2_2);
        et2_2_3=(EditText) findViewById(R.id.edit2_2_3);
        sub2_2=(TextView) findViewById(R.id.textViewSubTotal2_2);
        total2_2=(TextView) findViewById(R.id.textViewTotal2_2);

        et2_2_1.addTextChangedListener(new GenericTextWatcher(et2_2_1));
        et2_2_2.addTextChangedListener(new GenericTextWatcher(et2_2_2));
        et2_2_3.addTextChangedListener(new GenericTextWatcher(et2_2_3));

        et2_3_1=(EditText) findViewById(R.id.edit2_3_1);
        et2_3_2=(EditText) findViewById(R.id.edit2_3_2);
        et2_3_3=(EditText) findViewById(R.id.edit2_3_3);
        sub2_3=(TextView) findViewById(R.id.textViewSubTotal2_3);
        total2_3=(TextView) findViewById(R.id.textViewTotal2_3);

        et2_3_1.addTextChangedListener(new GenericTextWatcher(et2_3_1));
        et2_3_2.addTextChangedListener(new GenericTextWatcher(et2_3_2));
        et2_3_3.addTextChangedListener(new GenericTextWatcher(et2_3_3));

        et2_4_1=(EditText) findViewById(R.id.edit2_4_1);
        et2_4_2=(EditText) findViewById(R.id.edit2_4_2);
        et2_4_3=(EditText) findViewById(R.id.edit2_4_3);
        sub2_4=(TextView) findViewById(R.id.textViewSubTotal2_4);
        total2_4=(TextView) findViewById(R.id.textViewTotal2_4);

        et2_4_1.addTextChangedListener(new GenericTextWatcher(et2_4_1));
        et2_4_2.addTextChangedListener(new GenericTextWatcher(et2_4_2));
        et2_4_3.addTextChangedListener(new GenericTextWatcher(et2_4_3));

        et2_5_1=(EditText) findViewById(R.id.edit2_5_1);
        et2_5_2=(EditText) findViewById(R.id.edit2_5_2);
        et2_5_3=(EditText) findViewById(R.id.edit2_5_3);
        sub2_5=(TextView) findViewById(R.id.textViewSubTotal2_5);
        total2_5=(TextView) findViewById(R.id.textViewTotal2_5);

        et2_5_1.addTextChangedListener(new GenericTextWatcher(et2_5_1));
        et2_5_2.addTextChangedListener(new GenericTextWatcher(et2_5_2));
        et2_5_3.addTextChangedListener(new GenericTextWatcher(et2_5_3));

        et2_6_1=(EditText) findViewById(R.id.edit2_6_1);
        et2_6_2=(EditText) findViewById(R.id.edit2_6_2);
        et2_6_3=(EditText) findViewById(R.id.edit2_6_3);
        sub2_6=(TextView) findViewById(R.id.textViewSubTotal2_6);
        total2_6=(TextView) findViewById(R.id.textViewTotal2_6);

        et2_6_1.addTextChangedListener(new GenericTextWatcher(et2_6_1));
        et2_6_2.addTextChangedListener(new GenericTextWatcher(et2_6_2));
        et2_6_3.addTextChangedListener(new GenericTextWatcher(et2_6_3));

        et2_7_1=(EditText) findViewById(R.id.edit2_7_1);
        et2_7_2=(EditText) findViewById(R.id.edit2_7_2);
        et2_7_3=(EditText) findViewById(R.id.edit2_7_3);
        sub2_7=(TextView) findViewById(R.id.textViewSubTotal2_7);
        total2_7=(TextView) findViewById(R.id.textViewTotal2_7);

        et2_7_1.addTextChangedListener(new GenericTextWatcher(et2_7_1));
        et2_7_2.addTextChangedListener(new GenericTextWatcher(et2_7_2));
        et2_7_3.addTextChangedListener(new GenericTextWatcher(et2_7_3));

        et2_8_1=(EditText) findViewById(R.id.edit2_8_1);
        et2_8_2=(EditText) findViewById(R.id.edit2_8_2);
        et2_8_3=(EditText) findViewById(R.id.edit2_8_3);
        sub2_8=(TextView) findViewById(R.id.textViewSubTotal2_8);
        total2_8=(TextView) findViewById(R.id.textViewTotal2_8);

        et2_8_1.addTextChangedListener(new GenericTextWatcher(et2_8_1));
        et2_8_2.addTextChangedListener(new GenericTextWatcher(et2_8_2));
        et2_8_3.addTextChangedListener(new GenericTextWatcher(et2_8_3));

        et2_9_1=(EditText) findViewById(R.id.edit2_9_1);
        et2_9_2=(EditText) findViewById(R.id.edit2_9_2);
        et2_9_3=(EditText) findViewById(R.id.edit2_9_3);
        sub2_9=(TextView) findViewById(R.id.textViewSubTotal2_9);
        total2_9=(TextView) findViewById(R.id.textViewTotal2_9);

        et2_9_1.addTextChangedListener(new GenericTextWatcher(et2_9_1));
        et2_9_2.addTextChangedListener(new GenericTextWatcher(et2_9_2));
        et2_9_3.addTextChangedListener(new GenericTextWatcher(et2_9_3));

        et2_10_1=(EditText) findViewById(R.id.edit2_10_1);
        et2_10_2=(EditText) findViewById(R.id.edit2_10_2);
        et2_10_3=(EditText) findViewById(R.id.edit2_10_3);
        sub2_10=(TextView) findViewById(R.id.textViewSubTotal2_10);
        total2_10=(TextView) findViewById(R.id.textViewTotal2_10);

        et2_10_1.addTextChangedListener(new GenericTextWatcher(et2_10_1));
        et2_10_2.addTextChangedListener(new GenericTextWatcher(et2_10_2));
        et2_10_3.addTextChangedListener(new GenericTextWatcher(et2_10_3));

    }

    private void instanciarPdf() {
        //datos del pdf
        template3PDF=new Template3PDF(getApplicationContext());
        template3PDF.openDocument();
        template3PDF.adMetaData("Datos para el control de puntaje del arquero",club,ronda);
        template3PDF.addTitles("Distancia de diparo 18 metros","Puntaje total a 18 metros es 620 puntos",fecha);
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

                ,Utilidades.CAMPO_S1,Utilidades.CAMPO_S2,Utilidades.CAMPO_S3,Utilidades.CAMPO_S4,Utilidades.CAMPO_S5,Utilidades.CAMPO_S6,Utilidades.CAMPO_S7,Utilidades.CAMPO_S8,Utilidades.CAMPO_S9,Utilidades.CAMPO_S10
                ,Utilidades.CAMPO_S11,Utilidades.CAMPO_S12,Utilidades.CAMPO_S13,Utilidades.CAMPO_S14,Utilidades.CAMPO_S15,Utilidades.CAMPO_S16,Utilidades.CAMPO_S17,Utilidades.CAMPO_S18,Utilidades.CAMPO_S19,Utilidades.CAMPO_S20

                ,Utilidades.CAMPO_T1,Utilidades.CAMPO_T2,Utilidades.CAMPO_T3,Utilidades.CAMPO_T4,Utilidades.CAMPO_T5,Utilidades.CAMPO_T6,Utilidades.CAMPO_T7,Utilidades.CAMPO_T8,Utilidades.CAMPO_T9,Utilidades.CAMPO_T10
                ,Utilidades.CAMPO_T11,Utilidades.CAMPO_T12,Utilidades.CAMPO_T13,Utilidades.CAMPO_T14,Utilidades.CAMPO_T15,Utilidades.CAMPO_T16,Utilidades.CAMPO_T17,Utilidades.CAMPO_T18,Utilidades.CAMPO_T19,Utilidades.CAMPO_T20};
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
            s1=cursor.getString(61);
            s2=cursor.getString(62);
            s3=cursor.getString(63);
            s4=cursor.getString(64);
            s5=cursor.getString(65);
            s6=cursor.getString(66);
            s7=cursor.getString(67);
            s8=cursor.getString(68);
            s9=cursor.getString(69);
            s10=cursor.getString(70);
            s11=cursor.getString(71);
            s12=cursor.getString(72);
            s13=cursor.getString(73);
            s14=cursor.getString(74);
            s15=cursor.getString(75);
            s16=cursor.getString(76);
            s17=cursor.getString(77);
            s18=cursor.getString(78);
            s19=cursor.getString(79);
            s20=cursor.getString(80);
            t1=cursor.getString(81);
            t2=cursor.getString(82);
            t3=cursor.getString(83);
            t4=cursor.getString(84);
            t5=cursor.getString(85);
            t6=cursor.getString(86);
            t7=cursor.getString(87);
            t8=cursor.getString(88);
            t9=cursor.getString(89);
            t10=cursor.getString(90);
            t11=cursor.getString(91);
            t12=cursor.getString(92);
            t13=cursor.getString(93);
            t14=cursor.getString(94);
            t15=cursor.getString(95);
            t16=cursor.getString(96);
            t17=cursor.getString(97);
            t18=cursor.getString(98);
            t19=cursor.getString(99);
            t20=cursor.getString(100);
            db.close();
            cursor.close();
            if(deLista){
                llenarTablero();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            Log.e("error",e.getMessage());
        }
    }

    private void llenarTablero() {
        et1_1_1.setText(v1);
        et1_1_2.setText(v2);
        et1_1_3.setText(v3);
        et1_2_1.setText(v4);
        et1_2_2.setText(v5);
        et1_2_3.setText(v6);
        et1_3_1.setText(v7);
        et1_3_2.setText(v8);
        et1_3_3.setText(v9);
        et1_4_1.setText(v10);
        et1_4_2.setText(v11);
        et1_4_3.setText(v12);
        et1_5_1.setText(v13);
        et1_5_2.setText(v14);
        et1_5_3.setText(v15);
        et1_6_1.setText(v16);
        et1_6_2.setText(v17);
        et1_6_3.setText(v18);
        et1_7_1.setText(v19);
        et1_7_2.setText(v20);
        et1_7_3.setText(v21);
        et1_8_1.setText(v22);
        et1_8_2.setText(v23);
        et1_8_3.setText(v24);
        et1_9_1.setText(v25);
        et1_9_2.setText(v26);
        et1_9_3.setText(v27);
        et1_10_1.setText(v28);
        et1_10_2.setText(v29);
        et1_10_3.setText(v30);

        et2_1_1.setText(v31);
        et2_1_2.setText(v32);
        et2_1_3.setText(v33);
        et2_2_1.setText(v34);
        et2_2_2.setText(v35);
        et2_2_3.setText(v36);
        et2_3_1.setText(v37);
        et2_3_2.setText(v38);
        et2_3_3.setText(v39);
        et2_4_1.setText(v40);
        et2_4_2.setText(v41);
        et2_4_3.setText(v42);
        et2_5_1.setText(v43);
        et2_5_2.setText(v44);
        et2_5_3.setText(v45);
        et2_6_1.setText(v46);
        et2_6_2.setText(v47);
        et2_6_3.setText(v48);
        et2_7_1.setText(v49);
        et2_7_2.setText(v50);
        et2_7_3.setText(v51);
        et2_8_1.setText(v52);
        et2_8_2.setText(v53);
        et2_8_3.setText(v54);
        et2_9_1.setText(v55);
        et2_9_2.setText(v56);
        et2_9_3.setText(v57);
        et2_10_1.setText(v58);
        et2_10_2.setText(v59);
        et2_10_3.setText(v60);
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
        sub1_7.setText(s7);
        total1_7.setText(t7);
        sub1_8.setText(s8);
        total1_8.setText(t8);
        sub1_9.setText(s9);
        total1_9.setText(t9);
        sub1_10.setText(s10);
        total1_10.setText(t10);

        sub2_1.setText(s11);
        total2_1.setText(t11);
        sub2_2.setText(s12);
        total2_2.setText(t12);
        sub2_3.setText(s13);
        total2_3.setText(t13);
        sub2_4.setText(s14);
        total2_4.setText(t14);
        sub2_5.setText(s15);
        total2_5.setText(t15);
        sub2_6.setText(s16);
        total2_6.setText(t16);
        sub2_7.setText(s17);
        total2_7.setText(t17);
        sub2_8.setText(s18);
        total2_8.setText(t18);
        sub2_9.setText(s19);
        total2_9.setText(t19);
        sub2_10.setText(s20);
        total2_10.setText(t20);


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


    private class GenericTextWatcher implements TextWatcher {

        private View view;
        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            // actualizar o editar los valores de la base de datos con otro tipo de logica matematica
            switch (view.getId()) {
                case R.id.edit1_1_1:
                case R.id.edit1_1_2:
                case R.id.edit1_1_3:
                    operacionFilaUno();
                    guardarDatos();
                    break;
                case R.id.edit1_2_1:
                case R.id.edit1_2_2:
                case R.id.edit1_2_3:
                    operacionFilaDos();
                    guardarDatos();
                    break;
                case R.id.edit1_3_1:
                case R.id.edit1_3_2:
                case R.id.edit1_3_3:
                    operacionFilaTres();
                    guardarDatos();
                    break;
                case R.id.edit1_4_1:
                case R.id.edit1_4_2:
                case R.id.edit1_4_3:
                    operacionFilaCuatro();
                    guardarDatos();
                    break;
                case R.id.edit1_5_1:
                case R.id.edit1_5_2:
                case R.id.edit1_5_3:
                   operacionFilaCinco();
                    guardarDatos();
                    break;
                case R.id.edit1_6_1:
                case R.id.edit1_6_2:
                case R.id.edit1_6_3:
                    operacionFilaSeis();
                    guardarDatos();
                    break;
                case R.id.edit1_7_1:
                case R.id.edit1_7_2:
                case R.id.edit1_7_3:
                    operacionFilaSiete();
                    guardarDatos();
                    break;
                case R.id.edit1_8_1:
                case R.id.edit1_8_2:
                case R.id.edit1_8_3:
                    operacionFilaOcho();
                    guardarDatos();
                    break;
                case R.id.edit1_9_1:
                case R.id.edit1_9_2:
                case R.id.edit1_9_3:
                    operacionFilaNueve();
                    guardarDatos();
                    break;
                case R.id.edit1_10_1:
                case R.id.edit1_10_2:
                case R.id.edit1_10_3:
                    operacionFilaDiez();
                    guardarDatos();
                    break;
                case R.id.edit2_1_1:
                case R.id.edit2_1_2:
                case R.id.edit2_1_3:
                    operacionFilaOnce();
                    guardarDatos();
                    break;
                case R.id.edit2_2_1:
                case R.id.edit2_2_2:
                case R.id.edit2_2_3:
                    operacionFilaDoce();
                    guardarDatos();
                    break;
                case R.id.edit2_3_1:
                case R.id.edit2_3_2:
                case R.id.edit2_3_3:
                    operacionFilaTrece();
                    guardarDatos();
                    break;
                case R.id.edit2_4_1:
                case R.id.edit2_4_2:
                case R.id.edit2_4_3:
                    operacionFilaCatorce();
                    guardarDatos();
                    break;
                case R.id.edit2_5_1:
                case R.id.edit2_5_2:
                case R.id.edit2_5_3:
                    operacionFilaQuince();
                    guardarDatos();
                    break;
                case R.id.edit2_6_1:
                case R.id.edit2_6_2:
                case R.id.edit2_6_3:
                    operacionFilaDieciseis();
                    guardarDatos();
                    break;
                case R.id.edit2_7_1:
                case R.id.edit2_7_2:
                case R.id.edit2_7_3:
                    operacionFilaDiecisiete();
                    guardarDatos();
                    break;
                case R.id.edit2_8_1:
                case R.id.edit2_8_2:
                case R.id.edit2_8_3:
                    operacionFilaDieciocho();
                    guardarDatos();
                    break;
                case R.id.edit2_9_1:
                case R.id.edit2_9_2:
                case R.id.edit2_9_3:
                    operacionFilaDiecinueve();
                    guardarDatos();
                    break;
                case R.id.edit2_10_1:
                case R.id.edit2_10_2:
                case R.id.edit2_10_3:
                    operacionFilaVeinte();
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
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
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
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
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
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_3.setText("");
            total1_3.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_3.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_2.getText().toString());
            total1_3.setText(total + "");
        }
        operacionFilaCuatro();
    }

    private void operacionFilaCuatro() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_4_1.getText().toString();
        String dos = et1_4_2.getText().toString();
        String tres = et1_4_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_4.setText("");
            total1_4.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_4.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_3.getText().toString());
            total1_4.setText(total + "");
        }
        operacionFilaCinco();
    }

    private void operacionFilaCinco() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_5_1.getText().toString();
        String dos = et1_5_2.getText().toString();
        String tres = et1_5_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_5.setText("");
            total1_5.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_5.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_4.getText().toString());
            total1_5.setText(total + "");
        }
        operacionFilaSeis();
    }

    private void operacionFilaSeis() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_6_1.getText().toString();
        String dos = et1_6_2.getText().toString();
        String tres = et1_6_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_6.setText("");
            total1_6.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_6.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_5.getText().toString());
            total1_6.setText(total + "");
        }
        operacionFilaSiete();
    }

    private void operacionFilaSiete() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_7_1.getText().toString();
        String dos = et1_7_2.getText().toString();
        String tres = et1_7_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_7.setText("");
            total1_7.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_7.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_6.getText().toString());
            total1_7.setText(total + "");
        }
        operacionFilaOcho();
    }

    private void operacionFilaOcho() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_8_1.getText().toString();
        String dos = et1_8_2.getText().toString();
        String tres = et1_8_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_8.setText("");
            total1_8.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_8.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_7.getText().toString());
            total1_8.setText(total + "");
        }
        operacionFilaNueve();
    }

    private void operacionFilaNueve() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_9_1.getText().toString();
        String dos = et1_9_2.getText().toString();
        String tres = et1_9_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_9.setText("");
            total1_9.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_9.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_8.getText().toString());
            total1_9.setText(total + "");
        }
        operacionFilaDiez();
    }

    private void operacionFilaDiez() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_10_1.getText().toString();
        String dos = et1_10_2.getText().toString();
        String tres = et1_10_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub1_10.setText("");
            total1_10.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub1_10.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_9.getText().toString());
            total1_10.setText(total + "");
        }
         operacionFilaOnce();
    }

    private void operacionFilaOnce() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_1_1.getText().toString();
        String dos = et2_1_2.getText().toString();
        String tres = et2_1_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_1.setText("");
            total2_1.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_1.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total1_10.getText().toString());
            total2_1.setText(total + "");
        }
        operacionFilaDoce();
    }

    private void operacionFilaDoce() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_2_1.getText().toString();
        String dos = et2_2_2.getText().toString();
        String tres = et2_2_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_2.setText("");
            total2_2.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_2.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_1.getText().toString());
            total2_2.setText(total + "");
        }
        operacionFilaTrece();
    }

    private void operacionFilaTrece() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_3_1.getText().toString();
        String dos = et2_3_2.getText().toString();
        String tres = et2_3_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_3.setText("");
            total2_3.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_3.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_2.getText().toString());
            total2_3.setText(total + "");
        }
        operacionFilaCatorce();
    }

    private void operacionFilaCatorce() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_4_1.getText().toString();
        String dos = et2_4_2.getText().toString();
        String tres = et2_4_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_4.setText("");
            total2_4.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_4.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_3.getText().toString());
            total2_4.setText(total + "");
        }
        operacionFilaQuince();
    }

    private void operacionFilaQuince() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_5_1.getText().toString();
        String dos = et2_5_2.getText().toString();
        String tres = et2_5_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_5.setText("");
            total2_5.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_5.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_4.getText().toString());
            total2_5.setText(total + "");
        }
        operacionFilaDieciseis();
    }

    private void operacionFilaDieciseis() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_6_1.getText().toString();
        String dos = et2_6_2.getText().toString();
        String tres = et2_6_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_6.setText("");
            total2_6.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_6.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_5.getText().toString());
            total2_6.setText(total + "");
        }
        operacionFilaDiecisiete();
    }

    private void operacionFilaDiecisiete() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_7_1.getText().toString();
        String dos = et2_7_2.getText().toString();
        String tres = et2_7_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_7.setText("");
            total2_7.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_7.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_6.getText().toString());
            total2_7.setText(total + "");
        }
        operacionFilaDieciocho();
    }

    private void operacionFilaDieciocho() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_8_1.getText().toString();
        String dos = et2_8_2.getText().toString();
        String tres = et2_8_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_8.setText("");
            total2_8.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_8.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_7.getText().toString());
            total2_8.setText(total + "");
        }
        operacionFilaDiecinueve();
    }

    private void operacionFilaDiecinueve() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_9_1.getText().toString();
        String dos = et2_9_2.getText().toString();
        String tres = et2_9_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_9.setText("");
            total2_9.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_9.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_8.getText().toString());
            total2_9.setText(total + "");
        }
        operacionFilaVeinte();
    }

    private void operacionFilaVeinte() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et2_10_1.getText().toString();
        String dos = et2_10_2.getText().toString();
        String tres = et2_10_3.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub2_10.setText("");
            total2_10.setText("");
        }else {
            int subTotal = filaResultado(fila);
            sub2_10.setText(subTotal + "");
            int total = subTotal + Integer.parseInt(total2_9.getText().toString());
            total2_10.setText(total + "");
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
            }else if(!aux.isEmpty()&& !aux.equals("M")){
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
        values.put(Utilidades.CAMPO_S1,sub1_1.getText().toString());
        values.put(Utilidades.CAMPO_T1,total1_1.getText().toString());

        values.put(Utilidades.CAMPO_N4,et1_2_1.getText().toString());
        values.put(Utilidades.CAMPO_N5,et1_2_2.getText().toString());
        values.put(Utilidades.CAMPO_N6,et1_2_3.getText().toString());
        values.put(Utilidades.CAMPO_S2,sub1_2.getText().toString());
        values.put(Utilidades.CAMPO_T2,total1_2.getText().toString());

        values.put(Utilidades.CAMPO_N7,et1_3_1.getText().toString());
        values.put(Utilidades.CAMPO_N8,et1_3_2.getText().toString());
        values.put(Utilidades.CAMPO_N9,et1_3_3.getText().toString());
        values.put(Utilidades.CAMPO_S3,sub1_3.getText().toString());
        values.put(Utilidades.CAMPO_T3,total1_3.getText().toString());

        values.put(Utilidades.CAMPO_N10,et1_4_1.getText().toString());
        values.put(Utilidades.CAMPO_N11,et1_4_2.getText().toString());
        values.put(Utilidades.CAMPO_N12,et1_4_3.getText().toString());
        values.put(Utilidades.CAMPO_S4,sub1_4.getText().toString());
        values.put(Utilidades.CAMPO_T4,total1_4.getText().toString());

        values.put(Utilidades.CAMPO_N13,et1_5_1.getText().toString());
        values.put(Utilidades.CAMPO_N14,et1_5_2.getText().toString());
        values.put(Utilidades.CAMPO_N15,et1_5_3.getText().toString());
        values.put(Utilidades.CAMPO_S5,sub1_5.getText().toString());
        values.put(Utilidades.CAMPO_T5,total1_5.getText().toString());

        values.put(Utilidades.CAMPO_N16,et1_6_1.getText().toString());
        values.put(Utilidades.CAMPO_N17,et1_6_2.getText().toString());
        values.put(Utilidades.CAMPO_N18,et1_6_3.getText().toString());
        values.put(Utilidades.CAMPO_S6,sub1_6.getText().toString());
        values.put(Utilidades.CAMPO_T6,total1_6.getText().toString());

        values.put(Utilidades.CAMPO_N19,et1_7_1.getText().toString());
        values.put(Utilidades.CAMPO_N20,et1_7_2.getText().toString());
        values.put(Utilidades.CAMPO_N21,et1_7_3.getText().toString());
        values.put(Utilidades.CAMPO_S7,sub1_7.getText().toString());
        values.put(Utilidades.CAMPO_T7,total1_7.getText().toString());

        values.put(Utilidades.CAMPO_N22,et1_8_1.getText().toString());
        values.put(Utilidades.CAMPO_N23,et1_8_2.getText().toString());
        values.put(Utilidades.CAMPO_N24,et1_8_3.getText().toString());
        values.put(Utilidades.CAMPO_S8,sub1_8.getText().toString());
        values.put(Utilidades.CAMPO_T8,total1_8.getText().toString());

        values.put(Utilidades.CAMPO_N25,et1_9_1.getText().toString());
        values.put(Utilidades.CAMPO_N26,et1_9_2.getText().toString());
        values.put(Utilidades.CAMPO_N27,et1_9_3.getText().toString());
        values.put(Utilidades.CAMPO_S9,sub1_9.getText().toString());
        values.put(Utilidades.CAMPO_T9,total1_9.getText().toString());

        values.put(Utilidades.CAMPO_N28,et1_10_1.getText().toString());
        values.put(Utilidades.CAMPO_N29,et1_10_2.getText().toString());
        values.put(Utilidades.CAMPO_N30,et1_10_3.getText().toString());
        values.put(Utilidades.CAMPO_S10,sub1_10.getText().toString());
        values.put(Utilidades.CAMPO_T10,total1_10.getText().toString());
        ///////
        values.put(Utilidades.CAMPO_N31,et2_1_1.getText().toString());
        values.put(Utilidades.CAMPO_N32,et2_1_2.getText().toString());
        values.put(Utilidades.CAMPO_N33,et2_1_3.getText().toString());
        values.put(Utilidades.CAMPO_S11,sub2_1.getText().toString());
        values.put(Utilidades.CAMPO_T11,total2_1.getText().toString());

        values.put(Utilidades.CAMPO_N34,et2_2_1.getText().toString());
        values.put(Utilidades.CAMPO_N35,et2_2_2.getText().toString());
        values.put(Utilidades.CAMPO_N36,et2_2_3.getText().toString());
        values.put(Utilidades.CAMPO_S12,sub2_2.getText().toString());
        values.put(Utilidades.CAMPO_T12,total2_2.getText().toString());

        values.put(Utilidades.CAMPO_N37,et2_3_1.getText().toString());
        values.put(Utilidades.CAMPO_N38,et2_3_2.getText().toString());
        values.put(Utilidades.CAMPO_N39,et2_3_3.getText().toString());
        values.put(Utilidades.CAMPO_S13,sub2_3.getText().toString());
        values.put(Utilidades.CAMPO_T13,total2_3.getText().toString());

        values.put(Utilidades.CAMPO_N40,et2_4_1.getText().toString());
        values.put(Utilidades.CAMPO_N41,et2_4_2.getText().toString());
        values.put(Utilidades.CAMPO_N42,et2_4_3.getText().toString());
        values.put(Utilidades.CAMPO_S14,sub2_4.getText().toString());
        values.put(Utilidades.CAMPO_T14,total2_4.getText().toString());

        values.put(Utilidades.CAMPO_N43,et2_5_1.getText().toString());
        values.put(Utilidades.CAMPO_N44,et2_5_2.getText().toString());
        values.put(Utilidades.CAMPO_N45,et2_5_3.getText().toString());
        values.put(Utilidades.CAMPO_S15,sub2_5.getText().toString());
        values.put(Utilidades.CAMPO_T15,total2_5.getText().toString());

        values.put(Utilidades.CAMPO_N46,et2_6_1.getText().toString());
        values.put(Utilidades.CAMPO_N47,et2_6_2.getText().toString());
        values.put(Utilidades.CAMPO_N48,et2_6_3.getText().toString());
        values.put(Utilidades.CAMPO_S16,sub2_6.getText().toString());
        values.put(Utilidades.CAMPO_T16,total2_6.getText().toString());

        values.put(Utilidades.CAMPO_N49,et2_7_1.getText().toString());
        values.put(Utilidades.CAMPO_N50,et2_7_2.getText().toString());
        values.put(Utilidades.CAMPO_N51,et2_7_3.getText().toString());
        values.put(Utilidades.CAMPO_S17,sub2_7.getText().toString());
        values.put(Utilidades.CAMPO_T17,total2_7.getText().toString());

        values.put(Utilidades.CAMPO_N52,et2_8_1.getText().toString());
        values.put(Utilidades.CAMPO_N53,et2_8_2.getText().toString());
        values.put(Utilidades.CAMPO_N54,et2_8_3.getText().toString());
        values.put(Utilidades.CAMPO_S18,sub2_8.getText().toString());
        values.put(Utilidades.CAMPO_T18,total2_8.getText().toString());

        values.put(Utilidades.CAMPO_N55,et2_9_1.getText().toString());
        values.put(Utilidades.CAMPO_N56,et2_9_2.getText().toString());
        values.put(Utilidades.CAMPO_N57,et2_9_3.getText().toString());
        values.put(Utilidades.CAMPO_S19,sub2_9.getText().toString());
        values.put(Utilidades.CAMPO_T19,total2_9.getText().toString());

        values.put(Utilidades.CAMPO_N58,et2_10_1.getText().toString());
        values.put(Utilidades.CAMPO_N59,et2_10_2.getText().toString());
        values.put(Utilidades.CAMPO_N60,et2_10_3.getText().toString());
        values.put(Utilidades.CAMPO_S20,sub2_10.getText().toString());
        values.put(Utilidades.CAMPO_T20,total2_10.getText().toString());

        String[] parametros1 = {idTablero.toString()};

        db.update(Utilidades.TABLA_PUNTAJE,values,Utilidades.CAMPO_IDPUNTO+" =? ",parametros1);
        db.close();
    }


    private ArrayList<String []>getPuntos(){
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v1,v2,v3,s1,t1});
        rows.add(new String[]{"2",v4,v5,v6,s2,t2});
        rows.add(new String[]{"3",v7,v8,v9,s3,t3});
        rows.add(new String[]{"4",v10,v11,v12,s4,t4});
        rows.add(new String[]{"5",v13,v14,v15,s5,t5});
        rows.add(new String[]{"6",v16,v17,v18,s6,t6});
        rows.add(new String[]{"7",v19,v20,v21,s7,t7});
        rows.add(new String[]{"8",v22,v23,v24,s8,t8});
        rows.add(new String[]{"9",v25,v26,v27,s9,t9});
        rows.add(new String[]{"10",v28,v29,v30,s10,t10});
        return rows;
    }
    private ArrayList<String []>getPuntos2(){
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v31,v32,v33,s11,t11});
        rows.add(new String[]{"2",v34,v35,v36,s12,t12});
        rows.add(new String[]{"3",v37,v38,v39,s13,t13});
        rows.add(new String[]{"4",v40,v41,v42,s14,t14});
        rows.add(new String[]{"5",v43,v44,v45,s15,t15});
        rows.add(new String[]{"6",v46,v47,v48,s16,t16});
        rows.add(new String[]{"7",v49,v50,v51,s17,t17});
        rows.add(new String[]{"8",v52,v53,v54,s18,t18});
        rows.add(new String[]{"9",v55,v56,v57,s19,t19});
        rows.add(new String[]{"10",v58,v59,v60,s20,t20});
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
            Intent intent=new Intent(TableroPuntos3.this,Estadistica.class);
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
            //template3PDF.viewPDF();
            consultar();
            consultarPuntos();
            instanciarPdf();
            //consultarPuntos();
            template3PDF.appViewPDF(this);
            Toast.makeText(TableroPuntos3.this,"El pdf se guardo en la carpeta 'Archery'",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void verTotalRonda2() {
        consultarPuntos();
        ArrayList<String> totalRonada2=new ArrayList<>();
        ArrayList<Integer> totalEnterosRonda2 =new ArrayList<>();
        totalRonada2.add(t11);
        totalRonada2.add(t12);
        totalRonada2.add(t13);
        totalRonada2.add(t14);
        totalRonada2.add(t15);
        totalRonada2.add(t16);
        totalRonada2.add(t17);
        totalRonada2.add(t18);
        totalRonada2.add(t19);
        totalRonada2.add(t20);

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
        totalRonda1.add(t7);
        totalRonda1.add(t8);
        totalRonda1.add(t9);
        totalRonda1.add(t10);

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
        total.add(t13);
        total.add(t14);
        total.add(t15);
        total.add(t16);
        total.add(t17);
        total.add(t18);
        total.add(t19);
        total.add(t20);

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
    //para que el boton de ir asia atraz del celular no funcione
    @Override
    public void onBackPressed(){

    }
}

