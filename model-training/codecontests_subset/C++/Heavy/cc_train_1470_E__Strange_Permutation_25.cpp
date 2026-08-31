#include<bits/stdc++.h>
#define ll __int128
#define ld long double
#define ull unsigned ll
#define uint unsigned int
#define db double
#define pint pair<int,int>
#define mk make_pair
#define pb push_back
#define eb emplace_back
#define ins insert
#define fi first
#define se second
#define Rep(x,y,z) for(int x=(y);x<=(z);x++)
#define Red(x,y,z) for(int x=(y);x>=(z);x--)
using namespace std;
const int MAXN=3e4+5; 
char buf[1<<12],*pp1=buf,*pp2=buf,nc;int ny;
inline char gc() {return pp1==pp2&&(pp2=(pp1=buf)+fread(buf,1,1<<12,stdin),pp1==pp2)?EOF:*pp1++;}
//inline char gc(){return getchar();}
inline ll read(){
	ll x=0;for(ny=1;nc=gc(),(nc<48||nc>57)&&nc!=EOF;)if(nc==45)ny=-1;if(nc<0)return nc;
	for(x=nc-48;nc=gc(),47<nc&&nc<58&&nc!=EOF;x=(x<<3)+(x<<1)+(nc^48));return x*ny;
}
int n,c,q,p[MAXN];
struct Node{int l,r;Node(int l=0,int r=0):l(l),r(r){}};
Node L[5][MAXN*10];ll w[5][MAXN*10];int st[5][MAXN],ed[5][MAXN];
inline ll C(int n,int m){ll ans=1;Rep(i,n-m+1,n)ans*=i;Rep(i,1,m)ans/=i;return ans;}
inline ll calc(int n,int c){if(n==0)return 1;ll ans=0;Rep(i,0,c)ans+=C(n-1,i);return ans;}
inline void Init(){
	Rep(i,1,c){
		int l=n*5+1,r=n*5+1;L[i][l]=Node(1,1);
		Red(j,n,1){
			static int s[MAXN];Rep(k,1,min(i,n-j))s[k]=j+k;
			sort(s+1,s+min(i,n-j)+1,[](int x,int y){return p[x]<p[y];});
			Rep(k,1,min(i,n-j))if(p[s[k]]>p[j])L[i][++r]=Node(j,s[k]);
			Red(k,min(i,n-j),1)if(p[s[k]]<p[j])L[i][--l]=Node(j,s[k]);
			st[i][j]=l,ed[i][j]=r;
		}w[i][l-1]=0;Rep(j,l,r)w[i][j]=w[i][j-1]+(L[i][j].r!=L[i][j].l?calc(n-L[i][j].r,i-(L[i][j].r-L[i][j].l)):1);
//		Rep(j,l,r)cout<<L[i][j].l<<" "<<L[i][j].r<<"x\t";puts("");Rep(j,l,r)cout<<w[i][j]<<"\t\t";puts("");
	}
}
inline int F(int i,int c,ll k){return lower_bound(w[c]+st[c][i],w[c]+ed[c][i]+1,k+w[c][st[c][i]-1])-w[c];}
inline int Solve(int i,ll j){
	if(j>calc(n,c))return -1;
	else{
		static Node pp[MAXN];int now=1,cnt=0,tt=c;
		for(;tt>0&&j>0;){
			int t=F(now,tt,j);//cout<<j<<" "<<t<<" "<<L[tt][t].l<<" "<<L[tt][t].r<<"\n";
			if(L[tt][t].l==L[tt][t].r)break;pp[++cnt]=L[tt][t];
			j-=w[tt][t-1]-w[tt][st[tt][now]-1],now=L[tt][t].r+1,tt-=L[tt][t].r-L[tt][t].l;
		}//Rep(k,1,cnt)cout<<pp[k].l<<" "<<pp[k].r<<"\n";
		  Rep(k,1,cnt)if(pp[k].r>=i&&pp[k].l<=i)return p[pp[k].l+pp[k].r-i];return p[i];
	}
}
int main(){
//	freopen("std.in","r",stdin);
//	freopen("std.out","w",stdout);
	for(int t=read();t--;){
		n=read(),c=read(),q=read();Rep(i,1,n)p[i]=read();Init();
		for(ll i,j;q--;)i=read(),j=read(),cout<<Solve(i,j)<<'\n';
		memset(w,0,sizeof(w)),memset(st,0,sizeof(st)),memset(ed,0,sizeof(ed));
	}
	return 0;
}



