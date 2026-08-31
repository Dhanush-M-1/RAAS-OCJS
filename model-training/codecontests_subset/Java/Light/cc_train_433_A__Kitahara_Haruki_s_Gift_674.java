import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int a1=0,a2=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]==100)
            a1++;
            else
            a2++;
        }
        if((a1%2==0&&a2%2==0)||(a1%2==0&&a2%2!=0&&a1>=2))
        System.out.println("YES");
        else
        System.out.println("NO");
    }
}