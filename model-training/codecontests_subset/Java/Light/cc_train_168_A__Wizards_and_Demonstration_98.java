import java.util.Scanner;
public class WizardsAndDemonstration
{
    public static void main(String[] args)
    {
        Scanner z=new Scanner(System.in);
        int n=z.nextInt();
        int x=z.nextInt();
        int y=z.nextInt();
        int pcent = (int)Math.ceil(((double)y*(double)n)/100);
        if(x<pcent)
            System.out.println(pcent-x);
        else
            System.out.println(0);
    }
}