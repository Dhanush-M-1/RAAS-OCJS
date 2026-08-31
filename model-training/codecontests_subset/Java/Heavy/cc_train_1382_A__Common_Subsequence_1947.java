import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
           int n = s.nextInt();
           int m = s.nextInt();
           boolean found = false;
           int l =0;
           int element = 0;
           
          Set<Integer> map = new HashSet<Integer>();
           
           for(int i=0 ; i<n; i++){
               int k = s.nextInt();
               map.add(k);
           }
           
           for(int i=0 ; i<m; i++){
               int k = s.nextInt();
               if(map.contains(k)){
                   l=1;
                   found = true;
                   element = k;
               }
           }
           if(found){
               System.out.println("YES");
           
           System.out.println(l+" "+element);
           }else
           System.out.println("NO");
        }
    }
}