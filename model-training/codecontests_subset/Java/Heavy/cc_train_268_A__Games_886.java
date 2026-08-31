/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n,a,b;
		n= sc.nextInt();
		int arr[]= new int[n];
		HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();
// 		HashMap<Integer,Integer>map2= new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++)
		{
		    a= sc.nextInt();
		    b= sc.nextInt();
		  //  map1.put(a,map1.getOrdefault(a,0)+1);
		  arr[i]= a;
		    map.put(b,map.getOrDefault(b,0)+1);
		}
		int ans=0;
		for(int i=0;i<n;i++)
		{
		    if(map.containsKey(arr[i]))
		    {
		        ans+= map.get(arr[i]);
		    }
		}
		System.out.println(ans);
	}
}
