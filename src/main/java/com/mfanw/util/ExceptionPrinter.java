package com.mfanw.util;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class ExceptionPrinter {

    /**
     * <b>工具类不提供公共构造函数</b>
     */
    private ExceptionPrinter() {
    }

    /**
     * 打印输出日志代码行
     * 
     * @param ajust 打印行的位移，默认是日志行，可通过int值调节前后
     * @return 仅返回一行数据
     */
    public static String printStackTrace(int ajust) {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        StackTraceElement ste;
        StringBuilder sb = new StringBuilder();
        int finalAjust = 4 + ajust;
        if (stes.length >= finalAjust && finalAjust >= 0) {
            ste = stes[finalAjust];
            sb.append("\r\n");
            sb.append("at ");
            sb.append(ste.getClassName());
            sb.append(".");
            sb.append(ste.getMethodName());
            sb.append("(");
            sb.append(ste.getFileName());
            sb.append(":");
            sb.append(ste.getLineNumber());
            sb.append(")");
        }
        return sb.toString();
    }

    /**
     * <b>打印throwable的异常栈</b>
     * 
     * @param throwable
     * @return 返回异常栈的String形式
     */
    public static String printStackTrace(final Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        pw.flush();
        LineNumberReader reader = new LineNumberReader(new StringReader(sw.toString()));
        StringBuilder log = new StringBuilder();
        try {
            String line = reader.readLine();
            if (line != null) {
                log.append(line);
                while ((line = reader.readLine()) != null) {
                    log.append("\r\n" + line);
                }
            }
        } catch (IOException ex) {
            Thread.currentThread().interrupt();
            if (log.length() != 0) {
                log.append("\r\n");
            }
            log.append(ex.toString());
        }
        return log.toString();
    }

}
