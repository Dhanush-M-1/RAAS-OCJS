#include <bits/stdc++.h>
using namespace std;
typedef long long lint;
typedef long double llf;
typedef pair<lint, int> pi;
const int MAXN = 200005;

struct disj{
	int pa[MAXN];
	void init(int n){
		iota(pa, pa + n + 1, 0);
	}
	int find(int x){
		return pa[x] = (pa[x] == x ? x : find(pa[x]));
	}
	bool uni(int p, int q){
		p = find(p);
		q = find(q);
		if(p == q) return 0;
		pa[q] = p; return 1;
	}
}disj;

struct edg{
	int s, e;
	lint x;
	bool operator<(const edg &ee)const{
		return x < ee.x;
	}
};

int n, a[MAXN], proc[MAXN];
int sz[MAXN], msz[MAXN];
vector<edg> ans;
vector<pi> gph[MAXN];
vector<int> cdfn;

void dfs(int x, int p){
	cdfn.push_back(x);
	sz[x] = 1;
	msz[x] = 0;
	for(auto &i : gph[x]){
		if(!proc[i.second] && i.second != p){
			dfs(i.second, x);
			sz[x] += sz[i.second];
			msz[x] = max(msz[x], sz[i.second]);
		}
	}
}

int get_center(int x){
	cdfn.clear();
	dfs(x, -1);
	pi ans(1e9, x);
	for(auto &i : cdfn){
		int w = max(msz[i], sz[x] - sz[i]);
		ans = min(ans, pi(w, i));
	}
	return ans.second;
}

vector<pi> dfn;
lint dis[MAXN];

void dfs2(int x, int p){
	dfn.push_back(pi(a[x] + dis[x], x));
	for(auto &i : gph[x]){
		if(proc[i.second] || i.second == p) continue;
		dis[i.second] = dis[x] + i.first;
		dfs2(i.second, x);
	}
}

int main(){
	scanf("%d",&n);
  int d; scanf("%d",&d);
	for(int i=1; i<=n; i++) scanf("%d",&a[i]);
	for(int i=1; i<n; i++){
		int s = i, e = i + 1, x = d;
		gph[s].push_back(pi(x, e));
		gph[e].push_back(pi(x, s));
	}
	queue<int> que;
	que.push(1);
	while(!que.empty()){
		int x = que.front();
		que.pop();
		x = get_center(x);
		dfn.clear();
		dis[x] = 0;
		dfs2(x, -1);
		sort(dfn.begin(), dfn.end());
		for(int i=1; i<dfn.size(); i++){
			ans.push_back({dfn[0].second, dfn[i].second, 
					dfn[0].first + dfn[i].first});
		}
		proc[x] = 1;
		for(auto &i : gph[x]){
			if(!proc[i.second]){
				que.push(i.second);
			}
		}
	}
	sort(ans.begin(), ans.end());
	disj.init(n);
	lint dap = 0;
	for(auto &i : ans){
		if(disj.uni(i.s, i.e)) dap += i.x;
	}
	cout << dap << endl;
}
