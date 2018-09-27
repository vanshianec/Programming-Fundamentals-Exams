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
        StringBuilder str = new StringBuilder();
        String input =reader.readLine();
        while(!input.equals("Visual Studio crash")){
            str.append(input);
            str.append("\n");

            input=reader.readLine();
        }
        String text = str.toString();
        text=text.replace("\n"," ");
        Pattern pattern = Pattern.compile("32656 19759 32763 0 (\\d+) 0 ([ \\d]+?) 0");
        Matcher matcher = pattern.matcher(text);
        List<String> readableName = new ArrayList<>();
        while(matcher.find()){
            if(Integer.parseInt(matcher.group(1))==matcher.group(2).split(" ").length){
                readableName.add(matcher.group(2).trim());
            }

        }
        for (String code : readableName) {
            String asciCodes[] = code.split(" ");
            for (String asciCode : asciCodes) {
                System.out.print(Character.toString((char)Integer.parseInt(asciCode)));
            }
            System.out.println();
        }



    }

}





