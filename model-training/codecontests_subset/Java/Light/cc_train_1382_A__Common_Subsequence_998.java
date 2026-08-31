
import java.util.*;

public class CommonSubsequence {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int i=0;i<testcase;i++){
            int count=0;
            
            int n=sc.nextInt();
            int element=0;
            int m=sc.nextInt();
            int[] a1=new int[n];
            int[] b1=new int[m];
            for(int j=0;j<a1.length;j++){
                a1[j]=sc.nextInt();
            }
            for(int j=0;j<b1.length;j++){
                b1[j]=sc.nextInt();
            }
            Arrays.sort(a1);
             Arrays.sort(b1);
             for(int j=0;j<a1.length;j++){
                 for(int k=0;k<b1.length;k++){
                     if(a1[j]==b1[k]){
                         count++;
                         element=a1[j];
                         break;
                     }
                 }
             }
             if(count>0){
                 System.out.println("YES");
                 System.out.println(1+" "+element);
             }else{
                  System.out.println("NO");
             }
        }
    }
    
}
