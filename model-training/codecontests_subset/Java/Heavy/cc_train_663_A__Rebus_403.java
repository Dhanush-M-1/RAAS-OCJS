import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rebus {
    public static void main(String[] args) {
        // Instantiate & RUN!!!
        Rebus instance = new Rebus();
        instance.run(System.in, System.out);
    }

    public void run(InputStream inputStream, PrintStream printStream) {
        final Scanner scan = new Scanner(inputStream);
        final List<Boolean> isPositive = new ArrayList<>();
        StringBuilder outputFormatBuilder = new StringBuilder();
        outputFormatBuilder.append("%d");
        int n = inputParser(scan, isPositive, outputFormatBuilder);
        if(isPossibleSolution(isPositive, 1, n)) {
            printStream.println("Possible");
            final List<Integer> numbers = new ArrayList<>();
            final int diff = calcOneDiff(numbers, isPositive, n);
            adjustNumbers(numbers, isPositive, diff);
            numbers.add(n);
            printStream.println(String.format(outputFormatBuilder.toString(), numbers.toArray()));
        } else {
            printStream.println("Impossible");
        }
    }

    private void adjustNumbers(List<Integer> numbers, List<Boolean> isPositive, int diff) {
        if (diff == 0) {
            return;
        }
        int numPos = 0;
        int numNeg = 0;
        for (final boolean thisNum: isPositive) {
            if(thisNum) {
                numPos++;
            } else {
                numNeg++;
            }
        }
        final boolean isDiffPositive = (diff > 0);
        if (isDiffPositive) {
            int add = diff / numPos;
            int rem = diff % numPos;
            for (int i = 0; i < isPositive.size(); i++) {
                if (isPositive.get(i)) {
                    int n = numbers.get(i);
                    if (rem > 0) {
                        rem--;
                        n += add + 1;
                    } else {
                        n += add;
                    }
                    numbers.set(i, n);
                }
            }
        } else {
            diff = -1 * diff;
            int add = diff / numNeg;
            int rem = diff % numNeg;
            for (int i = 0; i < isPositive.size(); i++) {
                if (!isPositive.get(i)) {
                    int n = numbers.get(i);
                    if (rem > 0) {
                        rem--;
                        n += add + 1;
                    } else {
                        n += add;
                    }
                    numbers.set(i, n);
                }
            }
        }
    }

    private int calcOneDiff(List<Integer> numbers, List<Boolean> isPositive, int n) {
        int runningSum = 0;
        for(final boolean thisNum: isPositive) {
            numbers.add(1);
            if(thisNum) {
                runningSum++;
            } else {
                runningSum--;
            }
        }
        return n - runningSum;
    }

    private boolean isPossibleSolution(List<Boolean> isPositive, int start, int n) {
        int posMin = 0;
        int posMax = 0;
        for (final boolean thisNum: isPositive) {
            if(thisNum) {
                posMin += start;
                posMax += n;
            } else {
                posMin -= n;
                posMax -= start;
            }
        }
        return ((posMin <= n) && (n <= posMax));
    }

    private int inputParser(Scanner scan, List<Boolean> isPositive, StringBuilder outputFormatBuilder) {
        int returnInt = 0;
        isPositive.add(true);
        scan.next();
        while(scan.hasNext()) {
            switch (scan.next()) {
                case "+" :
                    outputFormatBuilder.append(" + %d");
                    isPositive.add(true);
                    scan.next();
                    break;
                case "-":
                    outputFormatBuilder.append(" - %d");
                    isPositive.add(false);
                    scan.next();
                    break;
                case "=":
                    returnInt = scan.nextInt();
                    outputFormatBuilder.append( " = ").append(returnInt);
                    break;
            }
        }
        return returnInt;
    }
}
