#include <bits/stdc++.h>
#define int long long
using namespace std;
int MOD=1e9+7;
int id[500005], sz[500005];
int find(int x){
	while(x!=id[x]){
		id[x]=id[id[x]];
		x=id[x];
	}
	return x;
}
void unite(int i, int j){
	int x=find(i), y=find(j);
	if(sz[x]<sz[y]) swap(x, y);
	sz[x]+=sz[y];
	id[y]=x;
}
signed main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin>>n>>m;
	for(int i=0;i<=m;i++){
		id[i]=i;
		sz[i]=1;
	}
	int ans=1;
	vector<int>v;
	for(int i=0;i<n;i++){
		int k, x, y;
		cin>>k>>x;
		if(k==1) y=0;
		else cin>>y;
		if(find(x)!=find(y)){
			unite(x, y);
			ans=(ans*2)%MOD;
			v.push_back(i+1);
		}
	}
	cout<<ans<<" "<<v.size()<<"\n";
	for(int i:v) cout<<i<<" ";
		cout<<endl;
}