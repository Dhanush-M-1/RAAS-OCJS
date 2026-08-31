#include<bits/stdc++.h>
using namespace std;
#define int long long
int n,val[200100],m,fa[200100],res;
struct node{
	int x,y,z;
	node(int u=0,int v=0,int w=0){x=u,y=v,z=w;}
	friend bool operator<(const node&u,const node&v){return u.z<v.z;}
};
vector<node>v;
inline void read(int &x){
	x=0;
	char c=getchar();
	while(c>'9'||c<'0')c=getchar();
	while(c>='0'&&c<='9')x=(x<<3)+(x<<1)+(c^48),c=getchar();
}
inline void print(int x){
	if(x<=9)putchar('0'+x);
	else print(x/10),putchar('0'+x%10);
}
void solve(int l,int r){
	if(l==r)return;
	int mid=(l+r)>>1;
	int ml=l,mr=r,mn;
	mn=0x3f3f3f3f3f3f3f3f;
	for(int i=l;i<=mid;i++)if(val[i]-i*m<mn)mn=val[i]-i*m,ml=i;
	mn=0x3f3f3f3f3f3f3f3f;
	for(int i=r;i>mid;i--)if(val[i]+i*m<mn)mn=val[i]+i*m,mr=i;
	for(int i=l;i<=mid;i++)v.push_back(node(i,mr,val[i]+val[mr]+(mr-i)*m));
	for(int i=r;i>mid;i--)v.push_back(node(ml,i,val[ml]+val[i]+(i-ml)*m));
	solve(l,mid),solve(mid+1,r);
}
int find(int x){
	return fa[x]==x?x:fa[x]=find(fa[x]);
}
bool merge(int x,int y){
	x=find(x),y=find(y);
	if(x==y)return false;
	fa[x]=y;
	return true;
}
signed main(){
	read(n),read(m);
	for(int i=1;i<=n;i++)read(val[i]),fa[i]=i;
	solve(1,n),sort(v.begin(),v.end());
	for(auto i:v){
		if(n==1)break;
		if(merge(i.x,i.y))n--,res+=i.z;
	}
	print(res);
	return 0;
}