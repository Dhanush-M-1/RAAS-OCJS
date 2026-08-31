#include <bits/stdc++.h>
using namespace std;
#define REP(i,n) FOR(i, 0, n)
#define FOR(i,a,b) for(int i=a;i<b;i++)
#ifdef LOCAL
#define DEBUG(...) printf(__VA_ARGS__)
#else
#define DEBUG(...)
#endif

#define MOD 10000
#define N 512
int m;
int memo[N][2][3][10][3][N];
char a[3][N];
int k;
// bool debug=false;

int DP(int, int, int, int, int, int);
int dp(int p, int q, int r, int s, int t, int u){
	if(~memo[p][q][r][s][t][u]) return memo[p][q][r][s][t][u];
	else return memo[p][q][r][s][t][u]=DP(p, q, r, s, t, u);
	// return DP(p, q, r, s, t, u);
}
// digit count, leading zero, constrain,     before, next none/up/down, mod
int DP(int p, int q, int r,    int s, int t, int u){
	int ret=0;
	if(p==0){
		if(u==0){
		 	ret=1;
		}else ret=0;
	}else{
		if(q){
			REP(i, 10){
				if(i>a[r][k-p]) continue;
					// printf(" (%d, %d)->(%d, %d)\n", p, u, p-1, u*10+i);
				ret+=dp(p-1, i==0, i<a[r][k-p]?2:r, i, 0, i%m);
			}
		}else{
			if(t==0){
				REP(i, 10){
					if(i==s) continue;
					if(i>a[r][k-p]) continue;
					ret+=dp(p-1, q, i<a[r][k-p]?2:r, i, s>i?1:2, (u*10+i)%m);
				}
			}else if(t==1){
				FOR(i, s+1, 10){
					if(i>a[r][k-p]) continue;
					ret+=dp(p-1, q, i<a[r][k-p]?2:r, i, 2, (u*10+i)%m);
				}
			}else{
				REP(i, s){
					if(i>a[r][k-p]) continue;
					ret+=dp(p-1, q, i<a[r][k-p]?2:r, i, 1, (u*10+i)%m);
				}
			}
		}
	}
	ret%=MOD;
	return ret;
}

int main(){
	scanf("%s%s%d", a[0], a[1], &m);
	int x[2];
	REP(i, 2){
		x[i]=strlen(a[i]);
		REP(j, x[i]) a[i][j]-='0';
	}
	REP(i, N) a[2][i]=9;
	REP(h, N) REP(i, 2) REP(j, 3) REP(f, 10) REP(l, 3) REP(g, N)
	 	memo[h][i][j][f][l][g]=-1;
	k=x[0];
	int p=dp(k, 1, 0, 0, 0, 0);
	// debug=true;
	REP(h, N) REP(i, 2) REP(j, 3) REP(f, 10) REP(l, 3) REP(g, N)
	 	memo[h][i][j][f][l][g]=-1;
	k=x[1];
	int q=dp(k, 1, 1, 0, 0, 0);
	int r=0;
	REP(j, 2){
		bool ok=true;
		REP(i, x[0]-1){
			if((i+j)%2==0 && a[0][i]>=a[0][i+1]) ok=false;
			if((i+j)%2==1 && a[0][i]<=a[0][i+1]) ok=false;
		}
		if(ok) r=1;
	}
	int buf=0;
	REP(i, x[0]){
		buf*=10;
		buf+=a[0][i];
		buf%=m;
	}
	if(buf) r=0;
	int ans=(q-p+r+MOD*100)%MOD;
	printf("%d\n", ans);
}