import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SolutionB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        HashMap<String, Integer> m = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            String c =  Character.toString(s.charAt(i)) + s.charAt(i + 1);

            int v = m.containsKey(c)? m.get(c) + 1 : 1;
            m.put(c, v);
        }

        String maxS = null;
        int maxV = 0;
        for (String k: m.keySet()) {
            if (m.get(k) > maxV) {
                maxS = k;
                maxV = m.get(k);
            }
        }

        System.out.println(maxS);
    }
}

