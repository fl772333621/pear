package com.mfanw.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil extends ThreadLocal<Map<String, Object>> {

    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String CLIENT_IP = "client_ip";

    private static final ThreadLocalUtil INSTANCE = new ThreadLocalUtil();

    /**
     * <b>工具类不提供公共构造函数</b>
     */
    private ThreadLocalUtil() {
    }

    public static ThreadLocalUtil getInstance() {
        return INSTANCE;
    }

    @Override
    protected Map<String, Object> initialValue() {
        return new HashMap<>(16);
    }

    public void clear() {
        this.get().clear();
    }

    public Object get(String key) {
        return this.get().get(key);
    }

    public void set(String key, Object value) {
        this.get().put(key, value);
    }

    public Map<String, Object> getAll() {
        return this.get();
    }

    @Override
    public void set(Map<String, Object> map) {
        this.get().putAll(map);
    }


}
