import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {


    public static void main (String[] args) throws Exception
    {       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String l = in.readLine();
        int contA=0;
        int contI=0;
        for (int i = 0; i < n && contI<2; i++) {
            if(l.charAt(i)=='A')
                contA++;
            if(l.charAt(i)=='I')
                contI++;
        }
        if(contI>=2)
        {
            System.out.println(0);
        }
        else if(contI==1)
        {
            System.out.println(1);
        }
        else
            System.out.println(contA);

    }
}