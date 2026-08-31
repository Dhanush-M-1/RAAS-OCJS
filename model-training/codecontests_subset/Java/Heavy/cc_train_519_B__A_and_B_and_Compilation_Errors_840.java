import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B {

    static Scanner in = new Scanner(System.in);
    
    static PrintStream out = System.out;
    
    static HashMap<Integer, Integer> buildMap(int[] a){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < a.length; i++){
            if (!map.containsKey(a[i])){
                map.put(a[i], 0);
            }
            
            map.put(a[i], map.get(a[i]) + 1);
        }
        
        return map;
    }
    
    public static void main(String[] args) {
        int n = in.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
                
        HashMap<Integer, Integer> map = buildMap(a);
        
        for (int i = 0; i < n - 1; i++){
            int err = in.nextInt();
            
            map.put(err, map.get(err) - 1);
            
            if (map.get(err) == 0){
                map.remove(err);
            }
        }
        
        int fixedErr1 = map.keySet().iterator().next();
        
        map = buildMap(a);
        map.put(fixedErr1, map.get(fixedErr1) - 1);
        
        if (map.get(fixedErr1) == 0){
            map.remove(fixedErr1);
        }
        
        for (int i = 0; i < n - 2; i++){
            int err = in.nextInt();
            
            map.put(err, map.get(err) - 1);
            
            if (map.get(err) == 0){
                map.remove(err);
            }
        }
        
        int fixedErr2 = map.keySet().iterator().next();
        
        System.out.println(fixedErr1);
        System.out.println(fixedErr2);
    }
    
}
