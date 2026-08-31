import java.util.*;
class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n], b = new int[n], c = new int[m], d = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            int index = m;
            int tmp = Integer.MAX_VALUE;
            for(int j = m-1; j >= 0; j--){
                int x = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
                if(x <= tmp){
                    index = j;
                    tmp = x;
                }
            }
            System.out.println(index+1);
        }
    }
}