import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class KefaandFirstSteps {


    static long gcd(long a , long b){
        if(a==0)
            return b;
        return gcd(b%a , a);

    }


    static void solve(long [] a , long []b){

        long gcd1 = a[0];
        for (int i = 1; i < a.length; i++) {
            gcd1 = gcd(gcd1 , a[i]);
        }


        long gcd2 = b[0];
        for (int i = 1; i < b.length; i++) {
            gcd2 = gcd(gcd2 , b[i]);
        }


        if(gcd1%gcd2==0 || a.length==1)
            System.out.println("Yes");
        else
            System.out.println("No");


    }


    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<t ; i++) {

            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer str1 = new StringTokenizer(br.readLine());
            StringTokenizer str2 = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());



            int [] arr1 = new int[n];
            int [] arr2 = new int[m];

            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(str1.nextToken());
            }

            for (int j = 0 ; j<m ; j++){
                arr2[j] = Integer.parseInt(str2.nextToken());
            }


            int x = 0;
            int y = 0;

            int c = 0;
            int res [] =new int[n+m];
            boolean f = false;

            while(true){

                if(x== arr1.length && y==arr2.length)
                    break;

                if(x != arr1.length && arr1[x]==0){
                    k++;
                    res[c++] = arr1[x++];
                }
                else if(y!=arr2.length && arr2[y]==0){

                    k++;
                    res[c++] = arr2[y++];

                }
                else if(x != arr1.length && arr1[x]<=k){
                    res[c++] = arr1[x++];
                }
                else if(y!=arr2.length && arr2[y]<=k){
                    res[c++] = arr2[y++];
                }else{
                    f = true;
                    System.out.println(-1);
                    break;
                }
            }

            if(!f){
                for (int j = 0; j < n+m; j++) {
                    System.out.print(res[j] + " ");
                }
                System.out.println();
            }

        }






    }



}
