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
        int lostGames = Integer.parseInt(reader.readLine());
        double headsetPrice = Double.parseDouble(reader.readLine());
        double mousePrice = Double.parseDouble(reader.readLine());
        double keyboardPrice =Double.parseDouble(reader.readLine());
        double displayPrice = Double.parseDouble(reader.readLine());

        int trashedHeadset =0;
        int trashedMouse=0;
        int trashedKeyboard=0;
        int trashedDisplay=0;
        int trashedKeyboardCounter=0;
        int counter=1;

        while(counter<=lostGames){
           if(counter%2==0&&counter%3==0&&counter!=1){
               trashedHeadset++;
               trashedMouse++;
               trashedKeyboard++;
               trashedKeyboardCounter++;
           }
           else if(counter%2==0&&counter!=1){
               trashedHeadset++;
           }
           else if (counter%3==0&counter!=1){
               trashedMouse++;
           }
           if(trashedKeyboardCounter%2==0&&counter!=1&&trashedKeyboardCounter!=0){
               trashedDisplay++;
               trashedKeyboardCounter=0;
           }


            counter++;
        }
         double totalExpenses=trashedDisplay*displayPrice+trashedHeadset*headsetPrice+trashedKeyboard*keyboardPrice+trashedMouse
                 *mousePrice;
        System.out.printf("Rage expenses: %.2f lv.",totalExpenses);


    }

}





