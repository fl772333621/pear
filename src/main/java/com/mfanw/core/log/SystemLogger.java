package com.mfanw.core.log;


import org.apache.log4j.Logger;

import com.mfanw.util.ExceptionPrinter;

/**
 * <b>系统用日志</b>
 * 
 * @version 2017年11月9日 下午6:26:59
 * @author mengwei
 */
public class SystemLogger {

    /**
     * 默认输出logger，已经在log4j.xml内配置了同类名的category<br />
     * 默认输出目录：${catalina.base}/logs/event/event.log
     */
    private static final Logger EVENT_LOGGER = Logger.getLogger("EventLogger");

    /**
     * 默认输出logger，已经在log4j.xml内配置了同类名的category<br />
     * 默认输出目录：${catalina.base}/logs/sql/sql.log
     */
    private static final Logger SQL_LOGGER = Logger.getLogger("SqlLogger");

    /**
     * 单例模式（组件1）
     */
    private static final SystemLogger INSTANCE = new SystemLogger();

    /**
     * 单例模式（组件2）
     */
    private SystemLogger() {
    }

    /**
     * 单例模式（组件3）
     */
    public static SystemLogger getInstance() {
        return INSTANCE;
    }

    /**
     * <b>记录message到日志</b>
     * 
     * @param message
     */
    public void event(String message) {
        event(EVENT_LOGGER, message, null);
    }

    /**
     * <b>记录message及错误信息到日志</b>
     * 
     * @param message
     * @param throwable
     */
    public void event(String message, Throwable throwable) {
        event(EVENT_LOGGER, message, throwable);
    }

    /**
     * <b>日志输出内容总装</b>
     * 
     * @param logger
     * @param message
     * @param throwable
     */
    private void event(final Logger logger, String message, Throwable throwable) {
        logger.info(((message == null) ? "" : message) + (((throwable == null) ? "" : ExceptionPrinter.printStackTrace(throwable)) + ExceptionPrinter.printStackTrace(0)));
    }

    /**
     * <b>记录message到日志</b>
     * 
     * @param message
     */
    public void sql(String message) {
        sql(SQL_LOGGER, message, null);
    }

    /**
     * <b>记录message及错误信息到日志</b>
     * 
     * @param message
     * @param throwable
     */
    public void sql(String message, Throwable throwable) {
        sql(SQL_LOGGER, message, throwable);
    }

    /**
     * <b>日志输出内容总装</b>
     * 
     * @param logger
     * @param message
     * @param throwable
     */
    private void sql(final Logger logger, String message, Throwable throwable) {
        logger.info(((message == null) ? "" : message) + (((throwable == null) ? "" : ExceptionPrinter.printStackTrace(throwable)) + ExceptionPrinter.printStackTrace(0)));
    }

}
