import java.util.Arrays;
import java.util.Scanner;

public class apples {

    public static void main(String[] args) {

        int t, a,  sub=1,  len, k = 0, i, j, temp;
        Scanner scan = new Scanner(System.in);
        t=scan.nextInt();
        while(k<t) {
            String s;
            int x;
            int[] count = new int[26];


            a = scan.nextInt();
            a = scan.nextInt();//number of tries
            s = scan.next();
            int[] b = new int[a];
            for (i = 0; i < a; i++)
                b[i] = scan.nextInt();//number of correct chars


            int[] arr=new int[s.length()];

                for (i = 0; i < a; i++) {
                    arr[b[i]-1]++;

                }
                sub=1;
                for(i=s.length()-1;i>=0;i--){
                    x = s.charAt(i) - 97;

                        temp=sub;
                        sub+=arr[i];
                        arr[i]+=temp;

                    count[x]+=arr[i];

                }
           /* for (i = 0; i < s.length(); i++) {
                x = s.charAt(i) - 97;
                count[x]++;
            }
            // count[]++;*/
            System.out.println(Arrays.toString(count).replace("[", "").replace(","," ").replace("]", ""));
            k++;
        }
    }
}