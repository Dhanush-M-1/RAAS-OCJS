import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if (a==b){
            System.out.println(0);
            return;
        }
        else{
            int ans=0;
            int ca2=0,cb2=0;
            while (a%2==0){
                a/=2;
                ca2++;
            }
            while (b%2==0){
                b/=2;
                cb2++;
            }
           
            int ca3=0,cb3=0;
            while (a%3==0){
                a/=3;
                ca3++;
            }
            while (b%3==0){
                b/=3;
                cb3++;
            }
            int ca5=0,cb5=0;
            while (a%5==0){
                a/=5;
                ca5++;
            }
            while (b%5==0){
                b/=5;
                cb5++;
            }

            ans+=Math.abs(ca5-cb5);
            ans+=Math.abs(ca3-cb3);
            ans+=Math.abs(ca2-cb2);
            if (a==b){
                System.out.println(ans);
            }
            else{
                System.out.println(-1);
            }


        }



    }
}
