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
        List<Long> beehives = Arrays.stream(reader.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(reader.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());

        for(int i=0;i<beehives.size();i++){
            if(hornets.isEmpty()){
                break;
            }
            long hornetsPower = 0L;
            for (Long hornet : hornets) {
                hornetsPower+=hornet;
            }
            if(hornetsPower<=beehives.get(i)){
                hornets.remove(0);
                long currentValue=beehives.get(i);
                beehives.remove(i);
                beehives.add(i,(currentValue-hornetsPower));
                if(beehives.get(i)==0){
                    beehives.remove(i);
                    i--;
                }
            }
            else{
                beehives.remove(i);
                i--;
            }

        }
        if(!beehives.isEmpty()){
            for (Long beehive : beehives) {
                System.out.print(beehive+" ");

            }
            System.out.println();
        }
        else{
            for (Long hornet : hornets){
                System.out.print(hornet +" ");
            }
            System.out.println();
        }




    }

}







