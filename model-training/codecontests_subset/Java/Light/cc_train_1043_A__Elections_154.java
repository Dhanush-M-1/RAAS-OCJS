import java.util.*;

public class solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int []a=new int[t];
        int sum=0;
        
        for(int i=0;i<t;i++){
            a[i]=sc.nextInt();
            sum=sum+a[i];
        }
        int max=a[0];
        
                for(int i=0;i<t;i++){
            if(max<a[i]){
                max=a[i];
            }
        }
        
        
        int r=((int)Math.ceil(2*sum/t))+1;
        
        if(r<max){
            r=max;
        }
        
        System.out.println(r);
    }
    
}