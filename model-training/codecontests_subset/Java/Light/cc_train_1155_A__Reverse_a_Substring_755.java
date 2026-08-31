import java.util.*;
public class GFG { 
      
    public static void main (String[] args) 
    { 
        Scanner sc=new Scanner(System.in); 
        int n=sc.nextInt();
        String s=sc.next();
        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        String w=new String(arr);
        if(w.equals(s))
        System.out.println("NO");
        else{
            for(int i=0;i<n-1;i++)
            {
                if(s.charAt(i)>s.charAt(i+1))
                {
                    System.out.println("YES");
                    System.out.println((i+1)+" "+(i+2));
                    break;
                }
            }
        }
    }
}