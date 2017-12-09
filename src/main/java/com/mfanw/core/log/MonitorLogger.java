package com.mfanw.core.log;

import org.apache.log4j.Logger;

import com.mfanw.util.ExceptionPrinter;

/**
 * <b>个性化目录日志工具</b>
 * 
 * @version 2017年11月9日 下午6:25:50
 * @author mengwei
 */
public class MonitorLogger {

    /**
     * 默认输出logger，已经在log4j.xml内配置了同类名的category<br />
     * 默认输出目录：${catalina.base}/logs/debug/debug.log
     */
    private static final Logger DEBUG_LOGGER = Logger.getLogger("DebugLogger");

    /**
     * 默认输出logger，已经在log4j.xml内配置了同类名的category<br />
     * 默认输出目录：${catalina.base}/logs/error/error.log
     */
    private static final Logger ERROR_LOGGER = Logger.getLogger("ErrorLogger");

    /**
     * 单例模式（组件1）
     */
    private static final MonitorLogger INSTANCE = new MonitorLogger();

    /**
     * 单例模式（组件2）
     */
    private MonitorLogger() {
    }

    /**
     * 单例模式（组件3）
     */
    public static MonitorLogger getInstance() {
        return INSTANCE;
    }

    /**
     * <b>记录message到日志</b>
     * 
     * @param message
     */
    public void debug(String message) {
        debug(DEBUG_LOGGER, message, null);
    }

    /**
     * <b>记录message及错误信息到日志</b>
     * 
     * @param message
     * @param throwable
     */
    public void debug(String message, Throwable throwable) {
        debug(DEBUG_LOGGER, message, throwable);
    }

    /**
     * <b>日志输出内容总装</b>
     * 
     * @param logger
     * @param message
     * @param throwable
     */
    private void debug(final Logger logger, String message, Throwable throwable) {
        logger.debug(((message == null) ? "" : message) + (((throwable == null) ? "" : ExceptionPrinter.printStackTrace(throwable)) + ExceptionPrinter.printStackTrace(0)));
    }

    /**
     * <b>记录message到日志</b>
     * 
     * @param message
     */
    public void error(String message) {
        error(ERROR_LOGGER, message, null);
    }

    /**
     * <b>记录message及错误信息到日志</b>
     * 
     * @param message
     * @param throwable
     */
    public void error(String message, Throwable throwable) {
        error(ERROR_LOGGER, message, throwable);
    }

    /**
     * <b>日志输出内容总装</b>
     * 
     * @param logger
     * @param message
     * @param throwable
     */
    private void error(final Logger logger, String message, Throwable throwable) {
        logger.error(((message == null) ? "" : message) + (((throwable == null) ? "" : ExceptionPrinter.printStackTrace(throwable)) + ExceptionPrinter.printStackTrace(0)));
    }

}
