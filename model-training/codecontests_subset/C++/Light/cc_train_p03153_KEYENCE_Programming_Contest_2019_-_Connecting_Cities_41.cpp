#include<bits/stdc++.h>
using namespace std;
#define ran 200020
#define i64 long long int
int n;
vector<pair<i64,pair<int,int> > > w;
i64 a[ran], d, u[ran], v[ran];
void add_edge(int x,int y){
	w.push_back(make_pair(labs(x-y)*d+a[x]+a[y], make_pair(x,y)));
}
void dfs(int s,int e){
	if(s == e)return;
	int m = (s + e)/2;
	dfs(s, m);
	dfs(m+1, e);
	int A = s, B = e;
	for(int i=s; i<=m; i++)if(u[i] < u[A])A = i;
	for(int i=m+1; i<=e; i++)if(v[i] < v[B])B = i;
	for(int i=s; i<=m; i++)add_edge(B, i);
	for(int i=m+1; i<=e; i++)add_edge(A, i);
}
int ace[ran];
int ancestor(int x){return x-ace[x]?ace[x]=ancestor(ace[x]):x;}
int main(){
	ios::sync_with_stdio(false);
	cin >> n >> d;
	for(int i=0; i<n; i++){
		cin >> a[i];
		u[i] = a[i] - i * d;
		v[i] = a[i] + i * d;
		ace[i] = i;
	}
	dfs(0,n-1);
	sort(w.begin(),w.end());
	i64 res = 0;
	for(auto p : w){
		int x = p.second.first, y = p.second.second;
		x = ancestor(x);
		y = ancestor(y);
		if(x == y)continue;
		ace[x] = y;
		res += p.first;
	}
	cout << res << endl;
	return 0;
}
