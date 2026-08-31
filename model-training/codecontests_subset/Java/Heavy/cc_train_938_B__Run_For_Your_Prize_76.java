import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;


public class solution {

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int x = 1,y =0;
        int n = sc.nextInt();
        int arr[]  = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Stack me = new Stack();
        Stack friend = new Stack();
        int count = 0,count2=0;
        try{
        for (int i = 0; i < arr.length; i++) {
            if((arr[i]-1)<=(1000000-arr[i]))
            {
                me.push(arr[i]-1);
                count2++;
            }
            else{
                friend.push(1000000-arr[i]);
                count++;
            }
                        }
        if(count2!=0)
         x= (int) me.pop();
         while(count!=1)
         {
             friend.pop();
             count--;
         }
         y = (int)friend.pop();
         if(x<y)
            {
                System.out.println(y);
            }
            else
                System.out.println(x);
           
        }
        catch(EmptyStackException e)
        {
            if(x<y)
            {
                System.out.println(y);
            }
            else
                System.out.println(x);
            }
    }
}