package it.tadbir.gbid;

import com.martiansoftware.jsap.*;
import it.tadbir.Jbase;
import it.tadbir.net.Google.Constants;
import it.tadbir.net.Google.Googler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by m_admin on 6/2/2016.
 */
public class Args {

    public static int maxThreads;
    public static int maxFiles;
    public static String userAgent;
    public static Boolean verbose;
    public static Boolean dontRename;
    public static ArrayList<Googler> queries;

    public static boolean initArgs(String[] args) {
        JSAP jsap = new JSAP();

        final String USER = "user";
        final String VERBOSE = "verbose";
        final String RENAME = "savename";
        final String HELP = "help";
        final String INFO = "?";
        final String PHRASE = "phrase";
        final String FILE = "file";
        final String THREAD = "thread";
        final String NUM = "num";
        final String DOMAIN = "domain";
        final String TYPE = "type";
        final String EXT = "ext";
        final String ASPECT = "aspect";
        final String RIGHTS = "rights";
        final String SIZE = "size";
        final String COLOR = "color";


        try {
            jsap.registerParameter(new Switch(VERBOSE).setShortFlag('v').setLongFlag(VERBOSE)
                    .setHelp("Set verbose mode for output."));

            jsap.registerParameter(new Switch(HELP).setShortFlag('h').setLongFlag(HELP)
                    .setHelp("Show help screen."));

            jsap.registerParameter(new Switch(INFO).setShortFlag('?').setLongFlag(JSAP.NO_LONGFLAG)
                    .setHelp("Show help screen."));

            jsap.registerParameter(new Switch(RENAME).setLongFlag(RENAME).setShortFlag('s')
                    .setHelp("Don't rename downloaded files."));

            jsap.registerParameter(new FlaggedOption(USER).setShortFlag('u').setStringParser(JSAP.STRING_PARSER)
                    .setLongFlag(USER)
                    .setDefault("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0")
                    .setHelp("Double qouted user agent.\n" +
                            "Ex: -u \"Windows / IE 7: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)\""));

            jsap.registerParameter(new FlaggedOption(PHRASE).setShortFlag('p').setStringParser(JSAP.STRING_PARSER)
                    .setLongFlag(PHRASE).setHelp("Double qouted search phrase. Ex: -p \"White lion\""));

            jsap.registerParameter(new FlaggedOption(FILE).setShortFlag('f')
                    .setLongFlag(FILE).setStringParser(JSAP.STRING_PARSER).setHelp("Input file name."));

            jsap.registerParameter(new FlaggedOption(THREAD).setShortFlag('t')
                    .setLongFlag(THREAD).setStringParser(JSAP.INTEGER_PARSER)
                    .setDefault("3").setHelp("Maximum working threads."));

            jsap.registerParameter(new FlaggedOption(NUM).setShortFlag('n')
                    .setLongFlag(NUM)
                    .setDefault("10").setStringParser(JSAP.INTEGER_PARSER).setHelp("Number of results."));

            jsap.registerParameter(new FlaggedOption(DOMAIN).setShortFlag('d')
                    .setLongFlag(DOMAIN).setStringParser(JSAP.STRING_PARSER).setHelp("Define search domain. Ex: -d www.mshams.ir"));

            jsap.registerParameter(new FlaggedOption(TYPE)
                    .setLongFlag(TYPE).setStringParser(JSAP.STRING_PARSER)
                    .setHelp(String.format("Define image type, possible values are:%s. \nEx: --%s %s",
                            Constants.Search.Image.TYPE.keySet().toString(), TYPE, Constants.Search.Image.TYPE_KEY_FACE)));

            jsap.registerParameter(new FlaggedOption(EXT)
                    .setLongFlag(EXT).setStringParser(JSAP.STRING_PARSER)
                    .setHelp(String.format("Define image file extension, possible values are:%s. \nEx: --%s %s",
                            Constants.Search.Image.FILETYPE.keySet().toString(), EXT, Constants.Search.Image.FILE_TYPE_KEY_BMP)));

            jsap.registerParameter(new FlaggedOption(ASPECT)
                    .setLongFlag(ASPECT).setStringParser(JSAP.STRING_PARSER)
                    .setHelp(String.format("Define image aspect ration, possible values are:%s. \nEx: --%s %s",
                            Constants.Search.Image.ASPECT.keySet().toString(), ASPECT, Constants.Search.Image.ASPECT_KEY_TALL)));

            jsap.registerParameter(new FlaggedOption(RIGHTS)
                    .setLongFlag(RIGHTS).setStringParser(JSAP.STRING_PARSER)
                    .setHelp(String.format("Define image copyrights, possible values are:%s. \nEx: --%s %s",
                            Constants.Search.Image.RIGHTS.keySet().toString(), RIGHTS, Constants.Search.Image.RIGHTS_KEY_COM_REUSE)));

            jsap.registerParameter(new FlaggedOption(SIZE).setList(true).setListSeparator(':')
                    .setLongFlag(SIZE).setStringParser(JSAP.STRING_PARSER)
                    .setHelp(
                            String.format("Define image size, possible values are:%s. \n" +
                                            "Ex: --%s %s\n\n" +
                                            "For %s mode there are other options:%s \n" +
                                            "Ex: --%s %s:%s\n\n" +
                                            "For %s mode weigth and heigth needed\n" +
                                            "Ex: --%s %s:640,480",
                                    Constants.Search.Image.SIZE.keySet().toString(), SIZE, Constants.Search.Image.SIZE_KEY_MEDIUM,
                                    Constants.Search.Image.SIZE_KEY_LARGER, Constants.Search.Image.SIZE_LT.keySet().toString(),
                                    SIZE, Constants.Search.Image.SIZE_KEY_LARGER, Constants.Search.Image.SIZE_LT_KEY_QSVGA,
                                    Constants.Search.Image.SIZE_KEY_SPEC,
                                    SIZE, Constants.Search.Image.SIZE_KEY_SPEC)));

            jsap.registerParameter(new FlaggedOption(COLOR).setList(true).setListSeparator(':')
                    .setLongFlag(COLOR).setStringParser(JSAP.STRING_PARSER)
                    .setHelp(
                            String.format("Define image coloe, possible values are:%s. \n" +
                                            "Ex: --%s %s\n\n" +
                                            "For %s mode there are other options:%s \n" +
                                            "Ex: --%s %s:%s",
                                    Constants.Search.Image.COLOR.keySet().toString(), COLOR, Constants.Search.Image.COLOR_KEY_TRANSPARENT,
                                    Constants.Search.Image.COLOR_KEY_SPEC, Constants.Search.Image.COLOR_SPEC.keySet().toString(),
                                    COLOR, Constants.Search.Image.COLOR_KEY_SPEC, Constants.Search.Image.COLOR_SPEC_KEY_GREEN)));

            JSAPResult config = jsap.parse(args);

            //if help switch
            if (config.getBoolean(HELP) || config.getBoolean(INFO)) {
                Jbase.trace("Google Batch Image Downloader (GBID) by www.mshams.ir\n");
                Jbase.trace("Usage:" + jsap.getUsage() + "\n" + jsap.getHelp());

                return false;
            }
            //if error
            else if (!config.success()) {
                for (java.util.Iterator errs = config.getErrorMessageIterator();
                     errs.hasNext(); ) {
                    Jbase.error("Error: " + errs.next());
                }

                Jbase.error();
                Jbase.error(jsap.getUsage());
                Jbase.error();
                Jbase.error(jsap.getHelp());

                return false;
            }
            //if no query input prepared
            else if (config.getString(PHRASE) == null && config.getString(FILE) == null) {
                Jbase.error("Error: No input query of file name prepared.");
                Jbase.error();
                Jbase.error(jsap.getUsage());
                Jbase.error();
                Jbase.error(jsap.getHelp());

                return false;
            }
            //set variables
            else {
                maxThreads = config.getInt(THREAD);
                maxFiles = config.getInt(NUM);

                String[] phrases;
                if (config.getString(PHRASE) != null) {
                    phrases = new String[]{config.getString(PHRASE)};
                } else {
                    phrases = readFile(config.getString(FILE));
                }

                Googler searchQuery = new Googler();

                if (config.getString(DOMAIN) != null)
                    searchQuery.setDomain(config.getString(DOMAIN));

                userAgent = config.getString(USER);
                verbose = config.getBoolean(VERBOSE);
                dontRename = config.getBoolean(RENAME);

                if (config.getString(TYPE) != null)
                    searchQuery.setOption().setType(config.getString(TYPE)).build();

                if (config.getString(EXT) != null)
                    searchQuery.setOption().setFileType(config.getString(EXT)).build();

                if (config.getString(ASPECT) != null)
                    searchQuery.setOption().setAspect(config.getString(ASPECT)).build();

                if (config.getString(RIGHTS) != null)
                    searchQuery.setOption().setRights(config.getString(RIGHTS)).build();

                if (config.getStringArray(SIZE) != null && config.getStringArray(SIZE).length > 0) {
                    String opt2 = config.getStringArray(SIZE).length > 1 ? config.getStringArray(SIZE)[1] : null;
                    int w = 0, h = 0;
                    if (config.getStringArray(SIZE)[0].equals(Constants.Search.Image.SIZE_KEY_SPEC)) {
                        w = Integer.valueOf(opt2.split(",")[0]);
                        h = Integer.valueOf(opt2.split(",")[1]);
                        opt2 = null;
                    }

                    //Jbase.trace(config.getStringArray(SIZE)[0], opt2, w, h);
                    searchQuery.setOption()
                            .setSize(config.getStringArray(SIZE)[0], opt2, w, h).build();
                }

                if (config.getStringArray(COLOR) != null && config.getStringArray(COLOR).length > 0) {
                    String opt2 = config.getStringArray(COLOR).length > 1 ? config.getStringArray(COLOR)[1] : null;

                    //Jbase.trace(config.getString(COLOR), opt2);
                    searchQuery.setOption()
                            .setColor(config.getString(COLOR), opt2).build();
                }

                queries = new ArrayList<Googler>();
                for (String phrase : phrases) {
                    Googler query = searchQuery.clone();
                    query.setQuery(phrase);

                    queries.add(query);
                }

            }

        } catch (JSAPException e) {
            Jbase.error("Argument parse error:", e.toString());
            return false;
        }

        return true;
    }

    private static String[] readFile(String file) {
        String content = null;
        String lines[] = new String[]{};
        try {
            content = new String(Files.readAllBytes(Paths.get(file)));
            lines = content.split("\\r?\\n");
        } catch (Exception e) {
            Jbase.error(String.format("File (%s) error: %s", file, e.getMessage()));
        }

        return lines;
    }
}
