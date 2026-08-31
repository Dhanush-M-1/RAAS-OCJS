#include<bits/stdc++.h>
using namespace std;
map<int,int>mp;
const int maxn = 5e5 + 10;
typedef long long ll;
const ll mode = 1e9+7;
ll bitcount[65];
ll a[maxn];
int pre[maxn];
int find(int x){
	if(x==pre[x]) return x;
	else return pre[x]  = find(pre[x]);
}
bool unions(int x,int y){
	int xx = find(x);
	int yy = find(y);
	if(xx==yy) return false;
	pre[xx]=yy;
	return true;
}
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	vector<int>ans;
	for(int i=1;i<=m+1;i++) pre[i] = i;
	for(int i=1;i<=n;i++){
		int a,b=m+1,k;
		scanf("%d%d",&k,&a);
		if(k>1) scanf("%d",&b);
		if(unions(a,b))	ans.push_back(i);
	}
	int res = 1;

	for(int i=0;i<ans.size();i++) res=res*2%mode;
	printf("%d %d\n",res,ans.size());
	for(auto v:ans){
		printf("%d ",v);
	}
	return 0;
}
// 101
// 110

