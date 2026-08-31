#include<bits/stdc++.h>
using namespace std;
#define LL long long
#define ULL unsigned long long
#define mp make_pair
#define pb push_back
#define pii pair<int,int>
#define pll pair<LL,LL>
#define x first
#define y second
#define pi acos(-1)
#define sqr(x) ((x)*(x))
#define pdd pair<double,double>
#define MEMS(x) memset(x,-1,sizeof(x))
#define MEM(x) memset(x,0,sizeof(x))
#define less Less
#define EPS 1e-4
#define arg ARG
#define cpdd const pdd
#define rank Rank
#define KK 500
#define N 100005
LL a[200005];
vector<pair<LL,pii> > v;
void dc(int l,int r,LL d){
    if(l==r)return;
    int mid=(l+r)/2;
    LL lmin=1e18,li;
    LL rmin=1e18,ri;
    for(int i=l;i<=mid;i++){
        LL val=a[i]+(mid-i)*d;
        if(val<lmin){
            lmin=val;
            li=i;
        }
    }
    for(int i = mid+1;i<=r;i++){
        LL val=a[i]+(i-mid)*d;
        if(val<rmin){
            rmin=val;
            ri=i;
        }
        v.pb(mp(val+lmin,mp(i,li)));
    }
    for(int i = l;i<=mid;i++){
        v.pb(mp(a[i]+(mid-i)*d+rmin,mp(i,ri)));
    }
    dc(l,mid,d);
    dc(mid+1,r,d);
}
int f[200005];
int Find(int x){
    if(f[x]==x)return x;
    return f[x]=Find(f[x]);
}
int main(){
    int n,d;
    scanf("%d %d",&n,&d);
    for(int i = 1;i<=n;i++){
        scanf("%lld",&a[i]);
    }
    dc(1,n,d);
    for(int i = 1;i<=n;i++)
        f[i]=i;
    sort(v.begin(),v.end());
    LL ans=0;
    for(auto it:v){
        int a=it.y.x,b=it.y.y;
        int fa=Find(a),fb=Find(b);
        if(fa!=fb){
            f[fa]=fb;
            ans+=it.x;
        }
    }
    printf("%lld\n",ans);
}
/*


     0   
     1   1
     2   3
     3 5  1 0 0
    4*/