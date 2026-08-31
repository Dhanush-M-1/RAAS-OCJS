import java.util.*;

public class Solve {
    public static void main(String[] args) {
        solveBro();
    }
    public static void solveBro() {
        Scanner scan=new Scanner(System.in);
        long t=scan.nextInt();
        while(t>0) {
            long a=scan.nextInt(),b=scan.nextInt(),c=scan.nextInt();
            long r=c/2,ans=0;
            if(r<=b) {
                ans+=((c/2)+((c/2)*2));
                b-=(c/2);
                c-=((c/2)*2);
            }
            else {
                ans+=(b+(b*2));
                b=0;
                c-=(b*2);
            }
            r=b/2;
            if(r<=a)
                ans+=((b/2)+((b/2)*2));
            else
                ans+=(a+(a*2));
            System.out.println(ans);
            t=t-1;
        }
    }
}