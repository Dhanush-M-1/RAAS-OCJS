 import java.lang.*; 
  import java.util.*;
  public class MyClass {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n,k;
        
        n=sc.nextInt();
        k=sc.nextInt();
        int min=k;
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {a[i]=sc.nextInt();
        if(k%a[i]==0)
        {
            if(min>k/a[i])
            min=k/a[i];
        }
            
        }System.out.println(min);
    }
}
