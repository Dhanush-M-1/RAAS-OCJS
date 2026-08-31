import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Compiler {

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = s.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int j = 0; j < n; j++)
        {
            String num = s.next();
            int p = Integer.parseInt(num);
            if(m.containsKey(p))
            {
                m.put(p, m.get(p) + 1);
            }
            else
            {
                m.put(p, 1);
            }
        }
        for(int i = 1; i < 3; i++)
        {
            Map<Integer, Integer> m2 = new HashMap<>();
            for(int j = 0; j < n-i; j++)
            {
                String num = s.next();
                int p = Integer.parseInt(num);
                if(m2.containsKey(p))
                {
                    m2.put(p, m2.get(p) + 1);
                }
                else
                {
                    m2.put(p, 1);
                }
                m.put(p,  m.get(p) - 1);
            }
            for(int k : m.keySet())
            {
                if(m.get(k) == 1)
                {
                    System.out.println(k);
                    break;
                }
            }
            m = m2;
        }
    }
}
