import java.util.*;
import java.io.*;
public class CODEFCHEF_EX{
   static String k(Map<String,Integer> m, int value){
       for(Map.Entry<String,Integer> entry : m.entrySet()){
           if(value == entry.getValue())
               return entry.getKey();
       }
       return null;
   } 
   public static void main(String args[]) throws IOException{
      Scanner sc = new Scanner(System.in);
      int len = sc.nextInt(),i=0,count=0;
      String str= sc.next(),sub;
      Map<String,Integer> map = new LinkedHashMap<>();
      sub = str.substring(i,i+2);
      map.put(sub,count++);
      for(i=1; i<len-1; i++){
          sub = str.substring(i,i+2);
          if(map.containsKey(sub))
              map.put(sub, map.get(sub)+1);
          else
              map.put(sub, 1);
      }
      int value = Collections.max(map.values());
      System.out.println(k(map,value));
   }
}
