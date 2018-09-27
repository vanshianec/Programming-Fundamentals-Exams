import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Long> setsSize = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> cache = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("thetinggoesskrra")) {
            if (!input.contains("|")) {
                String dataSet = input;
                if (!cache.containsKey(dataSet)) {
                    data.put(dataSet, new LinkedHashMap<>());

                    setsSize.put(dataSet, 0L);
                } else {
                    LinkedHashMap<String, Long> values = cache.get(dataSet);
                    data.put(dataSet, new LinkedHashMap<>());
                    Long valuesSum = 0L;
                    for (Map.Entry<String, Long> entry : values.entrySet()) {
                        data.get(dataSet).put(entry.getKey(), entry.getValue());
                        valuesSum += entry.getValue();
                    }

                    setsSize.put(dataSet, valuesSum);
                }
            } else {
                String tokens[] = input.split(" \\| ");
                String dataSet = tokens[1];
                String values = tokens[0];
                if (!data.containsKey(dataSet)) {
                    String key = values.split(" -> ")[0];
                    Long value = Long.parseLong(values.split(" -> ")[1]);
                    if (!cache.containsKey(dataSet)) {
                        cache.put(dataSet, new LinkedHashMap<>());
                    }
                    cache.get(dataSet).put(key, value);
                } else {

                    String key = values.split(" -> ")[0];
                    Long value = Long.parseLong(values.split(" -> ")[1]);
                    data.get(dataSet).put(key, value);
                    setsSize.put(dataSet, setsSize.get(dataSet) + value);
                }
            }


            input = reader.readLine();
        }

        setsSize=setsSize.entrySet().stream().sorted((kv2, kv1) -> kv1.getValue().compareTo(kv2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<String, Long> entry : setsSize.entrySet()) {
            System.out.printf("Data Set: %s, Total Size: %d%n", entry.getKey(), entry.getValue());
            LinkedHashMap<String, Long> innerMap = data.get(entry.getKey());
            for (String s : innerMap.keySet()) {
                System.out.printf("$.%s%n", s);
            }
            return;
        }


    }

}





