import java.io.*;
import java.util.StringTokenizer;

public class Main1165A
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int count = 0;
        for(int i=arr.length-1; i>arr.length-1-Y;--i)
        {
            if(arr[i]=='1')
                count++;
        }
        if(arr[arr.length-1-Y]=='0')
            count++;
        for(int i=arr.length-1-Y-1;i>arr.length-1-X;--i)
        {
            if(arr[i]=='1')
                count++;
        }
        bw.write(count+"");
        bw.close();
    }

}
