import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import java.io.*;
public class Ankush{
    public static void main(String []args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String arr[]=br.readLine().split("\\s+");
            int l=Integer.parseInt(arr[0]),r=Integer.parseInt(arr[1]),d=Integer.parseInt(arr[2]);
            if(d<l)
            System.out.println(d);
            else System.out.println(r+(d-r%d));
        }
    }
}