//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.StringTokenizer;



public class TheBestGift {
public static void main(String[] args) throws IOException {

    Scanner cs= new Scanner(System.in);
//    StringTokenizer tok=new StringTokenizer(reader.readLine());
    int n=cs.nextInt();
    int m=cs.nextInt();
//    tok=new StringTokenizer(reader.readLine());
    long a[] =new long[m];
    long c=0;
    for(int i=0;i<n;i++)
    {
        int x=cs.nextInt();
        a[x-1]++;
        for(int j=0;j<m;j++)
        {
            if(j!=x-1)
            {
                c+=a[j];
            }
        }
    }
    System.out.println(c);
}
    
}