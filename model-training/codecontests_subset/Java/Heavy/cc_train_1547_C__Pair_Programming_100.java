import java.util.*;

public class file
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0)
        {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int narr[] = new int[n];
            int marr[] = new int[m];
            int op[] = new int[n+m];
            for(int i = 0;i < narr.length;i++)
            {
                narr[i] = sc.nextInt();
            }
            for(int i = 0;i < marr.length;i++)
            {
                marr[i] = sc.nextInt();
            }
            int indexN = 0;
            int indexM = 0;
            int indexFinal = 0;
            boolean flag = true;
            while(indexN < n || indexM < m)
            {
                if(indexN < n && narr[indexN] == 0)
                {
                    op[indexFinal++] = narr[indexN];
                    indexN++;
                    k++;
                }
                else if(indexN < n && narr[indexN] <= k)
                {
                    op[indexFinal++] = narr[indexN];
                    indexN++;
                }
                else if(indexM < m && marr[indexM] == 0)
                {
                    op[indexFinal++] = marr[indexM];
                    indexM++;
                    k++;
                }
                else if(indexM < m && marr[indexM] <= k)
                {
                    op[indexFinal++] = marr[indexM];
                    indexM++;
                }
                else {
                    
                    flag = false;
                    break;
                }
            }
            if(!flag)
            {
                System.out.println("-1");
            }
            else
            {
                for(int i  = 0;i<indexFinal;i++)
                {
                    System.out.print(op[i]+" ");
                }
                System.out.println();
            }
            t--;
        }
    }
}