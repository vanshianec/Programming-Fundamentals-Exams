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
       int N = Integer.parseInt(reader.readLine());
       int exponent=N;
       int key = Integer.parseInt(reader.readLine());
        BigInteger token = BigInteger.valueOf(key);
       BigDecimal totalSiteLoss = BigDecimal.ZERO;
       while(N -- > 0){
           String tokens[]= reader.readLine().split(" ");
           String websiteName = tokens[0];
           Long siteVisits = Long.parseLong(tokens[1]);
           BigDecimal price = new BigDecimal(tokens[2]);
           BigDecimal siteVisitsDecimal = BigDecimal.valueOf(siteVisits);
           BigDecimal multiplier = price.multiply(siteVisitsDecimal);
           totalSiteLoss=totalSiteLoss.add(multiplier);
           System.out.println(websiteName);
       }


        System.out.printf("Total Loss: %.20f%n",totalSiteLoss);
        System.out.println("Security Token: "+token.pow(exponent));



    }
}





