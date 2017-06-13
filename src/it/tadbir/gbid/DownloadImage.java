package it.tadbir.gbid;

import it.tadbir.Jbase;
import it.tadbir.net.Download;
import it.tadbir.net.SignalImage;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.http.HttpEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by m_admin on 6/2/2016.
 */
public class DownloadImage extends Download implements Runnable {
    public String url;
    public String filename;
    public SignalImage signal;

    public DownloadImage(String userAgent) {
        super(userAgent);
    }

    @Override
    public void run() {
        save(url);
    }

    public void save(String uri) {
        HttpEntity entity = getResponse(uri).getEntity();

        try {
            File target = new File(filename);
            OutputStream outputStream = new FileOutputStream(target);
            InputStream inputStream = null;
            inputStream = entity.getContent();
            IOUtils.copy(inputStream, outputStream);
            inputStream.close();
            outputStream.close();
            if (signal != null)
                signal.Call();

        } catch (Exception e) {
            Jbase.error("Img download error:", e);
        }
    }
}
