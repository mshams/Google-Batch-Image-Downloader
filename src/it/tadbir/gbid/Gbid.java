package it.tadbir.gbid;

import it.tadbir.Jbase;
import it.tadbir.net.Google.Parser;
import it.tadbir.net.SignalHtml;
import it.tadbir.net.SignalImage;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gbid {

    public static final String SAVE_PATH = "download/";
    private static ExecutorService es;
    private static int numHtmlGot = 0;
    private static int numImgGot = 0;
    private static int numImgCount = 0;

    public static void main(String[] args) {
        Jbase.initTracer();

        //initialize Arguments and set variables
        if (!Args.initArgs(args))
            System.exit(1);

        //init thread pool
        es = Executors.newScheduledThreadPool(Args.maxThreads);

        //make save folder
        File target = new File(SAVE_PATH);
        target.mkdirs();


        //process search queries
        for (int i = 0; i < Args.queries.size(); i++) {

            //set a download thread for search result
            DownloadHtml threadHtml = new DownloadHtml(Args.userAgent);
            threadHtml.url = Args.queries.get(i).toString();
            String filename = Args.queries.get(i).getPhrase();

            threadHtml.signal = new SignalHtml() {
                @Override
                public void Call(HttpEntity entity) {
                    numHtmlGot += 1;
                    Jbase.trace(String.format("Html Done (%d/%d): %s", numHtmlGot, Args.queries.size(), filename));

                    //read image urls from html file
                    List<String> imageUrls = null;
                    try {
                        imageUrls = Parser.parseHtml(EntityUtils.toString(entity));

                        //make save search folder
                        File target = new File(SAVE_PATH + filename);
                        target.mkdirs();

                        int urlCount = Math.min(imageUrls.size(), Args.maxFiles);
                        numImgCount += urlCount;

                        //create new thread for each image
                        for (int j = 0; j < urlCount; j++) {
                            DownloadImage threadImage = new DownloadImage(Args.userAgent);
                            threadImage.url = imageUrls.get(j);

                            //set save name for image
                            if (Args.dontRename) {
                                threadImage.filename = SAVE_PATH + filename + "/" + fileName(threadImage.url);
                            } else {
                                threadImage.filename = SAVE_PATH + filename + "/" +
                                        filename + "_" + String.valueOf(j) + "." + fileExt(threadImage.url);
                            }

                            //if verbose switch selected show image download complete

                            threadImage.signal = new SignalImage() {
                                @Override
                                public void Call() {
                                    numImgGot += 1;

                                    if (Args.verbose)
                                        Jbase.trace(String.format("Image Done (%d/%d): %s", numImgGot, numImgCount, threadImage.filename));

                                    //if all the jobs done
                                    if (numImgGot == numImgCount && numHtmlGot == Args.queries.size()) {
                                        Jbase.trace("Gbid jobe done.");
                                        System.exit(0);
                                    }
                                }
                            };


                            //submit image download to thread pool
                            es.submit(threadImage);
                        }


                    } catch (Exception e) {
                        Jbase.error("Query process error:", e.toString());
                    }


                    //shutdown the thread
                    if (numHtmlGot == Args.queries.size()) {
                        if (Args.verbose)
                            Jbase.trace("Queries, job closed.");

                        if (es != null)
                            es.shutdown();
                    }
                }
            };

            //submit html download to thread pool
            es.submit(threadHtml);
        }
    }

    public static String fileName(String s) {
        return s.substring(s.lastIndexOf('/') + 1).split("&")[0].split("\\?")[0].split("#")[0];
    }

    public static String fileExt(String s) {
        try {
            return s.substring(s.lastIndexOf('/') + 1).split("&")[0].split("\\?")[0].split("#")[0].split("_")[0].split("\\.")[1];
        } catch (Exception e) {
            return "jpg";
        }
    }

}
