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

        LinkedHashMap<String, List<String>> pokemons = new LinkedHashMap<>();
        String input = reader.readLine();
        while (!input.equals("wubbalubbadubdub")) {

            String[] tokens = input.split(" -> ");
            if (tokens.length == 1) {
                if (pokemons.containsKey(tokens[0])) {
                    System.out.printf("# %s%n", tokens[0]);
                    for (String evolution : pokemons.get(tokens[0])) {
                        System.out.println(evolution);
                    }
                }
            } else {
                String pokemonName = tokens[0];
                String pokemonTypeAndIndex = tokens[1] + " <-> " + tokens[2];
                if (!pokemons.containsKey(pokemonName)) {
                    pokemons.put(pokemonName, new ArrayList<>());
                }
                pokemons.get(pokemonName).add(pokemonTypeAndIndex);
            }

            input = reader.readLine();
        }

        for (Map.Entry<String, List<String>> entry : pokemons.entrySet()) {
            System.out.printf("# %s%n", entry.getKey());
            entry.getValue().stream().sorted((e2, e1) -> {
                Integer firstValue = Integer.parseInt(e1.split(" <-> ")[1]);
                Integer secondValue = Integer.parseInt(e2.split(" <-> ")[1]);
                return firstValue.compareTo(secondValue);
            }).forEach(System.out::println);
        }

    }

}





