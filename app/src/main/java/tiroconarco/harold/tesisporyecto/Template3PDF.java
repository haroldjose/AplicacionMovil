package tiroconarco.harold.tesisporyecto;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Template3PDF {
     private Context context;
     private File pdfFile;
     private Document document;
     private PdfWriter pdfWriter;
     private Paragraph paragraph;
     private Font fTitle=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD, BaseColor.BLACK);
    private Font fSubTitle=new Font(Font.FontFamily.TIMES_ROMAN,15,Font.BOLD, BaseColor.BLACK);
    private Font fText=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD, BaseColor.BLACK);

    public Template3PDF(Context context) {
        this.context=context;
    }
    //creamos el documento donde se especifica el tamaño de la hoja
    public void openDocument()  {
        createFile();
        try{
            document=new Document(PageSize.LETTER);
            pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(pdfFile));
            document.open();
        }catch (Exception e){
            Log.e("openDocument",e.toString());
        }
    }

    // creamos el folder
    private void createFile()  {
        String nameDirectory="/Archery";
        File folder=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+nameDirectory);//nombre de la carpeta
        if(!folder.exists())
            folder.mkdirs() ;
            String pdfName="datosArquero.pdf";
            pdfFile=new File(folder.getAbsolutePath(),pdfName); // nombre del archivo
    }
    // cerrar el documento
    public void closeDocument(){
        document.close();
    }

    // insertar los datos con metadatos agregamos el titulo,nombre arquero,nombre club y nombre ronda

    public void adMetaData(String title,String club, String ronda){ //,String archery esto va dentro el metodo
        document.addTitle(title);
        document.addSubject(club);
        document.addAuthor(ronda);
       // document.addAuthor(archery);
    }

    // creamos el titulo , subtitulo y fecha
    public void  addTitles(String title,String subTitle, String date){
        try {
            paragraph = new Paragraph();
            addChildP(new Paragraph(title, fTitle));
            addChildP(new Paragraph(subTitle, fSubTitle));
            addChildP(new Paragraph(date, fText));
            paragraph.setSpacingAfter(30);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("addTitles",e.toString());
        }
    }
    private  void addChildP(Paragraph childParagraph){
        childParagraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(childParagraph);
    }
    //texto grande o pequeño que forma un parrafo
    public  void addParagraph(String text){
        try {
            paragraph = new Paragraph(text,fText);
            paragraph.setSpacingAfter(5);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("addParagraph",e.toString());
        }
    }
    // creacion de tablas
    public void createTable(String [] header, ArrayList<String[]>puntos){
      try {
        paragraph=new Paragraph();
        paragraph.setFont(fText);
        PdfPTable pdfPTable=new PdfPTable(header.length);
        pdfPTable.setWidthPercentage(100);
        pdfPTable.setSpacingBefore(20);
        PdfPCell pdfPCell;
        int indexC=0;
        //cantidad de titulos
        while(indexC<header.length){
            pdfPCell=new PdfPCell(new Phrase(header[indexC++],fSubTitle));
            pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPTable.addCell(pdfPCell);
        }
        for(int indexR=0;indexR<puntos.size();indexR++){
            String[] row=puntos.get(indexR);
            for (indexC=0;indexC<header.length;indexC++){
                pdfPCell=new PdfPCell(new Phrase(row[indexC],fText));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setFixedHeight(20);
                pdfPTable.addCell(pdfPCell);
            }
        }
        paragraph.add(pdfPTable);
        document.add(paragraph);
      }catch (Exception e){
          Log.e("createTable",e.toString());
      }
    }

    public void viewPDF(){
        Intent intent=new Intent(context,ViewPDF3.class);
        intent.putExtra("path",pdfFile.getAbsolutePath());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    public void appViewPDF(Activity activity){

        if(pdfFile.exists()){
            Uri uri=Uri.fromFile(pdfFile);
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri,"application/pdf");
            try {
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());
                activity.startActivity(intent);
            }catch (ActivityNotFoundException e){
                activity.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.adobe.reader&hl=es_419")));
                Toast.makeText(activity.getApplicationContext(),"no cuenta con un aplicacion de archivo pdf",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(activity.getApplicationContext(),"no se encontro el archivo",Toast.LENGTH_LONG).show();
        }

    }
}
