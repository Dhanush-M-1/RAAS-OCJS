import java.io.*;

public class Main1155A
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int s=-1,t=-1;
        for(int i=0;i<arr.length-1;++i)
        {
            if(arr[i]>arr[i+1])
            {
                bw.write("YES\n"+(i+1)+" "+(i+2));
                bw.close();
                return;
            }
        }
        bw.write("NO");
        bw.close();
    }
}
