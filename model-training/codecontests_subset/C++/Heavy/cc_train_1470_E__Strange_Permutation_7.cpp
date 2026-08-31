//starusc
#include<bits/stdc++.h>
using namespace std;
#define int long long
inline int read(){
	int x=0,f=1,c=getchar();
	while(!isdigit(c)){if(c=='-')f=-1;c=getchar();}
	while(isdigit(c)){x=(x<<1)+(x<<3)+(c^48);c=getchar();}
	return f==1?x:-x;
}
const int N=3e4+4;
int n,c,Q,p[N],st[5][N],ed[5][N],C[N][5],a[6];
inline bool comp(int x,int y){
	return p[x]<p[y];
}
inline void solve(){
	n=read();c=read();Q=read();
	for(int i=1;i<=n;i++)p[i]=read();
	for(int j=0;j<=c;j++)
		for(int i=1;i<=n;i++){
			st[j][i]=st[j][i-1];
			for(int u=min(n,i+j);u>i;u--)if(p[u]<p[i]){
				st[j][i]+=C[n-u][j-u+i];
			}
			ed[j][i]=st[j][i]+C[n-i][j]-1;
		}
	for(int x,k,r,nw,v;Q--;){
		x=read();k=read();
		if(k>C[n][c]){puts("-1");continue;}
		r=c;nw=0;
		while(1){
			v=min(upper_bound(st[r]+1,st[r]+n+1,k+st[r][nw]-1)-st[r],
				  upper_bound(ed[r]+1,ed[r]+n+1,k+st[r][nw]-1,greater<int>())-ed[r]);
			if(v>x){cout<<p[x]<<"\n";break;}
			k-=st[r][v-1]-st[r][nw];//
			r=min(r,n-v);//
			for(int i=0;i<=r;i++)a[i]=v+i;
			sort(a,a+r+1,comp);
			for(int i=0;i<=r;i++){
				if(k<=C[n-a[i]][r-a[i]+v]){
					r-=a[i]-v;
					nw=a[i];
					break;
				}
				else k-=C[n-a[i]][r-a[i]+v];
			}
			if(nw>=x){cout<<p[nw-(x-v)]<<"\n";break;}
		}
	}
}
signed main(){
	for(int i=0;i<=4;i++)st[i][0]=C[0][i]=1;
	for(int i=1;i<N;i++){
		C[i][0]=1;
		C[i][1]=C[i][0]+(i-1);
		C[i][2]=C[i][1]+(i-1)*(i-2)/2;
		C[i][3]=C[i][2]+(i-1)*(i-2)/2*(i-3)/3;
		C[i][4]=C[i][3]+(i-1)*(i-2)/2*(i-3)/3*(i-4)/4;
	}
	for(int T=read();T--;)solve();
	return (0-0);
}