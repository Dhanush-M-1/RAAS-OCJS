import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class CF {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);

        int nbErrs = in.nextInt();

        TreeMap<Integer, Integer> first = new TreeMap<>();
        TreeMap<Integer, Integer> second = new TreeMap<>();
        TreeMap<Integer, Integer> third = new TreeMap<>();

        for (int i = 0; i < nbErrs; i++) {
            int input = in.nextInt();
            if (first.containsKey(input)) {
                first.put(input, first.get(input) + 1);
            } else
                first.put(input, 1);
        }

        for (int i = 0; i < nbErrs - 1; i++) {
            int input = in.nextInt();

            if (second.containsKey(input))
                second.put(input, second.get(input) + 1);
            else
                second.put(input, 1);

            if (first.get(input) == 1)
                first.remove(input);
            else
                first.put(input, first.get(input) - 1);
        }

        for (Entry<Integer, Integer> entry : first.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }

        for (int i = 0; i < nbErrs - 2; i++) {

            int input = in.nextInt();

            if (second.get(input) == 1)
                second.remove(input);
            else
                second.put(input, second.get(input) - 1);

        }

        System.out.println(second.firstKey());

    }
}
