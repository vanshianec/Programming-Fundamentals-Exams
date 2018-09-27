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
        List<String> games = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        String commands = reader.readLine();
        while (!commands.equals("Play!")) {
            String tokens[] = commands.split(" ");
            switch (tokens[0]) {
                case "Install":
                    installGame(tokens[1], games);
                    break;
                case "Uninstall":
                    uninstallGame(tokens[1], games);
                    break;
                case "Update":
                    updateGame(tokens[1], games);
                    break;
                case "Expansion":
                    addExpansion(tokens[1], games);
                    break;
            }
            commands = reader.readLine();
        }
        for (String game : games) {
            System.out.print(game + " ");
        }
        System.out.println();
    }

    private static void installGame(String game, List<String> games) {
        if (!games.contains(game)) {
            games.add(games.size(), game);
        }
    }

    private static void uninstallGame(String game, List<String> games) {
        games.removeIf(g -> g.contains(game));
    }

    private static void updateGame(String game, List<String> games) {
        List<String> updatedGames = new ArrayList<>();
        for (String s : games) {
            if (s.contains(game)) {
                updatedGames.add(s);
            }
        }
        games.removeIf(g -> g.contains(game));
        games.addAll(games.size(), updatedGames);
    }

    private static void addExpansion(String expansionStats, List<String> games) {
        String tokens[] = expansionStats.split("-");
        String game = tokens[0];
        String expansion = tokens[1];
        if (games.contains(game)) {
            int index = games.indexOf(game);
            if (index == games.size()) {
                games.add(index, game + ":" + expansion);
            } else {
                games.add(index + 1, game + ":" + expansion);
            }

        }
    }

}





