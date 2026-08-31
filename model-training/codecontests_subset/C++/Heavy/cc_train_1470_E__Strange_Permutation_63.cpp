#include <bits/stdc++.h>
using namespace std;
int T,n,c,q,p[30010],st[10],t,now;
long long L[10][30010],R[10][30010],f[10][30010];
bool cmp(int x,int y){
	return p[now+x]<p[now+y];
}
int qry(int pos,long long id){
	if(id>f[c][1]) return -1;
	int op=c;now=1;
	while(now<=n){
		int l=now,r=n,res,mid;
		while(l<=r){
			mid=(l+r)>>1;
			if(L[op][now]-L[op][mid]<id&&R[op][now]-R[op][mid]<=f[op][now]-id) l=mid+1,res=mid;
			else r=mid-1; 
		}
		if(res>pos) return p[pos];
		id-=(L[op][now]-L[op][res]),now=res,t=0;
		for(int i=0;i<=op&&now+i<=n;i++) st[++t]=i;
		sort(st+1,st+t+1,cmp);
		int pp=0;
		for(int i=1;i<=t;i++){
			if(id<=f[op-st[i]][now+st[i]+1]){
				pp=st[i];
				break;
			}
			else id-=f[op-st[i]][now+st[i]+1];
		}
		if(pp+now>=pos) return p[2*now-pos+pp];
		op-=pp,now+=pp+1;
	}
	return p[pos];
}
void solve(){
	scanf("%d%d%d",&n,&c,&q);
	for(int i=1;i<=n;i++) scanf("%d",&p[i]);
	for(int i=0;i<=c;i++){
		f[i][n+1]=1,L[i][n+1]=R[i][n+1]=0;
		for(int j=n;j>=1;j--){
			f[i][j]=f[i][j+1],L[i][j]=L[i][j+1],R[i][j]=R[i][j+1];
			for(int k=1;k<=i&&j+k<=n;k++){
				long long v=f[i-k][j+k+1];
				f[i][j]+=v;
				assert(f[i][j]<1e18);
				if(p[j]>p[j+k]) L[i][j]+=v;
				else R[i][j]+=v;
			}
		}
	}
	while(q--){
		int pos;
		long long id;
		scanf("%d%lld",&pos,&id);
		printf("%d\n",qry(pos,id));
	}
}
int main(){
	scanf("%d",&T);
	while(T--) solve();
}