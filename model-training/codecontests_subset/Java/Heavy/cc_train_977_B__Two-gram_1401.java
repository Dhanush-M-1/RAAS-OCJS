
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n - 1; i++){
            String sub = s.substring(i, i+2);
            if(map.containsKey(sub)){
                map.put(sub, map.get(sub) + 1);
            }else{
                map.put(sub, 1);
            }
        }

        Map.Entry<String, Integer> maxEntry = null;

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = entry;
            }
        }

        System.out.println(maxEntry.getKey());
    }
}
