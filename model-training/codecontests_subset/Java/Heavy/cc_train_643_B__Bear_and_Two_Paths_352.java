

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by vikas.k on 27/11/16.
 */
public class TaskD {
    public static void main(String[] args){
        MyScanner sc = new MyScanner();

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] vt = new int[4];

        for(int i=0;i<4;i++){
            vt[i] = sc.nextInt();
        }

        if(n==4 || k<=n) System.out.print(-1);
        else{
            List<Integer> str = new ArrayList<>();

            for(int i=1;i<=n;i++){
                int chk =0;
                for(int j=0;j<4;j++){
                    if(vt[j] == i){
                        chk++;
                        break;
                    }
                }

                if(chk == 0){
                    str.add(i);
                }
            }

            System.out.print(vt[0]+ " " + vt[2]+ " ");
            for (int j: str) {
                System.out.print(j+" ");
            }
            System.out.println(vt[3]+ " " + vt[1]);

            System.out.print(vt[2]+ " " + vt[0]+ " ");
            for (int j: str) {
                System.out.print(j+" ");
            }
            System.out.println(vt[1]+ " " + vt[3]);
        }
    }

    private static class MyScanner{
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        private MyScanner(){
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next(){
            if(stringTokenizer == null || !stringTokenizer.hasMoreElements()){
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
