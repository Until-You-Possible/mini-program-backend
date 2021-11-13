package com.lin.missyou.util;



import java.io.*;
import java.nio.charset.StandardCharsets;

public class ImportJsonToElasticsearch {


    // 以本地json为例子
    public static String readJsonFile() throws IOException {
        String jsonString = "";
        // 读取本地json
        File  file = new File("/Users/wanggang/Desktop/index.json");
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        jsonString = sb.toString();
        return jsonString;
    }

}
