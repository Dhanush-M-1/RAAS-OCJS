import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main{
    public static void main(String[] args)throws Exception {
        File _=new File("win.in");
        BufferedReader br = _.exists() ? new BufferedReader( new FileReader(_)) : new BufferedReader( new InputStreamReader(System.in));
        long n=Long.parseLong(br.readLine().trim());
        long initn=n;
        ArrayList<Long> primes=new ArrayList<Long>();
        if(n==1l)
        {
            System.out.println("1");
            System.out.println("0");
            
        }
        
        
        else
        {
            while(n%2l==0)
            {
                primes.add(2l);
                n=n/2l;
            }
            long p=3;
            while(p<=Math.sqrt(n))
            {
                if(n%p==0l){
                    primes.add(p);
                    n=n/p;
                    
                }
                else
                    p=p+2l;
            }
            if(n!=1)primes.add(n);
    
            if(primes.size()>2)
            {
                System.out.println("1");
                System.out.println(primes.get(0)*primes.get(1));
            }
            else if (primes.size()==1)
            {
                System.out.println("1");
                System.out.println("0");
            }
                
            else
                System.out.println("2");
        }
        
        
        
    }
}
