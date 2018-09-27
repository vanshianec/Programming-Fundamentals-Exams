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
        String time[] = reader.readLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        long totalSeconds = hours * 3600 + minutes * 60 + seconds;
        BigInteger totalTime = BigInteger.ZERO;
        int steps = Integer.parseInt(reader.readLine());
        int secondsPerStep = Integer.parseInt(reader.readLine());
        BigInteger res = BigInteger.valueOf(steps);
        res = res.multiply(BigInteger.valueOf(secondsPerStep));
        totalTime = totalTime.add(res);
        totalTime = totalTime.add(BigInteger.valueOf(totalSeconds));
        BigInteger newHours = totalTime.divide(BigInteger.valueOf(3600)).remainder(BigInteger.valueOf(24));
        BigInteger newMinutes = totalTime.remainder(BigInteger.valueOf(3600)).divide(BigInteger.valueOf(60));
        BigInteger newSeconds = totalTime.remainder(BigInteger.valueOf(60));
        System.out.printf("Time Arrival: %02d:%02d:%02d%n", newHours, newMinutes, newSeconds);


    }

}







