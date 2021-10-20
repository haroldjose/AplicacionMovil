package tiroconarco.harold.tesisporyecto;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {

    public MyKeyboard(Context context){
        this(context,null,0);
    }
    public MyKeyboard(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }
    public MyKeyboard(Context context, AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        init(context,attrs);
    }

    private Button btnX,btn10,btn9,btn8,btn7,btn6,btn5,btn4,btn3,btn2,btn1,btnM,btnDelete;

   private SparseArray<String> keyValues=new SparseArray<>();

   private InputConnection inputConnection;


    private void init(Context context,AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.keyboard,this,true);

        btnX=(Button)findViewById(R.id.btnX);
        btnX.setOnClickListener(this);
        btn10=(Button)findViewById(R.id.btn10);
        btn10.setOnClickListener(this);
        btn9=(Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn8=(Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn7=(Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn6=(Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn5=(Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn4=(Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn3=(Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btnM=(Button)findViewById(R.id.btnM);
        btnM.setOnClickListener(this);
        btnDelete=(Button)findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);


        keyValues.put(R.id.btnX,"X");
        keyValues.put(R.id.btn10,"10");
        keyValues.put(R.id.btn9,"9");
        keyValues.put(R.id.btn8,"8");
        keyValues.put(R.id.btn7,"7");
        keyValues.put(R.id.btn6,"6");
        keyValues.put(R.id.btn5,"5");
        keyValues.put(R.id.btn4,"4");
        keyValues.put(R.id.btn3,"3");
        keyValues.put(R.id.btn2,"2");
        keyValues.put(R.id.btn1,"1");
        keyValues.put(R.id.btnM,"M");

    }

    @Override
    public void onClick(View view) {
       if(inputConnection==null){
           return;
       }
       if(view.getId() == R.id.btnDelete){
           CharSequence selectedText=inputConnection.getSelectedText(0);
           if(TextUtils.isEmpty(selectedText)){
               inputConnection.deleteSurroundingText(1,0);

           }else{
               inputConnection.commitText("",1);
           }

       }else {
           String value=keyValues.get(view.getId());
           inputConnection.deleteSurroundingText(2,1);
           inputConnection.deleteSurroundingText(1,0);
           inputConnection.commitText(value,1);
       }


    }

    public void setInputConnection(InputConnection ic){
       this.inputConnection=ic;
    }


}
