import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class Main
{
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        int[] a1 = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i<n; i++)
            a1[i] = Integer.parseInt(st.nextToken());
        
        int sum1 = 0;
        for(int i : a1)
            sum1+=i;
        
        int[] a2 = new int[n-1];
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i<n-1; i++)
            a2[i] = Integer.parseInt(st.nextToken());
        
        int sum2 = 0;
        for(int i : a2)
            sum2+=i;
        
        System.out.println(sum1-sum2);
        
        int[] a3 = new int[n-2];
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i<n-2; i++)
            a3[i] = Integer.parseInt(st.nextToken());
        
        int sum3 = 0;
        for(int i : a3)
            sum3+=i;
        
        System.out.println(sum2-sum3);

    }
}