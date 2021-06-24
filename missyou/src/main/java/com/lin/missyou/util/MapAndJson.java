package com.lin.missyou.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.Http.ServerErrorException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.Map;

//java实体的类型
// 数据类型？
public class MapAndJson implements AttributeConverter<Map<String, Object>, String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            return mapper.readValue(s, HashedMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
