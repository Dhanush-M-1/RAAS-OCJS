#include <cstdio>

inline int Min(const int a,const int b){return a<b?a:b;}
inline int Max(const int a,const int b){return a>b?a:b;}

int X,k,q,r[100005],t[100005],a[100005],Ans;

int main()
{
    scanf("%d%d",&X,&k);
    for(int i=1;i<=k;++i)scanf("%d",&r[i]);
    scanf("%d",&q);
    for(int i=1;i<=q;++i)scanf("%d%d",&t[i],&a[i]);
    int Minn=0,Maxn=X,t1=0,t2=1,f=-1,Now=0,p=0;
    while(t2<=q)
        if(t[t2]>r[t1+1]&&t1<k)
        {
            ++t1,Now=f*(r[t1]-r[t1-1]);
            Minn=Max(0,Min(X,Minn+Now));
            Maxn=Max(0,Min(X,Maxn+Now));
            p+=Now,f*=-1;
        }
        else
        {
            Ans=Max(Minn,Min(Maxn,a[t2]+p));
            Ans=Max(0,Min(X,Ans+f*(t[t2]-r[t1])));
            printf("%d\n",Ans),++t2;
        }
    return 0;
}
