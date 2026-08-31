import java.io.*;
import java.util.*;
public class CommonSubsequence {

    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(in.readLine());
        while (T-->0){
            String[] str=(in.readLine()).split(" ");
            int N=Integer.parseInt(str[0]);
            int M=Integer.parseInt(str[1]);
            HashSet<Integer> aEles=new HashSet<>();
            str=(in.readLine()).split(" ");
            for (int i=0; i<N; i++){
                aEles.add(Integer.parseInt(str[i]));
            }
            str=(in.readLine()).split(" ");
            boolean poss=false;
            for (int i=0; i<M; i++){
                if (aEles.contains(Integer.parseInt(str[i]))){
                    poss=true;
                    System.out.println("YES");
                    System.out.println("1 "+Integer.parseInt(str[i]));
                    break;
                }
            }
            if (!poss){
                System.out.println("NO");
            }
        }
    }
}