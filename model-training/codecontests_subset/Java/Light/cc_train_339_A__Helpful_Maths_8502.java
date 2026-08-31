import java.util.*;
public class Main
{
    public static void main(String args[])throws Exception
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int l=s.length();
        int a[]=new int[(l+1)/2];
        int j=0;
        for(int i=0;i<l;i=i+2){
                char ch=s.charAt(i);
                a[j]=Integer.parseInt(String.valueOf(ch));
                j++;
        }
        Arrays.sort(a);
        j=0;
        for(int i=0;i<l;i++){
            if(i%2==0){
                System.out.print(a[j]);
                j++;
            }
            else
            System.out.print("+");
        }
    }
}