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
        Pattern surface = Pattern.compile("^([^A-Za-z0-9]+)$");
        Pattern mantle = Pattern.compile("^([0-9_]+)$");
        Pattern core = Pattern.compile("^([^A-Za-z0-9]+)([0-9_]+)([A-Za-z]+)([0-9_]+)([^A-Za-z0-9]+)$");
        int coreLength=0;
        Matcher matcher = surface.matcher(reader.readLine());
        if(!matcher.find()){
            System.out.println("Invalid");
            return;
        }
        matcher=mantle.matcher(reader.readLine());
        if(!matcher.find()){
            System.out.println("Invalid");
            return;
        }
        matcher=core.matcher(reader.readLine());

        if(!matcher.find()){
            System.out.println("Invalid");
            return;
        }
        else{
            coreLength=matcher.group(3).length();
        }


        matcher=mantle.matcher(reader.readLine());
        if(!matcher.find()){
            System.out.println("Invalid");
            return;
        }
         matcher = surface.matcher(reader.readLine());
        if(!matcher.find()){
            System.out.println("Invalid");
            return;
        }
        System.out.println("Valid");
        System.out.println(coreLength);

    }


}





