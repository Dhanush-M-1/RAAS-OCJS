import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A868 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int a = sc.nextInt();
        String[] array = new String[a];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.next();
            if (array[i].equals(input)) {
                count++;
            }
        }
        //
        if (count > 0) {
            System.out.println("YES");

        } else {
            int count2=0;
            Pattern p= Pattern.compile(input);
            for (int i=0;i< array.length;i++)
            {
                for (int j=0;j< array.length;j++)
                {
                    if (i!=j)
                    {
                        if (array[i].charAt(1)==input.charAt(0) && array[j].charAt(0)==input.charAt(1))
                        {
                            count2++;
                        }
                    }
                }
            }
            //
            for (int i=0;i< array.length;i++)
            {
                for (int j=0;j< array.length;j++)
                {
                    if (i!=j)
                    {
                        if (array[j].charAt(1)==input.charAt(0) && array[i].charAt(0)==input.charAt(1))
                        {
                            count2++;
                        }
                    }
                }
            }


            if (count2>0)
            {
                System.out.println("YES");
            }else {
                int count3=0;
                for (int i=0;i< array.length;i++)
                {
                if (array[i].charAt(0)==input.charAt(1) && array[i].charAt(1)==input.charAt(0))
                {
                    count3++;
                }
                }
                if (count3>0)
                {
                    System.out.println("YES");
                }else {

                    System.out.println("NO");
                }
            }

        }
    }
}
