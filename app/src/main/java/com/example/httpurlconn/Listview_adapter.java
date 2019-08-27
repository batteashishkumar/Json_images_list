package com.example.httpurlconn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.httpurlconn.R;

import java.util.ArrayList;
import java.util.List;

public class Listview_adapter extends BaseAdapter {
    String myBitmap;
    ImageView imag;
    TextView tet;
    Context context;
    ArrayList<Bitmap> image_bitmaps;
    public Listview_adapter(Context context, ArrayList<Bitmap> image_bitmaps){
        this.context=context;
        this.image_bitmaps=image_bitmaps;
        this.image_bitmaps.addAll(image_bitmaps);
        this.image_bitmaps.addAll(image_bitmaps);
        this.image_bitmaps.addAll(image_bitmaps);
//        this.image_bitmaps.addAll(image_bitmaps); this.image_bitmaps.addAll(image_bitmaps);
//        this.image_bitmaps.addAll(image_bitmaps); this.image_bitmaps.addAll(image_bitmaps);
//        this.image_bitmaps.addAll(image_bitmaps); this.image_bitmaps.addAll(image_bitmaps);

    }
    @Override
    public int getCount() {
        return image_bitmaps.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(R.layout.list_view,null);
        imag=convertView.findViewById(R.id.imagee);
        imag.setImageBitmap(image_bitmaps.get(position));
        return convertView;
    }
}
