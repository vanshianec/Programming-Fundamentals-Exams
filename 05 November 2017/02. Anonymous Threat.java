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
        List<String> words = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String command = reader.readLine();

        while (!command.equals("3:1")) {
            String tokens[] = command.split(" ");
            switch (tokens[0]) {
                case "merge":
                    merge(words, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "divide":
                    divide(words,Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                    break;
            }


            command = reader.readLine();
        }
        System.out.println(String.join(" ",words).replace("[","").replace("]",""));

    }

    private static void merge(List<String> words, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex >= words.size()) {
            endIndex = words.size() - 1;
        }
        StringBuilder merger = new StringBuilder();
        if (startIndex < words.size() - 1) {
            int indexCounter=startIndex;
            for (int i = startIndex; i <= endIndex; i++) {
                if(indexCounter>endIndex){
                    break;
                }
                merger.append(words.get(i));
                words.remove(i);
                i--;
                indexCounter++;
            }
            words.add(startIndex, merger.toString());

        }
    }
    private static void divide(List<String> words, int index,int partitions){
           String word = words.get(index);
           int length= word.length();
           if(length%partitions==0){
               int eachSplitetWordLength=length/partitions;
               List<String> substring = new ArrayList<>();
                  while(partitions-->0){
                      String subs = word.substring(0,eachSplitetWordLength);
                      substring.add(subs);
                      StringBuilder str = new StringBuilder(word);
                      str.delete(0,eachSplitetWordLength);
                      word=str.toString();
                  }
                  words.remove(index);
                  words.addAll(index,substring);
           }
           else if (length%partitions!=0){
                   int bonusLength=length%partitions;
               int eachSplitetWordLength=length/partitions;
               List<String> substring = new ArrayList<>();
               while(partitions-->0){
                   if(partitions==0){
                       String subs = word.substring(0,eachSplitetWordLength+bonusLength);
                       substring.add(subs);
                       StringBuilder str = new StringBuilder(word);
                       str.delete(0,eachSplitetWordLength+bonusLength);
                       word=str.toString();
                   }
                   else{
                       String subs = word.substring(0,eachSplitetWordLength);
                       substring.add(subs);
                       StringBuilder str = new StringBuilder(word);
                       str.delete(0,eachSplitetWordLength);
                       word=str.toString();
                   }

               }
               words.remove(index);
               words.addAll(index,substring);
           }
    }

}





