import java.util.*;
import java.io.*;
import java.lang.*;
public class Task{

public static void main(String[] args) throws FileNotFoundException, IOException{
       Scanner s=new Scanner(System.in);
       BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=s.nextInt(),m=s.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
          a[i]=s.nextInt();
        }
          for(int i=0;i<n;i++){
          b[i]=s.nextInt();
        }
        Arrays.sort(a); Arrays.sort(b);
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
          int x=(b[i]-a[0]+m)%m;
          int[] c=new int[n];
          boolean bb=true;
          for(int j=0;j<n;j++){c[j]=(a[j]+x)%m;}
            Arrays.sort(c);
            for(int j=0;j<n;j++){
              if(c[j]!=b[j]){bb=false;}
            }
            if(bb){res=Math.min(res,x);}
        }
        
        out.write(res+" ");
        out.write("\n");
        out.flush();
  }
}
