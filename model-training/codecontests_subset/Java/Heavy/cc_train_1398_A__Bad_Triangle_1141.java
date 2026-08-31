import java.util.*;
public class solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int ar[] = new int[n];
            for(int i=0;i<n;i++)
            if(sc.hasNext())
            ar[i] = sc.nextInt();
            int s = ar[0]+ar[1];
            int index = -1;
            for(int i=2;i<n;i++)
            if(ar[i] >= s){
                index = i;
                break;
            }
            if(index!=-1)
            System.out.println(1+" "+2+" "+(index+1));
            else
            System.out.println(-1);
        }
    }
}