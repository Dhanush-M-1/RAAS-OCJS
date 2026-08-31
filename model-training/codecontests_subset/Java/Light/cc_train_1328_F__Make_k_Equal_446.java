
import java.util.*;

public class Result {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      int x,curr,ans=(int)1e9,sum=0;
      int[] a = new int[n];
      for (int i=0;i<n;i++)
          a[i]=scanner.nextInt();
      ArrayList<Integer>[] list = new ArrayList[200005];
        for (int i = 0; i < 200005; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0;i<n;i++){
          x=a[i];
          curr=0;
          while (x>0){
              list[x].add(curr);
              x/=2;
              curr++;
          }
      }
      for (int i=0;i<200005;i++){
          sum=0;
          Collections.sort(list[i]);
          if (list[i].size()<k)
              continue;
          for (int j=0;j<k;j++)
              sum+=list[i].get(j);
          ans=Math.min(ans,sum);
      }
        System.out.println(ans);
        scanner.close();
    }
}

