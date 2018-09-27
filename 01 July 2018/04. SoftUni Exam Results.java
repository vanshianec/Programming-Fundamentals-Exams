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
        HashMap<String,Integer> results = new HashMap<>();
        HashMap<String,Integer> submissions =new HashMap<>();

        String input = reader.readLine();
        while(!input.equals("exam finished")){

            String [] tokens = input.split("-");
            String username = tokens[0];
            String language=tokens[1];
            if(language.equals("banned")){
                if(results.containsKey(username)){
                    results.remove(username);
                }
                input=reader.readLine();
                continue;
            }
            int points = Integer.parseInt(tokens[2]);
            if(!results.containsKey(username)){
                results.put(username,points);
            }
            else{
                if(results.get(username)<points){
                    results.put(username,points);
                }
            }
            if(!submissions.containsKey(language)){
                submissions.put(language,1);
            }
            else{
                submissions.put(language,submissions.get(language)+1);
            }

            input=reader.readLine();
        }
        System.out.println("Results: ");
        Comparator<Map.Entry<String,Integer>> byValue = Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder());
        Comparator<Map.Entry<String,Integer>> byKey = Comparator.comparing(Map.Entry::getKey);
        results.entrySet().stream().sorted((byValue.thenComparing(byKey)))
                .forEach(kv -> System.out.println(kv.getKey()+" | "+kv.getValue()));
        System.out.println("Submissions: ");
        submissions.entrySet().stream().sorted(byValue.thenComparing(byKey))
                .forEach(kv -> System.out.println(kv.getKey()+" - "+kv.getValue()));

    }

}





