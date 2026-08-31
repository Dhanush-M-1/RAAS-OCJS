

import java.io.*;
import java.util.Arrays;

public class competetive  {

     public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
        String nki = br.readLine();
        String[]nk=nki.trim().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String line=br.readLine();
        String []s=line.trim().split(" ");
        int[]a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s[i]);
        }
        int []f=new int[200001];
        int []m=new int[200001];
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            int c=0;
            int num=a[i];
            while(num>0){
                if(f[num]<k)
                    m[num]+=c;
                f[num]++;

                num/=2;
                c++;
            }
            f[0]++;
            m[0]+=c;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<f.length;i++){
            if(f[i]>=k){
                min=Math.min(min,m[i]);
            }
        }
        out.write(String.valueOf(min));

        out.flush();
    }
}