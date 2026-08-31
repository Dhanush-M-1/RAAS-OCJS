import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int test= sc.nextInt();
        while(test-->0){
            int a = sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            System.out.println(find(a,b,c));
        }
        
    }

    public static int find(int a , int b, int c){
        int count =0;
        while(b>=1 && c>=2){
            count+=3;
            b-=1;
            c-=2;
        }while(a>=1 && b>=2){
            count+=3;
            a-=1;
            b-=2;
        } 
        return count;
    }
}
 
