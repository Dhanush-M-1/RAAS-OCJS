import java.util.*;
public class work {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int c1 = scan.nextInt();
        int c2 = scan.nextInt();
        int c3 = scan.nextInt();
        int c4 = scan.nextInt();
        int c5 = scan.nextInt();
        int sum = c1+c2+c3+c4+c5;
        if (sum%5==0 & sum/5!=0){
            System.out.println(sum/5);
        }
        else{
            System.out.println("-1");
        }
}
}