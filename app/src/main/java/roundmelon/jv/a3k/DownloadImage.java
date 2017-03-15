package roundmelon.jv.a3k;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Joseph on 13/03/17.
 */

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    Context context;
    ProgressDialog progressDialog;


    public DownloadImage(ImageView bmImage, Context context, ProgressDialog progressDialog) {
        this.bmImage = bmImage;
        this.context=context;
        this.progressDialog=progressDialog;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        Bitmap bigImage = result;

        Bitmap smallImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.dp);
        Bitmap mergedImages = createSingleImageFromMultipleImages(bigImage, smallImage);

        bmImage.setImageBitmap(mergedImages);
        writeToFile(mergedImages);
        progressDialog.dismiss();
        return;


    }

    void writeToFile(Bitmap mergedImages)
    {
        File folder = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "A3K");

        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
        if (success) {
            // Toast.makeText(context, "Already exists", Toast.LENGTH_LONG).show();
            Toast.makeText(context,"Image Successfully Stored In Pictures",Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(context, "Error creating directory", Toast.LENGTH_LONG).show();
            return;
        }
        //create a file to write bitmap data
        //Log.d("FILE",folder.getPath());
        File f = new File(folder.getPath(), "profile_picture.png");
        // Log.d("FILE",f.getPath());
        try{
            f.createNewFile();
//Convert bitmap to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            mergedImages.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();

            //write the bytes in file
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            // Log.d("FILE","file created !");
        }
        catch(IOException e){
            Toast.makeText(context,"Some error occurred while storing the badge to your device",Toast.LENGTH_LONG).show();
        }
    }


    private static Bitmap createSquaredBitmap(Bitmap srcBmp) {


        int dim = Math.max(srcBmp.getWidth(), srcBmp.getHeight());
        Bitmap dstBmp = Bitmap.createBitmap(dim, dim, Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(dstBmp);
        //canvas.drawColor(Color.argb(255,37,155,142));
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(srcBmp, (dim - srcBmp.getWidth()) / 2, 0, null);

        return dstBmp;
    }
    private Bitmap createSingleImageFromMultipleImages(Bitmap firstImage, Bitmap secondImage){
        firstImage=createSquaredBitmap(firstImage);
        Bitmap result = Bitmap.createBitmap(firstImage.getWidth(), firstImage.getHeight(), firstImage.getConfig());

        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(firstImage, 0f, 0f, null);
        canvas.drawBitmap(Bitmap.createScaledBitmap(secondImage,firstImage.getWidth(), firstImage.getHeight(), false), 0f, 0f, null);
        return result;
    }

}
