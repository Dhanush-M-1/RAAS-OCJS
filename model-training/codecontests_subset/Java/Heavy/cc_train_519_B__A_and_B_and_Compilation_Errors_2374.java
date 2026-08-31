import java.util.Scanner;

/**
 * Created by mkosten on 1/15/2016.
 */
public class driver {
    public static void main (String[] args)
    {
        Scanner s= new Scanner(System.in);
        String initNum=s.nextLine();
        String initErrs=s.nextLine();
        String[] indErrors=initErrs.split(" ");
        int sum1=0;
        for(int i=0; i<indErrors.length; i++)
        {
            sum1=Integer.parseInt(indErrors[i])+sum1;
        }
        String secErrs=s.nextLine();
        indErrors=secErrs.split(" ");
        int sum2=0;
        for(int v=0; v<indErrors.length; v++)
        {
            sum2=Integer.parseInt(indErrors[v])+sum2;
        }
        String threeErrs=s.nextLine();
        indErrors=threeErrs.split(" ");
        int sum3=0;
        for(int z=0; z<indErrors.length;z++)
        {
            sum3=Integer.parseInt(indErrors[z])+sum3;
        }
        System.out.println(sum1-sum2);
        System.out.println(sum2-sum3);
    }
}
