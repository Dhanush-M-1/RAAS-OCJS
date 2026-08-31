#include<vector>
#include<cmath>
#include<map>
#include<cstdlib>
#include<iostream>
#include<sstream>
#include<fstream>
#include<string>
#include<algorithm>
#include<cstring>
#include<cstdio>
#include<set>
#include<stack>
#include<bitset>
#include<functional>
#include<ctime>
#include<queue>
#include<deque>
#include<complex>
#include<cassert>
using namespace std;
#define pb push_back
#define pf push_front
typedef long long lint;
typedef complex<double> P;
#define mp make_pair
#define fi first
#define se second
typedef pair<int,int> pint;
typedef pair<int,lint> pl;
typedef pair<lint,pint> tint;
#define All(s) s.begin(),s.end()
#define rAll(s) s.rbegin(),s.rend()
#define REP(i,a,b) for(int i=a;i<b;i++)
#define rep(i,n) REP(i,0,n)
//問題文および制約はちゃんと確認しよう！
//サイズは10^5じゃなくて2×10^5とかかもしれないし、重要な制約・条件を見落としているかも
//とりあえずサンプルを読んでから解法を考えよう？
struct unionf{
	vector <int> data;
	unionf(int size):data(size,-1){}
	bool unions(int x,int y){
		x=root(x);y=root(y);
		if(x!=y){
			if(data[y]<data[x]){int d=x;x=y;y=d;}
			data[x]+=data[y];data[y]=x;
		}
		return x!=y;
	}
	bool finds(int x,int y){
		return root(x)==root(y);
	}
	int root(int x){
		return data[x]<0?x:data[x]=root(data[x]);
	}
	int find(int x){
		return -data[x];
	}
};
lint d[400100];int from[400100];
vector<pl> gr[400100];
priority_queue<tint> q;
vector<tint> ed;
int main()
{
	int n,a;lint D;cin>>n>>D;
	rep(i,n){
		cin>>a;gr[i].pb(mp(i+n,a));gr[i+n].pb(mp(i,a));
	}
	rep(i,n-1){
		gr[i].pb(mp(i+1,D));gr[i+1].pb(mp(i,D));
	}
	memset(from,-1,sizeof(from));
	rep(i,n) q.push(mp(0,mp(i+n,i+n)));
	while(!q.empty()){
		tint p=q.top();q.pop();
		lint di=-p.fi;int x=p.se.fi,y=p.se.se;
		//cout<<di<<' '<<x<<' '<<y<<endl;
		if(from[x]>=0){
			if(y!=from[x]) ed.pb(mp(d[x]+di,mp(y-n,from[x]-n)));
		}
		else{
			from[x]=y;d[x]=di;
			rep(i,gr[x].size()){
				q.push(mp(-di-gr[x][i].se,mp(gr[x][i].fi,y)));
			}
		}
	}
	unionf uni(n+10);
	lint out=0;
	rep(i,ed.size()){
		lint c=ed[i].fi;int x=ed[i].se.fi,y=ed[i].se.se;
		//cout<<c<<' '<<x<<' '<<y<<endl;
		if(uni.finds(x,y)) continue;
		out+=c;uni.unions(x,y);
	}
	cout<<out<<endl;
}
