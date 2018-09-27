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
        int firstEmployeeStudentsHandledPerHour=Integer.parseInt(reader.readLine());
        int secondEmployeeStudentsHandledPerHour=Integer.parseInt(reader.readLine());
        int thirdEmployeeStudentsHandledPerHour=Integer.parseInt(reader.readLine());
        int totalStudents = Integer.parseInt(reader.readLine());
        int totalStudentsAnsweredPerHour=firstEmployeeStudentsHandledPerHour+secondEmployeeStudentsHandledPerHour
                +thirdEmployeeStudentsHandledPerHour;
        int hourCount=0;
        int breakCount=3;
        while(totalStudents>0){
            if(breakCount==0){
                hourCount++;
                breakCount=3;
                continue;
            }
            totalStudents-=totalStudentsAnsweredPerHour;
            hourCount++;
            breakCount--;
        }
        System.out.printf("Time needed: %dh.%n",hourCount);


    }

}





