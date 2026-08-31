import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class AandBandCompilationErrors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        PrintWriter pw = new PrintWriter(os);
        // Get n
        int n = in.nextInt();
        List<Integer> firstSet = new ArrayList<Integer>();
        List<Integer> secondSet = new ArrayList<Integer>();
        List<Integer> thirdSet = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            firstSet.add(in.nextInt());
        }
        // Sort it
        Collections.sort(firstSet);
        for (int i = 0; i < n - 1; i++) {
            secondSet.add(in.nextInt());
        }
        // Sort it
        Collections.sort(secondSet);
        for (int i = 0; i < n - 2; i++) {
            thirdSet.add(in.nextInt());
        }
        // Sort it
        Collections.sort(thirdSet);
        // Sorted and hence do a comparison.
        // First not match is the deletion
        boolean found = false;
        for (int i = 0; i < n - 1; i++) {
            if (firstSet.get(i).equals(secondSet.get(i))) {
                continue;
            } else {
                pw.println(firstSet.get(i));
                found = true;
                break;
            }
        }
        // If loop exited and not found
        if (!found) {
            pw.println(firstSet.get(n - 1));
        }
        found = false;
        for (int i = 0; i < n - 2; i++) {
            if (secondSet.get(i).equals(thirdSet.get(i))) {
                continue;
            } else {
                pw.println(secondSet.get(i));
                found = true;
                break;
            }
        }
        // If loop exited and not found
        if (!found) {
            pw.println(secondSet.get(n - 2));
        }
        pw.close();
        in.close();

    }

}
