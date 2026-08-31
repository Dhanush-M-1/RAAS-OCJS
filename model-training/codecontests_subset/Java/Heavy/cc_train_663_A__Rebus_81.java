import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.TreeMap;
public class Main {
	public static Scanner in=new Scanner(System.in);
	public static int nn[]=new int[110];
	public static int jiaNum=1;
	public static int jianNum=0;
	public static int num=0;
	public static int wen=0;
	public static int i=0;
	public static int f(String s,int z,int sum,int temp){
		if(z==wen){
			if(sum==num){
				System.out.println(s+" = "+num);
				return 1;
			}
			else return 0;
		}
		else{
			if(nn[z]>0){
				for(int k=temp;k<=num;k++){
					if(z==0){if(f(s+Integer.toString(k),z+1,sum+k,temp)==1)return 1;}
					else{
						if(nn[z]==1){
							if(f(s+" + "+Integer.toString(k),z+1,sum+k,temp)==1)return 1;
						}
						else if(nn[z]==2){
							if(f(s+" - "+Integer.toString(k),z+1,sum-k,temp)==1)return 1;
						}
					}
				}
			}
			else{
				if(z==0){if(f(s+"1",z+1,sum+1,temp)==1)return 1;}
				else{
					if(nn[z]==-1){
						if(f(s+" + 1",z+1,sum+1,temp)==1)return 1;
					}
					else if(nn[z]==-2){
						if(f(s+" - 1",z+1,sum-1,temp)==1) return 1;
					}
				}
			}
		}
		return 0;
	}
	public static void main(String[] args){
		String s="";
		s=in.nextLine();
		nn[0]=1;
		for(i=0;i<s.length()&&s.charAt(i)!='=';i++){
			if(s.charAt(i)=='?')wen++;
			else if(s.charAt(i)=='+'){
				nn[wen]=1;
				jiaNum++;
			}
			else if(s.charAt(i)=='-'){
				nn[wen]=2;
				jianNum++;
			}
		}
		num=Integer.parseInt(s.substring(i+2,s.length()));
		if((num+jianNum)>=jiaNum&&(num+jianNum)<=num*jiaNum){
			for(i=0;i<wen;i++){
				if(nn[i]==2)nn[i]=-2;
			}
			System.out.println("Possible");
			f("",0,0,(num+jianNum)/jiaNum);
		}
		else{
			if((jiaNum-num)>=jianNum&&(jiaNum-num)<=num*jianNum){
				for(i=0;i<wen;i++){
					if(nn[i]==1)nn[i]=-1;
				}
				System.out.println("Possible");
				f("",0,0,(jiaNum-num)/jianNum);
			}
			else{
				System.out.println("Impossible");
			}
		}
	}
}
