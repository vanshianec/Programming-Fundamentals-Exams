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
        Integer N =Integer.parseInt(reader.readLine());
        Integer M = Integer.parseInt(reader.readLine());
        Integer Y = Integer.parseInt(reader.readLine());
        int originalValue=N;
        int counter=0;
        while(N>=M){
            N-=M;
            counter++;
            if(N==originalValue*0.5){
                if(Y!=0){
                    N/=Y;
                }
            }
        }
        System.out.println(N);
        System.out.println(counter);


    }

}





