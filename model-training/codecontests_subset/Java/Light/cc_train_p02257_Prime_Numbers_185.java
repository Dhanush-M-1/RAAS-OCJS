import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int Count=0;
        int count_num=scan.nextInt();

        for(int j=0;j<count_num;j++){
            if(Check(scan.nextInt()))
            {
                Count++;
            }
        }

        System.out.println(Count);
    }

    public static boolean Check(int a)
    {
        if(a==2 || a==3) return true;
        if(a<=3  || a%2==0) return false;
        for(int i=3;i<=Math.sqrt((double)a);i+=2)
        {
            if(a%i==0) return false;
        }
        return true;
    }
}