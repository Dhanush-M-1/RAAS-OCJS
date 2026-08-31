import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Main
{
  static final int MAXN = 2000;
  static int n = 0;
  private static Vector<Integer> odd = new Vector<>();
  private static Vector<Integer> even = new Vector<>();
  private static long sum = 0;

  public static void main(String[] args)
  {
    int x = 0;
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    for(int i = 0; i < n; i++)
    {
      x = scanner.nextInt();
      if((x & 1) == 1)
        odd.add(x);
      else
        even.add(x);
      sum += x;
    }
    Comparator<Integer> comparator = new Comparator<Integer>(){
    @Override
    public int compare(Integer o1, Integer o2)
    {
      if(o1 < o2)
        return 1;
      else
        return -1;
    }
  };
    odd.sort(comparator);
    even.sort(comparator);
    int k = Math.min(odd.size(), even.size());
    long s1 = 0;
    long s2 = 0;
    for(int i = 0; i < k; i++)
    {
      s1 += odd.get(i);
      s2 += even.get(i);
    }
    long rem = sum;
    rem -= s1 + s2;
    if(odd.size() > k)
      rem -= odd.get(k);
    else if(even.size() > k)
      rem -= even.get(k);
    System.out.println(rem);
    scanner.close();
  }
}
