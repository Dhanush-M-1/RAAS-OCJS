
import java.util.Scanner;

public class Main
{
    private final static Main main = new Main();

    public static void main(String[] args)
    {
        long l = System.currentTimeMillis();
        main.contest();
        //System.out.println("処理時間：" + (System.currentTimeMillis() - l));
    }

    private void contest()
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = s.length();
        int S = 0;
        for(int i=0; i<s.length(); ++i)
        {
            if(s.charAt(i) == 'S')
            {
                ++S;
            }
            else
            {
                if(S > 0)
                {
                    --S;
                    res -= 2;
                }
            }
        }
        System.out.println(res);
    }
}
