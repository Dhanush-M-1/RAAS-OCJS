#include <bits/stdc++.h>
#define endl '\n'
#define INF 0x3f3f3f3f
#define Inf 1000000000000000000LL
#define LL long long
#define pb push_back
#define mp make_pair
#define F first
#define S second
using namespace std;
typedef pair<int,int>pii;
const int mod=1e9+7;
int n,m;
vector<int>ans;
int fa[500010];
int find(int a){
	return fa[a]==a?a:fa[a]=find(fa[a]);
}
bool unite(int a,int b){
	a=find(a),b=find(b);
	fa[a]=b;
	return a!=b;
}
void init(int n){
	for(int i=1;i<=n;i++)fa[i]=i;
}
int main() {
	cin>>n>>m;
	init(m+1);
	for(int i=1,k;i<=n;i++){
		scanf("%d",&k);
		int fa;
		scanf("%d",&fa);
		int fb=m+1;
		if(k>1)scanf("%d",&fb);
		if(unite(fa,fb))ans.pb(i);
	}
	int res=1;
	for(int i=0;i<ans.size();i++)res=res*2%mod;
	printf("%d %d\n",res,(int)ans.size());
	for(auto v:ans)printf("%d ",v);
	puts("");
	return 0;
}
