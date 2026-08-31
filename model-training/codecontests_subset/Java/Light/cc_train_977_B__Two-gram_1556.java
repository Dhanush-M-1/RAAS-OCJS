import java.util.*;

public class Main
{
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String str = sc.next();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n - 1; ++i){
            String sub = str.substring(i, i + 2);
            if(!map.containsKey(sub)){
                map.put(sub, 0);
            }
            map.put(sub, map.get(sub) + 1);
        }
        System.out.println(map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).map(pair -> pair.getKey()).findFirst().orElse(""));
   }
}
