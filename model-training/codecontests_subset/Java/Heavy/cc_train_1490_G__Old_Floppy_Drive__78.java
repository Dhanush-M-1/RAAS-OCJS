import java.io.*;
import java.util.*;
public class Ishu
{
    static Scanner scan = new Scanner(System.in);
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static void tc() throws Exception
    {
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[] a = new int[n];
    int i;
    long[][] x = new long[m][3];
    long[] pre = new long[n];
    long[] max = new long[n];
    long sum = 0l;
    long M = Long.MIN_VALUE;
    for(i=0;i<n;++i)
        {
        a[i] = scan.nextInt();
        sum += a[i];
        pre[i] = sum;
        M = Math.max(sum, M);
        max[i] = M;
        }
        
    for(i=0;i<m;++i)
        {
        x[i][0] = scan.nextLong();
        x[i][1] = i;
        long X = x[i][0];
        long maxp = max[n-1];
        long rem = X - maxp;
        if(rem > 0L)
            {
            long whole = pre[n-1];
            if(whole < 1L)
                {
                x[i][2] = -1;
                x[i][0] = 0;
                continue;
                }
            else
                {
                long quo = rem / whole + (rem % whole > 0 ? 1 : 0);
                x[i][0] -= quo * whole;
                    
                x[i][2] = n * quo - (x[i][0] == 0 ? 1 : 0);
                }
            }
        }    
   
    Arrays.sort(x, Comparator.comparingLong(o -> o[0]));
  //  for(i=0;i<m;++i)
    //    System.out.println(x[i][0] + " " + x[i][1] + " " + x[i][2]); 
    int j = 0;
    while(j < m && x[j][0] == 0)
        ++j;
    for(i=0;i<n;++i)
        {
        long cpre = pre[i];
        while(j < m && x[j][0] <= cpre)
            {
            if(x[j][0] == 0)
                {
                ++j;
                continue;
                }
            x[j][2] += i;
            ++j;
            }
        }
    
    Arrays.sort(x, Comparator.comparingLong(o -> o[1]));
    
    for(i=0;i<m;++i)
        output.write(x[i][2] + " ");
    output.write("\n");
    output.flush();
    }
    public static void main(String[] args) throws Exception
    {
    int t = 1;
    t = scan.nextInt();
    while(t-- > 0)
        tc();
    }
}
