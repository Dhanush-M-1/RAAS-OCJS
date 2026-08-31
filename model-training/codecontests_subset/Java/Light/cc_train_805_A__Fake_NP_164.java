import java.util.Scanner;

/**
 * Created by jai on 26/6/17.
 */
public class p805a {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int r=sc.nextInt();
        if(l-r==3&&l%3==0)
            System.out.println(3);
        else if(l==r)
            System.out.println(r);
        else
            System.out.println(2);

    }
}
