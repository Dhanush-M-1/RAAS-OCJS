import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class contest {


        public static void main (String[] args)  {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        reader.nextLine();
        String input = reader.nextLine();
        Map<String, Integer> map = new HashMap<>();
        CompareByVal comarator = new CompareByVal(map);
        TreeMap<String, Integer> sorted = new TreeMap<>(comarator);

        for (int i = 0; i < input.length() - 1; i++) {

            char first = input.charAt(i);
            char second = input.charAt(i + 1);
            String sub = first+""+second;

            if (map.containsKey(sub)) {
                int val = map.get(sub);
                map.put(sub, val+1);
            } else {
                map.putIfAbsent(sub, 1);
            }
        }
        sorted.putAll(map);
        System.out.println(sorted.firstKey());
    }

}

class CompareByVal implements Comparator<String> {
    Map<String, Integer> base;

    public CompareByVal(Map<String, Integer> base) {
        this.base = base;
    }
    public int compare(String a, String b) {
        if (base.get(a) > base.get(b)) {
            return -1;
        }
        if (base.get(a) < base.get(b))
            return 1;
        return 0;
    }
}


class ContestReader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    ContestReader(InputStream inpt) {
        init(inpt);
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        Collection<Integer> q = new ArrayList<>();
        return Integer.parseInt(next());
    }
}
