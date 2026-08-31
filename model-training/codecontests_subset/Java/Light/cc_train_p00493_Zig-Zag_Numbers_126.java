import java.util.*;
import java.math.*;
class Main{
	static int dp[][][][];
	static int dpA[][][][][];
	static int dpB[][][][][];
	public static void main(String[] args){
		int MOD=10000;
		Scanner s=new Scanner(System.in);
		BigInteger A=s.nextBigInteger();
		BigInteger B=s.nextBigInteger();
		int m=s.nextInt();
		dp=new int[501][m][2][10];//dp[i][j][k][l]:iÚÜÅÅm ÜéBÅãªªü«Ík=0Å«ü«Ík=1,Åãªl
		dpA=new int[2][m][2][10][2];//ÅãÌ1Fà¤¬³¢±Æªmèµ½ÌÅ¢­çÅà«µÄ¢¢Å·æ 0:¢ÜÜÅ¨ñÈ¶ÈñÅ·
		dpB=new int[2][m][2][10][2];
		
		A=A.add(new BigInteger("-1"));
		String a=A.toString();
		String b=B.toString();
		
		for(int i=0;i<501;i++)
			for(int j=0;j<m;j++)
				for(int k=0;k<2;k++)
					for(int l=0;l<10;l++)
						dp[i][j][k][l]=0;
		for(int i=1;i<10;i++){
			dp[0][i%m][0][i]++;
			dp[0][i%m][1][i]++;
		}
		for(int i=0;i<500;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<10;k++){
					dp[i][j][0][k]%=MOD;
					dp[i][j][1][k]%=MOD;
					for(int l=k+1;l<10;l++){
						dp[i+1][(j*10+l)%m][0][l]+=dp[i][j][1][k];
					}
					for(int l=0;l<k;l++){
						dp[i+1][(j*10+l)%m][1][l]+=dp[i][j][0][k];
					}
				}
			}
		}
		
		for(int i=0;i<2;i++)
			for(int j=0;j<m;j++)
				for(int k=0;k<2;k++)
					for(int l=0;l<10;l++)
						dpA[i][j][k][l][1]=dpA[i][j][k][l][0]=0;
		for(int i=1;i<a.charAt(0)-'0';i++){
			dpA[0][i%m][0][i][1]++;
			dpA[0][i%m][1][i][1]++;
		}
		if(a.charAt(0)!='0')dpA[0][(a.charAt(0)-'0')%m][0][(a.charAt(0)-'0')][0]++;
		if(a.charAt(0)!='0')dpA[0][(a.charAt(0)-'0')%m][1][(a.charAt(0)-'0')][0]++;
		for(int i=0;i<a.length()-1;i++){
			int t=i&1;
			for(int j=0;j<m;j++)
				for(int k=0;k<2;k++)
					for(int l=0;l<10;l++)
						dpA[t^1][j][k][l][0]=dpA[t^1][j][k][l][1]=0;
			for(int j=0;j<m;j++){
				for(int k=0;k<10;k++){
					dpA[t][j][0][k][0]%=MOD;
					dpA[t][j][1][k][0]%=MOD;
					dpA[t][j][0][k][1]%=MOD;
					dpA[t][j][1][k][1]%=MOD;
					for(int l=k+1;l<10;l++){
						dpA[t^1][(j*10+l)%m][0][l][1]+=dpA[t][j][1][k][1];
					}
					for(int l=0;l<k;l++){
						dpA[t^1][(j*10+l)%m][1][l][1]+=dpA[t][j][0][k][1];
					}
					for(int l=k+1;l<a.charAt(i+1)-'0';l++){
						dpA[t^1][(j*10+l)%m][0][l][1]+=dpA[t][j][1][k][0];
					}
					for(int l=0;l<Math.min(k,a.charAt(i+1)-'0');l++){
						dpA[t^1][(j*10+l)%m][1][l][1]+=dpA[t][j][0][k][0];
					}
					if(k<a.charAt(i+1)-'0')dpA[t^1][(j*10+a.charAt(i+1)-'0')%m][0][a.charAt(i+1)-'0'][0]+=dpA[t][j][1][k][0];
					if(k>a.charAt(i+1)-'0')dpA[t^1][(j*10+a.charAt(i+1)-'0')%m][1][a.charAt(i+1)-'0'][0]+=dpA[t][j][0][k][0];
				}
			}
		}
		int count=0;
		for(int i=0;i<a.length()-1;i++){
			for(int j=0;j<10;j++){
				count=(count+dp[i][0][0][j])%MOD;
				if(i>0)count=(count+dp[i][0][1][j])%MOD;
			}
		}
		for(int i=0;i<10;i++){
			int t=a.length()&1;
			if(a.length()>1){
				count=(count+dpA[t^1][0][0][i][0]+dpA[t^1][0][0][i][1])%MOD;
			}
			count=(count+dpA[t^1][0][1][i][0]+dpA[t^1][0][1][i][1])%MOD;
		}
	//	System.out.println(count);
		
		for(int i=0;i<2;i++)
			for(int j=0;j<m;j++)
				for(int k=0;k<2;k++)
					for(int l=0;l<10;l++)
						dpB[i][j][k][l][0]=dpB[i][j][k][l][1]=0;
		for(int i=1;i<b.charAt(0)-'0';i++){
			dpB[0][i%m][0][i][1]++;
			dpB[0][i%m][1][i][1]++;
		}
		dpB[0][(b.charAt(0)-'0')%m][0][(b.charAt(0)-'0')][0]++;
		dpB[0][(b.charAt(0)-'0')%m][1][(b.charAt(0)-'0')][0]++;
		for(int i=0;i<b.length()-1;i++){
			int t=i&1;
			for(int j=0;j<m;j++)
				for(int k=0;k<2;k++)
					for(int l=0;l<10;l++)
						dpB[t^1][j][k][l][0]=dpB[t^1][j][k][l][1]=0;
			for(int j=0;j<m;j++){
				for(int k=0;k<10;k++){
					dpB[t][j][0][k][0]%=MOD;
					dpB[t][j][1][k][0]%=MOD;
					dpB[t][j][0][k][1]%=MOD;
					dpB[t][j][1][k][1]%=MOD;
			//		System.out.println(i+" "+j+" "+k+": "+"["+dpB[i][j][0][k][0]+","+dpB[i][j][0][k][1]+","+
			//		dpB[i][j][1][k][0]+","+dpB[i][j][1][k][1]+"]");
					for(int l=k+1;l<10;l++){
						dpB[t^1][(j*10+l)%m][0][l][1]+=dpB[t][j][1][k][1];
					}
					for(int l=0;l<k;l++){
						dpB[t^1][(j*10+l)%m][1][l][1]+=dpB[t][j][0][k][1];
					}
					for(int l=k+1;l<b.charAt(i+1)-'0';l++){
						dpB[t^1][(j*10+l)%m][0][l][1]+=dpB[t][j][1][k][0];
					}
					for(int l=0;l<Math.min(k,b.charAt(i+1)-'0');l++){
						dpB[t^1][(j*10+l)%m][1][l][1]+=dpB[t][j][0][k][0];
					}
					if(k<b.charAt(i+1)-'0')dpB[t^1][(j*10+b.charAt(i+1)-'0')%m][0][b.charAt(i+1)-'0'][0]+=dpB[t][j][1][k][0];
					if(k>b.charAt(i+1)-'0')dpB[t^1][(j*10+b.charAt(i+1)-'0')%m][1][b.charAt(i+1)-'0'][0]+=dpB[t][j][0][k][0];
				}
			}
		}
		int Count=0;
		for(int i=0;i<b.length()-1;i++){
			for(int j=0;j<10;j++){
				Count=(Count+dp[i][0][0][j])%MOD;
				if(i>0)Count=(Count+dp[i][0][1][j])%MOD;
	//			System.out.print(dp[i][0][0][j]+" ");
			}
	//		System.out.println();
		}
		for(int i=0;i<10;i++){
			int t=b.length()&1;
			if(b.length()>1){
				Count=(Count+dpB[t^1][0][0][i][0]+dpB[t^1][0][0][i][1])%MOD;
			}
			Count=(Count+dpB[t^1][0][1][i][0]+dpB[t^1][0][1][i][1])%MOD;
	//		System.out.print(dpB[b.length()-1][0][1][i][0]+dpB[b.length()-1][0][1][i][1]+dpB[b.length()-1][0][0][i][0]+dpB[b.length()-1][0][0][i][1]+" ");
		}
	//	System.out.println(Count);
		Count-=count;
		while(Count<0)Count+=10000;
		System.out.println(Count);
	}
}