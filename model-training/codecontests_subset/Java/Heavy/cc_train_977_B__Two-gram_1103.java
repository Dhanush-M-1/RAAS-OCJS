import java.util.*;
public class ProblemB {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        String s = sc.next();
        String[] two_grams = new String[n-1];
        Map<String, Integer> two_grams_Map = new HashMap<>();
        for(int i = 0; i < n-1; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            sb.append(s.charAt(i+1));
            two_grams[i] = sb.toString();
            if(two_grams_Map.containsKey(two_grams[i]))
            {
                two_grams_Map.put(two_grams[i], two_grams_Map.get(two_grams[i])+1);
            }
            else
            {
                two_grams_Map.put(two_grams[i], 1);
            }
        }
        int max = 0;
        for(String key: two_grams_Map.keySet())
        {
            int freq = two_grams_Map.get(key);
            max = Math.max(max, freq);
        }

        String res ="";
        for(String key: two_grams_Map.keySet())
        {
            int freq = two_grams_Map.get(key);
            if(freq == max)
            {
                res = key;
                break;
            }
        }

        System.out.println(res);

    }
}
