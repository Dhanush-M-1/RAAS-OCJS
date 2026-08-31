#include <cstdio>
#include <cstring>
#include <iostream>
#include <string>
#include <cmath>
#include <bitset>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <algorithm>
#include <complex>
#include <unordered_map>
#include <unordered_set>
#include <random>
#include <cassert>
using namespace std;
typedef long long int ll;
typedef pair<int, int> P;
typedef pair<ll, P> Pi;
int par[200002];
int rk[200002];

void init(int n){
	for(int i=0; i<n; i++){
		par[i]=i; rk[i]=0;
	}
}

int find(int x){
	if(par[x]==x){
		return x;
	}else{
		return par[x]=find(par[x]);
	}
}

void unite(int x, int y){
	x=find(x);
	y=find(y);
	if(x==y) return;
	if(rk[x]<rk[y]){
		par[x]=y;
	}else{
		par[y]=x;
		if(rk[x]==rk[y]) rk[x]++;
	}
}

bool same(int x, int y){
	return find(x)==find(y);
}
int n;
ll d;
ll a[200001];
vector<Pi> e;
void solve(int l, int r){
	if(l==r) return;
	int m=(l+r)/2;
	int i1=l; ll mn=a[l]-(ll)l*d;
	for(int i=l+1; i<=m; i++){
		if(mn>a[i]-(ll)i*d) mn=a[i]-(ll)i*d, i1=i;
	}
	for(int i=m+1; i<=r; i++) e.push_back(Pi(a[i]+a[i1]+(ll)(i-i1)*d, P(i1, i)));
	i1=m+1, mn=a[m+1]+(ll)(m+1)*d;
	for(int i=m+2; i<=r; i++){
		if(mn>a[i]+(ll)i*d) mn=a[i]+(ll)i*d, i1=i;
	}
	for(int i=l; i<=m; i++) e.push_back(Pi(a[i]+a[i1]+(ll)(i1-i)*d, P(i1, i)));
	solve(l, m);
	solve(m+1, r);
}
int main()
{
	cin>>n>>d;
	for(int i=0; i<n; i++){
		cin>>a[i];
	}
	if(n==1){
		cout<<0<<endl;
		return 0;
	}
	solve(0, n-1);
	ll ans=0;
	sort(e.begin(), e.end());
	init(n);
	for(int i=0; i<e.size(); i++){
		int x=e[i].second.first, y=e[i].second.second;
		if(!same(x, y)){
			unite(x, y);
			ans+=e[i].first;
		}
	}
	cout<<ans<<endl;
	return 0;
}