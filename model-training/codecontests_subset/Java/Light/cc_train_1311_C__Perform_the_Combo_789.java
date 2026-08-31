import java.util.*;
import java.util.stream.Collectors;


public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i =0;i<n;i++){
            int[] size = Arrays.asList(sc.nextLine().split(" ")).
                    stream().mapToInt(Integer::parseInt).toArray();
            String s = sc.nextLine();
            int[] num = Arrays.asList(sc.nextLine().split(" ")).
                    stream().mapToInt(Integer::parseInt).toArray();
            int[] ans = get_ans(size,s,num);
            for(int ij:ans)
                System.out.print(ij+" ");
            System.out.println();
        }
    }

    private static int[] get_ans(int[] size,String s,int[] num) {
        int n =size[0],m = size[1];
        int[] ans = new int[26],nn = new int[n+1];
        for(int i=0;i<m;i++){
            nn[0]+=1;
            nn[num[i]]-=1;
        }
        nn[0]+=1;nn[n]-=1;
        ans[s.charAt(0)-'a']+=nn[0];
        for(int i=1;i<n;i++){
            nn[i]+=nn[i-1];
            ans[s.charAt(i)-'a']+=nn[i];
        }
        return ans;
    }
}