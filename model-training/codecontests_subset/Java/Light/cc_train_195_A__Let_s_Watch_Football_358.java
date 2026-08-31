import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt(),b=in.nextInt(),c=in.nextInt();
        int t1=a*c,t2=b*c;
        double ans=(t1-t2)/(double)b;
        System.out.println((int)Math.ceil(ans));
    }

}
