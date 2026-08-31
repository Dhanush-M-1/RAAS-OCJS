#include <cstdio>
#include <cctype>
#include <algorithm>
#define repu(i,x,y) for (int i=x; i<=y; ++i)
using namespace std;

int n,m,a[100100],l[100100],r[100100],w[100100];

int getint()
{
    char ch;
    while (!isdigit(ch=getchar()));
    int x=ch-'0';
    for (; isdigit(ch=getchar()); x=x*10+ch-'0');
    return x;
}

int main()
{
    scanf("%d%d",&m,&n),r[0]=m;
    repu(i,1,n)
    {
        int t=(a[i]=getint())-a[i-1];
        if (!(i&1))
            if (l[i-1]+w[i-1]+t>m)
                l[i]=r[i]=m,w[i]=0;
            else
                l[i]=l[i-1],r[i]=min(r[i-1],m-w[i-1]-t),w[i]=w[i-1]+t;
        else
            if (r[i-1]+w[i-1]-t>=0)
                l[i]=max(l[i-1],t-w[i-1]),r[i]=r[i-1],w[i]=w[i-1]-t;
    }
    for (int q=getint(),i=0; q--;)
    {
        int t=getint(),x=getint();
        for (; i<n && a[i+1]<=t; ++i);
        int ans=max(min(x+w[i],r[i]+w[i]),l[i]+w[i]);
        if (i&1)
            ans=min(m,ans+t-a[i]);
        else
            ans=max(0,ans+a[i]-t);
        printf("%d\n",ans);
    }
    return 0;
}