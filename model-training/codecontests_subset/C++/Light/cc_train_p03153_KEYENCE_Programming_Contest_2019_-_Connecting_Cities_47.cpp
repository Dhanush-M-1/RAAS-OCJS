#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll,int>pli;
typedef pair<ll,pair<int,int>>plii;
const pli M(1ll<<60,0);
const int N=2e5+5;
struct node{
	int lb,rb,md;
	pli m[4];plii al;
}t[N<<2];
int n,D,a[N],i;ll ans;
bool b[N];
inline void set1(int i,int l){
	t[i].m[0]=pli(a[l]-1ll*l*D,l);
	t[i].m[1]=pli(a[l]+1ll*l*D,l);
	t[i].m[2]=t[i].m[3]=M;t[i].al=make_pair(1ll<<60,make_pair(0,0));
}
inline void set2(int i,int l){
	t[i].m[2]=pli(a[l]-1ll*l*D,l);
	t[i].m[3]=pli(a[l]+1ll*l*D,l);
	t[i].m[0]=t[i].m[1]=M;t[i].al=make_pair(1ll<<60,make_pair(0,0));
}
inline plii F(pli a,pli b){return make_pair(a.first+b.first,make_pair(a.second,b.second));}
inline void maintain(int i){
	for(int j=0;j<4;++j)t[i].m[j]=min(t[i<<1].m[j],t[i<<1|1].m[j]);
	t[i].al=min(min(t[i<<1].al,t[i<<1|1].al),min(F(t[i<<1].m[0],t[i<<1|1].m[3]),
		F(t[i<<1].m[2],t[i<<1|1].m[1])));
}
void build(int i,int l,int r){
	t[i].lb=l;t[i].rb=r;t[i].md=l+r>>1;
	if(l==r)return l==1?set1(i,l):set2(i,l);
	build(i<<1,l,t[i].md);build(i<<1|1,t[i].md+1,r);
	maintain(i);
}
void mdy(int i,int l){
	if(t[i].lb==t[i].rb)return set1(i,l);
	mdy(i<<1|(t[i].md<l),l);maintain(i);
}
int main(){
	scanf("%d%d",&n,&D);for(i=1;i<=n;++i)scanf("%d",a+i);build(1,1,n);
	b[1]=1;
	for(i=1;i<n;++i){
		int x=t[1].al.second.first,y=t[1].al.second.second;
		ans+=t[1].al.first;if(b[x])b[y]=1,mdy(1,y);else b[x]=1,mdy(1,x);
	}
	printf("%lld\n",ans);
	return 0;
}