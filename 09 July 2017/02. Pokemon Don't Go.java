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
        List<Integer> sequence = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        long sum = 0L;
        while(!sequence.isEmpty()){
            int index=Integer.parseInt(reader.readLine());
            if(index<0){
             sum+=sequence.get(0);
             int value = sequence.get(0);
             sequence.remove(0);
             sequence.add(0,sequence.get(sequence.size()-1));
                sequence=sequence.stream().map(element ->{
                    if(element<=value){
                        element+=value;
                    }
                    else{
                        element-=value;
                    }
                    return element;
                }).collect(Collectors.toList());
            }
            else if(index>=sequence.size()){
                sum+=sequence.get(sequence.size()-1);
                int value = sequence.get(sequence.size()-1);
                sequence.remove(sequence.size()-1);
                sequence.add(sequence.size(),sequence.get(0));
                sequence=sequence.stream().map(element ->{
                    if(element<=value){
                        element+=value;
                    }
                    else{
                        element-=value;
                    }
                    return element;
                }).collect(Collectors.toList());
            }
            else{
                int value = sequence.get(index);
                sequence.remove(index);
                sum+=value;
                sequence=sequence.stream().map(element ->{
                    if(element<=value){
                        element+=value;
                    }
                    else{
                        element-=value;
                    }
                    return element;
                }).collect(Collectors.toList());
            }


        }
        System.out.println(sum);


    }

}





