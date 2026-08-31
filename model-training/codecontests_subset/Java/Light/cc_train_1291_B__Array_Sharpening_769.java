//author @markysans
import java.util.*;
import java.io.*;
public class c{
	static Scanner sc=new Scanner(System.in);
	static int cnt;
	public static void main(String args[]){
		int k=1;
		k=sc.nextInt();
		while(k--!=0){
			solve();
		}
	}

	static void solve(){
        int n=sc.nextInt();
        int A[]=new int[n];
		for(int i=0;i<n;i++)
            A[i]=sc.nextInt();
        int p=0,change=1;
        int i=0;
        while(i<n){
            if(A[i]<p)
                break;
            i++;
            p++;
        }
        i--;
        p=A[i];
        while(i<n){
            if(p<0){
                System.out.println("No");
                return; 
            }
            p=Math.min(A[i]-1,p-1);
            i++;
        }
        System.out.println("Yes");
	}
	static int[] initarray(int n){
		int A[]=new int[n];
		for(int i=0;i<n;i++)
			A[i]=sc.nextInt();
		return A;
	}
}
// static ArrayList<Integer> initlist(int n){
// 	ArrayList<Integer> A=new ArrayList<Integer>();
// 	for(int i=0;i<n;i++)
// 		A.add(sc.nextInt());
// 	return A;
// }
// static long[] initarray2(int n){
// 	long A[]=new long[n];
// 	for(int i=0;i<n;i++)
// 		A[i]=sc.nextLong();
// 	return A;
// }
// static ArrayList<Long> initlist2(long n){
// 	ArrayList<Long> A=new ArrayList<Long>();
// 	for(long i=0;i<n;i++)
// 		A.add(sc.nextLong());
// 	return A;
// }
//System.out.println();
// A.add(5);
// A.remove(5);
// A.get(5);
// A.set(1,5);
// A.indexOf(5);
// A.lastIndexOf(5);
// A.subList(2,4);
