package com.example.httpurlconn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DownloadImageTask extends AsyncTask<String, Void, ArrayList<Bitmap>> {

    ImageView bmImage;
    List<String> image_links;
    List<String> image_strings;

    public DownloadImageTask(ImageView bmImage, List<String> image_links) {
        this.bmImage = bmImage;
        this.image_links = image_links;
    }

    protected ArrayList<Bitmap> doInBackground(String... urls) {
        ArrayList<Bitmap> mIcon11 = new ArrayList<Bitmap>();

        for (int i = 0; i < image_links.size(); i++) {
            try {
                InputStream in = new java.net.URL(image_links.get(i)).openStream();
                mIcon11.add(BitmapFactory.decodeStream(in));
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
        }

        return mIcon11;
    }

    protected void onPostExecute(ArrayList<Bitmap> result) {

        image_strings = new ArrayList<>();
        MainActivity.getInstance().get_allimagestrings(result);
    }
}