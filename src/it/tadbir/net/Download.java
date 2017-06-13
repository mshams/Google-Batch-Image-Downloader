package it.tadbir.net;

import it.tadbir.Jbase;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by m_admin on 6/2/2016.
 */
public class Download {
    private static final int TIMEOUT_MILLIS = 30000;
    private String userAgent;
    private LayeredConnectionSocketFactory sslsf;

    public Download(String userAgent) {
        this.userAgent = userAgent;

        //set ssl context for httpclient
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext);
        } catch (Exception e) {
            Jbase.error("SSL error:", e);
        }
    }

    public HttpResponse getResponse(String url) {
        Jbase.trace("Get: ", url);
        HttpClient client = HttpClientBuilder.create().setUserAgent(userAgent)
                .setSSLSocketFactory(sslsf).disableCookieManagement().build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(TIMEOUT_MILLIS)
                .setConnectTimeout(TIMEOUT_MILLIS)
                .setConnectionRequestTimeout(TIMEOUT_MILLIS)
                .build();

        HttpGet request = new HttpGet(url);
        request.setConfig(requestConfig);
        HttpResponse result = null;

        try {
            result = client.execute(request);
        } catch (Exception e) {
            Jbase.error("Download error:", e);
        }

        return result;
    }
}
