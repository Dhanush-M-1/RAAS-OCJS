import java.util.Scanner;
public class myfirst {
    public static int reduct = 1000000007;
    public static int indexlimit=2000000;
    public static int[] aman= new int[indexlimit];
    public static void main(final String[] args) {
        int t, n;
        final Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        aman[0]=0;
        aman[1]=0;
        aman[2]=4;
        aman[3]=4;
        aman[4]=12;
        aman[5]=24;
        for(int i=6;i<indexlimit;i++){
            aman[i]=aman[i-1]%reduct;
            aman[i]+=(2*aman[i-2])%reduct;
            aman[i]%=reduct;
            if((i+1)%3==0){
                aman[i]+=4;
            }
        }
        for(int i=0;i<t;i++){
            n=sc.nextInt();
            System.out.println(aman[n-1]);
        }
    }
}