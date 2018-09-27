import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> participants = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        List<String> songs = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        LinkedHashMap<String,Integer> peopleAwardsCount = new LinkedHashMap<>();
        LinkedHashMap<String,List<String>> peopleAwards = new LinkedHashMap<>();

        String input = reader.readLine();

        while(!input.equals("dawn")){
            String []tokens=input.split(", ");
            String name = tokens[0];
            String song = tokens[1];
            String award = tokens[2];
            if(participants.contains(name)&&songs.contains(song)){
            if(!peopleAwards.containsKey(name)){
                peopleAwards.put(name,new ArrayList<>());
                peopleAwards.get(name).add(award);
                peopleAwardsCount.put(name,1);
            }
            else{
                if(!peopleAwards.get(name).contains(award)){
                    peopleAwards.get(name).add(award);
                    peopleAwardsCount.put(name,peopleAwardsCount.get(name)+1);
                }
            }

            }

            input=reader.readLine();
        }
        if(peopleAwardsCount.isEmpty()){
            System.out.println("No awards");
        }
        else {
            peopleAwardsCount = peopleAwardsCount.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            for (Map.Entry<String, Integer> entry : peopleAwardsCount.entrySet()) {
                System.out.printf("%s: %d awards%n", entry.getKey(), entry.getValue());
                peopleAwards.get(entry.getKey()).stream()
                        .sorted((a, b) -> a.compareTo(b))
                        .forEach(el -> System.out.printf("--%s%n", el));
            }
        }

    }

}







