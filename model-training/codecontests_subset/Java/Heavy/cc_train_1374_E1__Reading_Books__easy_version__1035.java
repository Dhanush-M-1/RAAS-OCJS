import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        ArrayList<Integer> inter=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        
        while(n-->0)
        {
            int t=sc.nextInt();
            int p=sc.nextInt(),q=sc.nextInt();
            
            if((p&q)==1)
                inter.add(t);
            else
            {
                if(p==1)
                    a.add(t);
                else if(q==1)
                    b.add(t);
            }
        }
        Collections.sort(a);
        Collections.sort(b);
        for(int i=0;i<Math.min(a.size(),b.size());i++)
        {
            inter.add(a.get(i)+b.get(i));
        }
        Collections.sort(inter);
        if(inter.size()<k)
            System.out.println(-1);
        else
        {
            int ans=0;
            for(int i=0;i<k;i++)
            {
                ans+=inter.get(i);
            }
            System.out.println(ans);
        }
       // System.out.println("XXXXXXXX");
    }
}
