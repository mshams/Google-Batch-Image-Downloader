package it.tadbir.net.Google;

import it.tadbir.Jbase;
import org.apache.commons.compress.utils.CharsetNames;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by www.mshams.ir on 6/1/2016.
 * <p>
 * <p>
 * Jbase.trace(new Googler().setQuery("as3").setDomain("www.mshams.ir")
 * .setOption()
 * .setFileType(Google.Search.Image.FILE_TYPE_KEY_PNG)
 * .setColor(Google.Search.Image.COLOR_KEY_SPEC, Google.Search.Image.COLOR_SPEC_VAL_RED).toString());
 * <p>
 * Jbase.trace(new Googler().setQuery("mohammad shams")
 * .setOption()
 * .setType(Google.Search.Image.TYPE_KEY_PHOTO)
 * .setAspect(Google.Search.Image.ASPECT_KEY_TALL).toString());
 * <p>
 * Jbase.trace(new Googler().setQuery("persian flag")
 * .setOption()
 * .setFileType(Google.Search.Image.FILE_TYPE_VAL_PNG)
 * .setColor(Google.Search.Image.COLOR_KEY_TRANSPARENT, null).toString());
 * <p>
 * Jbase.trace(new Googler().setQuery("running man")
 * .setOption()
 * .setType(Google.Search.Image.TYPE_KEY_ANIMATED)
 * .setFileType(Google.Search.Image.FILE_TYPE_KEY_ICO)
 * .setColor(Google.Search.Image.COLOR_KEY_SPEC, Google.Search.Image.COLOR_SPEC_VAL_BLACK).toString());
 * <p>
 * Jbase.trace(new Googler().setQuery("white lion")
 * .setStart(20)
 * .setOption()
 * .setSize(Google.Search.Image.SIZE_KEY_LARGE, null, 0, 0)
 * .setFileType(Google.Search.Image.FILE_TYPE_KEY_JPG)
 * .setColor(Google.Search.Image.COLOR_KEY_SPEC, Google.Search.Image.COLOR_SPEC_VAL_WHITE).toString());
 */

public class Googler {
    private String query;
    private GoogleOption option;
    private String phrase;
    private final String SEP_PARAM = "&";
    private final String SEP_OPTION = ",";

    public Googler() {
        this.query = Constants.Search.Image.BASE_STR;
    }

    public Googler clone() {
        Googler obj = new Googler();
        obj.query = this.query;
        obj.option = this.option;
        obj.phrase = this.phrase;
        return obj;
    }

    public String getPhrase() {
        return phrase;
    }

    //set search query phrase
    public Googler setQuery(String phrase) {
        try {
            this.phrase = phrase;
            String url = URLEncoder.encode(phrase, CharsetNames.UTF_8);
            query = query.concat(SEP_PARAM + Constants.Search.Image.QUERY_STR + url);
        } catch (UnsupportedEncodingException e) {
            Jbase.error("Query error:", e.getMessage());
        }
        return this;
    }

    //set domain of search
    public Googler setDomain(String name) {
        try {
            String url = URLEncoder.encode(name, CharsetNames.UTF_8);
            query = query.concat(SEP_PARAM + Constants.Search.Image.DOMAIN_STR + url);
        } catch (UnsupportedEncodingException e) {
            Jbase.error("Domain error:", e.getMessage());
        }
        return this;
    }

    //set start point of results
    public Googler setStart(Integer n) {
        if (n > 0)
            query = query.concat(SEP_PARAM + Constants.Search.Image.START_STR + n.toString());

        return this;
    }

    //set other options
    public GoogleOption setOption() {
        if (option == null) {
            option = new GoogleOption(this);
        }
        return option;
    }

    public String toString() {
        return query;
    }


    public class GoogleOption {
        private Googler parent;

        public String toString() {
            return query;
        }

        public Googler build() {
            return parent;
        }

        //set default key for option
        public GoogleOption(Googler parent) {
            query = query.concat(SEP_PARAM + Constants.Search.Image.OPTION_STR);
            this.parent = parent;
        }

        //set image type
        public GoogleOption setType(String key) {
            String val = Constants.Search.Image.TYPE.get(key);
            if (val != null)
                query = query.concat(SEP_OPTION + Constants.Search.Image.TYPE_STR + val);
            return this;
        }

        //set file type extension
        public GoogleOption setFileType(String key) {
            String val = Constants.Search.Image.FILETYPE.get(key);
            if (val != null)
                query = query.concat(SEP_OPTION + Constants.Search.Image.FILETYPE_STR + val);
            return this;
        }

        //set aspect ratio
        public GoogleOption setAspect(String key) {
            String val = Constants.Search.Image.ASPECT.get(key);
            if (val != null)
                query = query.concat(SEP_OPTION + Constants.Search.Image.ASPECT_STR + val);
            return this;
        }

        //set usage rights
        public GoogleOption setRights(String key) {
            String val = Constants.Search.Image.RIGHTS.get(key);
            if (val != null)
                query = query.concat(SEP_OPTION + Constants.Search.Image.RIGHTS_STR + val);
            return this;
        }

        //set size of image
        public GoogleOption setSize(String key, String largerThanKey, Integer widthVal, Integer heightVal) {
            String val = Constants.Search.Image.SIZE.get(key);
            if (val != null) {

                //set size larger than
                if (val.equals(Constants.Search.Image.SIZE_VAL_LARGER)) {
                    if (Constants.Search.Image.SIZE_LT.get(largerThanKey) != null) {
                        query = query.concat(SEP_OPTION + Constants.Search.Image.SIZE_STR + val +
                                Constants.Search.Image.SIZE_LT_STR + Constants.Search.Image.SIZE_LT.get(largerThanKey));

                    }
                }
                //set size exactly to w, h
                else if (val.equals(Constants.Search.Image.SIZE_VAL_SPEC)) {
                    query = query.concat(SEP_OPTION + Constants.Search.Image.SIZE_STR + val +
                            Constants.Search.Image.SIZE_SPECW_STR + widthVal.toString() +
                            Constants.Search.Image.SIZE_SPECH_STR + heightVal.toString());
                }
                //set default size selected
                else {
                    query = query.concat(SEP_OPTION + Constants.Search.Image.SIZE_STR + val);
                }
            }

            return this;
        }

        //set color of image
        public GoogleOption setColor(String key, String colorValue) {
            String val = Constants.Search.Image.COLOR.get(key);
            if (val != null) {

                //set specific color
                if (val.equals(Constants.Search.Image.COLOR_VAL_SPEC)) {
                    if (Constants.Search.Image.COLOR_SPEC.get(colorValue) != null) {
                        query = query.concat(SEP_OPTION + Constants.Search.Image.COLOR_STR + val +
                                Constants.Search.Image.COLOR_SPEC_STR + Constants.Search.Image.COLOR_SPEC.get(colorValue));

                    }
                }
                //set default color selected
                else {
                    query = query.concat(SEP_OPTION + Constants.Search.Image.COLOR_STR + val);
                }
            }

            return this;
        }


    }
}
