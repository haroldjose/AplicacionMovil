package tiroconarco.harold.tesisporyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Estadistica extends AppCompatActivity {

    PieChart grafica;
   // GraphView barra;
    BarChart barra;
    ArrayList<Integer> colores=new ArrayList<>();
    private TextView flechaDisparada,puntajeTotal,porcentajeAcierto,puntajeMedio;
    int cantidadDisparos;
    private float uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,diez,x,m,ronda1,ronda2,ronda3,ronda4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        // flecha ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        grafica=(PieChart) findViewById(R.id.graficaTorta);
        barra=(BarChart) findViewById(R.id.graficaBarra);

        flechaDisparada=(TextView) findViewById(R.id.flechaDisparada);
        puntajeTotal=(TextView) findViewById(R.id.puntajeTotal);
        porcentajeAcierto=(TextView) findViewById(R.id.porcentajeAcierto);
        puntajeMedio=(TextView) findViewById(R.id.puntuacionMedio);

        Bundle objetoEnviado=getIntent().getExtras();

        if(objetoEnviado!=null){
            uno=objetoEnviado.getFloat("uno");
            dos=objetoEnviado.getFloat("dos");
            tres=objetoEnviado.getFloat("tres");
            cuatro=objetoEnviado.getFloat("cuatro");
            cinco=objetoEnviado.getFloat("cinco");
            seis=objetoEnviado.getFloat("seis");
            siete=objetoEnviado.getFloat("siete");
            ocho=objetoEnviado.getFloat("ocho");
            nueve=objetoEnviado.getFloat("nueve");
            diez=objetoEnviado.getFloat("diez");
            x=objetoEnviado.getFloat("x");
            m=objetoEnviado.getFloat("m");
            ronda1=objetoEnviado.getFloat("ronda1");
            ronda2=objetoEnviado.getFloat("ronda2");
            ronda3=objetoEnviado.getFloat("ronda3");
            ronda4=objetoEnviado.getFloat("ronda4");
        }
        final int disparos=getIntent().getIntExtra("disparos",1000);
        final int puntaje=getIntent().getIntExtra("puntaje",1000);
        final int acierto=getIntent().getIntExtra("acierto",1000);
        final int media=getIntent().getIntExtra("media",1000);
         cantidadDisparos=getIntent().getIntExtra("cantidadDisparos",1000);

        flechaDisparada.setText(disparos+"");
        puntajeTotal.setText(puntaje+"");
        int porcentaje=(puntaje/disparos);
        porcentajeAcierto.setText(porcentaje+"");
        int porMedia=(puntaje/media);
        puntajeMedio.setText(porMedia+"");

        crearGraficoPastel();
        crearGraficoBarra();

    }

    private void crearGraficoBarra() {
        List<BarEntry> entrada=new ArrayList<>();
        entrada.add(new BarEntry(1f,ronda1));
        entrada.add(new BarEntry(2f,ronda2));
        entrada.add(new BarEntry(3f,ronda3));
        entrada.add(new BarEntry(4f,ronda4));
        BarDataSet datos=new BarDataSet(entrada,"grafica total por ronda");
        BarData data=new BarData(datos);
        datos.setColors(ColorTemplate.COLORFUL_COLORS);
        data.setBarWidth(0.9f);
        barra.setData(data);
        barra.setFitBars(true);
        barra.invalidate();


    }

    private void crearGraficoPastel() {
        colores.add(getResources().getColor(R.color.amarrilloX));
        colores.add(getResources().getColor(R.color.amarrillo10));
        colores.add(getResources().getColor(R.color.amarrillo9));
        colores.add(getResources().getColor(R.color.rojo8));
        colores.add(getResources().getColor(R.color.rojo7));
        colores.add(getResources().getColor(R.color.celeste6));
        colores.add(getResources().getColor(R.color.celeste5));
        colores.add(getResources().getColor(R.color.negro4));
        colores.add(getResources().getColor(R.color.negro3));
        colores.add(getResources().getColor(R.color.blanco2));
        colores.add(getResources().getColor(R.color.blanco1));
        colores.add(getResources().getColor(R.color.blancoM));
        Description description=new Description();
        description.setText("aciertos");
        grafica.setDescription(description);
        grafica.setEntryLabelColor(Color.CYAN);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(x,"X"));
        pieEntries.add(new PieEntry(diez,"10"));
        pieEntries.add(new PieEntry(nueve,"9"));
        pieEntries.add(new PieEntry(ocho,"8"));
        pieEntries.add(new PieEntry(siete,"7"));
        pieEntries.add(new PieEntry( seis, "6"));
        pieEntries.add(new PieEntry(cinco,"5"));
        pieEntries.add(new PieEntry(cuatro,"4"));
        pieEntries.add(new PieEntry(tres,"3"));
        pieEntries.add(new PieEntry(dos,"2"));
        pieEntries.add(new PieEntry(uno,"1"));
        pieEntries.add(new PieEntry(m,"M"));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"valores torta");
        pieDataSet.setColors(colores);
        pieDataSet.setValueLineWidth(1);
        pieDataSet.setSliceSpace(5f);
        pieDataSet.setValueTextColor(Color.MAGENTA);
        PieData pieData=new PieData(pieDataSet);
        grafica.invalidate();
        grafica.setData(pieData);
    }


}
