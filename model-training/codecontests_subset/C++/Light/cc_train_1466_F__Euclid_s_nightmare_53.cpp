#include<bits/stdc++.h>
using namespace std;
const int mod=1e9+7;
const int maxn=5e5+5;
int f[maxn],ans[maxn];
int _find(int x){return x!=f[x]?f[x]=_find(f[x]):f[x];}
int main(){
    int n,m,id=0,num=1;scanf("%d%d",&n,&m);
    for(int i=1;i<=m;i++)f[i]=i;
    for(int i=1;i<=n;i++){
        int k,a,b;scanf("%d",&k);
        if(k==1)a=0,scanf("%d",&b);
        else scanf("%d%d",&a,&b);
        int aa=_find(a),bb=_find(b);
        if(aa!=bb){
            f[aa]=bb;
            ans[id++]=i;
            (num*=2)%=mod;
        }
    }
    printf("%d %d\n",num,id);
    for(int i=0;i<id;i++)printf("%d ",ans[i]);printf("\n");
    return 0;
}
