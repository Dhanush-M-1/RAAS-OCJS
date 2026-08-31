


import java.util.*;
public class CodeForce {
      
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer> set=new HashSet<Integer>();
        int button=sc.nextInt();
        int bulb=sc.nextInt();
        int[][]a=new int[button][];
        for(int i=0;i<button;i++){
            int bi=sc.nextInt();
            a[i]=new int[bi];
            for(int j=0;j<bi;j++){
                int a1=sc.nextInt();
                set.add(a1);
                
            }
        }
            if(set.size()==bulb)
                System.out.println("YES");
            else
                System.out.println("NO");

       
        
        
    }
        
}


