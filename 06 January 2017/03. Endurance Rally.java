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
        List<String> participants = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        List<Double> zones = Arrays.stream(reader.readLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        List<Integer> checkpoints = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (String participant : participants) {
            double fuel = participant.charAt(0);
            boolean finished=true;
            for (int i = 0; i < zones.size(); i++) {
                if (checkpoints.contains(i)) {
                    fuel += zones.get(i);
                } else {
                    fuel -= zones.get(i);
                    if (fuel <= 0) {
                        System.out.printf("%s - reached %d%n", participant, i);
                        finished=false;
                        break;
                    }
                }
            }
            if(finished){
                System.out.printf("%s - fuel left %.2f%n",participant,fuel);
            }
        }
    }

}







