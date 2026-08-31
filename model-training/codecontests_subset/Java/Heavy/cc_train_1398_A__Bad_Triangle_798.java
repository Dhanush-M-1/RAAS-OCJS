// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
            int t=s.nextInt();
            int[] arr= new int[t];
            for(int j=0;j<t;j++)
            {
                arr[j]=s.nextInt();
            }
            
            int a = arr[0];
            int b = arr[1];
            int c = arr[t-1];
            
            int x=a+b;
            int y= b+c;
            int z=c+a;
            if(x<=c || y<=a || z<=b)
            {
                System.out.println(1+" "+2+" "+(t));
                continue;
            }
            
            int a1 = arr[0];
            int b1 = arr[t-2];
            int c1 = arr[t-1];
            
            int x1=a1+b1;
            int y1= b1+c1;
            int z1=c1+a1;
            if(x1<=c1 || y1<=a1 || z1<=b1)
            {
                System.out.println(1+" "+(t-2)+" "+(t-1));
                continue;
            }
            
            System.out.println("-1");
                
        }
    }
}