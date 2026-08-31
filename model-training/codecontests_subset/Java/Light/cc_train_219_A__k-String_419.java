import java.util.*;

public class MySolution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        if (s.length() % n != 0)
        {
            System.out.println(-1);
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            Integer count = map.get(s.charAt(i));
            map.put(s.charAt(i), count == null ? 1 : count + 1);
        }

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> c : map.entrySet())
        {
            int val = c.getValue();

            if (val % n != 0)
            {
                System.out.println(-1);
                return;
            }
            val /= n;

            for (int i = 0; i < val; i++)
            {
               ans.append(c.getKey());
            }
        }

        String part = ans.toString();
        
        for (int i = 1; i < n; i++)
        {
            ans.append(part);
        }
        
        System.out.println(ans);
    }
}