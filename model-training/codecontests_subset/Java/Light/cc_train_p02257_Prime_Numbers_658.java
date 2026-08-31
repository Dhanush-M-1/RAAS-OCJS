import java.util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ct=0;  Boolean isPN;
        for(int i = 0; i<n;i++)
        {
            isPN=true;  
            int num = sc.nextInt();
            for(int j = 2; j<=Math.sqrt(num);j++)
            {
                if(num%j==0)
                {
                    isPN=false;
                    break;
                }  
            }
            if(isPN==true) ct++;
        }
        System.out.println(ct);
    }
}   

