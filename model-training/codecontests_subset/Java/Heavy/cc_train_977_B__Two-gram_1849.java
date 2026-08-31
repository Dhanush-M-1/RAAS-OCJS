
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class ProlemSolving {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        int n = input.nextInt();
        String k = input.next();

        char[] arr = k.toCharArray();
        String resKey = "" ;
        int MaxValue = 0 ;
        for (int i = 0; i < n - 1; i++) {
            String key = String.valueOf(arr[i]) + String.valueOf(arr[i+1]);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                int temp = map.get(key);
                temp++;
                map.put(key, temp);
            }
            
            if(MaxValue < map.get(key)) {
                MaxValue = map.get(key);
                resKey = key ;
            }
            
        }

        System.out.println(resKey);
        input.close();
    }

}
