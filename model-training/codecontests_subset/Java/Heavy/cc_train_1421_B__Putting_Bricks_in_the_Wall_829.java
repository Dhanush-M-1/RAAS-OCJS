import java.io.*;
import java.util.*;
public class PushingBricksInTheWall{
	public static void main(String args[]){
		Scanner Sc=new Scanner(System.in);
		int T=Sc.nextInt();
		for(int i=0;i<T;i++){
			int N=Sc.nextInt();
			char [][]grid=new char[N][N];
			for(int j=0;j<N;j++){
				String inputLine=Sc.next();
				for(int k=0;k<N;k++){
					grid[j][k]=inputLine.charAt(k);
				}
			}
			int count=0;
			int p1x=-1;
			int p1y=-1;
			int p2x=-1;
			int p2y=-1;
			char SR=grid[0][1];//right of start
			char SD=grid[1][0];//down of start
			char FU=grid[N-2][N-1];//up of finish
			char FL=grid[N-1][N-2];//left of finish
			if(SR==SD){
				if(FU==SR){
					count++;
					//System.out.println("1");
					p1x=N-1;
					p1y=N;
					//FU=(FU==1)?0:1;
				}
				if(FL==SR){
				    //System.out.println("2");
					count++;
					p2x=N;
					p2y=N-1;
					//FL=(FL==1)?0:1;
				}
			}else if(FL==FU){
				if(SR==FL){
				    //System.out.println("3");
					count++;
					p1x=1;
					p1y=2;
					//SR=(SR==1)?0:1;	
				}
				if(SD==FL){
				    //System.out.println("4");
					count++;
					p2x=2;
					p2y=1;
					//SR=(SR==1)?0:1;	
				}
			}else{
				if(SR!='1'){
				    //System.out.println("5");
					count++;
					p1x=1;
					p1y=2;
				}
				if(SD!='1'){
				    //System.out.println("6");
					count++;
					p1x=2;
					p1y=1;	
				}
				if(FU!='0'){
				    //System.out.println("7");
					count++;
					p2x=N-1;
					p2y=N;	
				}
				if(FL!='0'){
				    //System.out.println("8");
					count++;
					p2x=N;
					p2y=N-1;	
				}
			}
			if(count==0){
				System.out.println("0");
			}else if(count==1){
				System.out.println(count);
				if(p1x!=-1){
					System.out.println(p1x+" "+p1y);
				}else{
					System.out.println(p2x+" "+p2y);
				}
			}else{
				System.out.println(count);
				System.out.println(p1x+" "+p1y);
				System.out.println(p2x+" "+p2y);
			}
		}
	}
}