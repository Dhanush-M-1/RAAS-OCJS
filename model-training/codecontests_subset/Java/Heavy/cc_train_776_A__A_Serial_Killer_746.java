import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String a=read.next();
        String b=read.next();
        int n=read.nextInt();
        read.nextLine();
        String c="";
        String d="";
        System.out.println(a+" "+b);
        for (int i = 0; i < n ; i++) {
            c=read.next();
            d=read.next();
            if (c.equals(a)){
                System.out.println(d+" "+b);
                a=d;
            }else {
                System.out.println(a+" "+d);
                b=d;
            }
        }
        



    }
}
