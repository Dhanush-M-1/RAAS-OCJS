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
            TreeSet<Integer> t1=new TreeSet<>();
            TreeSet<Integer> t2=new TreeSet<>();
            int i;
            for(i=0;i<n;i++)
            t1.add(sc.nextInt());
            for(i=0;i<m;i++)
            t2.add(sc.nextInt());
            int flag=0;
            if(n<m)
            {
                for(int a:t1)
                {
                    if(t2.contains(a))
                    {
                        println("YES");
                        println(1+" "+a);
                        flag=1;
                        break;
                    }
                }
            }
            else
            {
                for(int a:t2)
                {
                    if(t1.contains(a))
                    {
                        println("YES");
                        println(1+" "+a);
                        flag=1;
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