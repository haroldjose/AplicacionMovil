package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class RealizarEjercicio extends AppCompatActivity {

    private Button btn;
    private TextView txt1,txt2,txt3,txt4,txt5;
    private GifImageView gifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizar_ejercicio);

        txt1=(TextView)findViewById(R.id.textView1);
        txt2=(TextView)findViewById(R.id.textView2);
        txt3=(TextView)findViewById(R.id.textView3);
        txt4=(TextView)findViewById(R.id.textView4);
        txt5=(TextView)findViewById(R.id.textView5);
        btn=(Button)findViewById(R.id.buttonSiguiEjer);
        gifImageView=(GifImageView)findViewById(R.id.gifVista);

        int res=getIntent().getIntExtra("a",1000);

        if(res==0){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });


        }
        if(res==1){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==2){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==3){
            gifImageView.setImageResource(R.drawable.sentadillas);

            txt1.setText(R.string.letra_sentadilla1);
            txt2.setText(R.string.letra_sentadilla2);
            txt3.setText(R.string.letra_sentadilla3);
            txt4.setText(R.string.letra_sentadilla4);
            txt5.setText(R.string.letra_sentadilla5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==4){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==5){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==6){
            gifImageView.setImageResource(R.drawable.sentadillas);

            txt1.setText(R.string.letra_sentadilla1);
            txt2.setText(R.string.letra_sentadilla2);
            txt3.setText(R.string.letra_sentadilla3);
            txt4.setText(R.string.letra_sentadilla4);
            txt5.setText(R.string.letra_sentadilla5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==7){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.sentadillas);

                            txt1.setText(R.string.letra_sentadilla1);
                            txt2.setText(R.string.letra_sentadilla2);
                            txt3.setText(R.string.letra_sentadilla3);
                            txt4.setText(R.string.letra_sentadilla4);
                            txt5.setText(R.string.letra_sentadilla5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==8){
            gifImageView.setImageResource(R.drawable.sentadillas);

            txt1.setText(R.string.letra_sentadilla1);
            txt2.setText(R.string.letra_sentadilla2);
            txt3.setText(R.string.letra_sentadilla3);
            txt4.setText(R.string.letra_sentadilla4);
            txt5.setText(R.string.letra_sentadilla5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==9){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==10){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==11){
            gifImageView.setImageResource(R.drawable.sentadillas);

            txt1.setText(R.string.letra_sentadilla1);
            txt2.setText(R.string.letra_sentadilla2);
            txt3.setText(R.string.letra_sentadilla3);
            txt4.setText(R.string.letra_sentadilla4);
            txt5.setText(R.string.letra_sentadilla5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==12){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==13){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==14){
            gifImageView.setImageResource(R.drawable.sentadillas);

            txt1.setText(R.string.letra_sentadilla1);
            txt2.setText(R.string.letra_sentadilla2);
            txt3.setText(R.string.letra_sentadilla3);
            txt4.setText(R.string.letra_sentadilla4);
            txt5.setText(R.string.letra_sentadilla5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==15){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.sentadillas);

                    txt1.setText(R.string.letra_sentadilla1);
                    txt2.setText(R.string.letra_sentadilla2);
                    txt3.setText(R.string.letra_sentadilla3);
                    txt4.setText(R.string.letra_sentadilla4);
                    txt5.setText(R.string.letra_sentadilla5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==16){
            gifImageView.setImageResource(R.drawable.abdominales);

            txt1.setText(R.string.letra_abdominal1);
            txt2.setText(R.string.letra_abdominal2);
            txt3.setText(R.string.letra_abdominal3);
            txt4.setText(R.string.letra_abdominal4);
            txt5.setText(R.string.letra_abdominal5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==17){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==18){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==19){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==20){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==21){
            gifImageView.setImageResource(R.drawable.sentadillas);

            txt1.setText(R.string.letra_sentadilla1);
            txt2.setText(R.string.letra_sentadilla2);
            txt3.setText(R.string.letra_sentadilla3);
            txt4.setText(R.string.letra_sentadilla4);
            txt5.setText(R.string.letra_sentadilla5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==22){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.sentadillas);

                    txt1.setText(R.string.letra_sentadilla1);
                    txt2.setText(R.string.letra_sentadilla2);
                    txt3.setText(R.string.letra_sentadilla3);
                    txt4.setText(R.string.letra_sentadilla4);
                    txt5.setText(R.string.letra_sentadilla5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==23){
            gifImageView.setImageResource(R.drawable.abdominales);

            txt1.setText(R.string.letra_abdominal1);
            txt2.setText(R.string.letra_abdominal2);
            txt3.setText(R.string.letra_abdominal3);
            txt4.setText(R.string.letra_abdominal4);
            txt5.setText(R.string.letra_abdominal5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==24){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==25){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.sentadillas);

                    txt1.setText(R.string.letra_sentadilla1);
                    txt2.setText(R.string.letra_sentadilla2);
                    txt3.setText(R.string.letra_sentadilla3);
                    txt4.setText(R.string.letra_sentadilla4);
                    txt5.setText(R.string.letra_sentadilla5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==26){
            gifImageView.setImageResource(R.drawable.abdominales);

            txt1.setText(R.string.letra_abdominal1);
            txt2.setText(R.string.letra_abdominal2);
            txt3.setText(R.string.letra_abdominal3);
            txt4.setText(R.string.letra_abdominal4);
            txt5.setText(R.string.letra_abdominal5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==27){
            gifImageView.setImageResource(R.drawable.flexiones);

            txt1.setText(R.string.letra_flexion1);
            txt2.setText(R.string.letra_flexion2);
            txt3.setText(R.string.letra_flexion3);
            txt4.setText(R.string.letra_flexion4);
            txt5.setText(R.string.letra_flexion5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.triceps);

                    txt1.setText(R.string.letra_triceps1);
                    txt2.setText(R.string.letra_triceps2);
                    txt3.setText(R.string.letra_triceps3);
                    txt4.setText(R.string.letra_triceps4);
                    txt5.setText(R.string.letra_triceps5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.abdominales);

                            txt1.setText(R.string.letra_abdominal1);
                            txt2.setText(R.string.letra_abdominal2);
                            txt3.setText(R.string.letra_abdominal3);
                            txt4.setText(R.string.letra_abdominal4);
                            txt5.setText(R.string.letra_abdominal5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==28){
            gifImageView.setImageResource(R.drawable.plancha);

            txt1.setText(R.string.letra_plancha1);
            txt2.setText(R.string.letra_plancha2);
            txt3.setText(R.string.letra_plancha3);
            txt4.setText(R.string.letra_plancha4);
            txt5.setText(R.string.letra_plancha5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.sentadillas);

                    txt1.setText(R.string.letra_sentadilla1);
                    txt2.setText(R.string.letra_sentadilla2);
                    txt3.setText(R.string.letra_sentadilla3);
                    txt4.setText(R.string.letra_sentadilla4);
                    txt5.setText(R.string.letra_sentadilla5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }
        if(res==29){
            gifImageView.setImageResource(R.drawable.abdominales);

            txt1.setText(R.string.letra_abdominal1);
            txt2.setText(R.string.letra_abdominal2);
            txt3.setText(R.string.letra_abdominal3);
            txt4.setText(R.string.letra_abdominal4);
            txt5.setText(R.string.letra_abdominal5);

            btn.setText(R.string.btn_siguiente);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gifImageView.setImageResource(R.drawable.plancha);

                    txt1.setText(R.string.letra_plancha1);
                    txt2.setText(R.string.letra_plancha2);
                    txt3.setText(R.string.letra_plancha3);
                    txt4.setText(R.string.letra_plancha4);
                    txt5.setText(R.string.letra_plancha5);

                    btn.setText(R.string.btn_siguiente);


                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            gifImageView.setImageResource(R.drawable.disco);

                            txt1.setText(R.string.letra_disco1);
                            txt2.setText(R.string.letra_disco2);
                            txt3.setText(R.string.letra_disco3);
                            txt4.setText(R.string.letra_disco4);
                            txt5.setText(R.string.letra_disco5);

                            btn.setText(R.string.btn_terminar);


                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent=new Intent(RealizarEjercicio.this,EjercicioInicio.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            });

        }

    }

    //para que el boton de ir asia atraz del celular no funcione
    @Override
    public void onBackPressed(){

    }
}
