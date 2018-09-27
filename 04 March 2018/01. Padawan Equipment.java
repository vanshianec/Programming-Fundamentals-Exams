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
        double money = Double.parseDouble(reader.readLine());
        int studentsCount=Integer.parseInt(reader.readLine());
        double lightsaberPrice = Double.parseDouble(reader.readLine());
        double robePrice = Double.parseDouble(reader.readLine());
        double beltPrice = Double.parseDouble(reader.readLine());

        int neededSabers=studentsCount+(int)Math.ceil((double)studentsCount*0.1);
        int freeBelts=studentsCount/6;
        double totalSum=lightsaberPrice*neededSabers+robePrice*studentsCount+beltPrice*(studentsCount-freeBelts);
        System.out.println(totalSum<=money ? String.format("The money is enough - it would cost %.2flv.%n",totalSum) :
        String.format("Ivan Cho will need %.2flv more.%n",totalSum-money));

    }
}





