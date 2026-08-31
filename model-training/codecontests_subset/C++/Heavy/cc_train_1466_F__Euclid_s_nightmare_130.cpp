#include <iostream>
#include <set>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <map>
#include <vector>
#include <assert.h>
#include <queue>
typedef long long ll;
const int mod=1e9+7;
using namespace std;
int n,m,k,v,ans=1,x,y;
int a[500005],par[500005];
vector<int>res;
int find(int x){
    return par[x]==x?x:par[x]=find(par[x]);
}
int main()
{
    scanf("%d%d",&n,&m);
    for(int i=1;i<=m;++i)
    {
        par[i]=i;
    }
    for(int i=1;i<=n;++i){
        scanf("%d",&k);
        a[1]=a[2]=m+1;
        for(int j=1;j<=k;++j){
            scanf("%d",&a[j]);
        }
        if((x=find(a[1]))!=(y=find(a[2]))){
            par[y]=x;
            ans=2ll*ans%mod;
            res.push_back(i);
        }
    }
    printf("%d %d\n",ans,(int)res.size());
    for(auto &x:res){
        printf("%d ",x);
    }
    return 0;
}