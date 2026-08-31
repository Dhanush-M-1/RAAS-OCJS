#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
int zs,ctw,n,q,nt,nv,nfx=1,nzl,xyz,fzt[N],fw1[N],fw2[N];
void mchange()
{
    int kbl=fzt[ctw+1]-fzt[ctw];
    if(nfx==1)
    {
        fw1[ctw+1]=max(0,fw1[ctw]-kbl);
        fw2[ctw+1]=max(0,fw2[ctw]-kbl);
        nzl-=kbl; 
    }
    else
    {
        fw1[ctw+1]=min(zs,fw1[ctw]+kbl);
        fw2[ctw+1]=min(zs,fw2[ctw]+kbl);
        nzl+=kbl;
    }
    nfx=nfx*(-1); 
}
int main()
{
    //freopen("c4.in","r",stdin);
    //freopen("test.out","w",stdout);
    int i,j;
    scanf("%d",&zs);
    scanf("%d",&n);
    for(i=1;i<=n;++i)
    {
        scanf("%d",&fzt[i]);
    }
    scanf("%d",&q);
    fw2[0]=zs; 
    for(i=1;i<=q;++i)
    {
        scanf("%d%d",&nt,&nv);
        while(ctw<n&&fzt[ctw+1]<nt) 
        {
           mchange();
           ctw++;
        }
        if(nv+nzl>=fw1[ctw]&&nv+nzl<=fw2[ctw])	xyz=nv+nzl;
        if(nv+nzl<fw1[ctw]) xyz=fw1[ctw];
        if(nv+nzl>fw2[ctw]) xyz=fw2[ctw];
        int kbl=nt-fzt[ctw];
        if(nfx==1) xyz=max(0,xyz-kbl);
        else xyz=min(zs,xyz+kbl);
        printf("%d\n",xyz);
    }
    return 0;
}