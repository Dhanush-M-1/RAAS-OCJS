


import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        s.nextLine();

        for (int i = 0; i < lines; i += 1) {
            //System.out.print("Case #" + (i / 2 + 1) + ": ");
            s.nextLine();
            solve(s.nextLine().split(" "), s.nextLine().split(" "), s.nextLine().split(" "));
        }
    }


    public static void solve(String a[], String b[], String c[]) {
        int k = Integer.parseInt(a[0]);
        
        int dataA[] = new int[b.length + 1];
        for (int i = 0; i < b.length; i++) {
            dataA[i] = Integer.parseInt(b[i]);
        }
        int dataB[] = new int[c.length + 1];
        for (int i = 0; i < c.length; i++) {
            dataB[i] = Integer.parseInt(c[i]);
        }

        dataA[dataA.length - 1] = 1000;
        dataB[dataB.length - 1] = 1000;


        int data[] = new int[b.length + c.length];
        int ia = 0;
        int ib = 0;

        for (int i = 0; i < data.length; i++) {
            if (dataA[ia] < dataB[ib]) {
                data[i] = dataA[ia++];
            } else {
                data[i] = dataB[ib++];
            }
        }


        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) {
                k++;
            } else {
                if (data[i] > k) {
                    System.out.println("-1");
                    return;
                }
            }
        }


        String out = Arrays.toString(data).replace(",", "").replace('[', ' ').replace(']', ' ').substring(1);
        System.out.println(out.substring(0, out.length() - 1));
    }
}
