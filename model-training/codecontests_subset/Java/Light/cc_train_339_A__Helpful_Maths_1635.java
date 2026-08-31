import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int len=s.length();
        int[] n = new int[(len/2)+1];
        int index = 0;
        char[] ch=s.toCharArray();
        for(int i=0;i<len;i++)
        {
            if(ch[i]!='+')
            {
                n[index] = Character.getNumericValue(ch[i]);
                index++;
            }
        }
        Arrays.sort(n);
        for (int i = 0; i < n.length-1; i++)
        {
            System.out.print(n[i]+"+");
        }
        System.out.print(n[n.length-1]);
    }
}