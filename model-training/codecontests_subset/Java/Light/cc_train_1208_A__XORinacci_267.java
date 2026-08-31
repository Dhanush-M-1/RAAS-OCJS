import java.util.Scanner;

 public class jjs {
    public static void main(String args[])
    {
        Scanner sc=new Scanner((System.in));
        int T=sc.nextInt();
        int arr[]=new int[T];
        for(int i=0;i<T;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int n=sc.nextInt();
            if(n%3==0)
                arr[i]=a;
            else if(n%3==1)
                arr[i]=b;
            else
                
                arr[i]=a^b;
            
        }
        for(int i=0;i<T;i++)
            System.out.println(arr[i]);
    }

}
