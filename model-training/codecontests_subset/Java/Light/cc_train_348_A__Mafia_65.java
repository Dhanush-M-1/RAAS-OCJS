import java.util.*;
public class mafia
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();
        double sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int a = in.nextInt();
            sum+=a;
            max = Math.max(max,a);
        }
        int ans = (int)Math.max(max,Math.ceil(sum/(n-1)));
        System.out.println(ans);
    }
}