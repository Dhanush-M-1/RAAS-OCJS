import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;
public class Main {
	//YOU CAN DO IT ....
	//Do what you love to do and give it your very best. Whether it's business or baseball, or the theater, or any field.
	//If you don't love what you're doing and you can't give it your best, get out of it. Life is too short. You'll be an old man before you know it.
	//Don't aim for success if you want it; just do what you love and believe in, and it will come naturally.
static int n; static int m; static long ans;static int count; static int flag;
static int arr[];static int arr2[];static boolean visited[];
static ArrayList<Integer> s[];static ArrayList<Integer>list;
static class pair{int first,second;public pair(int x,int y){x=first;y=second;}}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
         int n=sc.nextInt();
         int c=sc.nextInt();
         list=new ArrayList();
         arr=new int[n];
         for(int i=0;i<n;i++)
        		arr[i]=sc.nextInt();
         for(int i=0;i<n-1;i++)
        	 list.add(arr[i]-arr[i+1]);
         Collections.sort(list);
         if(list.get(list.size()-1)-c<0)
        	 System.out.print(0);
         else
         
         System.out.print(list.get(list.size()-1)-c);
       
         }
     
}
    