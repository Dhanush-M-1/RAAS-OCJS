import java.io.*;
import java.util.*;
public class BestGift
{ 
    public static void main(String args[])throws IOException
    { 
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s[] = br.readLine().split(" ");
         int books = Integer.parseInt(s[0]);
         int genre = Integer.parseInt(s[1]);
         s = br.readLine().split(" ");
         int arr[] = new int[genre];
         for(int i = 0;i < books;i++)
         { 
             arr[Integer.parseInt(s[i])-1]++;
         }
         int options = 0, t;
         for(int i = 0;i < genre;i++)
         { 
             t = 0;
             for(int j = i+1;j < genre;j++)
             { 
                 t += arr[j];
             }
             options += arr[i] * t;
         }
         System.out.println(options);
    }
}