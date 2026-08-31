#include<bits/stdc++.h>
#define Tp template<typename Ty>
#define Ts template<typename Ty,typename... Ar>
#define W while
#define I inline
#define RI register int
#define int long long
#define Cn const
#define CI Cn int&
#define gc getchar
#define D isdigit(c=gc())
#define pc(c) putchar((c))
using namespace std;
namespace Debug{
	Tp I void _debug(Cn char* f,Ty t){cerr<<f<<'='<<t<<endl;}
	Ts I void _debug(Cn char* f,Ty x,Ar... y){W(*f!=',') cerr<<*f++;cerr<<'='<<x<<",";_debug(f+1,y...);}
	Tp ostream& operator<<(ostream& os,Cn vector<Ty>& V){os<<"[";for(Cn auto& vv:V) os<<vv<<",";os<<"]";return os;}
	#define gdb(...) _debug(#__VA_ARGS__,__VA_ARGS__)
}using namespace Debug;
namespace FastIO{
	Tp I void read(Ty& x){char c;int f=1;x=0;W(!D) f=c^'-'?1:-1;W(x=(x<<3)+(x<<1)+(c&15),D);x*=f;}
	Ts I void read(Ty& x,Ar&... y){read(x),read(y...);}
	Tp I void write(Ty x){x<0&&(pc('-'),x=-x,0),x<10?(pc(x+'0'),0):(write(x/10),pc(x%10+'0'),0);}
	Tp I void writeln(Cn Ty& x){write(x),pc('\n');}
}using namespace FastIO;
Cn int N=5010;
int T,n,Ans,tag[N],s[N],dp[N];
signed main(){
	RI i,j,t;read(T);W(T--){
		read(n);for(i=1;i<=n;i++) read(tag[i]);Ans=0;memset(dp,0,sizeof(dp));
		for(i=1;i<=n;i++) read(s[i]);
		for(i=1;i<=n;i++) for(j=i-1;j>=1;j--) if(tag[i]^tag[j]) t=dp[i],dp[i]=max(dp[i],dp[j]+abs(s[i]-s[j])),dp[j]=max(dp[j],t+abs(s[i]-s[j]));
		for(i=1;i<=n;i++) Ans=max(dp[i],Ans);writeln(Ans);
	}return 0;
}
