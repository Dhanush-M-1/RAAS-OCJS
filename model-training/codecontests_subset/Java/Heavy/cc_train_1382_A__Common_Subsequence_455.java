import java.util.*;
import java.math.*;
public class temp{
    //use main for taking inputs only
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashSet<Integer> set = new HashSet(); 

            for(int i = 0; i < n; ++i)
            set.add(sc.nextInt());
            
            boolean found = false;
            for(int i = 0; i < m; ++i){
                int num = sc.nextInt();
                // System.out.print("num : " + num + " ");
                if(set.contains(num) && !found){
                    System.out.println("YES");
                    System.out.println("1 " + num); 
                    found = true;
                }
            }
            if(!found)
            System.out.println("NO");
        }
    }
}