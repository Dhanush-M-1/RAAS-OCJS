import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class c107 {
    public static void debug(Object... obs) {
        System.out.println(Arrays.deepToString(obs));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        
        
        long l=sc.nextLong();
        int up=(int)Math.sqrt(l);
        
        boolean[]prim=new boolean[up+1];
        
        prim[0]=true;
        prim[1]=true;
        
        for(int i=2;i*i<=up;i++)
        {
            if(prim[i])
            {
                continue;
            }
            for(int j=2*i;j<=up;j+=i)
            {
                prim[j]=true;
            }
        }
        //debug(prim);
        long res=1;
        long z=l;
        while(z > 1)
        {
            boolean found=false;
            for(long i=2;i*i<=z;i++)
            {
                if(z%i==0 && !prim[(int)i])
                {
                    //debug(z,i,res);
                    if(res==1)
                        res*=i;
                    else
                    {
                        res*=i;
                        System.out.println(1);
                        System.out.println(res);
                        return;
                    }
                    z/=i;
                    found=true;
                    break;
                }
            }
            
            if(!found && z>1 && isPrime(z))
            {
                break;
            }
        }
        if(res==1)
        {
            System.out.println(1);
            System.out.println(0);
            return;
        }
        
        System.out.println(2);
    }

    private static boolean isPrime(long z) {
        for(long i=2;i*i<=z;i++)
        {
            if(z%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
