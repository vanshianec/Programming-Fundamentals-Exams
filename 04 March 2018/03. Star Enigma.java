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
        int numberOfMessages = Integer.parseInt(reader.readLine());
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets= new ArrayList<>();
        while (numberOfMessages-- > 0) {
            String message = reader.readLine();
            int starsCounter = 0;
            for (int i = 0; i < message.length(); i++) {
                if (message.toLowerCase().charAt(i) == 's' ||
                        message.toLowerCase().charAt(i) == 't' ||
                        message.toLowerCase().charAt(i) == 'a' ||
                        message.toLowerCase().charAt(i) == 'r') {
                    starsCounter++;
                }
            }
            StringBuilder encryptMessage = new StringBuilder(message);
            for (int i = 0; i < encryptMessage.length(); i++) {
                char newChar = (char) ((int) encryptMessage.charAt(i) - starsCounter);
                encryptMessage.setCharAt(i, newChar);
            }
            message=encryptMessage.toString();
            Pattern pattern = Pattern.compile("@([A-Za-z]+)[^@:!>-]*?:(\\d+)[^@:!>-]*?!([AD])![^@:!>-]*?->(\\d+)");
            Matcher matcher = pattern.matcher(message);
            while(matcher.find()){
                if(matcher.group(3).toUpperCase().equals("A")){
                    attackedPlanets.add(matcher.group(1));
                }
                else if (matcher.group(3).toUpperCase().equals("D")){
                    destroyedPlanets.add(matcher.group(1));
                }
            }


        }
        if(attackedPlanets.isEmpty()){
            System.out.println("Attacked planets: 0");
        }
        else{
            System.out.println("Attacked planets: "+attackedPlanets.size());
            attackedPlanets=attackedPlanets.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
            for (String attackedPlanet : attackedPlanets) {
                System.out.printf("-> %s%n",attackedPlanet);
            }
        }
        if(destroyedPlanets.isEmpty()){
            System.out.println("Destroyed planets: 0");
        }
        else{
            System.out.println("Destroyed planets: "+destroyedPlanets.size());
            destroyedPlanets=destroyedPlanets.stream().sorted((a,b)-> a.compareTo(b)).collect(Collectors.toList());
            for (String destroyedPlanet : destroyedPlanets) {
                System.out.printf("-> %s%n",destroyedPlanet);
            }
        }


    }
}





