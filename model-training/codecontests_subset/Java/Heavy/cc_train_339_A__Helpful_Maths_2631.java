import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int no=str.length()/2+1;
        int arr[]=new int[no];
        int j=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='+'&&str.charAt(i)!='-')
            {
                arr[j]=Character.getNumericValue(str.charAt(i));
               // System.out.print(arr[j]);
                j++;
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<no;i++)
        {
             if(i!=no-1)
             System.out.print(arr[i]+"+");
             else
            System.out.print(arr[i]);
        }
    }
}
