import java.lang.reflect.Array;
import java.util.*;

public class solution {
 public static void main(String[] args){
        Scanner scn=new Scanner(System.in);

        int tc=scn.nextInt();
        // long[] res=new long[tc];
        
        for(int i=0;i<tc;i++){
        int n=scn.nextInt();
        int m=scn.nextInt();
        ArrayList<Integer> list1=new ArrayList<>();
       
        for(int j=0;j<n;j++){
          list1.add(scn.nextInt());
        }
        ArrayList<Integer> list2=new ArrayList<>();

        for(int j=0;j<m;j++){
          list2.add(scn.nextInt());
        }
        boolean flag=false;
          for(int j=0;j<n;j++){
            if(list2.contains(list1.get(j))){
              System.out.println("YES");
              System.out.println(1+" "+list1.get(j));
              flag=true;
              break;
            }
          }
          if(flag==false){
          System.out.println("NO");        
          }
        }
    }
    
}