#include<bits/stdc++.h>
#define For(i,a,b) for(register int i=(a);i<=(b);++i)
#define Rep(i,a,b) for(register int i=(a);i>=(b);--i)
#define int long long
using namespace std;
inline int read()
{
    char c=getchar();int x=0;bool f=0;
    for(;!isdigit(c);c=getchar())f^=!(c^45);
    for(;isdigit(c);c=getchar())x=(x<<1)+(x<<3)+(c^48);
    if(f)x=-x;return x;
}

#define mod 1000000007
struct modint{
    int x;
    modint(int o=0){x=o;}
    modint &operator = (int o){return x=o,*this;}
    modint &operator +=(modint o){return x=x+o.x>=mod?x+o.x-mod:x+o.x,*this;}
    modint &operator -=(modint o){return x=x-o.x<0?x-o.x+mod:x-o.x,*this;}
    modint &operator *=(modint o){return x=1ll*x*o.x%mod,*this;}
    modint &operator ^=(int b){
        modint a=*this,c=1;
        for(;b;b>>=1,a*=a)if(b&1)c*=a;
        return x=c.x,*this;
    }
    modint &operator /=(modint o){return *this *=o^=mod-2;}
    modint &operator +=(int o){return x=x+o>=mod?x+o-mod:x+o,*this;}
    modint &operator -=(int o){return x=x-o<0?x-o+mod:x-o,*this;}
    modint &operator *=(int o){return x=1ll*x*o%mod,*this;}
    modint &operator /=(int o){return *this *= ((modint(o))^=mod-2);}
    template<class I>friend modint operator +(modint a,I b){return a+=b;}
    template<class I>friend modint operator -(modint a,I b){return a-=b;}
    template<class I>friend modint operator *(modint a,I b){return a*=b;}
    template<class I>friend modint operator /(modint a,I b){return a/=b;}
    friend modint operator ^(modint a,int b){return a^=b;}
    friend bool operator ==(modint a,int b){return a.x==b;}
    friend bool operator !=(modint a,int b){return a.x!=b;}
    bool operator ! () {return !x;}
    modint operator - () {return x?mod-x:0;}
};

#define fi first
#define se second
#define pb push_back
#define mkp make_pair
typedef pair<int,int>pii;

#define maxn 200005
#define inf 0x3f3f3f3f
int n,c[maxn],b[maxn],sb[maxn];
int bsum=0;
modint f[maxn],g[maxn];
inline modint sumg(int l,int r){
	if(!l)return g[r];
	return g[r]-g[l-1];
}
signed main()
{
	n=read();
	For(i,1,n)c[i]=read();
	For(i,1,n-1)b[i]=read(),sb[i]=sb[i-1]+b[i];
	int Q=read(),x=read(),all=0,now=0;
	f[0]=1;
	For(i,1,n){
		For(j,0,all)g[j]=f[j],f[j]=0;
		all+=c[i];
		For(j,1,all)g[j]+=g[j-1];
		now+=x,now+=sb[i-1];
		if(now>all){
			puts("0");
			return 0;
		}
		For(j,0,all)
			f[j]=sumg(max(j-c[i],0ll),j);
//		cout<<now<<" "<<all<<endl; 
		if(now>0){
			For(j,0,now-1)
				f[j]=0;
		}
//		For(j,0,all)cout<<f[j].x<<" ";puts("");
	}
	modint res=0;
	For(i,max(0ll,now),all)res+=f[i];
	cout<<res.x;
	return 0;
}
/*

*/