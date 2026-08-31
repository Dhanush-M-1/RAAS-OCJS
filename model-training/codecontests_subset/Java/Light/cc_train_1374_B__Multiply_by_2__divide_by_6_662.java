import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeforces {

    public static void main(String[] args) throws IOException {


        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        for(int i=0;i<n;i++)
        {
            long x=Long.parseLong(reader.readLine());


            int countOf2=0;
            while(x%2==0)
            {
                x=x/2;
                countOf2++;
            }

            int countOf3=0;
            while(x%3==0)
            {
                x=x/3;
                countOf3++;
            }

            if(countOf2>countOf3||x!=1)
                System.out.println("-1");

            else
            {
                System.out.println((countOf3-countOf2)+countOf3);
            }
        }

    }
}
