import java.util.Scanner;

public class Main
{
    public static void main(String argz[])
    {
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        String str=inp.next();
        int arr[]=new int[2];
        char ch='0';
        if(n%2!=0)
        {
            System.out.println(1);
            System.out.println(str);
        }
        else
        {
            for(int i=0;i<n;i++)
            {   
                arr[str.charAt(i)-'0']++;
            }
            if(arr[0]==arr[1])
            {
                System.out.println(2);
                System.out.print(str.substring(0,n-1)+" "+str.substring(n-1));
            }
            else
            {
                System.out.println(1);
                System.out.println(str);
            }
        }
    }
}