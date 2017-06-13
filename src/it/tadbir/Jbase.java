package it.tadbir;


import it.tadbir.utils.Tracer;


public class Jbase {


    public static Tracer tracer = null;

    public static void trace(Object... param) {
        if (tracer != null) {
            tracer.trace(param);
        }
    }

    public static void error(Object... param) {
        if (tracer != null) {
            tracer.error(param);
        }
    }

    public static Tracer initTracer() {
        if (tracer == null) {
            tracer = new Tracer() {
                @Override
                public void trace(Object... param) {
                    String s = "";
                    if (param.length > 0) {
                        s += String.valueOf(param[0]);
                        for (int i = 1; i < param.length; i++) {
                            s += ", " + String.valueOf(param[i]);
                        }
                    }
                    println(s);
                }

                @Override
                public void error(Object... param) {
                    String s = "";
                    if (param.length > 0) {
                        s += String.valueOf(param[0]);
                        for (int i = 1; i < param.length; i++) {
                            s += ", " + String.valueOf(param[i]);
                        }
                    }
                    printlnErr(s);
                }
            };
        }

        return tracer;
    }

    public static Tracer initTracer(final String packageName) {
        if (tracer == null) {
            tracer = new Tracer() {
                @Override
                public void trace(Object... param) {
                    String s = "";
                    for (Object aParam : param) {
                        s += String.valueOf(aParam) + ", ";
                    }
                    println("APP:" + packageName + " " + s);
                }
            };
        }

        return tracer;
    }

    private static void println(String s) {
        System.out.println(s);
    }

    private static void printlnErr(String s) {
        System.out.println(s);
    }


}

