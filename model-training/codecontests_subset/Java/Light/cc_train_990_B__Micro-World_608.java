import java.util.*;

public class B
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        final int k = s.nextInt();
        int rem = n;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            int a  = s.nextInt();
            l.add(a);
        }
        l.sort(Integer::compareTo);
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < n; i++)
        {
            int a = l.get(i);
//            while(!t.empty() && t.get(t.size()-1) < a && t.get(t.size()-1)+k >= a){
            while(!t.empty() && t.peek() < a && t.peek()+k >= a){
                t.pop();
            }
            t.add(a);
        }
        System.out.println(t.size());
    }
}
