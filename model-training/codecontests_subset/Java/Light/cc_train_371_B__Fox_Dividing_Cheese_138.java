import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        long n=scn.nextLong();
        long m=scn.nextLong();

        int opr=0;
        int a1=reduce(n, 2);
        int b1=reduce(n, 3);
        int c1=reduce(n, 5);

        n=n/((int)Math.pow(2, a1)*(int)Math.pow(3, b1)*(int)Math.pow(5,c1));

        int a2=reduce(m, 2);
        int b2=reduce(m, 3);
        int c2=reduce(m, 5);

        m=m/((int)Math.pow(2, a2)*(int)Math.pow(3, b2)*(int)Math.pow(5,c2));
        
        opr=Math.abs(a1-a2)+Math.abs(b1-b2)+Math.abs(c1-c2);

        if(m!=n){
            System.out.println(-1);
        }else{
            System.out.println(opr);
        }
        
        scn.close();
    }
    public static int reduce(long n,int div){
        int ans=0;
        while(n%div==0){
            ans++;
            n=n/div;
        }
        return ans;
    }

}
