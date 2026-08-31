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
#define fi first
#define se second
#define pb push_back
#define mkp make_pair
typedef pair<int,int>pii;
typedef vector<int>vi;
#define maxn 5005
#define inf 0x3f3f3f3f

int n,tag[maxn],s[maxn],f[maxn];
void work()
{
	n=read();
	For(i,1,n)tag[i]=read(),f[i]=0;
	For(i,1,n)s[i]=read();
	For(j,2,n)
		Rep(i,j-1,1)
			if(tag[i]!=tag[j]){
				int fi=f[i],fj=f[j],val=abs(s[i]-s[j]);
				f[i]=max(f[i],fj+val);
				f[j]=max(f[j],fi+val);
			}
	cout<<*max_element(f+1,f+n+1)<<endl;
}

signed main()
{
	int T=read();
	while(T--)work();
	return 0;
}
