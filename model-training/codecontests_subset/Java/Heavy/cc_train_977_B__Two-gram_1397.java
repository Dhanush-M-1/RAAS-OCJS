import java.util.Scanner;

public class ProbB
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int length = input.nextInt();

        String s = input.next();

        String mostCommon = "";

        int mostTimes = 0;

        for(int i = 0; i < length; i++)
        {
           if(i+2 <= length)
           {
               String gram = s.substring(i, i + 2);

               int gCount = 0;

               for(int j = 0; j < length; j++)
               {
                   //check in bounds and cound
                   if(j+2 <= length && s.substring(j, j+2).equals(gram))
                   {
                       gCount++;
                   }
               }

               if(gCount > mostTimes)
               {
                   mostCommon = gram;
                   mostTimes = gCount;
               }
           }
        }

        System.out.println(mostCommon);
    }
}
