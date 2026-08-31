#include<stdio.h>
#include<algorithm>
#include<string.h>
using namespace std;
char A[1100];
char B[1100];
int mod=10000;
short int dp[2][520][3][11][11];
char tc[1100];
int c;
int calc(){
	int n=strlen(tc);
	for(int i=0;i<2;i++)for(int j=0;j<520;j++)for(int k=0;k<3;k++)
		for(int l=0;l<11;l++)for(int m=0;m<11;m++)
			dp[i][j][k][l][m]=0;
	dp[0][0][1][10][10]=1;
	int ret=0;
	for(int i=0;i<n;i++){
		int t=i%2;
		for(int j=0;j<520;j++)for(int k=0;k<3;k++)
		for(int l=0;l<11;l++)for(int m=0;m<11;m++)
			dp[!t][j][k][l][m]=0;
		for(int j=0;j<c;j++){
			for(int k=0;k<3;k++)for(int l=0;l<11;l++)for(int m=0;m<11;m++){
				if(!dp[t][j][k][l][m])continue;
				for(int n=0;n<10;n++){
					if(i==0&&n==0)continue;
					if(m==n)continue;
					int tm=(j*10+n)%c;
					int tk=k;
					if(tk==1&&n<tc[i]-'0')tk=0;
					if(tk==1&&n>tc[i]-'0')tk=2;
					if(l<10&&m<10&&(l-m)*(n-m)<=0)continue;
					dp[!t][tm][tk][m][n]=(dp[!t][tm][tk][m][n]+dp[t][j][k][l][m])%mod;
				}
			}
		}
		for(int j=0;j<3;j++){
			for(int k=0;k<11;k++)for(int l=0;l<11;l++){
				if(i+1==n&&j==2)continue;
				ret=(ret+dp[!t][0][j][k][l])%mod;
			}
		}
	}
	return ret;
}
int main(){
	scanf("%s%s",A,B);
	scanf("%d",&c);
	for(int i=0;i<1100;i++)tc[i]=B[i];
	int ret=calc();
	for(int i=0;i<1100;i++)tc[i]=A[i];
	ret=(ret+mod-calc())%mod;
	int now=0;
	bool ok=true;
	for(int i=0;A[i];i++){
		now*=10;
		now+=A[i]-'0';
		now%=c;
		if(i>=1&&A[i]==A[i-1])ok=false;
		if(i>=2&&(A[i]-A[i-1])*(A[i-2]-A[i-1])<=0){
			ok=false;
		}
	}
	if(ok&&now==0)ret=(ret+1)%mod;
	printf("%d\n",ret);
}