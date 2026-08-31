import java.util.Scanner;

public class Friend_metting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a,a1,b1,b,n,sum1,sum2;
        while (input.hasNext()){
            a=input.nextInt();b=input.nextInt();
            n=a+b;
            if(n%2==0){
                n/=2;
                if(a>=n){
                    a1=a-n;
                    sum1=((a1+1)*a1)/2;
                }
                else
                {
                    a1=n-a;
                    sum1=((a1+1)*a1)/2;
                }
                if(b>=n){
                    b1=b-n;
                    sum2=((b1+1)*b1)/2;
                }
                else {
                    b1=n-b;
                    sum2=((b1+1)*b1)/2;
                }
                System.out.println(sum1+sum2);
            }
            else {
                n/=2;
                n++;
                if(a>=n){
                    a1=a-n;
                    sum1=((a1+1)*a1)/2;
                }
                else {
                    a1=n-a;
                    sum1=((a1+1)*a1)/2;
                }
                if(b>=n){
                    b1=b-n;
                    sum2=((b1+1)*b1)/2;
                }
                else {
                    b1=n-b;
                    sum2=((b1+1)*b1)/2;
                }
                System.out.println(sum1+sum2);
            }
        }
    }
}
