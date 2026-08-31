import java.io.FileNotFoundException;
import java.util.*;
public class A {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k=in.nextInt();
    int res = 0;
    List<Integer> e = new ArrayList<>();
    for(int i=0;i<n;i++)
    {
        e.add(in.nextInt());
    }
    Iterator<Integer> i = e.iterator();
    int max =0;
    while(i.hasNext())
    {
        int div = i.next();
        if(div>max && k%div==0)
            max = div;
    }
   while(k!=0)
   {
       res++;
       k=k-max;
   }
    System.out.println(res);
    }
}
