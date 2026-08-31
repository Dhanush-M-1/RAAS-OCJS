
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _385A {
public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer str=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(str.nextToken());
        int c=Integer.parseInt(str.nextToken());
        int a[]=new int[n];
        int max=0;
        str=new StringTokenizer(br.readLine());
        a[0]=Integer.parseInt(str.nextToken());
        for(int i=1;i<n;i++)
        {
        a[i]=Integer.parseInt(str.nextToken());
        if(max<a[i-1]-a[i])
            max=a[i-1]-a[i];
        }
        max=max-c;
        if(max<0)
            max=0;
        System.out.println(max);
}
}
