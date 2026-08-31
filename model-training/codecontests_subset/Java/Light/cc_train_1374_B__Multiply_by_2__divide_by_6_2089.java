import java.util.Scanner;

public class Code
{
    static public long gcd(long j,long k)
    {
        if(j%k==0)
        {
            return k;
        }
        return gcd(k,j%k);
    }
    static boolean isPowerOfTwo(int n) 
    { 
        if(n==0) 
            return false; 
        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==  (int)(Math.floor(((Math.log(n) / Math.log(2))))); 
    } 
    public static int divisors(int n)
    {
        int cnt=0;
        for (int i = 3; i <= Math.sqrt(n); i = i + 2)
        {
            while (n % i == 0)
            {
                cnt++;
                n = n/i;
                if(cnt==2) break;
            }
        if(cnt==2) 
            break;
        }
        if(n>2)cnt++;
        return cnt; 
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long cnt = 0;
            while(n>1)
            {if(n%6==0){n/=6;cnt++;}
             else if(n%3==0&&n%2!=0){n*=2;cnt++;}
             else{cnt = -1;break;}}
            System.out.println(cnt);
        }
    }
}