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

vector<P>loop(bool b){
	unordered_map<int,ll>mp;//連結成分ごとの最小値
	set<P>se;//コスト、連結成分
	vector<P>res;
	rep(i,n){
		int id=(b?n-i-1:i);
		if(se.empty()){
			res.push_back(P(INFL,-1));
		}
		else{
			auto it=se.begin();
			while(it!=se.end()&&it->second==uf.find(id))it++;
			if(it!=se.end()){
				res.push_back(P(d*i+it->first+a[i],it->second));
			}
			else{
				res.push_back(P(INFL,-1));
			}
		}
		ll cost=-i*d+a[i];
		if(!mp.count(uf.find(id))||cost<mp[uf.find(id)]){
			if(mp.count(uf.find(id)))se.erase(P(mp[uf.find(id)],uf.find(id)));
			mp[uf.find(id)]=cost;
			se.insert(P(cost,uf.find(id)));
		}
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
		rep(i,n/2){
			swap(a[i],a[n-i-1]);
			swap(res2[i],res2[n-i-1]);
		}
		unordered_map<int,P>mp;
		rep(i,n){
			if(!mp.count(uf.find(i))||mp[uf.find(i)]>res[i]){
				mp[uf.find(i)]=res[i];
			}
			if(!mp.count(uf.find(i))||mp[uf.find(i)]>res2[i]){
				mp[uf.find(i)]=res2[i];
			}
		}
		for(auto p:mp){
			if(p.second.first==INFL)continue;
			if(!uf.same(p.first,p.second.second)){
				uf.unite(p.first,p.second.second);
				ans+=p.second.first;
			}
		}
	}
	cout<<ans<<endl;
}