import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        int n;
        String s = null,s1 = null;
        int flag = 0;
        n = reader.nextInt();
        s1 = reader.nextLine();
        s = reader.nextLine();
        //System.out.println(s);
        for(int i = 1;i < s.length();i++)
        {
            char mid1=s.charAt(i),mid2=s.charAt(i-1);
            //System.out.println("*" + (mid1 < mid2));
            if(mid1 < mid2)
            {
                flag = 1;
                System.out.println("YES");
                System.out.println(i + " " + (i + 1));
                break;
            }
        }
        if(flag == 0)
            System.out.println("NO");
    }
}
