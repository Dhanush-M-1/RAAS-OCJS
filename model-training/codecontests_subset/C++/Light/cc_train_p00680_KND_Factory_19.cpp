#include<stdio.h>
#include<algorithm>
#include<string.h>
#include<queue>
#include<vector>
using namespace std;
namespace MCF {
	// required <string.h> <vector> <queue> <algorithm>
	#define MAXN 110
	#define MAXM 30000
	#define wint int
	#define cint long double
	const wint wEPS = 0;
	const wint wINF = 1001001001;
	const cint cEPS = 1e-7L;
	const cint cINF = 1e10L;
	int n, m, ptr[MAXN], next[MAXM], zu[MAXM];
	wint capa[MAXM], tof;
	cint cost[MAXM], toc, d[MAXN], pot[MAXN];
	int vis[MAXN], pree[MAXN];
	void init(int _n) {
		n = _n; m = 0; memset(ptr, ~0, n * 4);
	}
	void ae(int u, int v, wint w, cint c) {
		next[m] = ptr[u]; ptr[u] = m; zu[m] = v; capa[m] = w; cost[m] = +c; ++m;
		next[m] = ptr[v]; ptr[v] = m; zu[m] = u; capa[m] = 0; cost[m] = -c; ++m;
	}
	bool solve(int src, int ink, wint flo = wINF) {
		int i, u, v;
		wint f;
		cint c, cc;
		memset(pot, 0, n * sizeof(cint));
		//*
		for (bool cont = 1; cont; ) {
			cont = 0;
			for (u = 0; u < n; ++u) for (i = ptr[u]; ~i; i = next[i]) if (capa[i] > wEPS) {
				if (pot[zu[i]] > pot[u] + cost[i] + cEPS) {
					pot[zu[i]] = pot[u] + cost[i]; cont = 1;
				}
			}
		}
		//*/
		for (toc = 0, tof = 0; tof + wEPS < flo; ) {
			typedef pair<cint,int> node;
			priority_queue< node,vector<node>,greater<node> > q;
			for (u = 0; u < n; ++u) { d[u] = cINF; vis[u] = 0; }
			for (q.push(make_pair(d[src] = 0, src)); !q.empty(); ) {
				c = q.top().first; u = q.top().second; q.pop();
				if (vis[u]++) continue;
				for (i = ptr[u]; ~i; i = next[i]) if (capa[i] > wEPS) {
					cc = c + cost[i] + pot[u] - pot[v = zu[i]];
					if (d[v] > cc + cEPS) { q.push(make_pair(d[v] = cc, v)); pree[v] = i; }
				}
			}
			if (!vis[ink]) return 0;
			f = flo - tof;
			for (v = ink; v != src; v = zu[i ^ 1]) { i = pree[v]; f=min(f,capa[i]); }
			for (v = ink; v != src; v = zu[i ^ 1]) { i = pree[v]; capa[i] -= f; capa[i ^ 1] += f; }
			tof += f;
			toc += f * (d[ink] - pot[src] + pot[ink]);
			for (u = 0; u < n; ++u) pot[u] += d[u];
		}
		return 1;
	}
}
const long double EPS=1e-10L;
typedef vector<long double>vec;
typedef vector<vec>mat;
long double ABS(long double a){return max(a,-a);}
vec gauss_jordan(const mat &A,const vec &b){
	int n=A.size();
	mat B(n,vec(n+1));
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)B[i][j]=A[i][j];
	for(int i=0;i<n;i++)B[i][n]=b[i];
	for(int i=0;i<n;i++){
		int pivot=i;
		for(int j=i;j<n;j++){
			if(ABS(B[j][i])>ABS(B[pivot][i]))pivot=j;
		}
		swap(B[i],B[pivot]);
		if(ABS(B[i][i])<EPS)return vec();
		for(int j=i+1;j<=n;j++)B[i][j]/=B[i][i];
		for(int j=0;j<n;j++){
			if(i!=j){
				for(int k=i+1;k<=n;k++)B[j][k]-=B[j][i]*B[i][k];
			}
		}
	}
	vec x(n);
	for(int i=0;i<n;i++)x[i]=B[i][n];
	return x;
}
int t1[110];
int t2[110];
int main(){
	int T;scanf("%d",&T);
	while(T--){
		int a,b,c,d;
		scanf("%d%d%d%d",&a,&b,&c,&d);
		mat A(a,vec(a));
		vec B(a);
		for(int i=0;i<a;i++){
			for(int j=0;j<a;j++){
				scanf("%Lf",&A[i][j]);
			}
			scanf("%Lf",&B[i]);
		}
		vec C=gauss_jordan(A,B);
	//s	for(int i=0;i<a;i++)printf("%Lf ",C[i]);
		MCF::init(a);
		for(int i=0;i<a;i++){
			int p;scanf("%d",&p);
			for(int j=0;j<p;j++){
				scanf("%d",t1+j);
			}
			for(int j=0;j<p;j++)scanf("%d",t2+j);
			for(int j=0;j<p;j++)MCF::ae(i,t1[j],t2[j],ABS(C[i]-C[t1[j]]));
		}
		int res=MCF::solve(b,c,d);
		if(!res)printf("impossible\n");
		else printf("%.12Lf\n",MCF::toc);
	}
}