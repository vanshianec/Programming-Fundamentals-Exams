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
        List<String> courses = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        String command = reader.readLine();

        while (!command.equals("course start")) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add":
                    add(tokens[1], courses);
                    break;
                case "Insert":
                    insert(tokens[1], Integer.parseInt(tokens[2]), courses);
                    break;
                case "Remove":
                    remove(tokens[1], courses);
                    break;
                case "Swap":
                    swap(tokens[1], tokens[2], courses);
                    break;
                case "Exercise":
                    exercise(tokens[1], courses);
                    break;
            }


            command = reader.readLine();
        }
        int printCounter = 1;
        for (String course : courses) {
            System.out.printf("%d.%s%n",printCounter,course);
            printCounter++;
        }

    }

    private static void add(String lessonTitle, List<String> courses) {
        if (!courses.contains(lessonTitle)) {
            courses.add(courses.size(), lessonTitle);
        }
    }

    private static void insert(String lessonTitle, int index, List<String> courses) {
        if (index >= 0 && index < courses.size()) {
            if (!courses.contains(lessonTitle)) {
                courses.add(index, lessonTitle);
            }
        }
    }

    private static void remove(String lessonTitle, List<String> courses) {
        if (courses.contains(lessonTitle)) {
            int index = courses.indexOf(lessonTitle);
            int lastIndex=0;
            if(index==courses.size()-1){
                lastIndex=courses.size()-1;
            }
            else{
                lastIndex=index;
            }
            courses.remove(lessonTitle);
            if (courses.get(lastIndex).contains("-")) {
                courses.remove(lastIndex);
            }

        }
    }

    private static void swap(String firstLessonTitle, String secondLessonTitle, List<String> courses) {
        if (courses.contains(firstLessonTitle) && courses.contains(secondLessonTitle)) {
            int firstIndex = Math.min(courses.indexOf(firstLessonTitle), courses.indexOf(secondLessonTitle));
            int secondIndex = Math.max(courses.indexOf(firstLessonTitle), courses.indexOf(secondLessonTitle));
            boolean firstEx = false;
            boolean secondEx = false;
            int lastIndex=0;
            if(secondIndex==courses.size()-1){
                lastIndex=courses.size()-1;
            }
            else{
                lastIndex=secondIndex+1;
            }
            if (courses.get(firstIndex + 1).contains("-")) {
                firstEx = true;
            }
            if (courses.get(lastIndex).contains("-")) {
                secondEx = true;
            }
            Collections.swap(courses, firstIndex, secondIndex);
            if (firstEx && secondEx) {
                Collections.swap(courses, firstIndex + 1, lastIndex);
            } else if (firstEx) {
                String exercise = courses.get(firstIndex + 1);
                courses.remove(firstIndex + 1);
                courses.add(secondIndex, exercise);
            } else if (secondEx) {
                String exercise = courses.get(lastIndex);
                courses.remove(lastIndex);
                courses.add(firstIndex + 1, exercise);
            }


        }
    }

    private static void exercise(String lessonTitle, List<String> courses) {
        if (!courses.contains(lessonTitle)) {
            courses.add(courses.size(), lessonTitle);
            courses.add(courses.size(), lessonTitle+"-Exercise");
        } else {
            int index = courses.indexOf(lessonTitle);
            int lastIndex=0;
            if(index==courses.size()-1){
                lastIndex=courses.size()-1;
            }
            else{
                lastIndex=index+1;
            }
            if (!courses.get(lastIndex).contains("-")) {
                courses.add(lastIndex, courses.get(index)+"-Exercise");
            }
        }
    //77 %
  //TODO
    }

}





