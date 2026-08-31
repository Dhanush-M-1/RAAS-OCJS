import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[m];
        int[] d = new int[m];
        int[] ans = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for(int i = 0;i < m;i++){
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        for(int i = 0;i < n;i++){
            int point = Integer.MAX_VALUE;
            for(int j = 0;j < m;j++){
                int tmp = Math.abs(a[i]-c[j]) + Math.abs(b[i]-d[j]);
                if(tmp < point){
                    point = tmp;
                    ans[i] = j+1;
                }
            }
        }
        for(int ret:ans)
            System.out.println(ret);
    }
}