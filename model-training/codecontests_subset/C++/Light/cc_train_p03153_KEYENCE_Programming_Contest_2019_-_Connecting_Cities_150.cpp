/*
读题不规范，爆零两行泪。
数据不清空，爆零两行泪。
多测不读完，爆零两行泪。
边界不特判，爆零两行泪。
贪心不证明，爆零两行泪。
D P 顺序错，爆零两行泪。
大小少等号，爆零两行泪。
变量不统一，爆零两行泪。
越界不判断，爆零两行泪。
调试不注释，爆零两行泪。
溢出不 l l，爆零两行泪。
*/
#include<bits/stdc++.h>
using namespace std;
#define int long long
#define mp make_pair
#define X first
#define Y second
#define pb push_back
const int inf=0x3f3f3f3f3f3f3f3f;
int lowbit(int x){return x&-x;}
const int N=200000;
int n,d;
int a[N+1];
pair<int,int> p[N+1];
struct bitree{
	pair<int,int> mn[N+1];
	void init(){
		for(int i=1;i<=n;i++)mn[i]=mp(inf,0);
	}
	void chkmn(int x,pair<int,int> v){
		while(x<=n)mn[x]=min(mn[x],v),x+=lowbit(x);
	}
	int Mn(int x){
		pair<int,int> res(inf,0);
		while(x)res=min(res,mn[x]),x-=lowbit(x);
		return res.Y;
	}
}bit,bit_r;
vector<pair<int,int> > eg;
struct ufset{
	int fa[N+1];
	void init(){memset(fa,0,sizeof(fa));}
	int root(int x){return fa[x]?fa[x]=root(fa[x]):x;}
	bool mrg(int x,int y){
		x=root(x);y=root(y);
		if(x==y)return false;
		return fa[x]=y,true;
	}
}ufs;
int cst(pair<int,int> x){
	if(x.X>x.Y)swap(x.X,x.Y);
	return a[x.X]+a[x.Y]+(x.Y-x.X)*d;
}
bool cmp(pair<int,int> x,pair<int,int> y){
	return cst(x)<cst(y);
}
int kruskal(){
	sort(eg.begin(),eg.end(),cmp);
	int ans=0;
//	for(int i=0;i<eg.size();i++)printf("%lld %lld\n",eg[i].X,eg[i].Y);
	for(int i=0;i<eg.size();i++)ans+=ufs.mrg(eg[i].X,eg[i].Y)*cst(eg[i]);
	return ans;
}
signed main(){
	cin>>n>>d;
	for(int i=1;i<=n;i++)scanf("%lld",a+i),p[i]=mp(a[i],i);
	sort(p+1,p+n+1);
	bit.init();bit_r.init();
	for(int i=1;i<=n;i++){
		int mn1=bit.Mn(p[i].Y-1),mn2=bit_r.Mn(n-p[i].Y);
		if(mn1)eg.pb(mp(p[i].Y,mn1));
		if(mn2)eg.pb(mp(p[i].Y,mn2));
		bit.chkmn(p[i].Y,mp(p[i].X-p[i].Y*d,p[i].Y));bit_r.chkmn(n-p[i].Y+1,mp(p[i].X+p[i].Y*d,p[i].Y));
	}
	cout<<kruskal();
	return 0;
}
/*1
3 1000
1 100 1
*/