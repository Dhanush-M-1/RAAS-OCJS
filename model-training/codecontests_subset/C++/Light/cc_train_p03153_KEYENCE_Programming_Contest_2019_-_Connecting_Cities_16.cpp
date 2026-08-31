#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<(int)(n);i++)
#define rep1(i,n) for(int i=1;i<=(int)(n);i++)
#define all(c) c.begin(),c.end()
#define pb push_back
#define fs first
#define sc second
#define show(x) cout << #x << " = " << (x) << endl
#define chmin(x,y) x=min(x,y)
#define chmax(x,y) x=max(x,y)
using namespace std;
template<class S,class T> ostream& operator<<(ostream& o,const pair<S,T> &p){
	return o<<"("<<p.fs<<","<<p.sc<<")";
}
template<class T> ostream& operator<<(ostream& o,const vector<T> &vc){
	o<<"{";
	for(const T& v:vc) o<<v<<",";
	o<<"}";
	return o;
}
using ll = long long;
template<class T> using V = vector<T>;
template<class T> using VV = vector<vector<T>>;
int N;
ll D;
ll A[200010];
using P = pair<int,int>;
using PP = pair<ll,P>;
struct UnionFind{
	vector<int> par;
	UnionFind(int N){
		par.assign(N,0);
		rep(i,N) par[i]=i;
	}
	int find(int x){
		if(par[x]==x) return x;
		return par[x]=find(par[x]);
	}
	bool same(int x,int y){
		return find(x)==find(y);
	}
	void unite(int x,int y){
		x=find(x),y=find(y);
		if(x==y) return;
		par[y]=x;
	}
};
vector<PP> es;
ll inf = 1e18;
void solve(int l,int r){
	if(r-l==1) return;
	int m = (l+r)/2;
	solve(l,m);
	solve(m,r);
	{
		ll bestl = inf;
		int agl = -1;
		for(int i=l;i<m;i++){
			ll cost = -i*D+A[i];
			if(bestl>cost){
				bestl = cost;
				agl = i;
			}
		}
		int agr = -1;
		ll bestr = inf;
		for(int i=m;i<r;i++){
			ll cost = i*D+A[i];
			if(bestr>cost){
				bestr = cost;
				agr = i;
			}
		}

		for(int i=l;i<m;i++){
			es.pb(PP(-i*D+A[i]+bestr,P(i,agr)));
		}
		for(int i=m;i<r;i++){
			es.pb(PP(i*D+A[i]+bestl,P(i,agl)));
		}
	}
}
int main(){
	cin>>N>>D;
	rep(i,N) cin>>A[i];
	solve(0,N);
	sort(all(es));
	UnionFind UF(N);
	ll ans = 0;
	for(PP e:es){
		ll c = e.fs;
		int x = e.sc.fs, y = e.sc.sc;
		if(!UF.same(x,y)){
			UF.unite(x,y);
			ans += c;
		}
	}
	cout<<ans<<endl;
}