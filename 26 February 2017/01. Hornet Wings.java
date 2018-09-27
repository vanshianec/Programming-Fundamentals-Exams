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
        int N = Integer.parseInt(reader.readLine());
        double M = Double.parseDouble(reader.readLine());
        int P = Integer.parseInt(reader.readLine());

        double distance = N/1000*M;
        int secondFlapping = N / 100;
        int restTime = N/P*5;
        System.out.printf("%.2f m.%n",distance);
        System.out.printf("%d s.%n",secondFlapping+restTime);
    }

}





