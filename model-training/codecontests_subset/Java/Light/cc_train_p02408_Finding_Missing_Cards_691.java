import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> card = new HashMap<>();
        try {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                card.put(br.readLine(), 1);
            }
        } finally {
            br.close();
        }
        String[] suitArr = {"S", "H", "C", "D"};
        for (String suit : suitArr) {
            for (int i = 1; i <= 13; i++) {
                String temp = suit+" "+i;
                if (card.get(temp) == null) {
                    System.out.println(suit+" "+i);
                }
            }
        }
    }
}