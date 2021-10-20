package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TableroPuntos extends AppCompatActivity {

    private EditText et1_1,et1_2,et1_3,et1_4,et1_5,et1_6,et2_1,et2_2,et2_3,et2_4,et2_5,et2_6,et3_1,et3_2,et3_3,et3_4,et3_5,et3_6,et4_1,et4_2,et4_3,et4_4,et4_5,et4_6,et5_1,et5_2,et5_3,et5_4,et5_5,et5_6,et6_1,et6_2,et6_3,et6_4,et6_5,et6_6,
            et2_1_1,et2_1_2,et2_1_3,et2_1_4,et2_1_5,et2_1_6,et2_2_1,et2_2_2,et2_2_3,et2_2_4,et2_2_5,et2_2_6,et2_3_1,et2_3_2,et2_3_3,et2_3_4,et2_3_5,et2_3_6,et2_4_1,et2_4_2,et2_4_3,et2_4_4,et2_4_5,et2_4_6,et2_5_1,et2_5_2,et2_5_3,et2_5_4,et2_5_5,et2_5_6,et2_6_1,et2_6_2,et2_6_3,et2_6_4,et2_6_5,et2_6_6,
            et3_1_1,et3_1_2,et3_1_3,et3_1_4,et3_1_5,et3_1_6,et3_2_1,et3_2_2,et3_2_3,et3_2_4,et3_2_5,et3_2_6,et3_3_1,et3_3_2,et3_3_3,et3_3_4,et3_3_5,et3_3_6,et3_4_1,et3_4_2,et3_4_3,et3_4_4,et3_4_5,et3_4_6,et3_5_1,et3_5_2,et3_5_3,et3_5_4,et3_5_5,et3_5_6,et3_6_1,et3_6_2,et3_6_3,et3_6_4,et3_6_5,et3_6_6,
            et4_1_1,et4_1_2,et4_1_3,et4_1_4,et4_1_5,et4_1_6,et4_2_1,et4_2_2,et4_2_3,et4_2_4,et4_2_5,et4_2_6,et4_3_1,et4_3_2,et4_3_3,et4_3_4,et4_3_5,et4_3_6,et4_4_1,et4_4_2,et4_4_3,et4_4_4,et4_4_5,et4_4_6,et4_5_1,et4_5_2,et4_5_3,et4_5_4,et4_5_5,et4_5_6,et4_6_1,et4_6_2,et4_6_3,et4_6_4,et4_6_5,et4_6_6;
    private TextView sub1_1,total1_1,sub1_2,total1_2,sub1_3,total1_3,sub1_4,total1_4,sub1_5,total1_5,sub1_6,total1_6,
                     sub2_1,total2_1,sub2_2,total2_2,sub2_3,total2_3,sub2_4,total2_4,sub2_5,total2_5,sub2_6,total2_6,
                     sub3_1,total3_1,sub3_2,total3_2,sub3_3,total3_3,sub3_4,total3_4,sub3_5,total3_5,sub3_6,total3_6,
                     sub4_1,total4_1,sub4_2,total4_2,sub4_3,total4_3,sub4_4,total4_4,sub4_5,total4_5,sub4_6,total4_6;

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
            v61,v62,v63,v64,v65,v66,v67,v68,v69,v70,v71,v72,v73,v74,v75,v76,v77,v78,v79,v80,
            v81,v82,v83,v84,v85,v86,v87,v88,v89,v90,v91,v92,v93,v94,v95,v96,v97,v98,v99,v100,
            v101,v102,v103,v104,v105,v106,v107,v108,v109,v110,v111,v112,v113,v114,v115,v116,v117,v118,v119,v120,
            v121,v122,v123,v124,v125,v126,v127,v128,v129,v130,v131,v132,v133,v134,v135,v136,v137,v138,v139,v140,
            v141,v142,v143,v144,
            s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,
            t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24;
    int cantidadDisparos=144;
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
    int ronda3=0;
    int ronda4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero_puntos);
        // flecha ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        con= new AdminSQLiteOpenHelper(getApplicationContext(),Utilidades.NOMBRE_BD,null,1);
        idTablero = getIntent().getLongExtra("idTablero",100);
        idRonda = getIntent().getLongExtra("idRonda",100);
        deLista = getIntent().getBooleanExtra("deLista",false);

        aniadirAccionesEInstancias();
        habilitarTeclado();



        if(deLista) {
            Toast.makeText(getApplicationContext(), "entro de lista", Toast.LENGTH_LONG).show();
            consultarPuntos();
            consultar();
        }


    }

    private void habilitarTeclado() {

        primeraRonda();
        segundaRonda();
        terceraRonda();
        cuartaRonda();
    }

    private void primeraRonda() {
        et1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic1_1 = et1_1.onCreateInputConnection(new EditorInfo());
                    et1_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_1);
                }
            }
        });
        et1_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_2=et1_2.onCreateInputConnection(new EditorInfo());
                    et1_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_2);
                }
            }
        });
        et1_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_3=et1_3.onCreateInputConnection(new EditorInfo());
                    et1_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_3);
                }
            }
        });
        et1_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_4=et1_4.onCreateInputConnection(new EditorInfo());
                    et1_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_4);
                }
            }
        });
        et1_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_5=et1_5.onCreateInputConnection(new EditorInfo());
                    et1_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_5);
                }
            }
        });
        et1_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic1_6=et1_6.onCreateInputConnection(new EditorInfo());
                    et1_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic1_6);
                }
            }
        });
        et2_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_1=et2_1.onCreateInputConnection(new EditorInfo());
                    et2_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_1);
                }
            }
        });
        et2_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_2=et2_2.onCreateInputConnection(new EditorInfo());
                    et2_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_2);
                }
            }
        });
        et2_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_3=et2_3.onCreateInputConnection(new EditorInfo());
                    et2_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_3);
                }
            }
        });
        et2_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_4=et2_4.onCreateInputConnection(new EditorInfo());
                    et2_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_4);
                }
            }
        });
        et2_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_5=et2_5.onCreateInputConnection(new EditorInfo());
                    et2_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_5);
                }
            }
        });
        et2_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic2_6=et2_6.onCreateInputConnection(new EditorInfo());
                    et2_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic2_6);
                }
            }
        });

        et3_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_1=et3_1.onCreateInputConnection(new EditorInfo());
                    et3_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1);
                }
            }
        });
        et3_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_2=et3_2.onCreateInputConnection(new EditorInfo());
                    et3_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2);
                }
            }
        });
        et3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_3=et3_3.onCreateInputConnection(new EditorInfo());
                    et3_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3);
                }
            }
        });
        et3_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_4=et3_4.onCreateInputConnection(new EditorInfo());
                    et3_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4);
                }
            }
        });
        et3_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_5=et3_5.onCreateInputConnection(new EditorInfo());
                    et3_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5);
                }
            }
        });
        et3_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_6=et3_6.onCreateInputConnection(new EditorInfo());
                    et3_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6);
                }
            }
        });

        et4_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_1=et4_1.onCreateInputConnection(new EditorInfo());
                    et4_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1);
                }
            }
        });
        et4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_2=et4_2.onCreateInputConnection(new EditorInfo());
                    et4_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2);
                }
            }
        });
        et4_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_3=et4_3.onCreateInputConnection(new EditorInfo());
                    et4_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3);
                }
            }
        });
        et4_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_4=et4_4.onCreateInputConnection(new EditorInfo());
                    et4_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4);
                }
            }
        });
        et4_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_5=et4_5.onCreateInputConnection(new EditorInfo());
                    et4_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5);
                }
            }
        });
        et4_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_6=et4_6.onCreateInputConnection(new EditorInfo());
                    et4_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6);
                }
            }
        });

        et5_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic5_1=et5_1.onCreateInputConnection(new EditorInfo());
                    et5_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic5_1);
                }
            }
        });
        et5_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic5_2=et5_2.onCreateInputConnection(new EditorInfo());
                    et5_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic5_2);
                }
            }
        });
        et5_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic5_3=et5_3.onCreateInputConnection(new EditorInfo());
                    et5_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic5_3);
                }
            }
        });
        et5_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic5_4=et5_4.onCreateInputConnection(new EditorInfo());
                    et5_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic5_4);
                }
            }
        });
        et5_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic5_5=et5_5.onCreateInputConnection(new EditorInfo());
                    et5_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic5_5);
                }
            }
        });
        et5_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic5_6=et5_6.onCreateInputConnection(new EditorInfo());
                    et5_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic5_6);
                }
            }
        });

        et6_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic6_1=et6_1.onCreateInputConnection(new EditorInfo());
                    et6_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic6_1);
                }
            }
        });
        et6_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic6_2=et6_2.onCreateInputConnection(new EditorInfo());
                    et6_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic6_2);
                }
            }
        });
        et6_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic6_3=et6_3.onCreateInputConnection(new EditorInfo());
                    et6_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic6_3);
                }
            }
        });
        et6_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic6_4=et6_4.onCreateInputConnection(new EditorInfo());
                    et6_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic6_4);
                }
            }
        });
        et6_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic6_5=et6_5.onCreateInputConnection(new EditorInfo());
                    et6_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic6_5);
                }
            }
        });
        et6_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic6_6=et6_6.onCreateInputConnection(new EditorInfo());
                    et6_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic6_6);
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
                if (hasFocus) {
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
    private void terceraRonda() {
        et3_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic3_1_1=et3_1_1.onCreateInputConnection(new EditorInfo());
                    et3_1_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1_1);
                }
            }
        });
        et3_1_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_1_2=et3_1_2.onCreateInputConnection(new EditorInfo());
                    et3_1_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1_2);
                }
            }
        });
        et3_1_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_1_3=et3_1_3.onCreateInputConnection(new EditorInfo());
                    et3_1_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1_3);
                }
            }
        });
        et3_1_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_1_4=et3_1_4.onCreateInputConnection(new EditorInfo());
                    et3_1_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1_4);
                }
            }
        });
        et3_1_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_1_5=et3_1_5.onCreateInputConnection(new EditorInfo());
                    et3_1_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1_5);
                }
            }
        });
        et3_1_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_1_6=et3_1_6.onCreateInputConnection(new EditorInfo());
                    et3_1_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_1_6);
                }
            }
        });

        et3_2_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic3_2_1=et3_2_1.onCreateInputConnection(new EditorInfo());
                    et3_2_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2_1);
                }
            }
        });
        et3_2_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_2_2=et3_2_2.onCreateInputConnection(new EditorInfo());
                    et3_2_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2_2);
                }
            }
        });
        et3_2_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_2_3=et3_2_3.onCreateInputConnection(new EditorInfo());
                    et3_2_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2_3);
                }
            }
        });
        et3_2_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_2_4=et3_2_4.onCreateInputConnection(new EditorInfo());
                    et3_2_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2_4);
                }
            }
        });
        et3_2_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_2_5=et3_2_5.onCreateInputConnection(new EditorInfo());
                    et3_2_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2_5);
                }
            }
        });
        et3_2_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_2_6=et3_2_6.onCreateInputConnection(new EditorInfo());
                    et3_2_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_2_6);
                }
            }
        });

        et3_3_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic3_3_1=et3_3_1.onCreateInputConnection(new EditorInfo());
                    et3_3_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3_1);
                }
            }
        });
        et3_3_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_3_2=et3_3_2.onCreateInputConnection(new EditorInfo());
                    et3_3_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3_2);
                }
            }
        });
        et3_3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_3_3=et3_3_3.onCreateInputConnection(new EditorInfo());
                    et3_3_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3_3);
                }
            }
        });
        et3_3_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_3_4=et3_3_4.onCreateInputConnection(new EditorInfo());
                    et3_3_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3_4);
                }
            }
        });
        et3_3_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_3_5=et3_3_5.onCreateInputConnection(new EditorInfo());
                    et3_3_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3_5);
                }
            }
        });
        et3_3_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_3_6=et3_3_6.onCreateInputConnection(new EditorInfo());
                    et3_3_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_3_6);
                }
            }
        });

        et3_4_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic3_4_1=et3_4_1.onCreateInputConnection(new EditorInfo());
                    et3_4_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4_1);
                }
            }
        });
        et3_4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_4_2=et3_4_2.onCreateInputConnection(new EditorInfo());
                    et3_4_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4_2);
                }
            }
        });
        et3_4_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_4_3=et3_4_3.onCreateInputConnection(new EditorInfo());
                    et3_4_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4_3);
                }
            }
        });
        et3_4_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_4_4=et3_4_4.onCreateInputConnection(new EditorInfo());
                    et3_4_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4_4);
                }
            }
        });
        et3_4_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_4_5=et3_4_5.onCreateInputConnection(new EditorInfo());
                    et3_4_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4_5);
                }
            }
        });
        et3_4_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_4_6=et3_4_6.onCreateInputConnection(new EditorInfo());
                    et3_4_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_4_6);
                }
            }
        });

        et3_5_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic3_5_1=et3_5_1.onCreateInputConnection(new EditorInfo());
                    et3_5_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5_1);
                }
            }
        });
        et3_5_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_5_2=et3_5_2.onCreateInputConnection(new EditorInfo());
                    et3_5_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5_2);
                }
            }
        });
        et3_5_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_5_3=et3_5_3.onCreateInputConnection(new EditorInfo());
                    et3_5_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5_3);
                }
            }
        });
        et3_5_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_5_4=et3_5_4.onCreateInputConnection(new EditorInfo());
                    et3_5_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5_4);
                }
            }
        });
        et3_5_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_5_5=et3_5_5.onCreateInputConnection(new EditorInfo());
                    et3_5_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5_5);
                }
            }
        });
        et3_5_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_5_6=et3_5_6.onCreateInputConnection(new EditorInfo());
                    et3_5_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_5_6);
                }
            }
        });

        et3_6_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic3_6_1=et3_6_1.onCreateInputConnection(new EditorInfo());
                    et3_6_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6_1);
                }
            }
        });
        et3_6_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_6_2=et3_6_2.onCreateInputConnection(new EditorInfo());
                    et3_6_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6_2);
                }
            }
        });
        et3_6_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_6_3=et3_6_3.onCreateInputConnection(new EditorInfo());
                    et3_6_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6_3);
                }
            }
        });
        et3_6_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_6_4=et3_6_4.onCreateInputConnection(new EditorInfo());
                    et3_6_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6_4);
                }
            }
        });
        et3_6_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_6_5=et3_6_5.onCreateInputConnection(new EditorInfo());
                    et3_6_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6_5);
                }
            }
        });
        et3_6_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic3_6_6=et3_6_6.onCreateInputConnection(new EditorInfo());
                    et3_6_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic3_6_6);
                }
            }
        });

    }
    private void cuartaRonda() {
        et4_1_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic4_1_1=et4_1_1.onCreateInputConnection(new EditorInfo());
                    et4_1_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1_1);
                }
            }
        });
        et4_1_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_1_2=et4_1_2.onCreateInputConnection(new EditorInfo());
                    et4_1_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1_2);
                }
            }
        });
        et4_1_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_1_3=et4_1_3.onCreateInputConnection(new EditorInfo());
                    et4_1_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1_3);
                }
            }
        });
        et4_1_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_1_4=et4_1_4.onCreateInputConnection(new EditorInfo());
                    et4_1_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1_4);
                }
            }
        });
        et4_1_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_1_5=et4_1_5.onCreateInputConnection(new EditorInfo());
                    et4_1_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1_5);
                }
            }
        });
        et4_1_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_1_6=et4_1_6.onCreateInputConnection(new EditorInfo());
                    et4_1_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_1_6);
                }
            }
        });

        et4_2_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic4_2_1=et4_2_1.onCreateInputConnection(new EditorInfo());
                    et4_2_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2_1);
                }
            }
        });
        et4_2_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_2_2=et4_2_2.onCreateInputConnection(new EditorInfo());
                    et4_2_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2_2);
                }
            }
        });
        et4_2_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_2_3=et4_2_3.onCreateInputConnection(new EditorInfo());
                    et4_2_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2_3);
                }
            }
        });
        et4_2_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_2_4=et4_2_4.onCreateInputConnection(new EditorInfo());
                    et4_2_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2_4);
                }
            }
        });
        et4_2_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_2_5=et4_2_5.onCreateInputConnection(new EditorInfo());
                    et4_2_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2_5);
                }
            }
        });
        et4_2_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_2_6=et4_2_6.onCreateInputConnection(new EditorInfo());
                    et4_2_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_2_6);
                }
            }
        });

        et4_3_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic4_3_1=et4_3_1.onCreateInputConnection(new EditorInfo());
                    et4_3_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3_1);
                }
            }
        });
        et4_3_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_3_2=et4_3_2.onCreateInputConnection(new EditorInfo());
                    et4_3_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3_2);
                }
            }
        });
        et4_3_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_3_3=et4_3_3.onCreateInputConnection(new EditorInfo());
                    et4_3_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3_3);
                }
            }
        });
        et4_3_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_3_4=et4_3_4.onCreateInputConnection(new EditorInfo());
                    et4_3_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3_4);
                }
            }
        });
        et4_3_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_3_5=et4_3_5.onCreateInputConnection(new EditorInfo());
                    et4_3_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3_5);
                }
            }
        });
        et4_3_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_3_6=et4_3_6.onCreateInputConnection(new EditorInfo());
                    et4_3_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_3_6);
                }
            }
        });

        et4_4_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic4_4_1=et4_4_1.onCreateInputConnection(new EditorInfo());
                    et4_4_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4_1);
                }
            }
        });
        et4_4_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_4_2=et4_4_2.onCreateInputConnection(new EditorInfo());
                    et4_4_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4_2);
                }
            }
        });
        et4_4_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_4_3=et4_4_3.onCreateInputConnection(new EditorInfo());
                    et4_4_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4_3);
                }
            }
        });
        et4_4_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_4_4=et4_4_4.onCreateInputConnection(new EditorInfo());
                    et4_4_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4_4);
                }
            }
        });
        et4_4_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_4_5=et4_4_5.onCreateInputConnection(new EditorInfo());
                    et4_4_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4_5);
                }
            }
        });
        et4_4_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_4_6=et4_4_6.onCreateInputConnection(new EditorInfo());
                    et4_4_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_4_6);
                }
            }
        });

        et4_5_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic4_5_1=et4_5_1.onCreateInputConnection(new EditorInfo());
                    et4_5_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5_1);
                }
            }
        });
        et4_5_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_5_2=et4_5_2.onCreateInputConnection(new EditorInfo());
                    et4_5_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5_2);
                }
            }
        });
        et4_5_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_5_3=et4_5_3.onCreateInputConnection(new EditorInfo());
                    et4_5_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5_3);
                }
            }
        });
        et4_5_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_5_4=et4_5_4.onCreateInputConnection(new EditorInfo());
                    et4_5_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5_4);
                }
            }
        });
        et4_5_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_5_5=et4_5_5.onCreateInputConnection(new EditorInfo());
                    et4_5_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5_5);
                }
            }
        });
        et4_5_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_5_6=et4_5_6.onCreateInputConnection(new EditorInfo());
                    et4_5_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_5_6);
                }
            }
        });

        et4_6_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputConnection ic4_6_1=et4_6_1.onCreateInputConnection(new EditorInfo());
                    et4_6_1.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6_1);
                }
            }
        });
        et4_6_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_6_2=et4_6_2.onCreateInputConnection(new EditorInfo());
                    et4_6_2.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6_2);
                }
            }
        });
        et4_6_3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_6_3=et4_6_3.onCreateInputConnection(new EditorInfo());
                    et4_6_3.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6_3);
                }
            }
        });
        et4_6_4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_6_4=et4_6_4.onCreateInputConnection(new EditorInfo());
                    et4_6_4.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6_4);
                }
            }
        });
        et4_6_5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_6_5=et4_6_5.onCreateInputConnection(new EditorInfo());
                    et4_6_5.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6_5);
                }
            }
        });
        et4_6_6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    InputConnection ic4_6_6=et4_6_6.onCreateInputConnection(new EditorInfo());
                    et4_6_6.setInputType(InputType.TYPE_NULL);
                    keyboard.setInputConnection(ic4_6_6);
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
                ,Utilidades.CAMPO_N71,Utilidades.CAMPO_N72,Utilidades.CAMPO_N73,Utilidades.CAMPO_N74,Utilidades.CAMPO_N75,Utilidades.CAMPO_N76,Utilidades.CAMPO_N77,Utilidades.CAMPO_N78,Utilidades.CAMPO_N79,Utilidades.CAMPO_N80
                ,Utilidades.CAMPO_N81,Utilidades.CAMPO_N82,Utilidades.CAMPO_N83,Utilidades.CAMPO_N84,Utilidades.CAMPO_N85,Utilidades.CAMPO_N86,Utilidades.CAMPO_N87,Utilidades.CAMPO_N88,Utilidades.CAMPO_N89,Utilidades.CAMPO_N90
                ,Utilidades.CAMPO_N91,Utilidades.CAMPO_N92,Utilidades.CAMPO_N93,Utilidades.CAMPO_N94,Utilidades.CAMPO_N95,Utilidades.CAMPO_N96,Utilidades.CAMPO_N97,Utilidades.CAMPO_N98,Utilidades.CAMPO_N99,Utilidades.CAMPO_N100
                ,Utilidades.CAMPO_N101,Utilidades.CAMPO_N102,Utilidades.CAMPO_N103,Utilidades.CAMPO_N104,Utilidades.CAMPO_N105,Utilidades.CAMPO_N106,Utilidades.CAMPO_N107,Utilidades.CAMPO_N108,Utilidades.CAMPO_N109,Utilidades.CAMPO_N110
                ,Utilidades.CAMPO_N111,Utilidades.CAMPO_N112,Utilidades.CAMPO_N113,Utilidades.CAMPO_N114,Utilidades.CAMPO_N115,Utilidades.CAMPO_N116,Utilidades.CAMPO_N117,Utilidades.CAMPO_N118,Utilidades.CAMPO_N119,Utilidades.CAMPO_N120
                ,Utilidades.CAMPO_N121,Utilidades.CAMPO_N122,Utilidades.CAMPO_N123,Utilidades.CAMPO_N124,Utilidades.CAMPO_N125,Utilidades.CAMPO_N126,Utilidades.CAMPO_N127,Utilidades.CAMPO_N128,Utilidades.CAMPO_N129,Utilidades.CAMPO_N130
                ,Utilidades.CAMPO_N131,Utilidades.CAMPO_N132,Utilidades.CAMPO_N133,Utilidades.CAMPO_N134,Utilidades.CAMPO_N135,Utilidades.CAMPO_N136,Utilidades.CAMPO_N137,Utilidades.CAMPO_N138,Utilidades.CAMPO_N139,Utilidades.CAMPO_N140
                ,Utilidades.CAMPO_N141,Utilidades.CAMPO_N142,Utilidades.CAMPO_N143,Utilidades.CAMPO_N144

                ,Utilidades.CAMPO_S1,Utilidades.CAMPO_S2,Utilidades.CAMPO_S3,Utilidades.CAMPO_S4,Utilidades.CAMPO_S5,Utilidades.CAMPO_S6,Utilidades.CAMPO_S7,Utilidades.CAMPO_S8,Utilidades.CAMPO_S9,Utilidades.CAMPO_S10
                ,Utilidades.CAMPO_S11,Utilidades.CAMPO_S12,Utilidades.CAMPO_S13,Utilidades.CAMPO_S14,Utilidades.CAMPO_S15,Utilidades.CAMPO_S16,Utilidades.CAMPO_S17,Utilidades.CAMPO_S18,Utilidades.CAMPO_S19,Utilidades.CAMPO_S20
                ,Utilidades.CAMPO_S21,Utilidades.CAMPO_S22,Utilidades.CAMPO_S23,Utilidades.CAMPO_S24

                ,Utilidades.CAMPO_T1,Utilidades.CAMPO_T2,Utilidades.CAMPO_T3,Utilidades.CAMPO_T4,Utilidades.CAMPO_T5,Utilidades.CAMPO_T6,Utilidades.CAMPO_T7,Utilidades.CAMPO_T8,Utilidades.CAMPO_T9,Utilidades.CAMPO_T10
                ,Utilidades.CAMPO_T11,Utilidades.CAMPO_T12,Utilidades.CAMPO_T13,Utilidades.CAMPO_T14,Utilidades.CAMPO_T15,Utilidades.CAMPO_T16,Utilidades.CAMPO_T17,Utilidades.CAMPO_T18,Utilidades.CAMPO_T19,Utilidades.CAMPO_T20
                ,Utilidades.CAMPO_T21,Utilidades.CAMPO_T22,Utilidades.CAMPO_T23,Utilidades.CAMPO_T24};
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
            v73=cursor.getString(73);
            v74=cursor.getString(74);
            v75=cursor.getString(75);
            v76=cursor.getString(76);
            v77=cursor.getString(77);
            v78=cursor.getString(78);
            v79=cursor.getString(79);
            v80=cursor.getString(80);
            v81=cursor.getString(81);
            v82=cursor.getString(82);
            v83=cursor.getString(83);
            v84=cursor.getString(84);
            v85=cursor.getString(85);
            v86=cursor.getString(86);
            v87=cursor.getString(87);
            v88=cursor.getString(88);
            v89=cursor.getString(89);
            v90=cursor.getString(90);
            v91=cursor.getString(91);
            v92=cursor.getString(92);
            v93=cursor.getString(93);
            v94=cursor.getString(94);
            v95=cursor.getString(95);
            v96=cursor.getString(96);
            v97=cursor.getString(97);
            v98=cursor.getString(98);
            v99=cursor.getString(99);
            v100=cursor.getString(100);
            v101=cursor.getString(101);
            v102=cursor.getString(102);
            v103=cursor.getString(103);
            v104=cursor.getString(104);
            v105=cursor.getString(105);
            v106=cursor.getString(106);
            v107=cursor.getString(107);
            v108=cursor.getString(108);
            v109=cursor.getString(109);
            v110=cursor.getString(110);
            v111=cursor.getString(111);
            v112=cursor.getString(112);
            v113=cursor.getString(113);
            v114=cursor.getString(114);
            v115=cursor.getString(115);
            v116=cursor.getString(116);
            v117=cursor.getString(117);
            v118=cursor.getString(118);
            v119=cursor.getString(119);
            v120=cursor.getString(120);
            v121=cursor.getString(121);
            v122=cursor.getString(122);
            v123=cursor.getString(123);
            v124=cursor.getString(124);
            v125=cursor.getString(125);
            v126=cursor.getString(126);
            v127=cursor.getString(127);
            v128=cursor.getString(128);
            v129=cursor.getString(129);
            v130=cursor.getString(130);
            v131=cursor.getString(131);
            v132=cursor.getString(132);
            v133=cursor.getString(133);
            v134=cursor.getString(134);
            v135=cursor.getString(135);
            v136=cursor.getString(136);
            v137=cursor.getString(137);
            v138=cursor.getString(138);
            v139=cursor.getString(139);
            v140=cursor.getString(140);
            v141=cursor.getString(141);
            v142=cursor.getString(142);
            v143=cursor.getString(143);
            v144=cursor.getString(144);

            s1=cursor.getString(145);
            s2=cursor.getString(146);
            s3=cursor.getString(147);
            s4=cursor.getString(148);
            s5=cursor.getString(149);
            s6=cursor.getString(150);
            s7=cursor.getString(151);
            s8=cursor.getString(152);
            s9=cursor.getString(153);
            s10=cursor.getString(154);
            s11=cursor.getString(155);
            s12=cursor.getString(156);
            s13=cursor.getString(157);
            s14=cursor.getString(158);
            s15=cursor.getString(159);
            s16=cursor.getString(160);
            s17=cursor.getString(161);
            s18=cursor.getString(162);
            s19=cursor.getString(163);
            s20=cursor.getString(164);
            s21=cursor.getString(165);
            s22=cursor.getString(166);
            s23=cursor.getString(167);
            s24=cursor.getString(168);

            t1=cursor.getString(169);
            t2=cursor.getString(170);
            t3=cursor.getString(171);
            t4=cursor.getString(172);
            t5=cursor.getString(173);
            t6=cursor.getString(174);
            t7=cursor.getString(175);
            t8=cursor.getString(176);
            t9=cursor.getString(177);
            t10=cursor.getString(178);
            t11=cursor.getString(179);
            t12=cursor.getString(180);
            t13=cursor.getString(181);
            t14=cursor.getString(182);
            t15=cursor.getString(183);
            t16=cursor.getString(184);
            t17=cursor.getString(185);
            t18=cursor.getString(186);
            t19=cursor.getString(187);
            t20=cursor.getString(188);
            t21=cursor.getString(189);
            t22=cursor.getString(190);
            t23=cursor.getString(191);
            t24=cursor.getString(192);

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
        et1_1.setText(v1);
        et1_2.setText(v2);
        et1_3.setText(v3);
        et1_4.setText(v4);
        et1_5.setText(v5);
        et1_6.setText(v6);
        et2_1.setText(v7);
        et2_2.setText(v8);
        et2_3.setText(v9);
        et2_4.setText(v10);
        et2_5.setText(v11);
        et2_6.setText(v12);
        et3_1.setText(v13);
        et3_2.setText(v14);
        et3_3.setText(v15);
        et3_4.setText(v16);
        et3_5.setText(v17);
        et3_6.setText(v18);
        et4_1.setText(v19);
        et4_2.setText(v20);
        et4_3.setText(v21);
        et4_4.setText(v22);
        et4_5.setText(v23);
        et4_6.setText(v24);
        et5_1.setText(v25);
        et5_2.setText(v26);
        et5_3.setText(v27);
        et5_4.setText(v28);
        et5_5.setText(v29);
        et5_6.setText(v30);
        et6_1.setText(v31);
        et6_2.setText(v32);
        et6_3.setText(v33);
        et6_4.setText(v34);
        et6_5.setText(v35);
        et6_6.setText(v36);

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

        et3_1_1.setText(v73);
        et3_1_2.setText(v74);
        et3_1_3.setText(v75);
        et3_1_4.setText(v76);
        et3_1_5.setText(v77);
        et3_1_6.setText(v78);
        et3_2_1.setText(v79);
        et3_2_2.setText(v80);
        et3_2_3.setText(v81);
        et3_2_4.setText(v82);
        et3_2_5.setText(v83);
        et3_2_6.setText(v84);
        et3_3_1.setText(v85);
        et3_3_2.setText(v86);
        et3_3_3.setText(v87);
        et3_3_4.setText(v88);
        et3_3_5.setText(v89);
        et3_3_6.setText(v90);
        et3_4_1.setText(v91);
        et3_4_2.setText(v92);
        et3_4_3.setText(v93);
        et3_4_4.setText(v94);
        et3_4_5.setText(v95);
        et3_4_6.setText(v96);
        et3_5_1.setText(v97);
        et3_5_2.setText(v98);
        et3_5_3.setText(v99);
        et3_5_4.setText(v100);
        et3_5_5.setText(v101);
        et3_5_6.setText(v102);
        et3_6_1.setText(v103);
        et3_6_2.setText(v104);
        et3_6_3.setText(v105);
        et3_6_4.setText(v106);
        et3_6_5.setText(v107);
        et3_6_6.setText(v108);

        et4_1_1.setText(v109);
        et4_1_2.setText(v110);
        et4_1_3.setText(v111);
        et4_1_4.setText(v112);
        et4_1_5.setText(v113);
        et4_1_6.setText(v114);
        et4_2_1.setText(v115);
        et4_2_2.setText(v116);
        et4_2_3.setText(v117);
        et4_2_4.setText(v118);
        et4_2_5.setText(v119);
        et4_2_6.setText(v120);
        et4_3_1.setText(v121);
        et4_3_2.setText(v122);
        et4_3_3.setText(v123);
        et4_3_4.setText(v124);
        et4_3_5.setText(v125);
        et4_3_6.setText(v126);
        et4_4_1.setText(v127);
        et4_4_2.setText(v128);
        et4_4_3.setText(v129);
        et4_4_4.setText(v130);
        et4_4_5.setText(v131);
        et4_4_6.setText(v132);
        et4_5_1.setText(v133);
        et4_5_2.setText(v134);
        et4_5_3.setText(v135);
        et4_5_4.setText(v136);
        et4_5_5.setText(v137);
        et4_5_6.setText(v138);
        et4_6_1.setText(v139);
        et4_6_2.setText(v140);
        et4_6_3.setText(v141);
        et4_6_4.setText(v142);
        et4_6_5.setText(v143);
        et4_6_6.setText(v144);

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
        sub3_1.setText(s13);
        total3_1.setText(t13);
        sub3_2.setText(s14);
        total3_2.setText(t14);
        sub3_3.setText(s15);
        total3_3.setText(t15);
        sub3_4.setText(s16);
        total3_4.setText(t16);
        sub3_5.setText(s17);
        total3_5.setText(t17);
        sub3_6.setText(s18);
        total3_6.setText(t18);
        sub4_1.setText(s19);
        total4_1.setText(t19);
        sub4_2.setText(s20);
        total4_2.setText(t20);
        sub4_3.setText(s21);
        total4_3.setText(t21);
        sub4_4.setText(s22);
        total4_4.setText(t22);
        sub4_5.setText(s23);
        total4_5.setText(t23);
        sub4_6.setText(s24);
        total4_6.setText(t24);

    }

    private void aniadirAccionesEInstancias() {
        keyboard=(MyKeyboard) findViewById(R.id.keyboard);
        et1_1=(EditText) findViewById(R.id.editText1_1);
        et1_2=(EditText) findViewById(R.id.editText1_2);
        et1_3=(EditText) findViewById(R.id.editText1_3);
        et1_4=(EditText) findViewById(R.id.editText1_4);
        et1_5=(EditText) findViewById(R.id.editText1_5);
        et1_6=(EditText) findViewById(R.id.editText1_6);
        sub1_1=(TextView) findViewById(R.id.textViewSubTotal1);
        total1_1=(TextView) findViewById(R.id.textViewTotal1);

        et1_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et1_1));
        et1_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et1_2));
        et1_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et1_3));
        et1_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et1_4));
        et1_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et1_5));
        et1_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et1_6));

        et2_1=(EditText) findViewById(R.id.editText2_1);
        et2_2=(EditText) findViewById(R.id.editText2_2);
        et2_3=(EditText) findViewById(R.id.editText2_3);
        et2_4=(EditText) findViewById(R.id.editText2_4);
        et2_5=(EditText) findViewById(R.id.editText2_5);
        et2_6=(EditText) findViewById(R.id.editText2_6);
        sub1_2=(TextView) findViewById(R.id.textViewSubTotal2);
        total1_2=(TextView) findViewById(R.id.textViewTotal2);

        et2_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1));
        et2_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2));
        et2_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3));
        et2_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4));
        et2_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5));
        et2_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6));

        et3_1=(EditText) findViewById(R.id.editText3_1);
        et3_2=(EditText) findViewById(R.id.editText3_2);
        et3_3=(EditText) findViewById(R.id.editText3_3);
        et3_4=(EditText) findViewById(R.id.editText3_4);
        et3_5=(EditText) findViewById(R.id.editText3_5);
        et3_6=(EditText) findViewById(R.id.editText3_6);
        sub1_3=(TextView) findViewById(R.id.textViewSubTotal3);
        total1_3=(TextView) findViewById(R.id.textViewTotal3);

        et3_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1));
        et3_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2));
        et3_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3));
        et3_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4));
        et3_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5));
        et3_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6));

        et4_1=(EditText) findViewById(R.id.editText4_1);
        et4_2=(EditText) findViewById(R.id.editText4_2);
        et4_3=(EditText) findViewById(R.id.editText4_3);
        et4_4=(EditText) findViewById(R.id.editText4_4);
        et4_5=(EditText) findViewById(R.id.editText4_5);
        et4_6=(EditText) findViewById(R.id.editText4_6);
        sub1_4=(TextView) findViewById(R.id.textViewSubTotal4);
        total1_4=(TextView) findViewById(R.id.textViewTotal4);

        et4_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1));
        et4_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2));
        et4_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3));
        et4_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4));
        et4_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5));
        et4_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6));

        et5_1=(EditText) findViewById(R.id.editText5_1);
        et5_2=(EditText) findViewById(R.id.editText5_2);
        et5_3=(EditText) findViewById(R.id.editText5_3);
        et5_4=(EditText) findViewById(R.id.editText5_4);
        et5_5=(EditText) findViewById(R.id.editText5_5);
        et5_6=(EditText) findViewById(R.id.editText5_6);
        sub1_5=(TextView) findViewById(R.id.textViewSubTotal5);
        total1_5=(TextView) findViewById(R.id.textViewTotal5);

        et5_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et5_1));
        et5_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et5_2));
        et5_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et5_3));
        et5_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et5_4));
        et5_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et5_5));
        et5_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et5_6));

        et6_1=(EditText) findViewById(R.id.editText6_1);
        et6_2=(EditText) findViewById(R.id.editText6_2);
        et6_3=(EditText) findViewById(R.id.editText6_3);
        et6_4=(EditText) findViewById(R.id.editText6_4);
        et6_5=(EditText) findViewById(R.id.editText6_5);
        et6_6=(EditText) findViewById(R.id.editText6_6);
        sub1_6=(TextView) findViewById(R.id.textViewSubTotal6);
        total1_6=(TextView) findViewById(R.id.textViewTotal6);

        et6_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et6_1));
        et6_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et6_2));
        et6_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et6_3));
        et6_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et6_4));
        et6_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et6_5));
        et6_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et6_6));

        et2_1_1=(EditText) findViewById(R.id.editText2_1_1);
        et2_1_2=(EditText) findViewById(R.id.editText2_1_2);
        et2_1_3=(EditText) findViewById(R.id.editText2_1_3);
        et2_1_4=(EditText) findViewById(R.id.editText2_1_4);
        et2_1_5=(EditText) findViewById(R.id.editText2_1_5);
        et2_1_6=(EditText) findViewById(R.id.editText2_1_6);
        sub2_1=(TextView) findViewById(R.id.textViewSubTotal2_1);
        total2_1=(TextView) findViewById(R.id.textViewTotal2_1);

        et2_1_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1_1));
        et2_1_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1_2));
        et2_1_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1_3));
        et2_1_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1_4));
        et2_1_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1_5));
        et2_1_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_1_6));

        et2_2_1=(EditText) findViewById(R.id.editText2_2_1);
        et2_2_2=(EditText) findViewById(R.id.editText2_2_2);
        et2_2_3=(EditText) findViewById(R.id.editText2_2_3);
        et2_2_4=(EditText) findViewById(R.id.editText2_2_4);
        et2_2_5=(EditText) findViewById(R.id.editText2_2_5);
        et2_2_6=(EditText) findViewById(R.id.editText2_2_6);
        sub2_2=(TextView) findViewById(R.id.textViewSubTotal2_2);
        total2_2=(TextView) findViewById(R.id.textViewTotal2_2);

        et2_2_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2_1));
        et2_2_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2_2));
        et2_2_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2_3));
        et2_2_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2_4));
        et2_2_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2_5));
        et2_2_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_2_6));

        et2_3_1=(EditText) findViewById(R.id.editText2_3_1);
        et2_3_2=(EditText) findViewById(R.id.editText2_3_2);
        et2_3_3=(EditText) findViewById(R.id.editText2_3_3);
        et2_3_4=(EditText) findViewById(R.id.editText2_3_4);
        et2_3_5=(EditText) findViewById(R.id.editText2_3_5);
        et2_3_6=(EditText) findViewById(R.id.editText2_3_6);
        sub2_3=(TextView) findViewById(R.id.textViewSubTotal2_3);
        total2_3=(TextView) findViewById(R.id.textViewTotal2_3);

        et2_3_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3_1));
        et2_3_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3_2));
        et2_3_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3_3));
        et2_3_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3_4));
        et2_3_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3_5));
        et2_3_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_3_6));

        et2_4_1=(EditText) findViewById(R.id.editText2_4_1);
        et2_4_2=(EditText) findViewById(R.id.editText2_4_2);
        et2_4_3=(EditText) findViewById(R.id.editText2_4_3);
        et2_4_4=(EditText) findViewById(R.id.editText2_4_4);
        et2_4_5=(EditText) findViewById(R.id.editText2_4_5);
        et2_4_6=(EditText) findViewById(R.id.editText2_4_6);
        sub2_4=(TextView) findViewById(R.id.textViewSubTotal2_4);
        total2_4=(TextView) findViewById(R.id.textViewTotal2_4);

        et2_4_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4_1));
        et2_4_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4_2));
        et2_4_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4_3));
        et2_4_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4_4));
        et2_4_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4_5));
        et2_4_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_4_6));

        et2_5_1=(EditText) findViewById(R.id.editText2_5_1);
        et2_5_2=(EditText) findViewById(R.id.editText2_5_2);
        et2_5_3=(EditText) findViewById(R.id.editText2_5_3);
        et2_5_4=(EditText) findViewById(R.id.editText2_5_4);
        et2_5_5=(EditText) findViewById(R.id.editText2_5_5);
        et2_5_6=(EditText) findViewById(R.id.editText2_5_6);
        sub2_5=(TextView) findViewById(R.id.textViewSubTotal2_5);
        total2_5=(TextView) findViewById(R.id.textViewTotal2_5);

        et2_5_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5_1));
        et2_5_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5_2));
        et2_5_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5_3));
        et2_5_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5_4));
        et2_5_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5_5));
        et2_5_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_5_6));

        et2_6_1=(EditText) findViewById(R.id.editText2_6_1);
        et2_6_2=(EditText) findViewById(R.id.editText2_6_2);
        et2_6_3=(EditText) findViewById(R.id.editText2_6_3);
        et2_6_4=(EditText) findViewById(R.id.editText2_6_4);
        et2_6_5=(EditText) findViewById(R.id.editText2_6_5);
        et2_6_6=(EditText) findViewById(R.id.editText2_6_6);
        sub2_6=(TextView) findViewById(R.id.textViewSubTotal2_6);
        total2_6=(TextView) findViewById(R.id.textViewTotal2_6);

        et2_6_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6_1));
        et2_6_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6_2));
        et2_6_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6_3));
        et2_6_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6_4));
        et2_6_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6_5));
        et2_6_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et2_6_6));

        et3_1_1=(EditText) findViewById(R.id.editText3_1_1);
        et3_1_2=(EditText) findViewById(R.id.editText3_1_2);
        et3_1_3=(EditText) findViewById(R.id.editText3_1_3);
        et3_1_4=(EditText) findViewById(R.id.editText3_1_4);
        et3_1_5=(EditText) findViewById(R.id.editText3_1_5);
        et3_1_6=(EditText) findViewById(R.id.editText3_1_6);
        sub3_1=(TextView) findViewById(R.id.textViewSubTotal3_1);
        total3_1=(TextView) findViewById(R.id.textViewTotal3_1);

        et3_1_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1_1));
        et3_1_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1_2));
        et3_1_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1_3));
        et3_1_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1_4));
        et3_1_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1_5));
        et3_1_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_1_6));

        et3_2_1=(EditText) findViewById(R.id.editText3_2_1);
        et3_2_2=(EditText) findViewById(R.id.editText3_2_2);
        et3_2_3=(EditText) findViewById(R.id.editText3_2_3);
        et3_2_4=(EditText) findViewById(R.id.editText3_2_4);
        et3_2_5=(EditText) findViewById(R.id.editText3_2_5);
        et3_2_6=(EditText) findViewById(R.id.editText3_2_6);
        sub3_2=(TextView) findViewById(R.id.textViewSubTotal3_2);
        total3_2=(TextView) findViewById(R.id.textViewTotal3_2);

        et3_2_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2_1));
        et3_2_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2_2));
        et3_2_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2_3));
        et3_2_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2_4));
        et3_2_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2_5));
        et3_2_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_2_6));

        et3_3_1=(EditText) findViewById(R.id.editText3_3_1);
        et3_3_2=(EditText) findViewById(R.id.editText3_3_2);
        et3_3_3=(EditText) findViewById(R.id.editText3_3_3);
        et3_3_4=(EditText) findViewById(R.id.editText3_3_4);
        et3_3_5=(EditText) findViewById(R.id.editText3_3_5);
        et3_3_6=(EditText) findViewById(R.id.editText3_3_6);
        sub3_3=(TextView) findViewById(R.id.textViewSubTotal3_3);
        total3_3=(TextView) findViewById(R.id.textViewTotal3_3);

        et3_3_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3_1));
        et3_3_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3_2));
        et3_3_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3_3));
        et3_3_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3_4));
        et3_3_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3_5));
        et3_3_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_3_6));

        et3_4_1=(EditText) findViewById(R.id.editText3_4_1);
        et3_4_2=(EditText) findViewById(R.id.editText3_4_2);
        et3_4_3=(EditText) findViewById(R.id.editText3_4_3);
        et3_4_4=(EditText) findViewById(R.id.editText3_4_4);
        et3_4_5=(EditText) findViewById(R.id.editText3_4_5);
        et3_4_6=(EditText) findViewById(R.id.editText3_4_6);
        sub3_4=(TextView) findViewById(R.id.textViewSubTotal3_4);
        total3_4=(TextView) findViewById(R.id.textViewTotal3_4);

        et3_4_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4_1));
        et3_4_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4_2));
        et3_4_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4_3));
        et3_4_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4_4));
        et3_4_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4_5));
        et3_4_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_4_6));

        et3_5_1=(EditText) findViewById(R.id.editText3_5_1);
        et3_5_2=(EditText) findViewById(R.id.editText3_5_2);
        et3_5_3=(EditText) findViewById(R.id.editText3_5_3);
        et3_5_4=(EditText) findViewById(R.id.editText3_5_4);
        et3_5_5=(EditText) findViewById(R.id.editText3_5_5);
        et3_5_6=(EditText) findViewById(R.id.editText3_5_6);
        sub3_5=(TextView) findViewById(R.id.textViewSubTotal3_5);
        total3_5=(TextView) findViewById(R.id.textViewTotal3_5);

        et3_5_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5_1));
        et3_5_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5_2));
        et3_5_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5_3));
        et3_5_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5_4));
        et3_5_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5_5));
        et3_5_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_5_6));

        et3_6_1=(EditText) findViewById(R.id.editText3_6_1);
        et3_6_2=(EditText) findViewById(R.id.editText3_6_2);
        et3_6_3=(EditText) findViewById(R.id.editText3_6_3);
        et3_6_4=(EditText) findViewById(R.id.editText3_6_4);
        et3_6_5=(EditText) findViewById(R.id.editText3_6_5);
        et3_6_6=(EditText) findViewById(R.id.editText3_6_6);
        sub3_6=(TextView) findViewById(R.id.textViewSubTotal3_6);
        total3_6=(TextView) findViewById(R.id.textViewTotal3_6);

        et3_6_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6_1));
        et3_6_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6_2));
        et3_6_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6_3));
        et3_6_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6_4));
        et3_6_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6_5));
        et3_6_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et3_6_6));

        et4_1_1=(EditText) findViewById(R.id.editText4_1_1);
        et4_1_2=(EditText) findViewById(R.id.editText4_1_2);
        et4_1_3=(EditText) findViewById(R.id.editText4_1_3);
        et4_1_4=(EditText) findViewById(R.id.editText4_1_4);
        et4_1_5=(EditText) findViewById(R.id.editText4_1_5);
        et4_1_6=(EditText) findViewById(R.id.editText4_1_6);
        sub4_1=(TextView) findViewById(R.id.textViewSubTotal4_1);
        total4_1=(TextView) findViewById(R.id.textViewTotal4_1);

        et4_1_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1_1));
        et4_1_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1_2));
        et4_1_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1_3));
        et4_1_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1_4));
        et4_1_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1_5));
        et4_1_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_1_6));

        et4_2_1=(EditText) findViewById(R.id.editText4_2_1);
        et4_2_2=(EditText) findViewById(R.id.editText4_2_2);
        et4_2_3=(EditText) findViewById(R.id.editText4_2_3);
        et4_2_4=(EditText) findViewById(R.id.editText4_2_4);
        et4_2_5=(EditText) findViewById(R.id.editText4_2_5);
        et4_2_6=(EditText) findViewById(R.id.editText4_2_6);
        sub4_2=(TextView) findViewById(R.id.textViewSubTotal4_2);
        total4_2=(TextView) findViewById(R.id.textViewTotal4_2);

        et4_2_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2_1));
        et4_2_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2_2));
        et4_2_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2_3));
        et4_2_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2_4));
        et4_2_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2_5));
        et4_2_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_2_6));


        et4_3_1=(EditText) findViewById(R.id.editText4_3_1);
        et4_3_2=(EditText) findViewById(R.id.editText4_3_2);
        et4_3_3=(EditText) findViewById(R.id.editText4_3_3);
        et4_3_4=(EditText) findViewById(R.id.editText4_3_4);
        et4_3_5=(EditText) findViewById(R.id.editText4_3_5);
        et4_3_6=(EditText) findViewById(R.id.editText4_3_6);
        sub4_3=(TextView) findViewById(R.id.textViewSubTotal4_3);
        total4_3=(TextView) findViewById(R.id.textViewTotal4_3);

        et4_3_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3_1));
        et4_3_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3_2));
        et4_3_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3_3));
        et4_3_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3_4));
        et4_3_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3_5));
        et4_3_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_3_6));

        et4_4_1=(EditText) findViewById(R.id.editText4_4_1);
        et4_4_2=(EditText) findViewById(R.id.editText4_4_2);
        et4_4_3=(EditText) findViewById(R.id.editText4_4_3);
        et4_4_4=(EditText) findViewById(R.id.editText4_4_4);
        et4_4_5=(EditText) findViewById(R.id.editText4_4_5);
        et4_4_6=(EditText) findViewById(R.id.editText4_4_6);
        sub4_4=(TextView) findViewById(R.id.textViewSubTotal4_4);
        total4_4=(TextView) findViewById(R.id.textViewTotal4_4);

        et4_4_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4_1));
        et4_4_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4_2));
        et4_4_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4_3));
        et4_4_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4_4));
        et4_4_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4_5));
        et4_4_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_4_6));

        et4_5_1=(EditText) findViewById(R.id.editText4_5_1);
        et4_5_2=(EditText) findViewById(R.id.editText4_5_2);
        et4_5_3=(EditText) findViewById(R.id.editText4_5_3);
        et4_5_4=(EditText) findViewById(R.id.editText4_5_4);
        et4_5_5=(EditText) findViewById(R.id.editText4_5_5);
        et4_5_6=(EditText) findViewById(R.id.editText4_5_6);
        sub4_5=(TextView) findViewById(R.id.textViewSubTotal4_5);
        total4_5=(TextView) findViewById(R.id.textViewTotal4_5);

        et4_5_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5_1));
        et4_5_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5_2));
        et4_5_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5_3));
        et4_5_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5_4));
        et4_5_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5_5));
        et4_5_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_5_6));

        et4_6_1=(EditText) findViewById(R.id.editText4_6_1);
        et4_6_2=(EditText) findViewById(R.id.editText4_6_2);
        et4_6_3=(EditText) findViewById(R.id.editText4_6_3);
        et4_6_4=(EditText) findViewById(R.id.editText4_6_4);
        et4_6_5=(EditText) findViewById(R.id.editText4_6_5);
        et4_6_6=(EditText) findViewById(R.id.editText4_6_6);
        sub4_6=(TextView) findViewById(R.id.textViewSubTotal4_6);
        total4_6=(TextView) findViewById(R.id.textViewTotal4_6);

        et4_6_1.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6_1));
        et4_6_2.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6_2));
        et4_6_3.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6_3));
        et4_6_4.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6_4));
        et4_6_5.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6_5));
        et4_6_6.addTextChangedListener(new TableroPuntos.GenericTextWatcher(et4_6_6));
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
                case R.id.editText1_1:
                case R.id.editText1_2:
                case R.id.editText1_3:
                case R.id.editText1_4:
                case R.id.editText1_5:
                case R.id.editText1_6:
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
                case R.id.editText3_1_1:
                case R.id.editText3_1_2:
                case R.id.editText3_1_3:
                case R.id.editText3_1_4:
                case R.id.editText3_1_5:
                case R.id.editText3_1_6:
                    operacionFilaTrece();
                    guardarDatos();
                    break;
                case R.id.editText3_2_1:
                case R.id.editText3_2_2:
                case R.id.editText3_2_3:
                case R.id.editText3_2_4:
                case R.id.editText3_2_5:
                case R.id.editText3_2_6:
                    operacionFilaCatorce();
                    guardarDatos();
                    break;
                case R.id.editText3_3_1:
                case R.id.editText3_3_2:
                case R.id.editText3_3_3:
                case R.id.editText3_3_4:
                case R.id.editText3_3_5:
                case R.id.editText3_3_6:
                    operacionFilaQuince();
                    guardarDatos();
                    break;
                case R.id.editText3_4_1:
                case R.id.editText3_4_2:
                case R.id.editText3_4_3:
                case R.id.editText3_4_4:
                case R.id.editText3_4_5:
                case R.id.editText3_4_6:
                    operacionFilaDieciseis();
                    guardarDatos();
                    break;
                case R.id.editText3_5_1:
                case R.id.editText3_5_2:
                case R.id.editText3_5_3:
                case R.id.editText3_5_4:
                case R.id.editText3_5_5:
                case R.id.editText3_5_6:
                    operacionFilaDiecisiete();
                    guardarDatos();
                    break;
                case R.id.editText3_6_1:
                case R.id.editText3_6_2:
                case R.id.editText3_6_3:
                case R.id.editText3_6_4:
                case R.id.editText3_6_5:
                case R.id.editText3_6_6:
                    operacionFilaDieciocho();
                    guardarDatos();
                    break;
                case R.id.editText4_1_1:
                case R.id.editText4_1_2:
                case R.id.editText4_1_3:
                case R.id.editText4_1_4:
                case R.id.editText4_1_5:
                case R.id.editText4_1_6:
                    operacionFilaDiecinueve();
                    guardarDatos();
                    break;
                case R.id.editText4_2_1:
                case R.id.editText4_2_2:
                case R.id.editText4_2_3:
                case R.id.editText4_2_4:
                case R.id.editText4_2_5:
                case R.id.editText4_2_6:
                    operacionFilaVente();
                    guardarDatos();
                    break;
                case R.id.editText4_3_1:
                case R.id.editText4_3_2:
                case R.id.editText4_3_3:
                case R.id.editText4_3_4:
                case R.id.editText4_3_5:
                case R.id.editText4_3_6:
                    operacionFilaVentiuno();
                    guardarDatos();
                    break;
                case R.id.editText4_4_1:
                case R.id.editText4_4_2:
                case R.id.editText4_4_3:
                case R.id.editText4_4_4:
                case R.id.editText4_4_5:
                case R.id.editText4_4_6:
                    operacionFilaVentidos();
                    guardarDatos();
                    break;
                case R.id.editText4_5_1:
                case R.id.editText4_5_2:
                case R.id.editText4_5_3:
                case R.id.editText4_5_4:
                case R.id.editText4_5_5:
                case R.id.editText4_5_6:
                    operacionFilaVentitres();
                    guardarDatos();
                    break;
                case R.id.editText4_6_1:
                case R.id.editText4_6_2:
                case R.id.editText4_6_3:
                case R.id.editText4_6_4:
                case R.id.editText4_6_5:
                case R.id.editText4_6_6:
                    operacionFilaVenticuatro();
                    guardarDatos();
                    break;
            }

        }
    }

    private void operacionFilaUno() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et1_1.getText().toString();
        String dos = et1_2.getText().toString();
        String tres = et1_3.getText().toString();
        String cuatro = et1_4.getText().toString();
        String cinco = et1_5.getText().toString();
        String seis = et1_6.getText().toString();
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
        String uno = et2_1.getText().toString();
        String dos = et2_2.getText().toString();
        String tres = et2_3.getText().toString();
        String cuatro = et2_4.getText().toString();
        String cinco = et2_5.getText().toString();
        String seis = et2_6.getText().toString();
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
        String uno = et3_1.getText().toString();
        String dos = et3_2.getText().toString();
        String tres = et3_3.getText().toString();
        String cuatro = et3_4.getText().toString();
        String cinco = et3_5.getText().toString();
        String seis = et3_6.getText().toString();
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
        String uno = et4_1.getText().toString();
        String dos = et4_2.getText().toString();
        String tres = et4_3.getText().toString();
        String cuatro = et4_4.getText().toString();
        String cinco = et4_5.getText().toString();
        String seis = et4_6.getText().toString();
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
        String uno = et5_1.getText().toString();
        String dos = et5_2.getText().toString();
        String tres = et5_3.getText().toString();
        String cuatro = et5_4.getText().toString();
        String cinco = et5_5.getText().toString();
        String seis = et5_6.getText().toString();
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
        String uno = et6_1.getText().toString();
        String dos = et6_2.getText().toString();
        String tres = et6_3.getText().toString();
        String cuatro = et6_4.getText().toString();
        String cinco = et6_5.getText().toString();
        String seis = et6_6.getText().toString();
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
        operacionFilaTrece();
    }

    private void operacionFilaTrece() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et3_1_1.getText().toString();
        String dos = et3_1_2.getText().toString();
        String tres = et3_1_3.getText().toString();
        String cuatro = et3_1_4.getText().toString();
        String cinco = et3_1_5.getText().toString();
        String seis = et3_1_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub3_1.setText("");
            total3_1.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub3_1.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total2_6.getText().toString());
            total3_1.setText(total+"");
        }
        operacionFilaCatorce();
    }

    private void operacionFilaCatorce() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et3_2_1.getText().toString();
        String dos = et3_2_2.getText().toString();
        String tres = et3_2_3.getText().toString();
        String cuatro = et3_2_4.getText().toString();
        String cinco = et3_2_5.getText().toString();
        String seis = et3_2_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub3_2.setText("");
            total3_2.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub3_2.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total3_1.getText().toString());
            total3_2.setText(total+"");
        }
        operacionFilaQuince();
    }

    private void operacionFilaQuince() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et3_3_1.getText().toString();
        String dos = et3_3_2.getText().toString();
        String tres = et3_3_3.getText().toString();
        String cuatro = et3_3_4.getText().toString();
        String cinco = et3_3_5.getText().toString();
        String seis = et3_3_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub3_3.setText("");
            total3_3.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub3_3.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total3_2.getText().toString());
            total3_3.setText(total+"");
        }
        operacionFilaDieciseis();
    }

    private void operacionFilaDieciseis() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et3_4_1.getText().toString();
        String dos = et3_4_2.getText().toString();
        String tres = et3_4_3.getText().toString();
        String cuatro = et3_4_4.getText().toString();
        String cinco = et3_4_5.getText().toString();
        String seis = et3_4_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub3_4.setText("");
            total3_4.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub3_4.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total3_3.getText().toString());
            total3_4.setText(total+"");
        }
        operacionFilaDiecisiete();
    }

    private void operacionFilaDiecisiete() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et3_5_1.getText().toString();
        String dos = et3_5_2.getText().toString();
        String tres = et3_5_3.getText().toString();
        String cuatro = et3_5_4.getText().toString();
        String cinco = et3_5_5.getText().toString();
        String seis = et3_5_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub3_5.setText("");
            total3_5.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub3_5.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total3_4.getText().toString());
            total3_5.setText(total+"");
        }
        operacionFilaDieciocho();
    }

    private void operacionFilaDieciocho() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et3_6_1.getText().toString();
        String dos = et3_6_2.getText().toString();
        String tres = et3_6_3.getText().toString();
        String cuatro = et3_6_4.getText().toString();
        String cinco = et3_6_5.getText().toString();
        String seis = et3_6_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub3_6.setText("");
            total3_6.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub3_6.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total3_5.getText().toString());
            total3_6.setText(total+"");
        }
        operacionFilaDiecinueve();
    }

    private void operacionFilaDiecinueve() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et4_1_1.getText().toString();
        String dos = et4_1_2.getText().toString();
        String tres = et4_1_3.getText().toString();
        String cuatro = et4_1_4.getText().toString();
        String cinco = et4_1_5.getText().toString();
        String seis = et4_1_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub4_1.setText("");
            total4_1.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub4_1.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total3_6.getText().toString());
            total4_1.setText(total+"");
        }
        operacionFilaVente();
    }

    private void operacionFilaVente() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et4_2_1.getText().toString();
        String dos = et4_2_2.getText().toString();
        String tres = et4_2_3.getText().toString();
        String cuatro = et4_2_4.getText().toString();
        String cinco = et4_2_5.getText().toString();
        String seis = et4_2_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub4_2.setText("");
            total4_2.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub4_2.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total4_1.getText().toString());
            total4_2.setText(total+"");
        }
        operacionFilaVentiuno();
    }

    private void operacionFilaVentiuno() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et4_3_1.getText().toString();
        String dos = et4_3_2.getText().toString();
        String tres = et4_3_3.getText().toString();
        String cuatro = et4_3_4.getText().toString();
        String cinco = et4_3_5.getText().toString();
        String seis = et4_3_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub4_3.setText("");
            total4_3.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub4_3.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total4_2.getText().toString());
            total4_3.setText(total+"");
        }
        operacionFilaVentidos();
    }

    private void operacionFilaVentidos() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et4_4_1.getText().toString();
        String dos = et4_4_2.getText().toString();
        String tres = et4_4_3.getText().toString();
        String cuatro = et4_4_4.getText().toString();
        String cinco = et4_4_5.getText().toString();
        String seis = et4_4_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub4_4.setText("");
            total4_4.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub4_4.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total4_3.getText().toString());
            total4_4.setText(total+"");
        }
        operacionFilaVentitres();
    }

    private void operacionFilaVentitres() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et4_5_1.getText().toString();
        String dos = et4_5_2.getText().toString();
        String tres = et4_5_3.getText().toString();
        String cuatro = et4_5_4.getText().toString();
        String cinco = et4_5_5.getText().toString();
        String seis = et4_5_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub4_5.setText("");
            total4_5.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub4_5.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total4_4.getText().toString());
            total4_5.setText(total+"");
        }
        operacionFilaVenticuatro();
    }

    private void operacionFilaVenticuatro() {
        ArrayList<String> fila = new ArrayList<>();
        String uno = et4_6_1.getText().toString();
        String dos = et4_6_2.getText().toString();
        String tres = et4_6_3.getText().toString();
        String cuatro = et4_6_4.getText().toString();
        String cinco = et4_6_5.getText().toString();
        String seis = et4_6_6.getText().toString();
        fila.add(uno);
        fila.add(dos);
        fila.add(tres);
        fila.add(cuatro);
        fila.add(cinco);
        fila.add(seis);
        if(uno.isEmpty()&&dos.isEmpty()&&tres.isEmpty()){
            sub4_6.setText("");
            total4_6.setText("");
        }else{
            int subTotal = filaResultado(fila);
            sub4_6.setText(subTotal+"");
            int total = subTotal+Integer.parseInt(total4_5.getText().toString());
            total4_6.setText(total+"");
        }

    }

    private void guardarDatos() {
        SQLiteDatabase db=con.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(Utilidades.CAMPO_N1,et1_1.getText().toString());
        values.put(Utilidades.CAMPO_N2,et1_2.getText().toString());
        values.put(Utilidades.CAMPO_N3,et1_3.getText().toString());
        values.put(Utilidades.CAMPO_N4,et1_4.getText().toString());
        values.put(Utilidades.CAMPO_N5,et1_5.getText().toString());
        values.put(Utilidades.CAMPO_N6,et1_6.getText().toString());
        values.put(Utilidades.CAMPO_S1,sub1_1.getText().toString());
        values.put(Utilidades.CAMPO_T1,total1_1.getText().toString());

        values.put(Utilidades.CAMPO_N7,et2_1.getText().toString());
        values.put(Utilidades.CAMPO_N8,et2_2.getText().toString());
        values.put(Utilidades.CAMPO_N9,et2_3.getText().toString());
        values.put(Utilidades.CAMPO_N10,et2_4.getText().toString());
        values.put(Utilidades.CAMPO_N11,et2_5.getText().toString());
        values.put(Utilidades.CAMPO_N12,et2_6.getText().toString());
        values.put(Utilidades.CAMPO_S2,sub1_2.getText().toString());
        values.put(Utilidades.CAMPO_T2,total1_2.getText().toString());

        values.put(Utilidades.CAMPO_N13,et3_1.getText().toString());
        values.put(Utilidades.CAMPO_N14,et3_2.getText().toString());
        values.put(Utilidades.CAMPO_N15,et3_3.getText().toString());
        values.put(Utilidades.CAMPO_N16,et3_4.getText().toString());
        values.put(Utilidades.CAMPO_N17,et3_5.getText().toString());
        values.put(Utilidades.CAMPO_N18,et3_6.getText().toString());
        values.put(Utilidades.CAMPO_S3,sub1_3.getText().toString());
        values.put(Utilidades.CAMPO_T3,total1_3.getText().toString());

        values.put(Utilidades.CAMPO_N19,et4_1.getText().toString());
        values.put(Utilidades.CAMPO_N20,et4_2.getText().toString());
        values.put(Utilidades.CAMPO_N21,et4_3.getText().toString());
        values.put(Utilidades.CAMPO_N22,et4_4.getText().toString());
        values.put(Utilidades.CAMPO_N23,et4_5.getText().toString());
        values.put(Utilidades.CAMPO_N24,et4_6.getText().toString());
        values.put(Utilidades.CAMPO_S4,sub1_4.getText().toString());
        values.put(Utilidades.CAMPO_T4,total1_4.getText().toString());

        values.put(Utilidades.CAMPO_N25,et5_1.getText().toString());
        values.put(Utilidades.CAMPO_N26,et5_2.getText().toString());
        values.put(Utilidades.CAMPO_N27,et5_3.getText().toString());
        values.put(Utilidades.CAMPO_N28,et5_4.getText().toString());
        values.put(Utilidades.CAMPO_N29,et5_5.getText().toString());
        values.put(Utilidades.CAMPO_N30,et5_6.getText().toString());
        values.put(Utilidades.CAMPO_S5,sub1_5.getText().toString());
        values.put(Utilidades.CAMPO_T5,total1_5.getText().toString());

        values.put(Utilidades.CAMPO_N31,et6_1.getText().toString());
        values.put(Utilidades.CAMPO_N32,et6_2.getText().toString());
        values.put(Utilidades.CAMPO_N33,et6_3.getText().toString());
        values.put(Utilidades.CAMPO_N34,et6_4.getText().toString());
        values.put(Utilidades.CAMPO_N35,et6_5.getText().toString());
        values.put(Utilidades.CAMPO_N36,et6_6.getText().toString());
        values.put(Utilidades.CAMPO_S6,sub1_6.getText().toString());
        values.put(Utilidades.CAMPO_T6,total1_6.getText().toString());
        ///////////////
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
        ////////////
        values.put(Utilidades.CAMPO_N73,et3_1_1.getText().toString());
        values.put(Utilidades.CAMPO_N74,et3_1_2.getText().toString());
        values.put(Utilidades.CAMPO_N75,et3_1_3.getText().toString());
        values.put(Utilidades.CAMPO_N76,et3_1_4.getText().toString());
        values.put(Utilidades.CAMPO_N77,et3_1_5.getText().toString());
        values.put(Utilidades.CAMPO_N78,et3_1_6.getText().toString());
        values.put(Utilidades.CAMPO_S13,sub3_1.getText().toString());
        values.put(Utilidades.CAMPO_T13,total3_1.getText().toString());

        values.put(Utilidades.CAMPO_N79,et3_2_1.getText().toString());
        values.put(Utilidades.CAMPO_N80,et3_2_2.getText().toString());
        values.put(Utilidades.CAMPO_N81,et3_2_3.getText().toString());
        values.put(Utilidades.CAMPO_N82,et3_2_4.getText().toString());
        values.put(Utilidades.CAMPO_N83,et3_2_5.getText().toString());
        values.put(Utilidades.CAMPO_N84,et3_2_6.getText().toString());
        values.put(Utilidades.CAMPO_S14,sub3_2.getText().toString());
        values.put(Utilidades.CAMPO_T14,total3_2.getText().toString());

        values.put(Utilidades.CAMPO_N85,et3_3_1.getText().toString());
        values.put(Utilidades.CAMPO_N86,et3_3_2.getText().toString());
        values.put(Utilidades.CAMPO_N87,et3_3_3.getText().toString());
        values.put(Utilidades.CAMPO_N88,et3_3_4.getText().toString());
        values.put(Utilidades.CAMPO_N89,et3_3_5.getText().toString());
        values.put(Utilidades.CAMPO_N90,et3_3_6.getText().toString());
        values.put(Utilidades.CAMPO_S15,sub3_3.getText().toString());
        values.put(Utilidades.CAMPO_T15,total3_3.getText().toString());

        values.put(Utilidades.CAMPO_N91,et3_4_1.getText().toString());
        values.put(Utilidades.CAMPO_N92,et3_4_2.getText().toString());
        values.put(Utilidades.CAMPO_N93,et3_4_3.getText().toString());
        values.put(Utilidades.CAMPO_N94,et3_4_4.getText().toString());
        values.put(Utilidades.CAMPO_N95,et3_4_5.getText().toString());
        values.put(Utilidades.CAMPO_N96,et3_4_6.getText().toString());
        values.put(Utilidades.CAMPO_S16,sub3_4.getText().toString());
        values.put(Utilidades.CAMPO_T16,total3_4.getText().toString());

        values.put(Utilidades.CAMPO_N97,et3_5_1.getText().toString());
        values.put(Utilidades.CAMPO_N98,et3_5_2.getText().toString());
        values.put(Utilidades.CAMPO_N99,et3_5_3.getText().toString());
        values.put(Utilidades.CAMPO_N100,et3_5_4.getText().toString());
        values.put(Utilidades.CAMPO_N101,et3_5_5.getText().toString());
        values.put(Utilidades.CAMPO_N102,et3_5_6.getText().toString());
        values.put(Utilidades.CAMPO_S17,sub3_5.getText().toString());
        values.put(Utilidades.CAMPO_T17,total3_5.getText().toString());

        values.put(Utilidades.CAMPO_N103,et3_6_1.getText().toString());
        values.put(Utilidades.CAMPO_N104,et3_6_2.getText().toString());
        values.put(Utilidades.CAMPO_N105,et3_6_3.getText().toString());
        values.put(Utilidades.CAMPO_N106,et3_6_4.getText().toString());
        values.put(Utilidades.CAMPO_N107,et3_6_5.getText().toString());
        values.put(Utilidades.CAMPO_N108,et3_6_6.getText().toString());
        values.put(Utilidades.CAMPO_S18,sub3_6.getText().toString());
        values.put(Utilidades.CAMPO_T18,total3_6.getText().toString());
        /////////////////
        values.put(Utilidades.CAMPO_N109,et4_1_1.getText().toString());
        values.put(Utilidades.CAMPO_N110,et4_1_2.getText().toString());
        values.put(Utilidades.CAMPO_N111,et4_1_3.getText().toString());
        values.put(Utilidades.CAMPO_N112,et4_1_4.getText().toString());
        values.put(Utilidades.CAMPO_N113,et4_1_5.getText().toString());
        values.put(Utilidades.CAMPO_N114,et4_1_6.getText().toString());
        values.put(Utilidades.CAMPO_S19,sub4_1.getText().toString());
        values.put(Utilidades.CAMPO_T19,total4_1.getText().toString());

        values.put(Utilidades.CAMPO_N115,et4_2_1.getText().toString());
        values.put(Utilidades.CAMPO_N116,et4_2_2.getText().toString());
        values.put(Utilidades.CAMPO_N117,et4_2_3.getText().toString());
        values.put(Utilidades.CAMPO_N118,et4_2_4.getText().toString());
        values.put(Utilidades.CAMPO_N119,et4_2_5.getText().toString());
        values.put(Utilidades.CAMPO_N120,et4_2_6.getText().toString());
        values.put(Utilidades.CAMPO_S20,sub4_2.getText().toString());
        values.put(Utilidades.CAMPO_T20,total4_2.getText().toString());

        values.put(Utilidades.CAMPO_N121,et4_3_1.getText().toString());
        values.put(Utilidades.CAMPO_N122,et4_3_2.getText().toString());
        values.put(Utilidades.CAMPO_N123,et4_3_3.getText().toString());
        values.put(Utilidades.CAMPO_N124,et4_3_4.getText().toString());
        values.put(Utilidades.CAMPO_N125,et4_3_5.getText().toString());
        values.put(Utilidades.CAMPO_N126,et4_3_6.getText().toString());
        values.put(Utilidades.CAMPO_S21,sub4_3.getText().toString());
        values.put(Utilidades.CAMPO_T21,total4_3.getText().toString());

        values.put(Utilidades.CAMPO_N127,et4_4_1.getText().toString());
        values.put(Utilidades.CAMPO_N128,et4_4_2.getText().toString());
        values.put(Utilidades.CAMPO_N129,et4_4_3.getText().toString());
        values.put(Utilidades.CAMPO_N130,et4_4_4.getText().toString());
        values.put(Utilidades.CAMPO_N131,et4_4_5.getText().toString());
        values.put(Utilidades.CAMPO_N132,et4_4_6.getText().toString());
        values.put(Utilidades.CAMPO_S22,sub4_4.getText().toString());
        values.put(Utilidades.CAMPO_T22,total4_4.getText().toString());

        values.put(Utilidades.CAMPO_N133,et4_5_1.getText().toString());
        values.put(Utilidades.CAMPO_N134,et4_5_2.getText().toString());
        values.put(Utilidades.CAMPO_N135,et4_5_3.getText().toString());
        values.put(Utilidades.CAMPO_N136,et4_5_4.getText().toString());
        values.put(Utilidades.CAMPO_N137,et4_5_5.getText().toString());
        values.put(Utilidades.CAMPO_N138,et4_5_6.getText().toString());
        values.put(Utilidades.CAMPO_S23,sub4_5.getText().toString());
        values.put(Utilidades.CAMPO_T23,total4_5.getText().toString());

        values.put(Utilidades.CAMPO_N139,et4_6_1.getText().toString());
        values.put(Utilidades.CAMPO_N140,et4_6_2.getText().toString());
        values.put(Utilidades.CAMPO_N141,et4_6_3.getText().toString());
        values.put(Utilidades.CAMPO_N142,et4_6_4.getText().toString());
        values.put(Utilidades.CAMPO_N143,et4_6_5.getText().toString());
        values.put(Utilidades.CAMPO_N144,et4_6_6.getText().toString());
        values.put(Utilidades.CAMPO_S24,sub4_6.getText().toString());
        values.put(Utilidades.CAMPO_T24,total4_6.getText().toString());

        String[] parametros1 = {idTablero.toString()};
        db.update(Utilidades.TABLA_PUNTAJE,values,Utilidades.CAMPO_IDPUNTO+" =? ",parametros1);
        db.close();
    }

    private int filaResultado(ArrayList<String> fila) {
        ArrayList<Integer> subTotalSuma = new ArrayList<>();
        int res = 0;
        for (int i =0; i<fila.size(); i++){
            String aux = fila.get(i);
            int valor =0;
            if(aux.equals("X")){
                valor = 10;
            }else if(!aux.isEmpty() && !aux.equals("M")){
                valor = Integer.parseInt(aux);
            }
            subTotalSuma.add(valor);
        }

        for (int j =0; j<subTotalSuma.size(); j++){
            res = res+subTotalSuma.get(j);
        }
        return res;
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
            verTotalRonda3();
            verTotalRonda4();
            Intent intent=new Intent(TableroPuntos.this,Estadistica.class);
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
            bundle.putFloat("ronda3",ronda3);
            bundle.putFloat("ronda4",ronda4);
            intent.putExtras(bundle);
            startActivity(intent);
        }else if(id==R.id.generarPdf){
            consultar();
            consultarPuntos();
            instanciarPdf();
            template3PDF.appViewPDF(this);
            Toast.makeText(TableroPuntos.this,"El pdf se guardo en la carpeta 'Archery'",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void instanciarPdf() {
        template3PDF=new Template3PDF(getApplicationContext());
        template3PDF.openDocument();
        template3PDF.adMetaData("Datos para el control de puntaje del arquero",club,ronda);
        template3PDF.addTitles("Distancia de diparo 70 metros","Puntaje total a 70 metros es 1440 puntos",fecha);
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
        template3PDF.createTable(header,getPuntos3());
        template3PDF.createTable(header,getPuntos4());
        template3PDF.closeDocument();
    }

    private ArrayList<String[]> getPuntos() {
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v1,v2,v3,v4,v5,v6,s1,t1});
        rows.add(new String[]{"2",v7,v8,v9,v10,v11,v12,s2,t2});
        rows.add(new String[]{"3",v13,v14,v15,v16,v17,v18,s3,t3});
        rows.add(new String[]{"4",v19,v20,v21,v22,v23,v24,s4,t4});
        rows.add(new String[]{"5",v25,v26,v27,v28,v29,v30,s5,t5});
        rows.add(new String[]{"6",v31,v32,v33,v34,v35,v36,s6,t6});
        return rows;
    }
    private ArrayList<String[]> getPuntos2() {
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v37,v38,v39,v40,v41,v42,s7,t7});
        rows.add(new String[]{"2",v43,v44,v45,v46,v47,v48,s8,t8});
        rows.add(new String[]{"3",v49,v50,v51,v52,v53,v54,s9,t9});
        rows.add(new String[]{"4",v55,v56,v57,v58,v59,v60,s10,t10});
        rows.add(new String[]{"5",v61,v62,v63,v64,v65,v66,s11,t11});
        rows.add(new String[]{"6",v67,v68,v69,v70,v71,v72,s12,t12});
        return rows;
    }
    private ArrayList<String[]> getPuntos3() {
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v73,v74,v75,v76,v77,v78,s13,t13});
        rows.add(new String[]{"2",v79,v80,v81,v82,v83,v84,s14,t14});
        rows.add(new String[]{"3",v85,v86,v87,v88,v89,v90,s15,t15});
        rows.add(new String[]{"4",v91,v92,v93,v94,v95,v96,s16,t16});
        rows.add(new String[]{"5",v97,v98,v99,v100,v101,v102,s17,t17});
        rows.add(new String[]{"6",v103,v104,v105,v106,v107,v108,s18,t18});
        return rows;
    }
    private ArrayList<String[]> getPuntos4() {
        ArrayList<String[]>rows=new ArrayList<>();
        rows.add(new String[]{"1",v109,v110,v111,v112,v113,v114,s19,t19});
        rows.add(new String[]{"2",v115,v116,v117,v118,v119,v120,s20,t20});
        rows.add(new String[]{"3",v121,v122,v123,v124,v125,v126,s21,t21});
        rows.add(new String[]{"4",v127,v128,v129,v130,v131,v132,s22,t22});
        rows.add(new String[]{"5",v133,v134,v135,v136,v137,v138,s23,t23});
        rows.add(new String[]{"6",v139,v140,v141,v142,v143,v144,s24,t24});
        return rows;
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
        total.add(t21);
        total.add(t22);
        total.add(t23);
        total.add(t24);

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
        valores.add(v73);
        valores.add(v74);
        valores.add(v75);
        valores.add(v76);
        valores.add(v77);
        valores.add(v78);
        valores.add(v79);
        valores.add(v80);
        valores.add(v81);
        valores.add(v82);
        valores.add(v83);
        valores.add(v84);
        valores.add(v85);
        valores.add(v86);
        valores.add(v87);
        valores.add(v88);
        valores.add(v89);
        valores.add(v90);
        valores.add(v91);
        valores.add(v92);
        valores.add(v93);
        valores.add(v94);
        valores.add(v95);
        valores.add(v96);
        valores.add(v97);
        valores.add(v98);
        valores.add(v99);
        valores.add(v100);
        valores.add(v101);
        valores.add(v102);
        valores.add(v103);
        valores.add(v104);
        valores.add(v105);
        valores.add(v106);
        valores.add(v107);
        valores.add(v108);
        valores.add(v109);
        valores.add(v110);
        valores.add(v111);
        valores.add(v112);
        valores.add(v113);
        valores.add(v114);
        valores.add(v115);
        valores.add(v116);
        valores.add(v117);
        valores.add(v118);
        valores.add(v119);
        valores.add(v120);
        valores.add(v121);
        valores.add(v122);
        valores.add(v123);
        valores.add(v124);
        valores.add(v125);
        valores.add(v126);
        valores.add(v127);
        valores.add(v128);
        valores.add(v129);
        valores.add(v130);
        valores.add(v131);
        valores.add(v132);
        valores.add(v133);
        valores.add(v134);
        valores.add(v135);
        valores.add(v136);
        valores.add(v137);
        valores.add(v138);
        valores.add(v139);
        valores.add(v140);
        valores.add(v141);
        valores.add(v142);
        valores.add(v143);
        valores.add(v144);
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

    private void verTotalRonda3() {
        consultarPuntos();
        ArrayList<String> totalRonada3=new ArrayList<>();
        ArrayList<Integer> totalEnterosRonda3 =new ArrayList<>();
        totalRonada3.add(t13);
        totalRonada3.add(t14);
        totalRonada3.add(t15);
        totalRonada3.add(t16);
        totalRonada3.add(t17);
        totalRonada3.add(t18);


        for (int j=0;j<totalRonada3.size();j++){
            String aux = totalRonada3.get(j);
            if(!aux.equals("")){
                totalEnterosRonda3.add(Integer.valueOf(aux));
            }
        }
        int valorMayor =0;
        for(int j=0;j<totalEnterosRonda3.size();j++){
            if(valorMayor<totalEnterosRonda3.get(j)){
                valorMayor = totalEnterosRonda3.get(j);
            }
        }
        ronda3 = valorMayor;

    }

    private void verTotalRonda4() {
        consultarPuntos();
        ArrayList<String> totalRonda4=new ArrayList<>();
        ArrayList<Integer> totalEnterosRonda4 =new ArrayList<>();
        totalRonda4.add(t19);
        totalRonda4.add(t20);
        totalRonda4.add(t21);
        totalRonda4.add(t22);
        totalRonda4.add(t23);
        totalRonda4.add(t24);

        for (int j=0;j<totalRonda4.size();j++){
            String aux = totalRonda4.get(j);
            if(!aux.equals("")){
                totalEnterosRonda4.add(Integer.valueOf(aux));
            }
        }
        int valorMayor =0;
        for(int j=0;j<totalEnterosRonda4.size();j++){
            if(valorMayor<totalEnterosRonda4.get(j)){
                valorMayor = totalEnterosRonda4.get(j);
            }
        }
        ronda4 = valorMayor;
    }

    //para que el boton de ir asia atraz del celular no funcione
    @Override
    public void onBackPressed(){

    }
}
