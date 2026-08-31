import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x= in.nextInt();
        int y= in.nextInt();
        char[] bits = new char[n];
        bits = in.next().toCharArray();
        int min=0;
        if(bits[n-1-y]=='0') {
            min++;
        }
        for(int i=0;i<x;i++)
        {
            if ((bits[n-1-i]=='1')&&(i!=y))
                min++;
        }
        System.out.println(min);
    }
}
