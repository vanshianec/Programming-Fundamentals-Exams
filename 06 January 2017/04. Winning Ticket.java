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
        List<String> tickets = Arrays.stream(reader.readLine().split("[, ]+")).collect(Collectors.toList());
        Pattern ticketPattern = Pattern.compile("^[^\\^$@#]*([$]|[#]|[@]|[\\^])(\\1{5,10})[^\\^$@#]*(\\1{6,10})[^\\^$@#]*$");
        Pattern jackpotPattern = Pattern.compile("^([$]{20}|[\\^]{20}|[@]{20}|[#]{20})$");
        for (String ticket : tickets) {
            Matcher jackpotMatcher = jackpotPattern.matcher(ticket);
            Matcher ticketMatcher = ticketPattern.matcher(ticket);
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            } else if (jackpotMatcher.find()) {
                System.out.printf("ticket \"%s\" - 10%c Jackpot!%n", ticket, jackpotMatcher.group(1).charAt(0));
                continue;
            } else if (ticketMatcher.find()) {
                if (ticket.indexOf(ticketMatcher.group(1)) + ticketMatcher.group(2).length() >= 10 || ticket.lastIndexOf(ticketMatcher.group(3)) < 10
                        ||ticket.indexOf(ticketMatcher.group(1))==ticket.lastIndexOf(ticketMatcher.group(3))) {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                } else {
                    System.out.printf("ticket \"%s\" - %d%c%n", ticket, Math.min(ticketMatcher.group(2).length() + 1, ticketMatcher.group(3).length()), ticketMatcher.group(1).charAt(0));
                }
            } else {
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            }

        }

    }

}







