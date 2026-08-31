#include <bits/stdc++.h>

using namespace std;

class union_find{
public:
	vector<int> arr;
	union_find(int n){
		arr.resize(n);
		fill(arr.begin(),arr.end(),-1);
	}
	int find(int x){
		return arr[x]<0?x:arr[x]=find(arr[x]);
	}
	void unite(int x,int y){
		x=find(x),y=find(y);
		if(x==y) return;
		if(arr[x]>arr[y]) swap(x,y);
		arr[x]+=arr[y];
		arr[y]=x;
	}
	bool connected(int x,int y){
		return find(x) == find(y);
	}
	int size(int x){
		return -arr[find(x)];
	}
};
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int n,m;
	cin >> n >> m;
	vector<bool> ta(m);
	int kos=0;
	union_find uf(m);
	vector<vector<int>> ad(m);
	
	function<void(int,int)> dfs=[&](int cur,int par){
		ta[cur]=true;
		for(int ch:ad[cur]){
			if(ch==par) continue;
			if(ta[ch]) continue;
			ta[ch]=true;
			dfs(ch,cur);
		}
	};
	vector<int> res;
	for(int i=0;i<n;i++){
		int k;
		cin >> k;
		if(k==1){
			int a;
			cin >> a;
			a--;
			if(ta[a]) continue;
			ta[a]=true;
			dfs(a,-1);
			res.push_back(i);
		}else{
			int a,b;
			cin >> a >> b;
			a--,b--;
			if(uf.connected(a,b)) continue;
			uf.unite(a,b);
			ad[a].push_back(b);
			ad[b].push_back(a);
			
			if(ta[a]){
				if(ta[b]) continue;
				res.push_back(i);
				dfs(b,-1);
			}else{
				res.push_back(i);
				if(ta[b]) dfs(a,-1);
			}
		}
	}
	
	long long c=1;
	long long mod=1000000007;
	for(int i=0;i<res.size();i++) c=c*2%mod;
	cout << c << " " << res.size() << "\n";
	for(int i=0;i<res.size();i++){
		cout << res[i]+1 << " ";
	}
	cout << "\n";
	return 0;
}