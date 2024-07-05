package com.iam57.akianime.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iam57
 * @since 2024/6/30 17:10
 */
public class UserContext {
    private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static void setUserId(Integer userId) {
        threadLocal.get().put("uid", userId);
    }

    public static Integer getUserId() {
        return (Integer) threadLocal.get().get("uid");
    }

    public static void setToken(String token) {
        threadLocal.get().put("token", token);
    }

    public static String getToken() {
        return (String) threadLocal.get().get("token");
    }

    public static void clear() {
        threadLocal.remove();
    }
}
