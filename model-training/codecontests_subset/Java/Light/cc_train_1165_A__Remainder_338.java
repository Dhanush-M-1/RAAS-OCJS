import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Rough {
    static StringBuilder sb = new StringBuilder();
    static PrintWriter pw = new PrintWriter(System.out,true);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //code goes here
        int n = sc.nextInt(),x=sc.nextInt(),y = sc.nextInt(),count=0;
        char arr[]= sc.next().toCharArray();
        Stack<Character> stk = new Stack<>();
        for( char ch : arr)
            stk.push(ch);
        int ind=0;
        while(true){
            char val = stk.pop();
            if(ind == y && val!='1')
                count++;
            else if(ind!= y && val=='1')
                count++;
            ind++;
            if(ind == x)
                break;
            //System.out.println(arr[i]+"  "+count+"  "+(n-1-i));
        }
        System.out.println(count);




        pw.println(sb);
        pw.flush();
        pw.close();


    }
}