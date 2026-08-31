#include<iostream>
#include<cstdio>
#include<algorithm>
#include<cstring>
#define ll long long
using namespace std;
inline int read(){
	int x=0,f=1;char ch;
	do{ch=getchar();if(ch=='-')f=-1;}while(ch<'0'||ch>'9');
	do{x=x*10+ch-'0';ch=getchar();}while(ch>='0'&&ch<='9');
	return x*f;
}
const int N=200010;
const ll INF=0x3f3f3f3f3f3f3f3f;
ll da[2][N],db[2][N],a[N];
int n;ll d;
inline int cmin(ll*num,int x,int y){
	if (num[x]<=num[y]) return x;
	else return y;
}
struct Data{
	int mna[2],mnb[2];
	pair<ll,int> ans;
}T[N<<2];
inline void pushup(int o){
	for (int i=0;i<2;++i){
		T[o].mna[i]=cmin(da[i],T[o<<1].mna[i],T[o<<1|1].mna[i]);
		T[o].mnb[i]=cmin(db[i],T[o<<1].mnb[i],T[o<<1|1].mnb[i]);
	}
	T[o].ans=min(T[o<<1].ans,T[o<<1|1].ans);
	ll tans=da[1][T[o<<1].mna[1]]+db[0][T[o<<1|1].mnb[0]];
	T[o].ans=min(T[o].ans,make_pair(tans,T[o<<1].mna[1]));
	tans=db[1][T[o<<1].mnb[1]]+da[0][T[o<<1|1].mna[0]];
	T[o].ans=min(T[o].ans,make_pair(tans,T[o<<1|1].mna[0]));
}
inline void build(int o,int l,int r){
	if (l==r){
		T[o].ans=make_pair(INF,l);
		T[o].mna[0]=T[o].mna[1]=T[o].mnb[0]=T[o].mnb[1]=l;
		return;
	}
	int mid=(l+r)>>1;
	build(o<<1,l,mid),build(o<<1|1,mid+1,r);
	pushup(o);
}
inline void qset(int o,int l,int r,int x){
	if (l==r){
		da[0][l]=da[1][l]=INF;
		db[0][l]=1ll*l*d+a[l],db[1][l]=-1ll*l*d+a[l];
		return;
	}
	int mid=(l+r)>>1;
	if (x<=mid) qset(o<<1,l,mid,x);
	else qset(o<<1|1,mid+1,r,x);
	pushup(o);
}
int main(){
	n=read(),d=read();
	for (int i=1;i<=n;++i) a[i]=read();
	for (int i=1;i<=n;++i){
		da[0][i]=1ll*i*d+a[i],da[1][i]=-1ll*i*d+a[i];
		db[0][i]=db[1][i]=INF;
	}
	build(1,1,n);
	ll ans=0;
	qset(1,1,n,1);
	for (int i=1;i<n;++i){
		ans+=T[1].ans.first;
		int wh=T[1].ans.second;
		qset(1,1,n,wh);
	}
	printf("%lld\n",ans);
	return 0;
}