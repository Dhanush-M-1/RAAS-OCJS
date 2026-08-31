
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class ProblemE {
public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> map3 = new HashMap<Integer,Integer>();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
            int num = scanner.nextInt();
            list.add(num);
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1); 
            } else map.put(num, 1);
            map2.put(num, 0);
            map3.put(num, 0);
        }
        
         
             
        
         
        
        for(int i = 0; i < n - 1; i++){
            int num = scanner.nextInt();
            if(map2.containsKey(num)){
                map2.put(num, map2.get(num) + 1); 
            } else map2.put(num, 1);
        }
        
        for(int i = 0; i < n - 2; i++){
            int num = scanner.nextInt();
            map3.put(num, map3.get(num) + 1);
        }
        
     
        
        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            
            int t = map.get(num) - map2.get(num) ;
            if(t > 0){
                System.out.println(num);
                break;
            }
        }
        
        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            
            int t = map2.get(num) - map3.get(num) ;
            if(t > 0){
                System.out.println(num);
                break;
            }
        }
        
    }
}
