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
        List<String> messages = new ArrayList<>();
        List<String> broadcasts = new ArrayList<>();
        Pattern messagePattern = Pattern.compile("^(\\d+) <-> (([A-Za-z0-9]+)|(\\d+)|([A-Za-z]+))$");
        Pattern broadcastPattern = Pattern.compile("^([^\\d]+) <-> (([A-Za-z0-9]+)|(\\d+)|([A-Za-z]+))$");

        String input = reader.readLine();
        while (!input.equals("Hornet is Green")) {
            Matcher message = messagePattern.matcher(input);
            Matcher broadcast = broadcastPattern.matcher(input);
            while (message.find()) {
                String code = message.group(0).split(" <-> ")[0];
                String reversedCode = new StringBuilder(code).reverse().toString();
                messages.add(reversedCode + " -> " + message.group(0).split(" <-> ")[1]);
            }
            while (broadcast.find()) {
                String code = broadcast.group(0).split(" <-> ")[1];
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < code.length(); i++) {
                    if (Character.isUpperCase(code.charAt(i))) {
                        str.append(Character.toLowerCase(code.charAt(i)));
                    } else if (Character.isLowerCase(code.charAt(i))) {
                        str.append(Character.toUpperCase(code.charAt(i)));
                    }
                    else{
                        str.append(code.charAt(i));
                    }
                }
                broadcasts.add(str.toString()+" -> "+broadcast.group(0).split(" <-> ")[0]);
            }
            input = reader.readLine();
        }
        System.out.println("Broadcasts:");
        if (broadcasts.isEmpty()) {
            System.out.println("None");
        } else {
            for (String broadcast : broadcasts) {
                System.out.println(broadcast);
            }
        }
        System.out.println("Messages:");
        if (messages.isEmpty()) {
            System.out.println("None");
        } else {
            for (String message : messages) {
                System.out.println(message);
            }
        }

    }

}







