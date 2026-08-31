import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProblemA {

    public static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
//        sc = new Scanner(new File("input-a.txt"));
        new ProblemA().doTest();
    }

    private void doTest() {
        String line = sc.nextLine();
        Map.Entry<String, String> names = getNames(line);
        String name1 = names.getKey();
        String name2 = names.getValue();

        System.out.println(name1 + " " + name2);

        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            names = getNames(line);
            String died = names.getKey();
            String potential = names.getValue();

            if (died.equals(name1)) {
                name1 = potential;
            } else {
                name2 = potential;
            }


            System.out.println(name1 + " " + name2);
        }
    }

    private Map.Entry<String, String> getNames(String s) {
        StringTokenizer tok = new StringTokenizer(s, " ");
        String a = tok.nextToken();
        String b = tok.nextToken();
        return new AbstractMap.SimpleEntry<>(a, b);
    }
}
