import java.util.*;

public class HelloWorld{
    private static Scanner sc = new Scanner(System.in);
    
     public static void main(String []args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            int x = sc.nextInt();
            for(int j=0;j<x;j++)
            {
                int y = sc.nextInt();
                hs.add(y);
            }
        }
        String s="NO";
        if(hs.size()==m)    s="YES";
        System.out.println(s);
     }
}