import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine().trim());

        char[] words = br.readLine().trim().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() % k != 0){
                System.out.println(-1);
                return;
            }

            int iteration = entry.getValue() / k;
            for(int i = 0; i < iteration; i++, count++){
                sb.append(entry.getKey());
            }

        }

        String resultWord = sb.toString();

        //String finalResult = resultWord;

        StringBuilder finalResult = new StringBuilder();
        finalResult.append(resultWord);

        for(int i = 2; i <= k; i++){
            finalResult.append(resultWord);
        }

        System.out.println(finalResult);

    }
}