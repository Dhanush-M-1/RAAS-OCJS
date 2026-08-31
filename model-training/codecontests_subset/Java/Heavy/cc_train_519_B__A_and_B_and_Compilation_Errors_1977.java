import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final boolean FROM_FILE = false;
    private static final boolean TO_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("C:/home/programming/input.txt"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        PrintWriter pw;
        if (TO_FILE) {
            pw = new PrintWriter("C:/home/programming/output.txt");
        } else {
            pw = new PrintWriter(System.out);
        }

        // Algorithm:
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> first = read(br);
        Map<Integer, Integer> second = read(br);
        Map<Integer, Integer> third = read(br);

        List<Integer> result = new ArrayList<>();
        result.add(getDiff(first, second));
        result.add(getDiff(second, third));

        for (int v : result) {
            pw.println(v);
        }

        pw.flush();
    }

    private static Map<Integer, Integer> read(BufferedReader br) throws IOException {
        Map<Integer, Integer> first = new HashMap<>();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            int v = Integer.parseInt(line[i]);
            int c = first.getOrDefault(v, 0);
            first.put(v, c + 1);
        }
        return first;
    }

    private static int getDiff(Map<Integer, Integer> first, Map<Integer, Integer> second) {
        for (Map.Entry<Integer, Integer> entry : first.entrySet()) {
            Integer secondValue = second.get(entry.getKey());
            if (secondValue == null) {
                return entry.getKey();
            } else if (entry.getValue() > secondValue) {
                return entry.getKey();
            }
        }
        throw new RuntimeException();
    }
}