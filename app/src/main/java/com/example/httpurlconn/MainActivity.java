package com.example.httpurlconn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    Listview_adapter adapter;
    StringBuilder sb=null;
    String uri = "https://api.androidhive.info/json/glide.json";
    List<String> bitimagearray ;
    ImageView image1;
    ListView list;
    ArrayList<Bitmap> image_bitmaps;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitimagearray = new ArrayList<>();
        list=findViewById(R.id.list);
        sb=new StringBuilder();
        instance=this;
    }
    public static MainActivity getInstance() {
        return instance;
    }


public void call(View view){
    HttpPostAsyncTask asyncTask=new HttpPostAsyncTask(uri,MainActivity.this);
    asyncTask.execute();
}
public void set_name_link_n_call_download(List<String> name , List<String> link){
    DownloadImageTask asyncTask = new DownloadImageTask(image1,link);
    asyncTask.execute();
}

public void get_allimagestrings(ArrayList<Bitmap> image_bitmaps) {

    this.image_bitmaps = image_bitmaps;
    adapter=new Listview_adapter(this,image_bitmaps);
    list.setAdapter(adapter);
}

}