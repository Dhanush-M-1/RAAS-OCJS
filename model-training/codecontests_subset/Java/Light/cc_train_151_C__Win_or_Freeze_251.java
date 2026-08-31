import java.util.*;

public class cf150a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long z = in.nextLong();
        long zz = z;
        ArrayList<Long> p = new ArrayList<Long>();
        for(long i=2; i*1L*i<=zz; i++) 
            while(z%i==0) {
                    z/=i;
                    p.add(i);
            }
        if(p.size()==0) 
            System.out.printf("%d%n%d",1,0);
        else if(p.size()==1)
            System.out.println(2);
        else {
            long ans = p.get(0)*1L*p.get(1);
            if(ans==zz) 
                System.out.println(2);
            else
                System.out.printf("%d%n%d", 1,ans);
        }
    }
}