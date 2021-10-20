package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class PracticaDiario extends AppCompatActivity {

    private TextView txtTitulo,txtInfo1,txtInfo2,txtInfo3,txtInfo4,txtInfo5;
    private Button btn;
    private GifImageView gifImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_diario);

        txtTitulo=(TextView)findViewById(R.id.tituloPractica);
        txtInfo1=(TextView)findViewById(R.id.descripcionPractica1);
        txtInfo2=(TextView)findViewById(R.id.descripcionPractica2);
        txtInfo3=(TextView)findViewById(R.id.descripcionPractica3);
        txtInfo4=(TextView)findViewById(R.id.descripcionPractica4);
        txtInfo5=(TextView)findViewById(R.id.descripcionPractica5);
        btn=(Button)findViewById(R.id.btnpracticaRealizar);
        gifImageView=(GifImageView)findViewById(R.id.gifPractica);


        final int d1=getIntent().getIntExtra("1",1);

        if(d1==0){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2 );
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar3);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            intent.putExtra("campo",d1);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
         }
       });


        }
        if( d1==1 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
                                           gifImageView.setImageResource(R.drawable.estirarliga);

                                           txtInfo1.setText(R.string.descripcion_liga1);
                                           txtInfo2.setText(R.string.descripcion_liga2);
                                           txtInfo3.setText(R.string.descripcion_liga3);
                                           txtInfo4.setText(R.string.descripcion_liga4);
                                           txtInfo5.setText(R.string.descripcion_liga5);

                                           btn.setText(R.string.btn_siguiente);
                                           btn.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   txtTitulo.setText(R.string.estirar_arco);
                                                   gifImageView.setImageResource(R.drawable.estirararco);
                                                   txtInfo1.setText(R.string.descripcion_arco1);
                                                   txtInfo2.setText(R.string.descripcion_arco2);
                                                   txtInfo3.setText(R.string.descripcion_arco3);
                                                   txtInfo4.setText(R.string.descripcion_arco4);
                                                   txtInfo5.setText(R.string.descripcion_arco5);

                                                   btn.setText(R.string.btn_siguiente);
                                                   btn.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           txtTitulo.setText(R.string.descanso);
                                                           gifImageView.setImageResource(R.drawable.descanso);
                                                           txtInfo1.setText(R.string.descripcion_descanso3);
                                                           txtInfo2.setText(R.string.descripcion_descanso1);
                                                           txtInfo3.setText(R.string.descripcion_descanso3);
                                                           txtInfo4.setText(R.string.descripcion_descanso2);
                                                           txtInfo5.setText(R.string.descripcion_descanso3);

                                                           btn.setText(R.string.btn_siguiente);
                                                           btn.setOnClickListener(new View.OnClickListener() {
                                                               @Override
                                                               public void onClick(View view) {
                                                                   txtTitulo.setText(R.string.tirar);
                                                                   gifImageView.setImageResource(R.drawable.disparar);
                                                                   txtInfo1.setText(R.string.descripcion_tirar1);
                                                                   txtInfo2.setText(R.string.descripcion_tirar2);
                                                                   txtInfo3.setText(R.string.descripcion_tirar3);
                                                                   txtInfo4.setText(R.string.descripcion_tirar4);
                                                                   txtInfo5.setText("");

                                                                   btn.setText(R.string.btn_terminar);
                                                                   btn.setOnClickListener(new View.OnClickListener() {
                                                                       @Override
                                                                       public void onClick(View view) {
                                                                           Intent intent = new Intent(PracticaDiario.this, PracticaInicio.class);
                                                                           //intent.putExtra();
                                                                           startActivity(intent);
                                                                       }
                                                                   });
                                                               }
                                                           });
                                                       }
                                                   });
                                               }
                                           });

             }
            });


        }
        if( d1==2 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
             txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar3);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            //intent.putExtra();
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
        }
    });


        }
        if(d1==3 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar3);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            //intent.putExtra();
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if(d1==4 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar3);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            //intent.putExtra();
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
        }
    });
        }
        if(d1==5 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);

                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);
                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar3);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });

                                       }
            });

        }
        if( d1==6 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);

                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);
                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar3);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if( d1==7 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);

                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);
                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if( d1==8 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);

                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);
                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if(d1==9 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);

                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);
                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if(d1==10 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if( d1==11 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if( d1==12 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if( d1==13 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar5);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if(d1==14 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if(d1==15 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
            txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==16 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if(d1==17 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==18 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if(d1==19 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);

                    gifImageView.setImageResource(R.drawable.estirararco);
                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);


                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);

                                    gifImageView.setImageResource(R.drawable.disparar);
                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if(d1==20 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);



                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar6);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==21 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);



                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==22 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);



                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==23 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);



                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if(d1==24 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);
            gifImageView.setImageResource(R.drawable.estirarliga);

            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);



                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if(d1==25 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if( d1==26 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==27 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });


        }
        if( d1==28 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
                                       }
            });

        }
        if(d1==29 ){
            txtTitulo.setText(R.string.calentamiento);
            gifImageView.setImageResource(R.drawable.calemtamiento);
            txtInfo1.setText(R.string.calentamiento1);
            txtInfo2.setText(R.string.calentamiento2);
            txtInfo3.setText(R.string.calentamiento3);
            txtInfo4.setText(R.string.calentamiento4);
            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           txtTitulo.setText(R.string.estirar_liga);

            gifImageView.setImageResource(R.drawable.estirarliga);
            txtInfo1.setText(R.string.descripcion_liga1);
            txtInfo2.setText(R.string.descripcion_liga2);
            txtInfo3.setText(R.string.descripcion_liga3);
            txtInfo4.setText(R.string.descripcion_liga4);
            txtInfo5.setText(R.string.descripcion_liga5);

            btn.setText(R.string.btn_siguiente);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtTitulo.setText(R.string.estirar_arco);
                    gifImageView.setImageResource(R.drawable.estirararco);

                    txtInfo1.setText(R.string.descripcion_arco1);
                    txtInfo2.setText(R.string.descripcion_arco2);
                    txtInfo3.setText(R.string.descripcion_arco3);
                    txtInfo4.setText(R.string.descripcion_arco4);
                    txtInfo5.setText(R.string.descripcion_arco5);

                    btn.setText(R.string.btn_siguiente);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtTitulo.setText(R.string.descanso);
                            gifImageView.setImageResource(R.drawable.descanso);
                            txtInfo1.setText(R.string.descripcion_descanso3);
                            txtInfo2.setText(R.string.descripcion_descanso1);
                            txtInfo3.setText(R.string.descripcion_descanso3);
                            txtInfo4.setText(R.string.descripcion_descanso2);
                            txtInfo5.setText(R.string.descripcion_descanso3);

                            btn.setText(R.string.btn_siguiente);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    txtTitulo.setText(R.string.tirar);
                                    gifImageView.setImageResource(R.drawable.disparar);

                                    txtInfo1.setText(R.string.descripcion_tirar1);
                                    txtInfo2.setText(R.string.descripcion_tirar2);
                                    txtInfo3.setText(R.string.descripcion_tirar7);
                                    txtInfo4.setText(R.string.descripcion_tirar4);
                                    txtInfo5.setText("");

                                    btn.setText(R.string.btn_terminar);
                                    btn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent=new Intent(PracticaDiario.this,PracticaInicio.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                            });
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
