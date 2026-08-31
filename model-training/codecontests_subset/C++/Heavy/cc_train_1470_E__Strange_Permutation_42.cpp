#include<bits/stdc++.h>
#define mz 1000000007
using namespace std;

pair<long long,long long> pp;
vector <pair<long long,long long> > vb[30005],vs[30005];
long long p[30005];
long long c[30005][10],s[30005][10];
long long bg[30005][10],sm[30005][10],sumb[30005][10],sums[30005][10];
long long y,wtf;
long long n,k,x,z,now;

void go(long long l)
{
    if(now==0 || l>x || y==0)
        return;
    long long lp=l-1,r=n-1,mid;
    if(y>sums[n-1][now]-sums[lp][now])
    {
        y-=(sums[n-1][now]-sums[lp][now]);
        y--;
        if(y==0)
            return ;
        while(l!=r)
        {
            mid=(l+r)/2;
            if(sumb[n-1][now]-sumb[mid][now]>=y)
                l=mid+1;
            else
                r=mid;
        }
        y-=sumb[n-1][now]-sumb[l][now];
        for(long long i=0;i<vb[l].size();i++)
        {
            if(now<vb[l][i].second-l)
                continue;
            if(y<=s[n-vb[l][i].second][now-(vb[l][i].second-l)])
            {
                if((l<=x) && (vb[l][i].second>=x))
                {
                    z=p[vb[l][i].second-(x-l)];
                }
                now-=(vb[l][i].second-l);
                go(vb[l][i].second+1);
                return ;
            }
            else
                y-=s[n-vb[l][i].second][now-(vb[l][i].second-l)];
        }
    }
    else
    {
        while(l!=r)
        {
            mid=(l+r)/2;
            if((sums[mid][now]-sums[lp][now])>=y)
                r=mid;
            else
                l=mid+1;
        }
        y-=sums[l-1][now]-sums[lp][now];
        for(long long i=0;i<vs[l].size();i++)
        {
            if(now<vs[l][i].second-l)
                continue;
            if(y<=s[n-vs[l][i].second][now-(vs[l][i].second-l)])
            {
                if((l<=x) && (vs[l][i].second>=x))
                {
                    z=p[vs[l][i].second-(x-l)];
                }
                now-=(vs[l][i].second-l);
                go(vs[l][i].second+1);
                return ;
            }
            else
                y-=s[n-vs[l][i].second][now-(vs[l][i].second-l)];
        }
    }
}

signed main()
{
    c[1][0]=c[0][0]=1;
    for(long long j=0;j<=4;j++)
        s[1][j]=s[0][j]=1;
    for(long long i=2;i<=30000;i++)
    {
        c[i][0]=s[i][0]=1;
        for(int j=1;j<=4;j++)
        {
            c[i][j]=c[i-1][j-1]+c[i-1][j];
            s[i][j]=s[i][j-1]+c[i][j];
        }
    }
    long long t,q;
    scanf("%lld",&t);
    while(t--)
    {
        scanf("%lld%lld%lld",&n,&k,&q);
        for(long long i=1;i<=n;i++)
            scanf("%lld",&p[i]);
        for(long long i=1;i<n;i++)
        {
            vs[i].clear();
            vb[i].clear();
            for(long long j=1;j<=k;j++)
                bg[i][j]=sm[i][j]=0;
            for(long long j=i+1;j<=n && j-i<=k;j++)
            {
                pp.first=p[j];
                pp.second=j;
                if(p[j]<p[i])
                {
                    vs[i].push_back(pp);
                    for(int l=j-i;l<=k;l++)
                        sm[i][l]+=s[n-j][l-(j-i)];
                }
                else
                {
                    vb[i].push_back(pp);
                    for(int l=j-i;l<=k;l++)
                        bg[i][l]+=s[n-j][l-(j-i)];

                }
            }
            sort(vs[i].begin(),vs[i].end());
            sort(vb[i].begin(),vb[i].end());
            for(int j=1;j<=k;j++)
            {
                sumb[i][j]=sumb[i-1][j]+bg[i][j];
                sums[i][j]=sums[i-1][j]+sm[i][j];
            }
        }
        wtf=sumb[n-1][k]+1+sums[n-1][k];
        while(q--)
        {
            scanf("%lld%lld",&x,&y);
            if(y>wtf)
                z=-1;
            else
            {
                z=p[x];
                now=k;
                go(1);
            }
            printf("%lld\n",z);
        }
    }
    return 0;
}
