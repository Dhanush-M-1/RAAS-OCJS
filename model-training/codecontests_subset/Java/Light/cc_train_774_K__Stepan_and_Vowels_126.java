
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        char[] s = new char[n+1];
        char[] a = new char[n+1];
        s = scan.next().toCharArray();
        int k = 0;
        for(int i = 0, j = 0; i < n;)
        {
            if(s[i] != 'a' && s[i] != 'e' && s[i] != 'o' && s[i] != 'y' && s[i] != 'u' && s[i] != 'i')
            {
                a[k++] = s[i++];
                j++;
                continue;
            }
            while(j < n && s[i] == s[j]) ++j;
            if(s[i] == 'o' && j - i == 2)
            {
                for(;i < j; ++i)
                {
                    a[k++] = s[i];
                }
            }
            else if(s[i] == 'e' && j - i == 2)
            {
                for(;i < j; ++i)
                {
                    a[k++] = s[i];
                }
            }
            else
            {
                a[k++] = s[i];
                for(; i < j && i < n; ++i);
            }
        }
        for(int i = 0; i < k; ++i)
        {
            System.out.print(a[i]);
        }
    }
}