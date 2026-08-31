import java.io.*;
import java.util.*;
import java.lang.*;
public class A339{
        public static void main(String[] args){
                Scanner in=new Scanner(System.in);
		String inp=in.nextLine();
		int count1=0,count2=0,count3=0;
		String kq="";
		for(int i=0;i<inp.length();i++){
			char temp=inp.charAt(i);
			if(temp=='1') count1++;
			if(temp=='2') count2++;
			if(temp=='3') count3++;			
		}
		//System.out.println(count1+"   "+count2+"    "+count3);
		int sum123=count1+count2+count3;
		if(sum123==1)	System.out.println(inp);
		else {
			for(int i=sum123;i>0;i--){
				if(count1!=0){
					kq+="1+";
					count1--;
				}
				if(count1==0 && count2!=0){
					kq+="2+";
					count2--;
				}
				if(count1==0 && count2==0 && count3!=0){
					kq+="3+";
					count3--;}
			}
		}
		for(int i=0;i<(kq.length()-1);i++){
			System.out.print(kq.charAt(i));	
		}
	}
}
