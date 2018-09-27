import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Long N = Long.parseLong(reader.readLine());
        BigInteger bestValue = BigInteger.valueOf(0);

        Long bestSnowballSnow=Long.MIN_VALUE;
        Long bestSnowballTime =Long.MIN_VALUE;
        int bestSnowballQuality=Integer.MIN_VALUE;
        while(N-->0){
            Long snowballSnow = Long.parseLong(reader.readLine());
            Long snowballTime = Long.parseLong(reader.readLine());
            int snowballQuality = Integer.parseInt(reader.readLine());
            BigInteger value = BigInteger.valueOf(snowballSnow/snowballTime);
            BigInteger result = value.pow(snowballQuality);

            if(result.compareTo(bestValue)>0){
                bestSnowballSnow=snowballSnow;
                bestSnowballQuality=snowballQuality;
                bestSnowballTime=snowballTime;
                bestValue=result;
            }

        }
        System.out.printf("%d : %d = %d (%d)%n",bestSnowballSnow,bestSnowballTime,bestValue,bestSnowballQuality);

    }
}





