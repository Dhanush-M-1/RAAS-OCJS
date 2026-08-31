#include<bits/stdc++.h>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;

const int mod=10000;
char a[505],b[505];
int m;
int dp[501][500][10][2][2];//????????????m??§?????£??????????????°??????????????????????¢?????????????????°?????????????n??¨?????´?????????????????´?????????

int check(char *n){//n??\???????????°??¶??°??°
	int i;
	for(i=0;i<501;i++) for(int j=0;j<500;j++) for(int k=0;k<10;k++) for(int r=0;r<2;r++) for(int l=0;l<2;l++) dp[i][j][k][r][l]=0;
	for(i=1;n[i+1]!=0;i++) for(int k=1;k<10;k++) for(int r=0;r<2;r++) dp[i][k%m][k][r][0]=1;
	for(int k=1;k<10;k++) dp[i][k%m][k][0][0]=1;
	for(i=1;i<n[0]-48;i++) dp[0][i%m][i][1][0]=dp[0][i%m][i][0][0]=1;
	dp[0][(n[0]-48)%m][n[0]-48][0][1]=dp[0][(n[0]-48)%m][n[0]-48][1][1]=1;
	for(i=0;n[i+1]!=0;i++) for(int j=0;j<m;j++) for(int k=0;k<10;k++){
		for(int z=0;z<10;z++){
			if(k==z) continue;
			dp[i+1][(j*10+z)%m][z][z>k][0]+=dp[i][j][k][z<k][0];
			if(n[i+1]-48==z) dp[i+1][(j*10+z)%m][z][z>k][1]+=dp[i][j][k][z<k][1];
			if(n[i+1]-48>z)  dp[i+1][(j*10+z)%m][z][z>k][0]+=dp[i][j][k][z<k][1];
			dp[i+1][(j*10+z)%m][z][z>k][0]%=10000;
		}
	}
	int res=0;
	if(i==0){
		for(int j=1;j<=n[0]-48;j++) if(j%m==0) res++;
		return res;
	}
	for(int k=0;k<10;k++) for(int r=0;r<2;r++) for(int l=0;l<2;l++){ res+=dp[i][0][k][r][l]; res%=10000;}
	return res%10000;
}

int zig(char *n){//n????????°??¶??°?????????
	if(n[1]==0) return 1;
	if(n[0]==n[1]) return 1;
	bool c=n[0]<n[1];
	for(int i=1;n[i+1]!=0;i++) if((n[i]<n[i+1])==c||n[i]==n[i+1]) return 0; else c=n[i]<n[i+1];
	return 1;
}

int main(){
	scanf("%s%s%d",a,b,&m);
	printf("%d\n",(check(b)-check(a)+zig(a)+10000)%10000);
}