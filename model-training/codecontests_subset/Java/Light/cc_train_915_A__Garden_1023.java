
import java.util.*;

public class Garden {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int[] ar=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(k%ar[i]==0){
                if(ar[i]>=max){
                    max=ar[i];
                }
            }
        }
        System.out.println(k/max);
    }
}
