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
        Map<String, List<String>> sideAndUsers = new LinkedHashMap<>();
        Map<String, String> userAndSide = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!input.equals("Lumpawaroo")) {
            String forceSide = "";
            String forceUser = "";
            if (input.contains("|")) {
                forceSide = input.split(" \\| ")[0];
                forceUser = input.split(" \\| ")[1];
                fillSideAndUsers(sideAndUsers, userAndSide, forceSide, forceUser);
            } else if (input.contains(" -> ")) {
                forceUser = input.split(" -> ")[0];
                forceSide = input.split(" -> ")[1];
                fillUserAndSide(sideAndUsers, userAndSide, forceSide, forceUser);
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }


            input = reader.readLine();
        }
         Comparator<Map.Entry<String,List<String>>> byValue = Comparator.comparing(kv -> kv.getValue().size());
         Comparator<Map.Entry<String,List<String>>> byKey = Comparator.comparing(Map.Entry::getKey);

        sideAndUsers = sideAndUsers.entrySet().stream().sorted(byValue.reversed().thenComparing(byKey))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, List<String>> entry : sideAndUsers.entrySet()) {
            if (entry.getValue().isEmpty()) {
                continue;
            }
            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
            List<String> users = entry.getValue().stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
            for (String user : users) {
                System.out.printf("! %s%n", user);
            }
        }


    }

    private static void fillUserAndSide(Map<String, List<String>> sideAndUsers, Map<String, String> userAndSide, String forceSide, String forceUser) {
        if (!userAndSide.containsKey(forceUser)) {
            userAndSide.put(forceUser, forceSide);
            if (!sideAndUsers.containsKey(forceSide)) {
                sideAndUsers.put(forceSide, new ArrayList<>());
                sideAndUsers.get(forceSide).add(forceUser);
            } else {
                sideAndUsers.get(forceSide).add(forceUser);
            }
        } else {
            String oldSide = userAndSide.get(forceUser);
            userAndSide.put(forceUser, forceSide);
            sideAndUsers.get(oldSide).remove(forceUser);
            if (!sideAndUsers.containsKey(forceSide)) {
                sideAndUsers.put(forceSide, new ArrayList<>());
                sideAndUsers.get(forceSide).add(forceUser);
            } else {
                sideAndUsers.get(forceSide).add(forceUser);
            }

        }
    }

    private static void fillSideAndUsers(Map<String, List<String>> sideAndUsers, Map<String, String> userAndSide, String forceSide, String forceUser) {
        if (!sideAndUsers.containsKey(forceSide)) {
            sideAndUsers.put(forceSide, new ArrayList<>());

            if (!userAndSide.containsKey(forceUser)) {
                sideAndUsers.get(forceSide).add(forceUser);
                userAndSide.put(forceUser, forceSide);
            }
        } else {
            if (!userAndSide.containsKey(forceUser)) {
                sideAndUsers.get(forceSide).add(forceUser);
                userAndSide.put(forceUser, forceSide);
            }
        }
    }
}





