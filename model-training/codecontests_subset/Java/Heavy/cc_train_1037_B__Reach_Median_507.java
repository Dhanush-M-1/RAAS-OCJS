import java.io.*;
import java.util.*;

public class Solution {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw=new PrintWriter(System.out);
//        int n=Integer.parseInt(br.readLine());
//        long index=1,sum=0;
//        while(sum + index <= n){
//            sum+=index;
//            index++;
//        }
//        if(sum==n){
//            pw.println(index-1);
//        }else{
//            pw.println(index);
//        }
//        pw.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        String string = br.readLine();
        st = new StringTokenizer(string, " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        if (array[n / 2] >= s) {
            long count = 0;
            for (int i = n / 2; i >= 0; i--) {
                if (array[i] <= s) {
                    break;
                }
                count += array[i] - s;
            }
            pw.println(count);
        } else {
            long count = 0;
            for (int i = n / 2; i < n; i++) {
                if (array[i] >= s) {
                    break;
                }
                count += s - array[i];
            }
            pw.println(count);
        }
        pw.close();
    }
}