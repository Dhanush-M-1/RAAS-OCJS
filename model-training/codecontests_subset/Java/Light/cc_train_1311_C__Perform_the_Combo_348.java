
import java.util.*;
public class dmecA_B_and_team_training {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tn = scn.nextInt();
		
		while(tn-->0){
			for(int i=0;i<2;i++){
				
			}
			int n=scn.nextInt();
			int m=scn.nextInt();
					String srr=scn.next();
			int marr[]=new int[srr.length()];
			for(int i=0;i<m;i++){
				int ind=scn.nextInt();
				marr[ind]+=1;
			}
for(int i=0;i<2;i++){
				
			}
			int str=marr[srr.length()-1];
			marr[srr.length()-1]=1;
			for(int i=srr.length()-2;i>=0;i--){
				int ss=marr[i];
				marr[i]=str+marr[i+1];
				str=ss;
			}
			
			int mans[]=new int[26];
			for(int i=0;i<marr.length;i++){
				char c=srr.charAt(i);
				mans[c-'a']+=marr[i];
			}
for(int i=0;i<2;i++){
				
			}
			for(int i=0;i<26;i++){
				System.out.print(mans[i]+" ");
			}
			System.out.println();
			 

		}
	}
}