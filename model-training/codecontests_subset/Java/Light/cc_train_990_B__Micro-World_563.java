import java.util.*;
public class B990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1000000*4];
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            list.add(x);
            count[x]++;
        }
        Collections.sort(list);
        for (int i=n-1; i>=1; i--) {
            if (list.get(i)>list.get(i-1) && list.get(i)<=list.get(i-1)+k) ans+=count[list.get(i-1)];
        }
        
        System.out.println(n-ans);
    }
}