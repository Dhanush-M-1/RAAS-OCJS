import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            int []arr1=new int[n1];
            int []arr2=new int[n2];
            HashSet<Integer>h=new HashSet<Integer>();
            for(int j=0;j<n1;j++){
                arr1[j]=sc.nextInt();
                h.add(arr1[j]);
            }
            for(int j=0;j<n2;j++){
                arr2[j]=sc.nextInt();
            }
            int d=-1;
            for(int k=0;k<n2;k++){
                if(h.contains(arr2[k])){
                    d=arr2[k];
                    break;
                }
            }
            if(d==-1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
                System.out.println(1+" "+d);
            }
            
        }
    }
}