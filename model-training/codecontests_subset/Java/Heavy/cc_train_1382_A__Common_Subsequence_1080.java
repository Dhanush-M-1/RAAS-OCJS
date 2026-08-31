import java.util.*;
import java.io.*;
public class MyClass extends PrintWriter {
    MyClass()
    {
        super(System.out);
    }
    public static void main(String args[]) {
      MyClass o=new MyClass();
      o.main();
      o.flush();
      o.close();
    }
    void main()
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int i;
            int arr[]=new int[n];
            int b[]=new int[m];
            for(i=0;i<n;i++)
            arr[i]=sc.nextInt();
            for(i=0;i<m;i++)
            b[i]=sc.nextInt();
            int j;
            int flag=0;
            if(n<m)
            {
                Arrays.sort(b);
                for(i=0;i<n;i++)
                {
                    if(Arrays.binarySearch(b,arr[i])>=0)
                    {
                        flag=1;
                        println("YES");
                        println(1+" "+arr[i]);
                        break;
                    }
                }
            }
            else
            {
                Arrays.sort(arr);
                for(i=0;i<m;i++)
                {
                    if(Arrays.binarySearch(arr,b[i])>=0)
                    {
                        flag=1;
                        println("YES");
                        println(1+" "+b[i]);
                        break;
                    }
                }
            }
            if(flag==0)
            println("NO");
            
        }
        sc.close();
    }
}