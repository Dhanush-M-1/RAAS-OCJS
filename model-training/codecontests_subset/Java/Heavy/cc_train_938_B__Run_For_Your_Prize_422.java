
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Problem2 {

    public static double[] parseLineDoubles( String line) {
        String[] parts = line.split(" ");

        double[] res = new double[parts.length];

        for (int i = 0; i < res.length; i++) {

            res[i] = Double.valueOf(parts[i].trim());
        }

        return res;
    }

    public static int[] parseLineInts( String line) {
        String[] parts = line.split(" ");

        int[] res = new int[parts.length];

        for (int i = 0; i < res.length; i++) {

            res[i] = Integer.valueOf(parts[i].trim());
        }

        return res;
    }

    public static long[] parseLineLongs( String line) {
        String[] parts = line.split(" ");

        long[] res = new long[parts.length];

        for (int i = 0; i < res.length; i++) {

            res[i] = Long.valueOf(parts[i].trim());
        }

        return res;
    }

    public static String[] parseLineStrings( String line) {
        String[] parts = line.split(" ");

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        return parts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();



        int n = parseLineInts(line)[0];

        line = scanner.nextLine();

        int[] mas = parseLineInts(line);

        int middle = 500000;

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(Integer i : mas) {
            treeSet.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>(treeSet);
        list.sort(null);

        ///

        if (treeSet.contains(middle)) {
            System.out.println(middle - 1);
            return;
        }

        Integer higher = treeSet.higher(middle);
        int indHi = -1;

        if (higher != null)
            indHi = higher;

        Integer lower = treeSet.lower(middle);

        int indLo = -1;
        if (lower != null)
            indLo = lower;

//        System.out.println(higher);
//        System.out.println(indHi);
//
//        System.out.println(lower);
//        System.out.println(indLo);

        int a = -1;
        int b = -1;

        if (indHi == -1) {
            a = indLo - 1;
            b = -1;
        }
        else if (indLo == -1) {
            a = -1;
            b = 1000000 - indHi;
        }
        else {

            a = indLo - 1;
            b = 1000000 - indHi;
        }

//        System.out.println(a);
//        System.out.println(b);

        System.out.println(Math.max(a, b));



    }


}
