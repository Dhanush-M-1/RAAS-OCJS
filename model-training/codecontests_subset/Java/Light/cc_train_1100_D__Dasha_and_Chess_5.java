import java.util.*;
import java.io.*;
public class Main{
	static Scanner in=new Scanner(System.in);
	static int X,Y;
	static int x[]=new int[668],y[]=new int[668];
	static boolean b[][]=new boolean[1001][1001];
	static void Go(int nx,int ny){
		while(X!=nx||Y!=ny){
			if(X<nx)++X;else if(X>nx)--X;
			if(Y<ny&&!b[X][Y+1])++Y;
			if(Y>ny&&!b[X][Y-1])--Y;
			System.out.println(X+" "+Y);
			System.out.flush();
			int k=in.nextInt(),xx=in.nextInt(),yy=in.nextInt();
			if(k<1)System.exit(0);
			b[x[k]][y[k]]=false;x[k]=xx;y[k]=yy;
			b[xx][yy]=true;
		}
	}
	public static void main(String args[]){
		X=in.nextInt();Y=in.nextInt();
		for(int i=1;i<=999;++i)
		for(int j=1;j<=999;++j)b[i][j]=false;
		for(int i=1;i<=666;++i){
			x[i]=in.nextInt();
			y[i]=in.nextInt();
			b[x[i]][y[i]]=true;
		}
		Go(500,500);
		int ct1=0,ct2=0,ct3=0,ct4=0;
		for(int i=1;i<=666;++i)
		if(x[i]<500&&y[i]<500)++ct1;else
		if(x[i]<500&&y[i]>500)++ct2;else
		if(x[i]>500&&y[i]<500)++ct3;else ++ct4;
		if(ct1<=ct2&&ct1<=ct3&&ct1<=ct4)Go(999,999);
		if(ct2<=ct1&&ct2<=ct3&&ct2<=ct4)Go(999,1);
		if(ct3<=ct1&&ct3<=ct2&&ct3<=ct4)Go(1,999);
		if(ct4<=ct1&&ct4<=ct2&&ct4<=ct3)Go(1,1);
	}
}