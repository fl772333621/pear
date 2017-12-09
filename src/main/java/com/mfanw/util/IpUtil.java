package com.mfanw.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.mfanw.core.log.MonitorLogger;

/**
 * <b>ip工具类</b>
 * 
 * @version 2017年11月9日 下午6:29:39
 * @author mengwei
 */
public class IpUtil {

    public static final String DEFAULT_LOCAL_IP = "127.0.0.1";

    private static final MonitorLogger monitor = MonitorLogger.getInstance();

    /**
     * <b>工具类不提供公共构造函数</b>
     */
    private IpUtil() {
    }

    /**
     * 检查IP是否合法
     * 
     * @param ip
     * @return
     */
    public static boolean ipValid(String ip) {
        String regex0 = "(2[0-4]\\d)" + "|(25[0-5])";
        String regex1 = "1\\d{2}";
        String regex2 = "[1-9]\\d";
        String regex3 = "\\d";
        String regex = "(" + regex0 + ")|(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")";
        regex = "(" + regex + ").(" + regex + ").(" + regex + ").(" + regex + ")";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);
        return m.matches();
    }

    /**
     * 获取本地ip 适合windows与linux
     *
     * @return
     */
    public static String getLocalIP() {
        String localIp = null;
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                InetAddress ip = ni.getInetAddresses().nextElement();
                if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    localIp = ip.getHostAddress();
                    break;
                }
            }
        } catch (Exception e) {
            try {
                localIp = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e1) {
                monitor.error(e1.getMessage(), e1);
            }
        }
        return localIp == null ? DEFAULT_LOCAL_IP : localIp;
    }

    /**
     * 获取客户机的ip地址
     * 
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }


    /**
     * 把ip转化为整数
     * 
     * @param ip
     * @return
     */
    public static long translateIP2Int(String ip) {
        String[] intArr = ip.split("\\.");
        int[] ipInt = new int[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            ipInt[i] = Integer.valueOf(intArr[i]);
        }
        return ipInt[0] * 256 * 256 * 256 + +ipInt[1] * 256 * 256 + ipInt[2] * 256 + ipInt[3];
    }

}
