import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problems {

    public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int numberOfButtons = sc.nextInt();
   int numberOfBulbs = sc.nextInt();
   sc.nextLine();
   boolean valid = true;
   Map<Integer,Integer> map = new HashMap<Integer, Integer>();
   
   for(int i=1;i<=numberOfBulbs;i++){
       map.put(i, 0);
   }
   
   for(int i=0;i<numberOfButtons;i++){
       String[] bulbs = sc.nextLine().split(" ");
       for(int j=1;j<bulbs.length;j++){
           int value = map.get(Integer.parseInt(bulbs[j]));
           value++;
           map.put(Integer.parseInt(bulbs[j]), value);
       }
   }
   
   for(Map.Entry<Integer,Integer> entry : map.entrySet()){
       if(entry.getValue() == 0)
           valid =false;
   }
   if(valid)
       System.out.println("YES");
   else
       System.out.println("NO");
   
                           
        
}
   
}