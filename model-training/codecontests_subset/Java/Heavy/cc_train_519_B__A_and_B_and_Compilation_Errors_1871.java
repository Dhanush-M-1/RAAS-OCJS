import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class b519 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        int[] ar1=new int[n-1];
        int[] ar2=new int[n-2];
        
        for(int i=0;i<n;i++)
            ar[i]=sc.nextInt();
        for(int i=0;i<n-1;i++)
            ar1[i]=sc.nextInt();
        for(int i=0;i<n-2;i++)
            ar2[i]=sc.nextInt();
        Arrays.sort(ar);
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        int j=0;
        while(j<n-1)
        {
            if(ar[j]!=ar1[j])
                break;
            j++;
        }
        if(j<n-1)
            System.out.println(ar[j]);
        else
            System.out.println(ar[n-1]);
        j=0;
        while(j<n-2)
        {
            if(ar1[j]!=ar2[j])
                break;
            j++;
        }
        if(j<n-2)
            System.out.println(ar1[j]);
        else
            System.out.println(ar1[n-2]);
    }
    
}