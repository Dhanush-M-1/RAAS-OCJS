import java.util.Scanner;
public class _519B_A_and_B_and_Compilation_Errors {
    public static void main(String[] args)
    {
        Scanner input= new Scanner (System.in);
        int n= input.nextInt(),i,t,s1=0,s2=0,s3=0;
        for (i=0;i<n;i++)
        {
            t=input.nextInt();
            s1+=t;
        }
        for (i=0;i<n-1;i++)
        {
            t=input.nextInt();
            s2+=t;
        }
        for (i=0;i<n-2;i++)
        {
            t=input.nextInt();
            s3+=t;
        }
        System.out.println(s1-s2);
        System.out.println(s2-s3);
        input.close();
    }
}
