import java.util.Scanner;

public class LCMChallenge {
    public static void main(String[] args) {
        Scanner l1=new Scanner(System.in);
         long l2=l1.nextLong();
     LCM s1=new LCM();
     s1.LeastCommanMultiple(l2);
    }
}
class LCM{
    public void LeastCommanMultiple(long a){
         if(a>=1&&a<=2) {
             System.out.println(a);
         }
         else if(a>=3) {
             if (a%2 == 0&&a%3==0) {

                     System.out.println((a -1)* (a - 2) * (a - 3));
             }
             else if(a%2==0&&a%3!=0){
                 System.out.println(a*(a-1)*(a-3));

             }
             else if(a%2==0) {
                 System.out.println(a * (a - 1) * ((a - 2) / 2));

             }
             else
             System.out.println(a * (a - 1) * (a - 2));


    }}}