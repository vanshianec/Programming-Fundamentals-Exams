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
        int length = Integer.parseInt(reader.readLine());
        String command = reader.readLine();
        int longestSubSequence = Integer.MIN_VALUE;
        int leftmostIndex = Integer.MAX_VALUE;
        int bestSum = Integer.MIN_VALUE;
        int bestSequenceCounter = Integer.MIN_VALUE;
        Stack<List<Integer>> bestSequenceLine = new Stack<>();
        int sequenceCounter = 1;
        while (!command.equals("Clone them!")) {
            List<Integer> sequence = Arrays.stream(command.split("\\!+")).map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (sequence.size() != length) {
                sequenceCounter++;
                command=reader.readLine();
                continue;
            }
            int currentBestSubSequence = 0;
            int currentBestLeftMostIndex = 0;
            int currentLongestSubSequence = 1;

            for (int i = 0; i < sequence.size() - 1; i++) {
                if (sequence.get(i) == 1 && sequence.get(i + 1) == 1) {
                    currentLongestSubSequence++;
                    if (currentLongestSubSequence > currentBestSubSequence) {
                        currentBestSubSequence = currentLongestSubSequence;
                        currentBestLeftMostIndex = i + 1 - (currentBestSubSequence - 1);
                    }
                } else {
                    currentLongestSubSequence = 1;
                }
            }
            int currentBestSum = sequence.stream().reduce((x, y) -> x + y).get();
            if (currentBestSubSequence > longestSubSequence) {
                leftmostIndex=currentBestLeftMostIndex;
                longestSubSequence = currentBestSubSequence;
                bestSum = currentBestSum;
                bestSequenceCounter = sequenceCounter;
                bestSequenceLine.push(sequence);

            } else if (currentBestSubSequence == longestSubSequence) {
                if (currentBestLeftMostIndex < leftmostIndex) {
                    leftmostIndex = currentBestLeftMostIndex;
                    bestSum = currentBestSum;
                    bestSequenceCounter = sequenceCounter;
                    bestSequenceLine.push(sequence);
                } else if (currentBestLeftMostIndex == leftmostIndex) {
                    if (currentBestSum > bestSum) {
                        bestSum = currentBestSum;
                        bestSequenceCounter = sequenceCounter;
                        bestSequenceLine.push(sequence);
                    }
                }
            }

            command = reader.readLine();
            sequenceCounter++;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n",bestSequenceCounter,bestSum);
        List<Integer> bestSequence=bestSequenceLine.pop();
        for (Integer num : bestSequence) {
            System.out.print(num+" ");
        }

    }
}





