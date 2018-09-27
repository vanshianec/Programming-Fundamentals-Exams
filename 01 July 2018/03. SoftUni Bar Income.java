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
        Pattern pattern = Pattern.compile(".*%([A-Z]{1}[a-z]+)%.*<([\\w]+)>.*\\|(\\d+)\\|[^\\d\\.]*([-+]?[0-9]*\\.?[0-9]*)\\$");
        String command = reader.readLine();
        double totalSum=0;
        while(!command.equals("end of shift")){
            Matcher matcher = pattern.matcher(command);
            while(matcher.find()){
                String name = matcher.group(1);
                String product = matcher.group(2);
                int quantity = Integer.parseInt(matcher.group(3));
                double value = Double.parseDouble(matcher.group(4));
                System.out.printf("%s: %s - %.2f%n",name,product,quantity*value);
                totalSum+=quantity*value;
            }


            command=reader.readLine();
        }
        System.out.printf("Total income: %.2f",totalSum);


    }

}





