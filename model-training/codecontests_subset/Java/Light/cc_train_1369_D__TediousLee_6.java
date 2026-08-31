import java.util.Scanner;
import java.lang.Math;
public class Helloworld {

    public static int shrink = 1000000007;
    public static int indexlimit=2000000;
    public static int[] aman= new int[indexlimit];

    public static void main(String[] args) {
        int t,n;
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();

        aman[0]=0;
        aman[1]=0;
        aman[2]=4;
        aman[3]=4;
        aman[4]=12;
        aman[5]=24;



        for(int i=6;i<indexlimit;i++){
            aman[i]=aman[i-1]%shrink;
            aman[i]+=(2*aman[i-2])%shrink;
            aman[i]%=shrink;
            if((i+1)%3==0){
                aman[i]+=4;
            }
        }
        for(int i=0;i<t;i++){
            n=sc.nextInt();
            System.out.println(fun(n));

        }

    }
    public static int fun(int n){
        //if(n<=indexlimit){
            return aman[n-1];
        /*}
        else {
            int x = (fun(n - 1) % shrink) + (2 * ((fun(n - 2)) % shrink));
            return x;
        }
        */

    }
}