

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        String[] a=br.readLine().split(" ");
        BigInteger[] arr=new BigInteger[n+1];
        for (int i = 1; i <=n ; i++) {
           arr[i]=new BigInteger(a[i-1]);
        }
        if (n==1){
            bw.write("1 1"+"\n");
            bw.write(""+arr[1].negate()+"\n");
            bw.write("1 1"+"\n");
            bw.write("0"+"\n");
            bw.write("1 1"+"\n");
            bw.write("0"+"\n");
            bw.flush();

            return;
        }
        BigInteger chu=arr[1];
        bw.write("2 "+n+"\n");
        bw.flush();
        for (int i = 2; i <=n ; i++) {
            bw.write(""+arr[i].multiply(BigInteger.valueOf(n-1))+" ");

        }
        bw.write("\n");
        bw.flush();
        bw.write("1 "+n+"\n");
        for (int i = 1; i <=n ; i++) {
            arr[i]=arr[i].multiply(BigInteger.valueOf(n));
            bw.write(arr[i].negate()+" ");
        }
        bw.flush();
        bw.write("\n");
        bw.flush();

        bw.write("1 1"+"\n");
        bw.write(chu.multiply(BigInteger.valueOf(n-1))+"");
        bw.flush();


    }
}
