
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoGram2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String line = reader.readLine();

        Map<String, Integer> mapDwaGramToCount = new HashMap<>();

        for (int i = 0; i < n-1; i++) {
            String dwaGramm = line.substring(i, i + 2);
            mapDwaGramToCount.merge(dwaGramm, 1, Integer::sum);

        }
        Comparator<Map.Entry<String,Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        String gramm = Collections.max(mapDwaGramToCount.entrySet(), comparator).getKey();
        System.out.println(gramm);
    }
}