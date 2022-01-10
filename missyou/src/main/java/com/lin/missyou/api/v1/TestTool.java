package com.lin.missyou.api.v1;
import co.elastic.clients.elasticsearch._core.IndexRequest;
import com.alibaba.fastjson.JSON;
import com.lin.missyou.util.ImportJsonToElasticsearch;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Date;
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
    public List<Object> convertStringToList(String jsonString) throws IOException {
        createIndex();
        return (List<Object>) JSON.parse(jsonString);
    }

    public Map<String, String> makeMappingInfo() {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("index", "index_test_name");
        stringMap.put("type", "_doc");
        return stringMap;
    }

    public RestHighLevelClient getClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
    }

    // 创建索引
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("posts");
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
        request.mapping(
                "{\n" +
                        "  \"properties\": {\n" +
                        "    \"message\": {\n" +
                        "      \"type\": \"text\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);
        CreateIndexResponse createIndexResponse = this.getClient().indices().create(request, RequestOptions.DEFAULT);
        System.out.println("createIndexResponse" + createIndexResponse);
    }
}
