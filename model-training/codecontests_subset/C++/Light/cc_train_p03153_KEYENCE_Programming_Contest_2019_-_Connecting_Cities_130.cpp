#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N=2e5+105;
const ll MAXN=9e18+105;
struct node{
    ll u,v,w;
    node(ll u,ll v,ll w):u(u),v(v),w(w){}
    bool operator <(const node&A)const{return w<A.w;}
};
ll n,d,ans,cnt;
ll A[N],lv[N],fa[N],deep[N];
vector<node>edge;
int find(int x){
    if(fa[x]==x)return x;
    else return fa[x]=find(fa[x]);
}
void combine(int x,int y){
	x=find(x),y=find(y);
	if(lv[x]<lv[y])fa[x]=y;
	else if(lv[x]==lv[y])fa[y]=x,lv[x]++;
	else fa[y]=x;
}
void divide(int L,int R){
	if(L==R)return; 
	ll mid=(L+R)/2,pL,pR,mL=MAXN,mR=MAXN;
	for(int i=L;i<=mid;i++)if(A[i]-d*i<mL)mL=A[i]-d*i,pL=i;
	for(int i=mid+1;i<=R;i++)if(A[i]+d*i<mR)mR=A[i]+d*i,pR=i;
	for(int i=L;i<=mid;i++)edge.push_back(node(i,pR,mR+A[i]-d*i));
	for(int i=mid+1;i<=R;i++)edge.push_back(node(pL,i,mL+A[i]+d*i));
	divide(L,mid),divide(mid+1,R);
}
void kruskal(){
	for(int i=1;i<=n;i++)fa[i]=i;
	for(int i=0;i<edge.size();i++){
		int u=edge[i].u,v=edge[i].v;
		if(find(u)!=find(v)){
			ans+=edge[i].w;
			combine(u,v);
			cnt++;
		}
		if(cnt==n-1)break;
	}
	return;
}
int main(){
	scanf("%d%d",&n,&d);
	for(int i=1;i<=n;i++)scanf("%d",&A[i]);
	divide(1,n);
	sort(edge.begin(),edge.end());
	kruskal();
	cout<<ans<<endl;
	return 0;
} 