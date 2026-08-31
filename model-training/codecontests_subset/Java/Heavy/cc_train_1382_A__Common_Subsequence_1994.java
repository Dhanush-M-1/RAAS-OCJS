
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;



public class ieee1{

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            int m=scn.nextInt();
            boolean[] arr=new boolean[2000];
            
            int ans=-1;
            while(n-->0){
                int ele=scn.nextInt();
                arr[ele]=true;
            }
            while(m-->0){
                int ele=scn.nextInt();
                if(arr[ele]){
                    ans=ele;
                }
            }
            if(ans==-1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
                System.out.println("1"+" "+ans);
            }
            



           
        }
}

}
   