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
        Pattern pattern = Pattern.compile("([A-Za-z]+)(.+)(\\1)");
        Pattern valuePattern = Pattern.compile("([^{}]+)");
        String input = reader.readLine();
        String values = reader.readLine();
        Matcher valueMatcher= valuePattern.matcher(values);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){

            while(valueMatcher.find()){
                StringBuilder str = new StringBuilder(input);
                int index = input.indexOf(matcher.group(2));
                str=str.replace(index,input.lastIndexOf(matcher.group(3)),valueMatcher.group(1));
               input=str.toString();
                break;
            }
        }
        System.out.println(input);

    }

}





