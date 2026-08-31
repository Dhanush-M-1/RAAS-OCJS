import java.util.Scanner;
public class Main
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String[] names = new String[2];
        names[0] = in.next();
        names[1] = in.next();
        System.out.printf("%s %s\n",names[0],names[1]);
        int days = in.nextInt();
        String temp;
        for (int i = 0; i < days; i++)
        {
           temp = in.next();
            for (int j = 0; j < names.length; j++)
            {
                if (names[j].equalsIgnoreCase(temp))
                {
                    names[j] = in.next();
                }
            }
            
            System.out.printf("%s %s\n",names[0],names[1]);
        }

    }
}