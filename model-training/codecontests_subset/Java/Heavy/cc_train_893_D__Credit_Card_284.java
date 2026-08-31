import java.io.PrintWriter;
import java.util.*;

/**
 * Created by trung.pham on 25/12/17.
 */
public class D_Edu_Round_33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int d = in.nextInt();
        long[]cur = new long[n];
        long[]data = new long[n];
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < n; i++){
            data[i] = in.nextInt();
            cur[i] += data[i];
            if(i > 0){
                cur[i] += cur[i - 1];
            }
            if(data[i] == 0){
                list.add(i);
            }

        }
      //  System.out.println ( Arrays.toString(cur));
        long[]max = new long[n];
        for(int i = n - 1; i >= 0; i --){
            max[i] = cur[i];
            if(i + 1 < n){
                max[i] = max(max[i], max[i + 1]);
            }
        }
      //  System.out.println(Arrays.toString(max) + " " + Arrays.toString(cur));
        int result = max[0] > d ? -1 : 0;
        long tmp = 0;
        for(int i = 0; i < list.size() && result != -1; i++){
            int index = list.get(i);
            long v = cur[index];
            if(v < 0){
                v = -v;
                if(tmp >= v){
                    v = 0;
                }else{
                    tmp = v;
                }
            }else{
                v = 0;
            }

            if(v == 0){
                continue;
            }
           // System.out.println(index);
            if(max[index] + v > d){
                result = -1;
            }else{
                long mx = max[index];
                result++;
                int nxt = i + 1;
                while(nxt < list.size()){
                    index = list.get(nxt);
                    v = cur[index];
                    if(v < 0){
                        v = -v;

                    }else{
                        v = 0;
                    }
                   // System.out.println(v + " " + mx);
                    if(v == 0 || tmp >= v){

                    }else{

                        if(mx + v > d){

                            break;
                        }else{
                            tmp = v;
                        }
                    }
                    nxt++;
                }
                i = --nxt;
            }
        }
        out.println(result);


        out.close();
    }

    static long max(long a, long b){
        return a < b ? b : a;
    }
}
