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
        List<String> snowmans = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        while (true) {

            for (int i = 0; i < snowmans.size(); i++) {
                List<String> copy = snowmans;
                copy=copy.stream().filter(sn -> !sn.contains("*")).collect(Collectors.toList());
                if(copy.size()==1){
                    return;
                }
                if (snowmans.get(i).contains("*")) {
                    continue;
                } else {
                    int attackerIndex = i;
                    int targetIndex = Integer.parseInt(snowmans.get(i));
                    if (targetIndex >= snowmans.size()) {
                        targetIndex %= snowmans.size();
                    }
                    if (attackerIndex == targetIndex) {
                        String concated= snowmans.get(i).concat("*");
                        snowmans.set(attackerIndex,concated);
                        System.out.printf("%d performed harakiri%n", attackerIndex);
                        continue;
                    }
                    int difference = Math.abs(attackerIndex - targetIndex);
                    if (difference % 2 == 0) {
                        String concated=snowmans.get(targetIndex).concat("*");
                        snowmans.set(targetIndex,concated);
                        System.out.printf("%d x %d -> %d wins%n", attackerIndex, targetIndex, attackerIndex);
                        continue;
                    } else if (difference % 2 != 0) {
                        String concated= snowmans.get(attackerIndex).concat("*");
                        snowmans.set(attackerIndex,concated);
                        System.out.printf("%d x %d -> %d wins%n",attackerIndex,targetIndex,targetIndex);
                        continue;
                    }
                }

            }
            snowmans.removeIf(sn -> sn.contains("*"));
            if(snowmans.size()==1){
                return;
            }


        }
    }


}





