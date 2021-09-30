package com.lin.missyou.core;

import com.lin.missyou.model.User;

import java.util.HashMap;
import java.util.Map;

public class LocalUser {

    private static final ThreadLocal<Map<String, Object>> mapThreadLocal = new ThreadLocal<Map<String, Object>>();

    private static User user;
    public  static void set(User user, Integer scope) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("scope", scope);
        LocalUser.mapThreadLocal.set(map);
    }
    public static void clear() {
        LocalUser.mapThreadLocal.remove();
    }
    public static User getUser() {
        Map<String, Object> map = LocalUser.mapThreadLocal.get();
        return (User) map.get("user");
    }

    public static Integer getScoped() {
        Map<String, Object> map = LocalUser.mapThreadLocal.get();
        return (Integer) map.get("scope");
    }

}
