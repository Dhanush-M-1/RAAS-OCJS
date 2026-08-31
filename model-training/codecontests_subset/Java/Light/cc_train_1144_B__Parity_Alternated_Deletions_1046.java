import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt();
		int arr[]=new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		List<Integer> list1=new LinkedList<Integer>();
		List<Integer> list2=new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			if(arr[i]%2==0)list1.add(arr[i]);
			else list2.add(arr[i]);
		}
		
		while(list1.size()!=0&&list2.size()!=0) {
			list1.remove(list1.size()-1);
			list2.remove(list2.size()-1);
		}
		int s=0;
		if(list1.size()>0) {
			list1.remove(list1.size()-1);
			for(int i=0;i<list1.size();i++) {
				s=s+list1.get(i);
			}
		}
		if(list2.size()>0) {
			list2.remove(list2.size()-1);
			for(int i=0;i<list2.size();i++) {
				s=s+list2.get(i);
			}
		}
		
		System.out.println(s);
	}
}
	 			   	 		  			   	 				 	 	