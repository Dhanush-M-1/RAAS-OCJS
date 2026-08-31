#include<stdio.h>
#include<queue>
#include<math.h>
#include<time.h>
#include<string.h>
#include<vector>
#include<algorithm>
#include<iostream>
#include<set>
#include<map>
#include<stack>
#define LL long long
#define mem(a,b) memset(a,b,sizeof(a))
#define lowbit(a) a&(-a)
#define PI acos(-1)
#define shortime(a)  std::ios::sync_with_stdio(a);
using  namespace std;
const LL inf=16777216;
//long long cmp(node a,node b){ if(a.x==b.x) return a.r>b.r;return a.x>b.x;}
int maxn (int a,int b,int c){return max(max(a,b),max(b,c));}
int judge(int x,int y,int z)
{
    if(x<y) return y;
    if(x>z) return z;
    return x;
}
int main()
{
    int x,k,a[100005];
    scanf("%d%d",&x,&k);
    for(int i=1;i<=k;i++)
    {
        scanf("%d",&a[i]);
    }
    int n,l=0,r=x,num=1;
    scanf("%d",&n);
    int flag=-1,sum=0;
    for(int i=0;i<n;i++)
    {
        int lr,t,a1;
        scanf("%d%d",&t,&a1);
        while(t>=a[num]&&num<=k)
        {
            lr=flag*(a[num]-a[num-1]);
            sum+=lr;
            l=judge(lr+l,0,x);
            r=judge(lr+r,0,x);
            num++;
            flag=-flag;
        }
        printf("%d\n",judge(flag*(t-a[num-1])+judge(a1+sum,l,r),0,x));
    }
    return 0;
}
