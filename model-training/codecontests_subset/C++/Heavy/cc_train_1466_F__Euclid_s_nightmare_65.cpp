/*
	Coded with Leachim's ACM Template.
	No errors. No warnings. ~~
*/
#include <bits/stdc++.h>
#pragma GCC diagnostic ignored "-Wunused-const-variable"
#pragma GCC diagnostic ignored "-Wsign-conversion"
#pragma GCC diagnostic ignored "-Wsign-compare"
#define LL long long
using namespace std;
const int inf=0x3f3f3f3f;
const LL INF=0x3f3f3f3f3f3f3f3f;
const double eps=1e-7;
const int dx[4]={1,-1,0,0};
const int dy[4]={0,0,1,-1};
const int RT=3;
const int MOD=1e9+7;
const int MAXN=500005;

int binpow(int x,int y,int m) {
	int r=1%m;
	while(y) {
		if(y&1) r=1LL*r*x%m;
		x=1LL*x*x%m;
		y>>=1;
	}
	return r;
}

struct edge {
	int to,next,w;
}e[MAXN<<1];

int tot,head[MAXN];

void add(int x,int y,int w) {
	tot++;
	e[tot].to=y;
	e[tot].next=head[x];
	e[tot].w=w;
	head[x]=tot;
}

int fa[MAXN];

vector<int> v;

int a[MAXN];

void dfs(int x,int f) {
	a[x]=-1;
	for(int p=head[x];p;p=e[p].next) {
		int u=e[p].to;
		if(a[u]==-1) continue;
		dfs(u,x);
	}
}

int find(int x) {
	if(fa[x]==x)return x;
	return fa[x]=find(fa[x]);
}

void join(int x,int y) {
	fa[find(x)]=find(y);
}


int x[MAXN],y[MAXN];

void get(int t,int i) {
	if(!a[t]) {
		a[t]=-1;
		v.push_back(i);
	} else if(a[t]!=-1) {
		v.push_back(i);
		dfs(t,t);
	}
}


void solve() {
	int n,m;
	scanf("%d %d", &n, &m);
	memset(a+1,0,m*sizeof(a[0]));
	for(int i=1;i<=m;i++) fa[i]=i;
	for(int i=1;i<=n;i++) {
		int k;
		scanf("%d", &k);
		if(k==1) {
			int x;
			scanf("%d", &x);
			get(x,i);
		} else {
			scanf("%d %d", &x[i], &y[i]);
			if(!a[x[i]] && !a[y[i]]) {
				v.push_back(i);
				a[x[i]]=a[y[i]]=i;
				join(x[i],y[i]);
				add(x[i],y[i],i);
				add(y[i],x[i],i);
			} else if(a[x[i]]==-1) {
				get(y[i],i);
			} else if(a[y[i]]==-1) {
				get(x[i],i);
			} else if(!a[x[i]]) {
				v.push_back(i);
				join(x[i],y[i]);
				add(x[i],y[i],i);
				add(y[i],x[i],i);
				a[x[i]]=i;
			} else if(!a[y[i]]) {
				v.push_back(i);
				join(x[i],y[i]);
				add(x[i],y[i],i);
				add(y[i],x[i],i);
				a[y[i]]=i;
			} else {
				if(find(x[i])!=find(y[i])) {
					v.push_back(i);
					join(x[i],y[i]);
					add(x[i],y[i],i);
					add(y[i],x[i],i);
				}

			}
		}
	}
	printf("%d %lu\n", binpow(2,v.size(),MOD), v.size());
	for(auto x:v) {
		printf("%d ", x);
	}
	puts("");
}

int main() {
	int T=1,cas=1;(void)(cas);
	// scanf("%d", &T);
	while(T--) {
		// printf("Case #%d: ", cas++);
		solve();
	}
	return 0;
}