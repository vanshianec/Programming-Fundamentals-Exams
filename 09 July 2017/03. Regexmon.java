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
        String text = reader.readLine();
        Pattern didimonPattern = Pattern.compile("([^A-Za-z-]+)");
        Pattern bojomonPattern = Pattern.compile("([A-Za-z]+-[A-Za-z]+)");
        Matcher didimonMatcher ;
        Matcher bojomonMatcher ;

        while (true) {
            didimonMatcher = didimonPattern.matcher(text);
            if (didimonMatcher.find()) {
                int index = text.indexOf(didimonMatcher.group(1));
                System.out.println(didimonMatcher.group(1));
                StringBuilder str = new StringBuilder(text);
                str.replace(0,index+didimonMatcher.group(1).length(),"");
                text=str.toString();
            }
            else{
                return;
            }
            bojomonMatcher=bojomonPattern.matcher(text);
             if(bojomonMatcher.find()){
               int index=text.indexOf(bojomonMatcher.group(1));
                 System.out.println(bojomonMatcher.group(1));
                 StringBuilder str = new StringBuilder(text);
                 str.replace(0,index+bojomonMatcher.group(1).length(),"");
                 text=str.toString();

            }
            else{
                return;
             }


        }


    }

}





