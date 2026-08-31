#include<bits/stdc++.h>
using namespace std;
#define rep(i,n) for(int i=0; i<(n); i++)
const int MX = 100005;
int x, k, r[MX], q, t, a;
struct Sand{int xl, xr, yl, yr;} sd[MX][18];
int calc(Sand& a, int x){return min(a.yr, a.yl + max(0,x-a.xl));}
int rcalc(Sand& a, int y){return min(a.xr, a.xl + max(0,y-a.yl));}
Sand merge(Sand& a, Sand& b){
	int ml = max(b.xl,a.yl), mr = min(b.xr,a.yr);
	return (Sand){rcalc(a,ml),rcalc(a,mr),calc(b,ml),calc(b,mr)};
}
int main(){
	scanf("%d%d", &x, &k);
	rep(i,k){
		scanf("%d", r+i+1);
		int dr = r[i+1] - r[i];
		if(i&1) sd[i][0] = (Sand){0,max(0,x-dr),min(x,dr),x};
		else sd[i][0] = (Sand){min(x,dr),x,0,max(0,x-dr)};
	}
	for(int j = 1; j < 18; j++) rep(i,k) if(i + (1<<j) <= k){
		sd[i][j] = merge(sd[i][j-1],sd[i+(1<<(j-1))][j-1]);
	}
	scanf("%d", &q);
	rep(i,q){
		scanf("%d%d", &t, &a);
		int it = (int)(upper_bound(r,r+k+1,t) - r)-1, c = 0;
		for(int j = 0; it >> j; j++) if(it>>j&1){
			a = calc(sd[c][j],a);
			c += 1 << j;
		}
		if(it&1) a = min(x,a+t-r[it]);
		else a = max(0,a-(t-r[it]));
		printf("%d\n", a);
	}
}