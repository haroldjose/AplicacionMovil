package tiroconarco.harold.tesisporyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<CheckDia> number;

    public MyAdapter(Context context,int layout,ArrayList<CheckDia> number){
        this.context=context;
        this.layout=layout;
        this.number=number;
    }
    @Override
    public int getCount() {
       return number.size();

    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(this.layout,null);
            holder= new ViewHolder();
            //aqui los nuevos textos y  lo demas
            holder.numberTextView=convertView.findViewById(R.id.txtViewGrid);
            holder.v=(TextView)convertView.findViewById(R.id.txtViewGrid);
            convertView.setTag(holder);
        }else {
                holder=(ViewHolder) convertView.getTag();

       }
        holder.numberTextView.setText(number.get(position).getNumeroDia());
        if(number.get(position).getCheckDia().equals("1")){
            holder.v.setText("");
            holder.v.setBackgroundResource(R.drawable.ic_check_circle);
        }


        return convertView;
    }
    static class ViewHolder{
        // aqui los nombres de los nuevos textos
        private TextView numberTextView;
        private TextView v;
    }

}
