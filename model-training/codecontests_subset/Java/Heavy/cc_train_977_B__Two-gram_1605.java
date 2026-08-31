// "static void main" must be defined in a public class.
import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      String s = sc.next(); 
      String cmp =""; 
      int max = Integer.MIN_VALUE; 
      String ans = "";
      HashMap<String,Integer> map = new HashMap<>(); 
      for(int i=0;i<s.length()-1 ; i++ ) {
        String new_val = "" + s.charAt(i) + s.charAt(i+1); 
        if(map.containsKey(new_val)){
          map.put(new_val,map.get(new_val)+1);
        }
        else {
          map.put(new_val,1);
        }
        if(map.get(new_val ) > max){
          max = map.get(new_val);
          ans = new_val;
        }
      }
      System.out.println(ans);
      
    }
}