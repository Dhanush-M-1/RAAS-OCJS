#include<bits/stdc++.h>
#define it register int
#define ct const int
#define il inline
using namespace std;
typedef long long ll;
#define rll register ll
#define cll const ll
#define mkp make_pair
#define fir first
#define sec second
const int N=1000005;
#define P 1000000007
template<class I>
il I Min(I p,I q){return p<q?p:q;}
template<class I>
il void ckMin(I&p,I q){p=(p<q?p:q);}
int T,n,cn[N],u,v,ans,fa[N],m;
bool tag[N];
vector<int> o;
il int fd(ct x){return fa[x]^x?fa[x]=fd(fa[x]):x;}
il void mer(it u,it v,ct i){u=fd(u),v=fd(v),(u^v)&&(tag[u]+tag[v]<=1)?fa[u]=v,tag[v]|=tag[u],o.push_back(i),(ans<<=1,ans>=P?ans-=P:0):0;}
int main(){ 
	scanf("%d%d",&n,&m);it i,op;ans=1;
	for(i=1;i<=m;++i) fa[i]=i;
	for(i=1;i<=n;++i) scanf("%d%d",&op,&u),op^1?scanf("%d",&v),mer(u,v,i),0:(u=fd(u),!tag[u]?o.push_back(i),ans<<=1,ans>=P?ans-=P:0,tag[u]=1:0);
	printf("%d %d\n",ans,o.size());
	for(const int &i : o) printf("%d ",i);
	return 0;
}
