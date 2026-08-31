import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Tejas on 25-09-2018.
 */
public class Main {

    static int a[],w[];
    public static void main(String[]args)throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String temp[]=bufferedReader.readLine().split(" ");
        int N=Integer.parseInt(temp[0]);
        int M=Integer.parseInt(temp[1]);
        temp=bufferedReader.readLine().split(" ");
        w=new int[N];
        a=new int[M];
        for(int i=0;i<N;i++)
            w[i]=Integer.parseInt(temp[i]);
        temp=bufferedReader.readLine().split(" ");
        for (int i = 0; i < M; i++)
            a[i]=Integer.parseInt(temp[i]);
        System.out.println(solve(N, M));
    }

    private static long solve(int N, int M) {
        HashSet<Integer> set=new HashSet<>();
        LinkedList<Integer> res=new LinkedList<>();
        for(int i=0;i<M;i++) {
            if(set.size()==N) break;
            if (!set.contains(a[i])){
                set.add(a[i]);
                res.add(a[i]);
            }
        }

        long ans=0;
        for(int i=0;i<M;i++){
            int index=res.indexOf(a[i]);
            for(int j=0;j<index;j++)
                ans+=w[res.get(j)-1];
            res.remove(index);
            res.addFirst(a[i]);
        }
        return ans;
    }
}
