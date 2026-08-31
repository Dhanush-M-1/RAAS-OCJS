#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
const int N=2e5+10,M=1e9+7,OO=0x3f3f3f3f;

int n;
int arr[N];
ll pre[N];

ll seg[4*N];

void build(int si=0,int ss=0,int se=n-1){
    if(ss==se){
        seg[si]=pre[ss];
        return;
    }
    int md=ss+(se-ss)/2,lf=si*2+1,rt=si*2+2;
    build(lf,ss,md);
    build(rt,md+1,se);
    seg[si]=max(seg[lf],seg[rt]);
}


int go_for(ll val,int si=0,int ss=0,int se=n-1){
    if(seg[si]<val) return -1;
    if(ss==se) return ss;
    int md=ss+(se-ss)/2,lf=si*2+1,rt=si*2+2;
    if(seg[lf]>=val) return go_for(val,lf,ss,md);
    return go_for(val,rt,md+1,se);
}

int main(){

    //freopen("haa.txt","r",stdin);
    //freopen("myfile.txt","w",stdout);


    int t;
    scanf("%d",&t);
    while(t--){
        int m;
        scanf("%d%d",&n,&m);
        for(int i=0;i<n;++i)
            scanf("%d",arr+i);
        pre[0]=arr[0];
        for(int i=1;i<n;++i)
            pre[i]=pre[i-1]+arr[i];

        build();

        while(m--){
            int x;
            scanf("%d",&x);
            int cur=go_for(x);
            if(cur==-1&&pre[n-1]<=0){
                printf("-1 ");
                continue;
            }
            else if(cur!=-1){
                printf("%d ",cur);
                continue;
            }
            else{
                int lo=1,hi=1e9;
                while(lo<hi){
                    int md=lo+(hi-lo)/2;
                    if(md*1ll*pre[n-1]+seg[0]<x) lo=md+1;
                    else hi=md;
                }
                ll cnt=lo*1ll*n+go_for(x-lo*pre[n-1]);
                printf("%lld ",cnt);
            }
        }
        puts("");

    }

    return 0;
}
