#include <cstdio>
#include <cstring>
using namespace std;
int dp[501][10][3][2][500];
char a[502],b[502],*s;
int alen,blen,slen,m;
int solve(int n,int pv,int ud,int ok,int md) {
	if(n==slen)return !md;
	if(dp[n][pv][ud][ok][md]>=0)return dp[n][pv][ud][ok][md];
	int ret=0;
	for(int i=0;i<=(ok?9:s[n]-'0');i++) {
		if(ud==0 && pv<=i)continue;
		if(ud==1 && pv>=i)continue;
		if(ud==2 && pv!=0 && pv==i)continue;
		int u;
		if(ud==2) {
			if(pv==0)u=2;
			else if(pv>i)u=1;
			else u=0;
		}else{
			u=ud^1;
		}
		ret+=solve(n+1,i,u,ok||(i!=(s[n]-'0')),(md*10+i)%m);
	}
	return dp[n][pv][ud][ok][md]=ret%10000;
}
int main() {
	scanf("%s",a);
	alen=strlen(a);
	for(int i=alen-1;i>=0;i--) {
		if(a[i]>='1') {
			a[i]--;
			for(int j=i+1;j<alen;j++)a[j]='9';
			break;
		}
	}
	scanf("%s",b);
	blen=strlen(b);
	scanf("%d",&m);
	int aa,bb;
	s=b,slen=blen;
	memset(dp,-1,sizeof(dp));
	bb=solve(0,0,2,0,0);
	s=a,slen=alen;
	memset(dp,-1,sizeof(dp));
	aa=solve(0,0,2,0,0);
	printf("%d\n",(bb+10000-aa)%10000);
}