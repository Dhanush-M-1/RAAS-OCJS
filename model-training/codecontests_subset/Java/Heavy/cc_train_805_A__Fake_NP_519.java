import java.util.Arrays;
import java.util.Scanner;

public class A805 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        if (a==b)
        {
            System.out.println(a);
        }else {
        if (Math.abs(a-b)>9)
        {
            System.out.println("2");
        }else {
            int k=(int) Math.abs(a-b);
            long[] array=new long[k+1];
            int length=0;
            for (long i=a;i<=b;i++)
            {
                array[length]=i;
                length++;


            }
            int[] array2=new int[10];
            int length2=0;
            int value=0;
            for (int i=2;i<=10;i++)
            {
                int count=0;
                for (int j=0;j<array.length;j++)
                {
                    if (array[j]%i==0)
                    {
                        count++;
                    }
                }

             if(count>length2)
             {
                 length2=count;
                 value=i;
             }
            }
            System.out.println(value);

        }
    }}
}
