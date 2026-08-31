import java.util.Scanner;

/**
 *
 * @author CHAGO
 */
public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a=sc.next();
        int s=0;
        int i=0;
        while (n>=11) {
            int b=a.indexOf("8", i);
            if (b!=-1) {
                s++;
                i=b+1;
                n-=11;
            }else{
                n=0;
            }
        }
        System.out.println(s);
    }
}
