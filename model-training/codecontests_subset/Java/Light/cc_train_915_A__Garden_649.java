import java.util.*;
public class TestClass {
    
    public static void main(String args[] ) throws Exception {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=s.nextInt();
        Arrays.sort(a);
            for(int i=n-1;i>=0;i--)
            {
                if(k%a[i]==0)
                {
                    System.out.println(k/a[i]);
                    break;
                }
            }
    }
}