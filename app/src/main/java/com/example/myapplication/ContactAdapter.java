package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contactclass> {
    Context context ;
    ArrayList<Contactclass> contactclassArrayList;
    int id;

    public ContactAdapter(Context context, int id, ArrayList<Contactclass> contactclassArrayList) {
        super(context,id, contactclassArrayList);
        this.context = context;
        this.contactclassArrayList = contactclassArrayList;
        this.id = id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder;
        if(view==null) {
            viewholder = new Viewholder();
            view = LayoutInflater.from(context).inflate(R.layout.contact,viewGroup,false);

            //ánh xạ view
            viewholder.txtten = (TextView) view.findViewById(R.id.txt_ten);
            viewholder.txtphonenumer = (TextView) view.findViewById(R.id.txt_phonenumber);
            viewholder.imghinh = (ImageView) view.findViewById(R.id.viewhinh);
            view.setTag(viewholder);
        }
        else{
            viewholder = (Viewholder) view.getTag();
        }
        //gán giá trị


        Contactclass Contactclass = contactclassArrayList.get(i);
        viewholder.txtten.setText(Contactclass.getTen());
        viewholder.txtphonenumer.setText(Contactclass.getPhoneNumber());
        viewholder.imghinh.setImageResource(Contactclass.getHinh());
        return view;
    }
    public class  Viewholder{
        TextView txtten;
        TextView txtphonenumer;
        ImageView imghinh;
    }
}
