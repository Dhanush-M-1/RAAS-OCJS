

import java.util.Arrays;
import java.util.Scanner;

public class k2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
				int n=sc.nextInt();
				int k=sc.nextInt();
				int arr[]=new int [123];//数组下标当做字母，储存出现的次数
				char s[]=sc.next().toCharArray();//储存字母的数组
				int csn[]=new int [k];//储存重置位置
				
				for (int i = 0; i < csn.length; i++) {
					csn[i]=sc.nextInt()-1;//第一个元素对应的数组下标是0
				}Arrays.sort(csn);
				//System.out.println(Arrays.toString(csn));
				for (int i = 0; i < csn.length-1; i++) {
					for (int j = csn[i]+1; j <= csn[i+1]; j++) {
					arr[s[j]]+=(csn.length-i-1);
					}
				}
				for (int i = 0; i <=csn[0]; i++) {
					arr[s[i]]+=csn.length;
				}
				
				for (int i = 0; i < s.length; i++) {
					arr[s[i]]++;
				}
				for (int i = 97; i <=122; i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
		}
	
	}
}

  	    	    	 		        			 		