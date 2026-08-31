import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	public static void main(String []args){
	Scanner s=new Scanner(System.in);
	String input=s.nextLine();
	String a[]=input.split(" ");
	int n=Integer.parseInt(a[a.length-1]),pos=0,neg=0,total;
	for(int i=0;i<a.length-2;i++){
		if(a[i].equals("+"))
			pos++;
		else if(a[i].equals("-"))
			neg++;
	}
	total=pos+neg+1;
	int x[]=new int[total];
	if(total==1)
		{System.out.println("Possible");
		System.out.println(n+" = "+n);
		}
	else if(pos==0||(total>n&&neg==0))
		System.out.println("Impossible");
	else{
		//pos--;
		total--;
		x[0]=n;
		int temp=pos-neg;
		
			int i=1;
			while(i<=total)
				x[i++]=1;
		if(total+1==n){
		x[0]=1;
		}
		else{
		if(temp>0){
			i=x.length-1;
			int count=0;
			while(temp>0){
				if(x[i]<n)
					x[i--]++;
				else
					{x[0]-=temp;
					temp=0;
					if(x[0]<=0)
						{
						System.out.println("Impossible");
						return ;
						}
					}
				temp--;
				count++;
				if(count==neg){
					i=x.length-1;
					count=0;
				}
			}
		}
		else{
			i=1;
			int count=0;
			temp*=-1;
			while(temp>0){
				if(x[i]<n)
					x[i++]++;
				else{
					System.out.println("Impossible");
					return;
				}
				temp--;
				count++;
				if(count==pos){
					i=1;
					count=0;
				}
			}
		}
		}
		System.out.println("Possible");
		int j=0,k=x.length-1;
		System.out.print(x[j++]+" ");
		for(i=0;i<a.length;i++){
			if(a[i].equals("+"))
				System.out.print("+ "+x[j++]+" ");
			else if(a[i].equals("-"))
				System.out.print("- "+x[k--]+" ");
			else if(!a[i].equals("?"))
				System.out.print(a[i]+" ");
		}
		
	}
	
	
	
	}
}