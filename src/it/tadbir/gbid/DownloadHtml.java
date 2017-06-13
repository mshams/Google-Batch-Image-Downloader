package it.tadbir.gbid;

import it.tadbir.Jbase;
import it.tadbir.net.Download;
import it.tadbir.net.SignalHtml;
import org.apache.http.HttpEntity;

/**
 * Created by m_admin on 6/2/2016.
 */
public class DownloadHtml extends Download implements Runnable {
    public String url;
    public SignalHtml signal;

    public DownloadHtml(String userAgent) {
        super(userAgent);
    }

    @Override
    public void run() {
        getUrl(url);
    }

    private void getUrl(String uri) {
        try {
            HttpEntity entity = getResponse(uri).getEntity();
            if (signal != null)
                signal.Call(entity);
        } catch (Exception e) {
            Jbase.error("Html download error:", e);
        }
    }
}
