import java.util.Arrays;
import java.util.Scanner;

public class Garden {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int time=0,watered=0,min=999;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--)
        {
            if(k%arr[i]==0)
            {
                //watered=arr[i];
                while(watered<k)
                {
                    watered+=arr[i];
                    time++;
                }
                break;
            }
        }
        System.out.println(time);
    }
}
