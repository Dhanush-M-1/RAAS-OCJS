import java.util.Scanner;

public class pre134
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int tc = obj.nextInt();
        while (tc--!=0)
        {
           int n = obj.nextInt(),m = obj.nextInt(),alph[] = new int[26];
           String str = obj.next();
           int p[] = new int[n];
           for(int i=0;i<m;i++)
           {
               int k = obj.nextInt();
               p[k-1]++;
           }
           for(int i=n-1;i>0;i--)
               p[i-1] += p[i];
           int arr[] = new int[26];
           for(int i=0;i<n;i++)
           {
               arr[str.charAt(i)-'a'] += p[i];
               arr[str.charAt(i)-'a']++;
           }
           for(int i=0;i<26;i++)
               System.out.print(arr[i]+" ");
           System.out.println();
        }
    }
}
