import java.util.*;
public class A{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //int a[]=new int[n];
        int max=0,sum=0;
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            sum=sum+a;
            if(max<a)
                max=a;
        }
        while((max*n)-sum<=sum){
            max++;
        }
        System.out.println(max);
    }
}