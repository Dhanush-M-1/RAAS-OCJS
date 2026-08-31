#include <bits/stdc++.h>
#define rep(i,n)for(int i=0;i<(n);i++)
#define MOD 1000000007
#define INF 0x3f3f3f3f
#define INFL 0x3f3f3f3f3f3f3f3f
using namespace std;
typedef long long ll;
typedef pair<ll,int>P;

class UnionFind {
	vector<int>par, sz;
public:
	UnionFind() {}
	UnionFind(int n) {
		par = sz = vector<int>(n);
		for (int i = 0; i < n; i++) {
			par[i] = i;
			sz[i] = 1;
		}
	}
	int find(int x) {
		if (par[x] == x)return x;
		return par[x] = find(par[x]);
	}
	void unite(int x, int y) {
		x = find(x); y = find(y);
		if (x == y)return;
		if (sz[x] > sz[y]) {
			par[y] = x;
			sz[x] += sz[y];
		}
		else {
			par[x] = y;
			sz[y] += sz[x];
		}
	}
	bool same(int x, int y) {
		return find(x) == find(y);
	}
	int size(int x) {
		return sz[find(x)];
	}
};

int n;ll d;
ll a[300000];
UnionFind uf;
ll mp[300000];

vector<P>loop(bool b){
	vector<P>res(n);
	rep(i,n)res[i]=P(INFL,-1),mp[i]=INFL;
	set<P>se;//コスト、連結成分
	rep(i,n){
		int id=(b?n-i-1:i);
		int p=uf.find(id);
		if(!se.empty()){
			auto it=se.begin();
			while(it!=se.end()&&it->second==p)it++;
			if(it!=se.end()){
				res[p]=min(res[p],P(d*i+it->first+a[i],it->second));
			}
		}
		ll cost=-i*d+a[i];
		if(cost<mp[p]){
			se.erase(P(mp[p],p));
			mp[p]=cost;
			se.insert(P(cost,p));
		}
		while(se.size()>2)se.erase(--se.end());
	}
	return res;
}
int main(){
	cin>>n>>d;
	rep(i,n)scanf("%lld",&a[i]);
	uf=UnionFind(n);
	ll ans=0;
	while(uf.size(0)!=n){
		auto res=loop(0);
		rep(i,n/2)swap(a[i],a[n-i-1]);
		auto res2=loop(1);
		rep(i,n/2)swap(a[i],a[n-i-1]);
		rep(i,n){
			res[i]=min(res[i],res2[i]);
			if(res[i].second==-1)continue;
			if(!uf.same(i,res[i].second)){
				uf.unite(i,res[i].second);
				ans+=res[i].first;
			}
		}
	}
	cout<<ans<<endl;
}