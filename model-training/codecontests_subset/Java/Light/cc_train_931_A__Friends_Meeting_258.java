import java.util.Scanner;

public class java {
    public static void main(String[] arg) {

        int avg,mini,maxi;
        int c=0;
        Scanner in;
        in = new Scanner(System.in);
        int a =in.nextInt();
        int b=in.nextInt();
        if(a>b)
        {
            int temp;
            temp=a;
            a=b;
            b=temp;
        }
        avg=(a+b)/2;
        mini=avg-a;
        maxi=b-avg;
        for (int i=1;i<=mini;i++)
        {

            c+=i;
        }
        for(int j=1;j<=maxi;j++)
        {
            c+=j;
        }
        System.out.println(c);
    }
}
