package com.lin.missyou.api.v1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lin.missyou.util.ImportJsonToElasticsearch;
import org.apache.logging.log4j.util.StringMap;
import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.transport.Transport;

import javax.management.monitor.StringMonitor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestTool {


    @GetMapping("/es")
    public List<Object> testElasticTool () throws IOException {
        String jsonString = ImportJsonToElasticsearch.readJsonFile();
        return convertStringToList(jsonString);
    }

    @SuppressWarnings("unchecked")
    public List<Object> convertStringToList(String jsonString) {
        return (List<Object>) JSON.parse(jsonString);
    }

    public Map<String, String> makeMappingInfo() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("index", "index_test_name");
        stringMap.put("type", "_doc");
        return stringMap;
    }

    public void importToElasticsearch(){
        // 链接es
        
    }

}
