import java.util.*;

public class p1144B
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        List<Integer> even = new ArrayList<>(),
                        odd = new ArrayList<>();
        long sum = 0;
        while(times-- > 0)
        {
            int val = scan.nextInt();
            if(val % 2 == 0)
                even.add(val);
            else
                odd.add(val);
            sum += val;
        }
        Collections.sort(even);
        Collections.sort(odd);

        if(even.size() < odd.size())
        {
            List<Integer> temp = even;
            even = odd;
            odd = temp;
        }

        // Assume odd.size() < even.size()
        for(int val : odd)
            sum -= val;
        for(int i = 0; i < even.size() && i < odd.size() + 1; i++)
            sum -= even.get(even.size() - 1 - i);
        System.out.println(sum);
    }
}
