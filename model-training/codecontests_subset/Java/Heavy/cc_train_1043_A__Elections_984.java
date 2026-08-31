/*                 _____                                                             ___
    /\      /\    |     | |   |    /\       /\      /\       /\      /\       /\    |   \     محمد أبوحسن*
   /  \    /  \   |     | |___|   /__\     /  \    /  \     /  \    /  \     /__\   |    \
  /    \  /    \  |     | |   |  /    \   /    \  /    \   /    \  /    \   /    \  |    /
 /      \/      \ |_____| |   | /      \ /      \/      \ /      \/      \ /      \ |___/
*/
import java.util.*;
public class Mohammad {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
            s += a[i];
        }
        Arrays.sort(a);
        System.out.println((s*2+n)/n > a[n-1] ? (s*2+n)/n : a[n-1]);
    }
}