
import java.util.*;

public class codeforces {


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        int max = 0;
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max,arr[i]);
        }

        
        ArrayList<Integer>[] matrix = new ArrayList[max+1];

        for(int i=0;i<=max;i++)
            matrix[i] = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            int temp = arr[i];
            int count = 0;

            while(true)
            {
                matrix[temp].add(count);
                if(temp == 0)
                    break;
                temp = temp / 2;
                count++;
            }
        }



        long ans = Long.MAX_VALUE;
        for(int i=0;i<=max;i++)
        {
            long temp = 0;
            long element = 0;

            if (matrix[i].size()<k) continue;
            Collections.sort(matrix[i]);
            for(int j=0;j<k;j++)
            {
                temp = temp + matrix[i].get(j);
            }
            ans = Math.min(ans,temp);
        }
        System.out.println(ans);


    }



}
