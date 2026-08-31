import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author msagimbekov
 */
public class Codeforces519B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> map3 = new HashMap<>();
        int[] s1 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] s3 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int res1 = 0;
        int res2 = 0;
        
        for (int i = 0; i < s1.length; i++) {
            map1.put(s1[i], map1.getOrDefault(s1[i], 0) + 1);
        }
        
        for (int i = 0; i < s2.length; i++) {
            map2.put(s2[i], map2.getOrDefault(s2[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !map2.get(entry.getKey()).equals(entry.getValue())) {
                res1 = entry.getKey();
                break;
            }
        }
        
        for (int i = 0; i < s3.length; i++) {
            map3.put(s3[i], map3.getOrDefault(s3[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (!map3.containsKey(entry.getKey()) || !map3.get(entry.getKey()).equals(entry.getValue())) {
                res2 = entry.getKey();
                break;
            }
        }
        
        System.out.println(res1);
        System.out.println(res2);
        
        
        
        
        
        
    }

}

