import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multi2Div6
{

    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int e=1;e<=t;e++)
        {
            int n=Integer.parseInt(br.readLine());
            int count2=0,count3=0;
            while(n%2==0)
            {
                n=n/2;
                count2++;
            }
            while(n%3==0)
            {
                n=n/3;
                count3++;
            }
            if(n!=1)
                System.out.println("-1");
            else if(count3>=count2)
                System.out.println(count3-count2+count3);
            else
                System.out.println("-1");
        }
    }
}