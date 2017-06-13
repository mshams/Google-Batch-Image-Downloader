package it.tadbir.net.Google;

import java.util.HashMap;

/**
 * Created by www.mshams.ir on 6/1/2016.
 */


public class Constants {
    public static class Search {
        public static class Image {
            public static final String TAG_SEARCH_MAIN = "div#search";
            public static final String TAG_SEARCH_RESULT_ITEM = "div.rg_meta";
            public static final String TAG_SEARCH_RESULT_ITEM_JSON = "ou";

            public static final String BASE_STR = "https://google.com/search?tbm=isch";
            public static final String DOMAIN_STR = "as_sitesearch=";
            public static final String START_STR = "start=";
            public static final String QUERY_STR = "q=";
            public static final String OPTION_STR = "tbs=";

            //--------------------------------------------------------------------------------------------
            public static final String TYPE_STR = "itp:";
            public static final HashMap<String, String> TYPE = new HashMap<String, String>() {{
                put(TYPE_KEY_FACE, TYPE_VAL_FACE);
                put(TYPE_KEY_PHOTO, TYPE_VAL_PHOTO);
                put(TYPE_KEY_CLIPART, TYPE_VAL_CLIPART);
                put(TYPE_KEY_LINEART, TYPE_VAL_LINEART);
                put(TYPE_KEY_ANIMATED, TYPE_VAL_ANIMATED);
            }};
            public static final String TYPE_KEY_FACE = "face";
            public static final String TYPE_VAL_FACE = "face";
            public static final String TYPE_KEY_PHOTO = "photo";
            public static final String TYPE_VAL_PHOTO = "photo";
            public static final String TYPE_KEY_CLIPART = "clipart";
            public static final String TYPE_VAL_CLIPART = "clipart";
            public static final String TYPE_KEY_LINEART = "lineart";
            public static final String TYPE_VAL_LINEART = "lineart";
            public static final String TYPE_KEY_ANIMATED = "animated";
            public static final String TYPE_VAL_ANIMATED = "animated";

            //--------------------------------------------------------------------------------------------

            public static final String FILETYPE_STR = "ift:";
            public static final HashMap<String, String> FILETYPE = new HashMap<String, String>() {{
                put(FILE_TYPE_KEY_ICO, FILE_TYPE_VAL_ICO);
                put(FILE_TYPE_KEY_SVG, FILE_TYPE_VAL_SVG);
                put(FILE_TYPE_KEY_JPG, FILE_TYPE_VAL_JPG);
                put(FILE_TYPE_KEY_PNG, FILE_TYPE_VAL_PNG);
                put(FILE_TYPE_KEY_GIF, FILE_TYPE_VAL_GIF);
                put(FILE_TYPE_KEY_BMP, FILE_TYPE_VAL_BMP);
                put(FILE_TYPE_KEY_WEBP, FILE_TYPE_VAL_WEBP);
            }};
            public static final String FILE_TYPE_KEY_ICO = "ico";
            public static final String FILE_TYPE_VAL_ICO = "ico";
            public static final String FILE_TYPE_KEY_SVG = "svg";
            public static final String FILE_TYPE_VAL_SVG = "svg";
            public static final String FILE_TYPE_KEY_JPG = "jpg";
            public static final String FILE_TYPE_VAL_JPG = "jpg";
            public static final String FILE_TYPE_KEY_PNG = "png";
            public static final String FILE_TYPE_VAL_PNG = "png";
            public static final String FILE_TYPE_KEY_GIF = "gif";
            public static final String FILE_TYPE_VAL_GIF = "gif";
            public static final String FILE_TYPE_KEY_BMP = "bmp";
            public static final String FILE_TYPE_VAL_BMP = "bmp";
            public static final String FILE_TYPE_KEY_WEBP = "webp";
            public static final String FILE_TYPE_VAL_WEBP = "webp";


            //--------------------------------------------------------------------------------------------

            public static final String ASPECT_STR = "iar:";
            public static final HashMap<String, String> ASPECT = new HashMap<String, String>() {{
                put(ASPECT_KEY_TALL, ASPECT_VAL_TALL);
                put(ASPECT_KEY_WIDE, ASPECT_VAL_WIDE);
                put(ASPECT_KEY_SQUARE, ASPECT_VAL_SQUARE);
                put(ASPECT_KEY_PANORAMIC, ASPECT_VAL_PANORAMIC);
            }};
            public static final String ASPECT_KEY_TALL = "tall";
            public static final String ASPECT_VAL_TALL = "t";
            public static final String ASPECT_KEY_WIDE = "wide";
            public static final String ASPECT_VAL_WIDE = "w";
            public static final String ASPECT_KEY_SQUARE = "square";
            public static final String ASPECT_VAL_SQUARE = "s";
            public static final String ASPECT_KEY_PANORAMIC = "panoramic";
            public static final String ASPECT_VAL_PANORAMIC = "xw";

            //--------------------------------------------------------------------------------------------

            public static final String RIGHTS_STR = "sur:";
            public static final HashMap<String, String> RIGHTS = new HashMap<String, String>() {{
                put(RIGHTS_KEY_REUSE, RIGHTS_VAL_REUSE);
                put(RIGHTS_KEY_COM_REUSE, RIGHTS_VAL_COM_REUSE);
                put(RIGHTS_KEY_REUSE_MODIFY, RIGHTS_VAL_REUSE_MODIFY);
                put(RIGHTS_KEY_COM_REUSE_MODIFY, RIGHTS_VAL_COM_REUSE_MODIFY);
            }};
            public static final String RIGHTS_KEY_REUSE = "reuse";
            public static final String RIGHTS_VAL_REUSE = "f";
            public static final String RIGHTS_KEY_COM_REUSE = "com_reuse";
            public static final String RIGHTS_VAL_COM_REUSE = "fc";
            public static final String RIGHTS_KEY_REUSE_MODIFY = "reuse_modify";
            public static final String RIGHTS_VAL_REUSE_MODIFY = "fm";
            public static final String RIGHTS_KEY_COM_REUSE_MODIFY = "com_reuse_modify";
            public static final String RIGHTS_VAL_COM_REUSE_MODIFY = "fmc";

            //--------------------------------------------------------------------------------------------

            public static final String SIZE_STR = "isz:";
            public static final String SIZE_SPECW_STR = ",iszw:";
            public static final String SIZE_SPECH_STR = ",iszh:";
            public static final HashMap<String, String> SIZE = new HashMap<String, String>() {{
                put(SIZE_KEY_ICON, SIZE_VAL_ICON);
                put(SIZE_KEY_LARGE, SIZE_VAL_LARGE);
                put(SIZE_KEY_MEDIUM, SIZE_VAL_MEDIUM);
                put(SIZE_KEY_SMALL, SIZE_VAL_SMALL);
                put(SIZE_KEY_LARGER, SIZE_VAL_LARGER);
                put(SIZE_KEY_SPEC, SIZE_VAL_SPEC);
            }};
            public static final String SIZE_KEY_ICON = "icon";
            public static final String SIZE_VAL_ICON = "i";
            public static final String SIZE_KEY_LARGE = "large";
            public static final String SIZE_VAL_LARGE = "l";
            public static final String SIZE_KEY_MEDIUM = "medium";
            public static final String SIZE_VAL_MEDIUM = "m";
            public static final String SIZE_KEY_SMALL = "small";
            public static final String SIZE_VAL_SMALL = "s";
            public static final String SIZE_KEY_LARGER = "larger";
            public static final String SIZE_VAL_LARGER = "lt";
            public static final String SIZE_KEY_SPEC = "exactly";
            public static final String SIZE_VAL_SPEC = "ex";

            public static final String SIZE_LT_STR = ",islt:";
            public static final HashMap<String, String> SIZE_LT = new HashMap<String, String>() {{
                put(SIZE_LT_KEY_QSVGA, SIZE_LT_VAL_QSVGA);
                put(SIZE_LT_KEY_VGA, SIZE_LT_VAL_VGA);
                put(SIZE_LT_KEY_SVGA, SIZE_LT_VAL_SVGA);
                put(SIZE_LT_KEY_XGA, SIZE_LT_VAL_XGA);
                put(SIZE_LT_KEY_2MP, SIZE_LT_VAL_2MP);
                put(SIZE_LT_KEY_4MP, SIZE_LT_VAL_4MP);
                put(SIZE_LT_KEY_6MP, SIZE_LT_VAL_6MP);
                put(SIZE_LT_KEY_8MP, SIZE_LT_VAL_8MP);
                put(SIZE_LT_KEY_10MP, SIZE_LT_VAL_10MP);
                put(SIZE_LT_KEY_12MP, SIZE_LT_VAL_12MP);
                put(SIZE_LT_KEY_15MP, SIZE_LT_VAL_15MP);
                put(SIZE_LT_KEY_20MP, SIZE_LT_VAL_20MP);
                put(SIZE_LT_KEY_40MP, SIZE_LT_VAL_40MP);
                put(SIZE_LT_KEY_70MP, SIZE_LT_VAL_70MP);
            }};
            public static final String SIZE_LT_KEY_QSVGA = "qsvga";
            public static final String SIZE_LT_VAL_QSVGA = "qsvga";
            public static final String SIZE_LT_KEY_VGA = "vga";
            public static final String SIZE_LT_VAL_VGA = "vga";
            public static final String SIZE_LT_KEY_SVGA = "svga";
            public static final String SIZE_LT_VAL_SVGA = "svga";
            public static final String SIZE_LT_KEY_XGA = "xga";
            public static final String SIZE_LT_VAL_XGA = "xga";
            public static final String SIZE_LT_KEY_2MP = "2mp";
            public static final String SIZE_LT_VAL_2MP = "2mp";
            public static final String SIZE_LT_KEY_4MP = "4mp";
            public static final String SIZE_LT_VAL_4MP = "4mp";
            public static final String SIZE_LT_KEY_6MP = "6mp";
            public static final String SIZE_LT_VAL_6MP = "6mp";
            public static final String SIZE_LT_KEY_8MP = "8mp";
            public static final String SIZE_LT_VAL_8MP = "8mp";
            public static final String SIZE_LT_KEY_10MP = "10mp";
            public static final String SIZE_LT_VAL_10MP = "10mp";
            public static final String SIZE_LT_KEY_12MP = "12mp";
            public static final String SIZE_LT_VAL_12MP = "12mp";
            public static final String SIZE_LT_KEY_15MP = "15mp";
            public static final String SIZE_LT_VAL_15MP = "15mp";
            public static final String SIZE_LT_KEY_20MP = "20mp";
            public static final String SIZE_LT_VAL_20MP = "20mp";
            public static final String SIZE_LT_KEY_40MP = "40mp";
            public static final String SIZE_LT_VAL_40MP = "40mp";
            public static final String SIZE_LT_KEY_70MP = "70mp";
            public static final String SIZE_LT_VAL_70MP = "70mp";

            //--------------------------------------------------------------------------------------------

            public static final String COLOR_STR = "ic:";
            public static final HashMap<String, String> COLOR = new HashMap<String, String>() {{
                put(COLOR_KEY_COLOR, COLOR_VAL_COLOR);
                put(COLOR_KEY_NOCOLOR, COLOR_VAL_NOCOLOR);
                put(COLOR_KEY_TRANSPARENT, COLOR_VAL_TRANSPARENT);
                put(COLOR_KEY_SPEC, COLOR_VAL_SPEC);
            }};
            public static final String COLOR_KEY_COLOR = "color";
            public static final String COLOR_VAL_COLOR = "color";
            public static final String COLOR_KEY_NOCOLOR = "nocolor";
            public static final String COLOR_VAL_NOCOLOR = "grey";
            public static final String COLOR_KEY_TRANSPARENT = "transparent";
            public static final String COLOR_VAL_TRANSPARENT = "trans";
            public static final String COLOR_KEY_SPEC = "specific";
            public static final String COLOR_VAL_SPEC = "specific";

            public static final String COLOR_SPEC_STR = ",isc:";
            public static final HashMap<String, String> COLOR_SPEC = new HashMap<String, String>() {{
                put(COLOR_SPEC_KEY_BLACK, COLOR_SPEC_VAL_BLACK);
                put(COLOR_SPEC_KEY_BLUE, COLOR_SPEC_VAL_BLUE);
                put(COLOR_SPEC_KEY_BROWN, COLOR_SPEC_VAL_BROWN);
                put(COLOR_SPEC_KEY_GRAY, COLOR_SPEC_VAL_GRAY);
                put(COLOR_SPEC_KEY_GREEN, COLOR_SPEC_VAL_GREEN);
                put(COLOR_SPEC_KEY_ORANGE, COLOR_SPEC_VAL_ORANGE);
                put(COLOR_SPEC_KEY_PINK, COLOR_SPEC_VAL_PINK);
                put(COLOR_SPEC_KEY_PURPLE, COLOR_SPEC_VAL_PURPLE);
                put(COLOR_SPEC_KEY_RED, COLOR_SPEC_VAL_RED);
                put(COLOR_SPEC_VAL_TEAL, COLOR_SPEC_KEY_TEAL);
                put(COLOR_SPEC_VAL_WHITE, COLOR_SPEC_KEY_WHITE);
                put(COLOR_SPEC_VAL_YELLOW, COLOR_SPEC_KEY_YELLOW);
            }};

            public static final String COLOR_SPEC_KEY_BLACK = "black";
            public static final String COLOR_SPEC_VAL_BLACK = "black";
            public static final String COLOR_SPEC_KEY_BLUE = "blue";
            public static final String COLOR_SPEC_VAL_BLUE = "blue";
            public static final String COLOR_SPEC_KEY_BROWN = "brown";
            public static final String COLOR_SPEC_VAL_BROWN = "brown";
            public static final String COLOR_SPEC_KEY_GRAY = "gray";
            public static final String COLOR_SPEC_VAL_GRAY = "gray";
            public static final String COLOR_SPEC_KEY_GREEN = "green";
            public static final String COLOR_SPEC_VAL_GREEN = "green";
            public static final String COLOR_SPEC_KEY_ORANGE = "orange";
            public static final String COLOR_SPEC_VAL_ORANGE = "orange";
            public static final String COLOR_SPEC_KEY_PINK = "pink";
            public static final String COLOR_SPEC_VAL_PINK = "pink";
            public static final String COLOR_SPEC_KEY_PURPLE = "purple";
            public static final String COLOR_SPEC_VAL_PURPLE = "purple";
            public static final String COLOR_SPEC_KEY_RED = "red";
            public static final String COLOR_SPEC_VAL_RED = "red";
            public static final String COLOR_SPEC_VAL_TEAL = "teal";
            public static final String COLOR_SPEC_KEY_TEAL = "teal";
            public static final String COLOR_SPEC_VAL_WHITE = "white";
            public static final String COLOR_SPEC_KEY_WHITE = "white";
            public static final String COLOR_SPEC_VAL_YELLOW = "yellow";
            public static final String COLOR_SPEC_KEY_YELLOW = "yellow";


        }

    }
}
