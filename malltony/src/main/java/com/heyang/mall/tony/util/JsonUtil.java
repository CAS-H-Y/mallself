package com.heyang.mall.tony.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;
import java.util.List;

/**
 * creat on 2019/4/9
 * <p>
 * #author : CAS_hy
 **/
public final class JsonUtil {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * 转换对象为JSON<br>
     * 支持的对象：<br>
     * String: 转换为相应的对象<br>
     * Array Collection：转换为JSONArray<br>
     * Bean对象：转为JSONObject
     *
     * @param obj 对象
     * @return JSON
     */
    public static JSON parse(Object obj) {
        if (null == obj) {
            return null;
        }

        JSON json = null;
        if (obj instanceof JSON) {
            json = (JSON) obj;
        } else if (obj instanceof String) {
            String jsonStr = ((String) obj).trim();
            if (jsonStr.startsWith("[")) {
                json = parseArray(jsonStr);
            } else {
                json = parseObj(jsonStr);
            }
        } else if (obj instanceof Collection || obj.getClass().isArray()) {// 列表
            json = new JSONArray(obj);
        } else {// 对象
            json = new JSONObject(obj);
        }

        return json;
    }
    /**
     * JSON字符串转JSONArray
     *
     * @param jsonStr JSON字符串
     * @return JSONArray
     */
    public static JSONArray parseArray(String jsonStr) {
        return new JSONArray(jsonStr);
    }

    /**
     * JSON字符串转JSONArray
     *
     * @param arrayOrCollection 数组或集合对象
     * @return JSONArray
     * @since 3.0.8
     */
    public static JSONArray parseArray(Object arrayOrCollection) {
        return new JSONArray(arrayOrCollection);
    }

    /**
     * JSON字符串转JSONArray
     *
     * @param arrayOrCollection 数组或集合对象
     * @param ignoreNullValue 是否忽略空值
     * @return JSONArray
     * @since 3.2.3
     */
    public static JSONArray parseArray(Object arrayOrCollection, boolean ignoreNullValue) {
        return new JSONArray(arrayOrCollection, ignoreNullValue);
    }
    public static JSONObject parseObj(String jsonStr) {
        return new JSONObject(jsonStr);
    }

    /**
     * JSON字符串转JSONObject对象<br>
     * 此方法会忽略空值，但是对JSON字符串不影响
     *
     * @param obj Bean对象或者Map
     * @return JSONObject
     */
    public static JSONObject parseObj(Object obj) {
        return new JSONObject(obj);
    }

    /**
     * JSON字符串转JSONObject对象
     *
     * @param obj Bean对象或者Map
     * @param ignoreNullValue 是否忽略空值，如果source为JSON字符串，不忽略空值
     * @return JSONObject
     * @since 3.0.9
     */
    public static JSONObject parseObj(Object obj, boolean ignoreNullValue) {
        return new JSONObject(obj, ignoreNullValue);
    }

    /**
     * JSON字符串转JSONObject对象
     *
     * @param obj Bean对象或者Map
     * @param ignoreNullValue 是否忽略空值，如果source为JSON字符串，不忽略空值
     * @param isOrder 是否有序
     * @return JSONObject
     * @since 4.2.2
     */
    public static JSONObject parseObj(Object obj, boolean ignoreNullValue, boolean isOrder) {
        return new JSONObject(obj, ignoreNullValue, isOrder);
    }
}
