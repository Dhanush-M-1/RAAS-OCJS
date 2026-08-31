import java.io.*;
public class temp{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        char[] s = in.readLine().toCharArray();
        boolean good = false;
        for (int i = 0 ; i <= n - 5; i ++)
            for (int j = 1; j <= (n - i - 1)/4; j++)
                if (s[i] == '*' && s[i+j] =='*' && s[i+2*j] =='*' && s[i+3*j] =='*' && s[i+4*j] =='*')
                {
                    good = true;
                    break;
                }
        if(good) System.out.print("yes");
        else System.out.print("no");
    }
}