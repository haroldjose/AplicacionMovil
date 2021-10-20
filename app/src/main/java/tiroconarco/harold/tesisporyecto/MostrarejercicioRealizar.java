package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MostrarejercicioRealizar extends AppCompatActivity {

     ImageView imagen1,imagen2,imagen3;
     TextView texto1,texto2,texto3;
     Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarejercicio_realizar);

        imagen1=(ImageView)findViewById(R.id.imageView1);
        imagen2=(ImageView)findViewById(R.id.imageView2);
        imagen3=(ImageView)findViewById(R.id.imageView3);
        texto1=(TextView)findViewById(R.id.textViewprimero);
        texto2=(TextView)findViewById(R.id.textViewsegundo);
        texto3=(TextView)findViewById(R.id.textViewtercero);
        comenzar=(Button)findViewById(R.id.buttonComenzar);

        final int ejercicio=getIntent().getIntExtra("ejercicio",100);

        mostrarEjercicios(ejercicio);


    }

    private void mostrarEjercicios(final int ejercicioElegido) {
        if (ejercicioElegido == 0){

            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);
                }
            });

        }else if (ejercicioElegido == 1){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });

        }else if (ejercicioElegido == 2){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido == 3){
            texto1.setText(R.string.sentadilla);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido == 4){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido == 5){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido ==  6){
            texto1.setText(R.string.sentadilla);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido == 7){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.sentadilla);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });

        }else if (ejercicioElegido == 8){
            texto1.setText(R.string.sentadilla);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });

        }else if (ejercicioElegido == 9){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==10){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==11){
            texto1.setText(R.string.sentadilla);
            texto2.setText(R.string.plancha);
            texto3.setText( R.string.disco);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==12){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==13){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==14){
            texto1.setText(R.string.sentadilla);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==15){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.sentadilla);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==16){
            texto1.setText(R.string.abdominal);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==17){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==18){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==19){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==20){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==21){
            texto1.setText(R.string.sentadilla);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==22){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.sentadilla);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==23){
            texto1.setText(R.string.abdominal);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==24){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==25){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.sentadilla);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==26){
            texto1.setText(R.string.abdominal);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==27){
            texto1.setText(R.string.flexion);
            texto2.setText(R.string.tricep);
            texto3.setText(R.string.abdominal);
            Picasso.get().load(R.drawable.flexion).fit().into(imagen1);
            Picasso.get().load(R.drawable.tricep).fit().into(imagen2);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==28){
            texto1.setText(R.string.plancha);
            texto2.setText(R.string.sentadilla);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen1);
            Picasso.get().load(R.drawable.sentadilla).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }else if (ejercicioElegido==29){
            texto1.setText(R.string.abdominal);
            texto2.setText(R.string.plancha);
            texto3.setText(R.string.disco);
            Picasso.get().load(R.drawable.abdominal).fit().into(imagen1);
            Picasso.get().load(R.drawable.plancha).fit().into(imagen2);
            Picasso.get().load(R.drawable.disco).fit().into(imagen3);
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    comenzar(ejercicioElegido);

                }
            });
        }

    }

    private void comenzar(int ejercicio) {
        Intent intent=new Intent(MostrarejercicioRealizar.this,RealizarEjercicio.class);
        intent.putExtra("a",ejercicio);
        startActivity(intent);
    }

    //para que el boton de ir asia atraz del celular no funcione
    @Override
    public void onBackPressed(){

    }
}
