import java.util.Scanner;
public class java
{
    static long m_xor(long i,long j,long n) {
        if(n==0) {
            return i;
        }
        else if(n==1) {
            return j;
        }
        else if(n==2) {
            return i^j;
        }
        return m_xor(i,j,n%3);
    }
    public static void main(String []args) {
        long a,b,c;
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(n!=0) {
            n--;
            a = sc.nextLong();
            b = sc.nextLong();
            c = sc.nextLong();
            System.out.println(m_xor(a,b,c));
        }
    }
}