#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
#include<cmath>
using namespace std;
int X,k,r[100010],Q;
struct node{int t,a,id;
}q[100010];int ans[100010];
bool cmp(node x,node y) {return x.t<y.t;}
int pls(int x,int y){return max(0,min(X,x+y));}
int main()
{
    scanf("%d%d",&X,&k);
    for (int i=1;i<=k;i++) scanf("%d",&r[i]);
    scanf("%d",&Q);
    for (int i=1;i<=Q;i++) 
    {
        scanf("%d%d",&q[i].t,&q[i].a);q[i].id=i;
    }
    sort(q+1,q+Q+1,cmp);
    int topr=0,topq=1,sum=0,down=0,up=X,add=0,js=-1;
    int cnt;
    while (topq<=Q)
    {
        if (r[topr+1]<q[topq].t&&topr<k)
        {
            topr++;
            add=js*(r[topr]-r[topr-1]);
            down=pls(down,add);up=pls(up,add);
            sum+=add;js=-js;
        } else
        {
            cnt=q[topq].t-r[topr];
            ans[q[topq].id]=pls(max(down,min(up,q[topq].a+sum)),js*cnt);
            topq++;
        }
    }
    for (int i=1;i<=Q;i++) printf("%d\n",ans[i]);
    
}