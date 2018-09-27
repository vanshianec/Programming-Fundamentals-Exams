import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, TreeMap<String, Integer>> tier = new TreeMap<>();
        Map<String, Integer> rank = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!input.equals("Season end")) {
            String[] tokens;
            if (!input.contains("->")) {
                tokens = input.split(" vs ");
                String firstPlayer = tokens[0];
                String secondPlayer = tokens[1];
                if (tier.containsKey(firstPlayer) && tier.containsKey(secondPlayer)) {
                    TreeMap<String, Integer> test = tier.get(firstPlayer);
                    for (Map.Entry<String, Integer> entry : test.entrySet()) {
                        if (tier.get(secondPlayer).containsKey(entry.getKey())) {
                            int firstPlayerSkill = tier.get(firstPlayer).values().stream().reduce((v1, v2) -> v1 + v2).get();
                            int secondPlayerSkill = tier.get(secondPlayer).values().stream().reduce((v1, v2) -> v1 + v2).get();
                            if (firstPlayerSkill > secondPlayerSkill) {
                                tier.remove(secondPlayer);
                                rank.remove(secondPlayer);
                            } else if (firstPlayerSkill < secondPlayerSkill) {
                                tier.remove(firstPlayer);
                                rank.remove(firstPlayer);
                            }
                            break;
                        }
                    }
                }
            } else {
                tokens = input.split(" -> ");
                String player = tokens[0];
                String role = tokens[1];
                int skill = Integer.parseInt(tokens[2]);
                if (!tier.containsKey(player)) {
                    tier.put(player, new TreeMap<>());
                    tier.get(player).put(role, skill);
                    rank.put(player, skill);

                } else {
                    if (!tier.get(player).containsKey(role)) {
                        tier.get(player).put(role, skill);
                        rank.put(player, rank.get(player) + skill);
                    } else {
                        if (tier.get(player).get(role) < skill) {
                            tier.get(player).put(role, skill);
                            rank.put(player, rank.get(player) + skill);
                        }
                    }
                }
            }


            input = reader.readLine();


        }
        Comparator<Map.Entry<String, Integer>> byValue = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> byKey = Comparator.comparing(Map.Entry::getKey);
        rank = rank.entrySet().stream().sorted(byValue.thenComparing(byKey)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : rank.entrySet()) {
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());
            LinkedHashMap<String, Integer> sortedRoles = tier.get(entry.getKey()).entrySet()
                    .stream().sorted(byValue.thenComparing(byKey))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            for (Map.Entry<String, Integer> innerEntry : sortedRoles.entrySet()) {
                System.out.printf("- %s <::> %d%n", innerEntry.getKey(), innerEntry.getValue());
            }
        }
    }
}





