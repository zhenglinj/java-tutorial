package com.thirdparty.examples.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class NonPojoTest {
    @Test
    public void parseNonPojoClass() {
        String jsonStr = "{\"name\":\"tom\", \"alias\":\"tom\", \"age\":10}";
        NonPojo obj = JSON.parseObject(jsonStr, NonPojo.class);
        System.out.println(obj);

        JSONObject jsonObject = JSON.parseObject(jsonStr);
        System.out.println(jsonObject);
    }
}
