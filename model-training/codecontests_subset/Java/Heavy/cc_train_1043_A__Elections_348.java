import java.util.*;
public final class solution2
{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int s=0,max=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            s+=a[i];
            if(a[i]>max) max=a[i];
        }
        int sum=0,k=max;
        while(true){
            for(int i=0;i<n;i++){
                sum+=(k-a[i]);
            }
            if(sum>s){
                System.out.print(k);
                break;
            }
            else {
            	k++;
            	sum=0;
            }
        }
    }
}