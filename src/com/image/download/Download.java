package com.image.download;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class Download implements Runnable{

    String link;
    File out;

    public Download(String link, File out){
        this.link = link;
        this.out = out;
    }

    @Override
    public void run() {
        try{
            URL url = new URL(link);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            double fileSize = (double) httpsURLConnection.getContentLengthLong();
            BufferedInputStream in = new BufferedInputStream(httpsURLConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDownload = 0.00;

            while((read = in.read(buffer, 0, 1024)) >= 0) {
                bout.write(buffer, 0, read);
                downloaded += read;
                percentDownload = (downloaded * 100) / fileSize;
                String percent = String.format("%.4f", percentDownload);
                System.out.println("Downloaded " + percent + "% of a file.");
            }
            bout.close();
            in.close();
            System.out.println("Download Completed!");
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
