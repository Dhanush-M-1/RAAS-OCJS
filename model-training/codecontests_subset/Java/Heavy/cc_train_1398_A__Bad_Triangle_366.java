import java.util.Scanner;

public class BadTraingle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        while(t-->0)
        {   
            int n = sc.nextInt();
            long arr[] = new long[n];
            for(int i=0 ; i<n ; i++)
            arr[i] = sc.nextLong();
            int j=2;
            long sum = arr[0]+arr[1];
            boolean b = false;
            while(j<n)
            {   
                if(sum<=arr[j])
                 {  b=true;  break;}
                else
                j++;
            }
            j++;
            if(b)
            System.out.println("1 2 "+j);
            else
            System.out.println("-1");
        }
    }
}