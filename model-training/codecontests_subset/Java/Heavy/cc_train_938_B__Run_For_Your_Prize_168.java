import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App 
{
    public static void main( String[] args ) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> data = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        int l = 1;
        int r = 1000000;
        int count = 0;
        int time = -1;
        while (count != n) {
            time++;
            if (data.contains(l)) {
                count++;
            }
            if (data.contains(r)) {
                count++;
            }
            l++;
            r--;
        }
        System.out.println(time);
    }
}
