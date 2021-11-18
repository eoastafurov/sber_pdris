package ru.sbt.mipt;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringProcessing {
    public static List<String> getClientTypeAndJson(String path) {
        List<String> out = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            out.add((String)map.get("clientType"));
            out.add(map.toString());
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return out;
    }
}
