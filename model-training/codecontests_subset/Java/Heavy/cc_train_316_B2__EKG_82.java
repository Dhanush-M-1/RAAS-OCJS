import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by KC on 4/8/14.
 */
public class EKG {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter printWriter= new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException{
        String[] p = bufferedReader.readLine().trim().split(" ");
        int n = Integer.parseInt(p[0]);
        int idx = Integer.parseInt(p[1]);

       // int n = 10;
       // int idx = 2;

        int[] count = new int[n+1];
        int[] array = new int[n+1];
        p = bufferedReader.readLine().trim().split(" ");
    //   String[] p = {"10","0","9","0","0","4","2","6","8","0"};



        for(int i = 1; i <= n; i++){
            array[i] = Integer.parseInt(p[i-1]);
            count[i] += 1;

            if(array[i] != 0){
                if(array[i] < i){
                    int t = i;
                    while (array[t] != 0) t = array[t];
                    count[t] += count[i];
                }
                else {
                    count[array[i]] += count[i];

                }
            }
        }



        int fin = idx;
        int pre = 0;
        while (array[fin] != 0){
             fin = array[fin];
             pre++;
        }

        ArrayList<Integer> group = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            if(array[i] == 0 && i != fin){
                group.add(count[i]);
            }
        }

        pre++;
        printWriter.println(pre);
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        int size = group.size();
        int[][] results = new int[size][size];
      for(int i = 0; i < size; i++){
          int tmp = group.get(i);
          int tsize = result.size();
          if(!set.contains(tmp)){
              set.add(tmp);
              result.add(tmp);
          }

          for(int k = 0; k < tsize; k++){
              int ct = tmp + result.get(k);
              if(!set.contains(ct)){
                  set.add(ct);
                  result.add(ct);
              }
          }
      }





        Collections.sort(result);
        for(int i = 0; i < result.size();i++)
            printWriter.println(result.get(i)+pre);


        printWriter.flush();
        printWriter.close();

    }
}
