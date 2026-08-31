import java.util.*;
 
public class test {
    
    public static void main(String[] args)  {
          Scanner s = new Scanner(System.in);
        int n = s.nextInt();
    //     List<Integer> sr = Arrays.asList(0, 1, 1, 1, 10);
      //   int n = 5;
        long[] arr = new long[n+1];
        long[] fw = new long[n+1];
    
        for(int i=1;i<=n;++i) {
            arr[i] = s.nextLong();
        }
 
        for(int i=1;i<=n;++i) fw[i] = 0;
        for(int i=1;i<=n;++i) {
            fw[i] += i;
            if((i + (i & (-i))) <= n)
            fw[i + (i & (-i))] += fw[i];
        }
      
        for(int i=n; i>=1; --i) {
            int l = 0, r = n;
            while(l < r) {
                
                int mid = (l + r )/2;
                long tp = 0;
                    int j = mid;
                while(j > 0) {
                    tp += fw[j];
                    j -= j&(-j);
                   
                }
             //   System.out.println(l + " " + r + " " + mid + " " + tp);
                if(tp <= arr[i]) l = mid + 1;
                else r = mid ;
            }
            arr[i] = l;
            addfw(l, -l, n, fw);
        }
      
       
        for(int i=1; i<=n; ++i)
            System.out.print(arr[i] + " ");
    }
    
      private static void addfw(int a, int b, int n, long[] fw) {
        while((a) <= n) {
            fw[a] += b;
            a += a&(-a);
        }
    }
}
