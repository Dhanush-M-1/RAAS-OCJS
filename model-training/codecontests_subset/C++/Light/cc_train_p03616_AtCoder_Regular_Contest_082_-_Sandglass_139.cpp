#include<cstdio>
#include<algorithm>
#include<vector>
using namespace std;
inline int read()
{
	int x;char c;
	while((c=getchar())<'0'||c>'9');
	for(x=c-'0';(c=getchar())>='0'&&c<='9';)x=x*10+c-'0';
	return x;
}
#define MN 100000
int r[MN+5],t[MN+5],a[MN+5],s[MN+5],sl,sr,f[MN+5];
vector<int> v[MN+5];
bool cmp(int x,int y){return a[x]<a[y];}
int gf(int k){return f[k]?f[k]=gf(f[k]):k;}
int main()
{
	int x,k,q,i,j,ss=0;
	x=read();k=read();
	for(i=1;i<=k;++i)r[i]=read();
	q=read();
	for(i=1;i<=q;++i)
	{
		t[i]=read();a[i]=read();s[i]=i;
		v[upper_bound(r+1,r+k+1,t[i])-r-1].push_back(i);
	}
	sort(s+(sl=1),s+(sr=q)+1,cmp);
	for(i=0;i<v[0].size();++i)t[v[0][i]]=max(a[v[0][i]]-t[v[0][i]],0);
	for(i=1;i<=k;++i)
		if(i&1)
		{
			ss-=r[i]-r[i-1];
			if(a[s[sl]]+ss<=0)
			{
				for(j=sl;j<=sr&&a[s[j]]+ss<=0;++j);
				a[s[--j]]=-ss;
				while(sl<j)f[s[sl++]]=s[j];
			}
			for(j=0;j<v[i].size();++j)
				t[v[i][j]]=min(a[gf(v[i][j])]+ss+t[v[i][j]]-r[i],x);
		}
		else
		{
			ss+=r[i]-r[i-1];
			if(a[s[sr]]+ss>=x)
			{
				for(j=sr;j>=sl&&a[s[j]]+ss>=x;--j);
				a[s[++j]]=x-ss;
				while(sr>j)f[s[sr--]]=s[j];
			}
			for(j=0;j<v[i].size();++j)
				t[v[i][j]]=max(a[gf(v[i][j])]+ss-t[v[i][j]]+r[i],0);
		}
	for(i=1;i<=q;++i)printf("%d\n",t[i]);
}