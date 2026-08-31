#include<stdio.h>
#include<string.h>
#define M 10000
int dp[2][2][10][500];
char a[501];
char b[501];
int m;
int solve(char s[],bool cont){
	memset(dp,0,sizeof(dp));
	int n=strlen(s);
	int i,j,k,l;
	int pre=2,cur=2;
	int mm=0;
	bool use=true;
	int d=s[0]-'0';
	for(i=1;i<d;i++){
		dp[0][0][i][i%m]=1;
		dp[0][1][i][i%m]=1;
	}
	mm=d%m;
	if(n==1){
		int ans=0;
		for(i=1;i<d;i++)if(i%m==0)ans++;
		if(cont&&mm==0)ans++;
		return ans;
	}
	for(i=1;i<n;i++){
		for(j=0;j<2;j++)for(k=0;k<10;k++)for(l=0;l<m;l++)dp[i%2][j][k][l]=0;
		for(j=1;j<10;j++){
			dp[i%2][0][j][j%m]=1;
			dp[i%2][1][j][j%m]=1;
		}
		for(j=0;j<10;j++){
			for(k=0;k<m;k++){
				for(l=0;l<j;l++)dp[i%2][0][l][(k*10+l)%m]=(dp[i%2][0][l][(k*10+l)%m]+dp[(i+1)%2][1][j][k])%M;
				for(l=j+1;l<10;l++)dp[i%2][1][l][(k*10+l)%m]=(dp[i%2][1][l][(k*10+l)%m]+dp[(i+1)%2][0][j][k])%M;
			}
		}
		if(use){
			d=s[i]-'0';
			for(j=0;j<d;j++){
				if(cur==1||cur==2)if(j<s[i-1]-'0')dp[i%2][0][j][(mm*10+j)%m]++;
				if(cur==-1||cur==2)if(j>s[i-1]-'0')dp[i%2][1][j][(mm*10+j)%m]++;
			}
			pre=cur;
			if(s[i]>s[i-1])cur=1;
			else if(s[i]<s[i-1])cur=-1;
			else cur=0;
			if(pre==cur||cur==0)use=false;
		}
		mm=(mm*10+d)%m;
	}
	int ans=0;
	for(i=0;i<10;i++){
		ans+=dp[(n+1)%2][0][i][0];
		ans+=dp[(n+1)%2][1][i][0];
		if(i>=1&&i%m==0)ans--;
	}
	if(use&&cont&&mm==0)ans++;
	return ans%M;
}
int main(){
	scanf(" %s",a);
	scanf(" %s",b);
	scanf("%d",&m);
	int p=solve(a,false);
	int q=solve(b,true);
	printf("%d\n",(q-p+M)%M);
	return 0;
}