#include<bits/stdc++.h>
using namespace std;
#define maxn 400020
#define rep(i,l,r) for(register int i = l ; i <= r ; i++)
#define repd(i,r,l) for(register int i = r ; i >= l ; i--)
#define rvc(i,S) for(register int i = 0 ; i < (int)S.size() ; i++)
#define rvcd(i,S) for(register int i = ((int)S.size()) - 1 ; i >= 0 ; i--)
#define fore(i,x)for (register int i = head[x] ; i ; i = e[i].next)
#define pb push_back
#define prev prev_
#define stack stack_
#define mp make_pair
#define fi first
#define se second
#define inf 1e18
#define lowbit(x) (x&(-x))
typedef long long ll;
typedef pair<ll,int> pr;

struct node{
	int x,y; ll w;
	bool operator < (node a)const{
		return w < a.w;
	}
}dt[maxn];
int fa[maxn],n,a[maxn],rec[maxn],D,tot;
ll b[maxn],c[maxn],ans;
pr mn[maxn];

inline pr query(int id){
	pr res (inf,0);
	for (int i = id ; i ; i -= lowbit(i)){
		if ( mn[i].fi < res.fi ) res = mn[i];
	}
	return res;
}
inline void modify(int id,pr cur){
	for (int i = id ; i <= n ; i += lowbit(i)){
		if ( mn[i].fi > cur.fi ) mn[i] = cur;
	}
}
void init(){
	sort(rec + 1,rec + n + 1);
	rep(i,1,n) a[i] = lower_bound(rec + 1,rec + n + 1,a[i]) - rec;
	rep(i,1,n) mn[i] = mp(inf,0);
	rep(i,1,n){
		pr cur = query(a[i] - 1);
		if ( cur.se ) dt[++tot] = (node){i,cur.se,(ll)D * i + rec[a[i]] + cur.fi};
		modify(a[i],mp((ll)-D * i + rec[a[i]],i));
	}
	rep(i,1,n) mn[i] = mp(inf,0);
	repd(i,n,1){
		pr cur = query(a[i]);
		if ( cur.se ) dt[++tot] = (node){i,cur.se,(ll)-D * i + rec[a[i]] + cur.fi};
		modify(a[i],mp((ll)D * i + rec[a[i]],i));
	}
}
int getfa(int x){ return x == fa[x] ? x : fa[x] = getfa(fa[x]); }
int main(){
	scanf("%d %d",&n,&D);
	rep(i,1,n) scanf("%d",&a[i]) , rec[i] = a[i] ,  b[i] = (ll)a[i] + (ll)D * i , c[i] = (ll)a[i] - (ll)D * i;
	init();
	sort(dt + 1,dt + tot + 1);
	for (int i = 1 ; i <= n ; i++) fa[i] = i;
	rep(i,1,tot){
		int x = dt[i].x , y = dt[i].y;
		int p = getfa(x) , q = getfa(y);
		if ( p != q ){
			ans += dt[i].w;
			fa[p] =q;
		}
	}
	cout<<ans<<endl;
}
