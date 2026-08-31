#include<bits/stdc++.h>
#define Add(x,y) x=mymax(0,mymin(X,x+y))
using namespace std;

namespace IO
{
	const int S=(1<<20)+5;
	//Input Correlation
	char buf[S],*H,*T;
	inline char Get()
	{
		if(H==T) T=(H=buf)+fread(buf,1,S,stdin);
		if(H==T) return -1;return *H++;
	}
	inline int read()
	{
		int x=0;char c=Get();
		while(!isdigit(c)) c=Get();
		while(isdigit(c)) x=x*10+c-'0',c=Get();
		return x;
	}
	//Output Correlation
	char obuf[S],*oS=obuf,*oT=oS+S-1,c,qu[55];int qr;
	inline void flush(){fwrite(obuf,1,oS-obuf,stdout);oS=obuf;}
	inline void putc(char x){*oS++ =x;if(oS==oT) flush();}
	template <class I>inline void print(I x)
	{
		if(!x) putc('0');
		if(x<0) putc('-'),x=-x;
		while(x) qu[++qr]=x%10+'0',x/=10;
		while(qr) putc(qu[qr--]);
	}
}

inline int mymax(const int &x,const int &y){return x>y?x:y;}
inline int mymin(const int &x,const int &y){return x<y?x:y;}

using namespace IO;
const int N=100010;
int t[N],a[N],r[N];
int X,n,Q;

int main()
{
	X=read();n=read();
	for(int i=1;i<=n;i++) r[i]=read();
	Q=read();
	for(int i=1;i<=Q;i++) t[i]=read(),a[i]=read();
	int down=0,c=0,up=X,fg=-1,p1=0,p2=1,ad=0;
	while(p2<=Q)
	{
		if(t[p2]>r[p1+1]&&p1<n)
		{
			p1++;
			ad=fg*(r[p1]-r[p1-1]);
			Add(down,ad);Add(up,ad);
			c+=ad;fg=-fg;
		}
		else
		{
			int len=t[p2]-r[p1];
			int ans=mymax(down,mymin(up,a[p2]+c));
			Add(ans,fg*len);
			print(ans);putc('\n');
			p2++;
		}
	}
	flush();
	return 0;
}