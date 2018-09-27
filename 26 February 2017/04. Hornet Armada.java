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
        LinkedHashMap<String, Integer> legionAndActivity = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> legionAndSoldiers = new LinkedHashMap<>();

        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String tokens[] = reader.readLine().split("[ =->:-]+");
            int currentActivity = Integer.parseInt(tokens[0]);
            String legionName = tokens[1];
            String soldiersType = tokens[2];
            Long soldiersCount = Long.parseLong(tokens[3]);

            if (!legionAndSoldiers.containsKey(legionName)) {
                legionAndSoldiers.put(legionName, new LinkedHashMap<>());
                legionAndSoldiers.get(legionName).put(soldiersType, soldiersCount);
                legionAndActivity.put(legionName, currentActivity);
            } else {
                if (!legionAndSoldiers.get(legionName).containsKey(soldiersType)) {
                    legionAndSoldiers.get(legionName).put(soldiersType, soldiersCount);
                    if (legionAndActivity.get(legionName) < currentActivity) {
                        legionAndActivity.put(legionName, currentActivity);
                    }
                } else {
                    legionAndSoldiers.get(legionName).put(soldiersType, legionAndSoldiers.get(legionName).get(soldiersType) + soldiersCount);
                    if (legionAndActivity.get(legionName) < currentActivity) {
                        legionAndActivity.put(legionName, currentActivity);
                    }
                }
            }

        }
        String command = reader.readLine();
        if (command.contains("\\")) {
            int activity = Integer.parseInt(command.split("\\\\")[0]);
            String soldierType = command.split("\\\\")[1];
            LinkedHashMap<String, Long> result = new LinkedHashMap<>();
            for (Map.Entry<String, LinkedHashMap<String, Long>> entry : legionAndSoldiers.entrySet()) {
                if (entry.getValue().containsKey(soldierType)) {
                    result.put(entry.getKey(), entry.getValue().get(soldierType));
                }
            }
            result.entrySet().stream().sorted((kv2, kv1) -> kv1.getValue().compareTo(kv2.getValue()))
                    .filter(kv -> legionAndActivity.get(kv.getKey()) < activity)
                    .forEach(kv -> System.out.println(kv.getKey() + " -> " + kv.getValue()));
        } else {
            String soldierType = command;
            legionAndActivity.entrySet().stream().sorted((kv2, kv1) -> kv1.getValue().compareTo(kv2.getValue()))
                    .filter(kv -> legionAndSoldiers.get(kv.getKey()).containsKey(soldierType))
                    .forEach(kv -> System.out.println(kv.getValue() + " : " + kv.getKey()));
        }


    }

}







