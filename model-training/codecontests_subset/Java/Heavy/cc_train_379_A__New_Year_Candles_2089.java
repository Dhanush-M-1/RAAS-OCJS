import java.util.*;
import java.io.*;

public class Main{

	public static int contains(int [] array,int a){
		int c=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==a){
				c=1;
				break;
			}else{
				c=2;
			}
		}return c;
	}

	public static void print(int[] array){
		for(int i=0;i<array.length;i++){

			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	public static int[] sort(int[] array){
		int h=array.length/2;  // here, h is the interval.
		while(h>0){
			for(int i=h;i<array.length;i++){
				int temp=array[i];
				int j;
				for( j=i;j>=h && array[j-h]>temp; j=j-h){
					array[j]=array[j-h];
				}
				array[j]=temp;

				print(array);
			}
			h=h/2;
			
		}
		return array;
	}

	public static boolean isUpperCase(String s){
		return s==s.toUpperCase();
	}
	public static boolean isLowerCase(String s){
		return s==s.toLowerCase();
	}

	public static int con(String s, String a){
		int c=0;
		for(int i=0;i<s.length();i++){
			if(s.substring(i,i+1).equals(a)){
				c=1;
				break;
			}else{
				c=2;
			}
		}
		return c;
	}

	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int hour=0;
		int smart=0;
		while(a>0){
			if(smart!=b){
				a--;
				hour++;
				smart++;
			}else{
				a++;
				smart=0;
			}
		}
		if(smart==b){
		System.out.println(hour+1);
	}else{
		System.out.println(hour);
	}
}
	public static int prime(int a){
		int c=0;
		for(int i=2;i<=a/2;i++){
			if(a%i==0){
				c=1;
				break;
			}else{
				c=0;
			}
		}
		return c;
	}

	public static int contains(String s,String a){
		int c=0;
		for(int i=0;i<s.length();i++){
			
			if(s.substring(i,i+1).equals(a)&&!a.equals("l")){
				c=1;
				break;
			}else if(a.equals("l")){
				int m=count(s,a);
				if(m==0 || m==1){
					c=0;
				}else{
					c=1;
					break;
				}
			}
			else{
				c=0;
			}
		}
		return c;
	}
	public static int count(String s,String a){
		int c=0;
		for(int i=0;i<s.length();i++){
			if(s.substring(i,i+1).equals(a)){
				c++;
			}
		}
		return c;
	}

	public static int minpos(int[] array,int c){
		int a=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			if(array[i]==c){
				list.add(i);
			}
		}
		Collections.sort(list);
		return list.get(list.size()-1);
	}
	public static int maxpos(int[] array,int c){
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
			if(array[i]==c){
				list.add(i);
			}
		}
		Collections.sort(list);
		return list.get(0);
	}
	
}
