import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        for(int i = 0;i < 5;i++)
            sum += scan.nextInt();
        if(sum%5 != 0 || sum == 0)
            System.out.println(-1);
        else
            System.out.println(sum/5);
    }
}