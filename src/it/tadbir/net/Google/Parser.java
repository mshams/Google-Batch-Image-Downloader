package it.tadbir.net.Google;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import it.tadbir.Jbase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m_admin on 6/2/2016.
 */
public class Parser {

    public static List<String> parseHtml(String document) {
        Document searchDoc = Jsoup.parse(document);

        //Elements contentDiv = searchDoc.select(Constants.Search.Image.TAG_SEARCH_MAIN);
        List<String> imgUrls = new ArrayList<String>();
        Elements results = searchDoc.select(Constants.Search.Image.TAG_SEARCH_RESULT_ITEM);

        Jbase.trace("Item found:", results.size());

        for (Element link : results) {
            String innerUrl = (new Gson().fromJson(link.text(), JsonObject.class))
                    .get(Constants.Search.Image.TAG_SEARCH_RESULT_ITEM_JSON).getAsString();

            imgUrls.add(innerUrl);
        }
        return imgUrls;
    }

}
