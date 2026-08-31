import java.util.*;
import java.lang.*;
public class solution {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt(),c=scan.nextInt(),arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int largest=arr[0]-c-arr[1];
        for(int i=2;i<n;i++){
            if((arr[i-1]-c-arr[i])>largest)largest=(arr[i-1]-c-arr[i]);
        }
        if(largest>0)System.out.println(largest);
        else System.out.println(0);
    }    
}