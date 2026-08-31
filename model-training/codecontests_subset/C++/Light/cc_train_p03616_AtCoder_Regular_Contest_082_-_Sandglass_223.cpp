#include <bits/stdc++.h>
#define REP(i,n) for(int i=0;i<(int)(n);i++)
#define ALL(x) (x).begin(),(x).end()
#define LL long long

using namespace std;

int main(){

    LL X;cin>>X;
    int K;cin>>K;
    LL r[K+1];REP(i,K)cin>>r[i+1];
    r[0]=0;

    LL sum[K+1];
    sum[0]=0;
    REP(i,K)sum[i+1]=sum[i]+(r[i+1]-r[i])*(i%2==0 ? 1:-1);
    pair<LL,LL> range[K+1];
    range[0]={0LL,X};

    REP(i,K){
        range[i+1].first=range[i].first;range[i+1].second=range[i].second;
        if(i%2==0)range[i+1].first=max(range[i+1].first,sum[i+1]);
        else range[i+1].second =min(range[i+1].second,X+sum[i+1]);
    }

    LL a0[K+1];a0[0]=0;
    LL ax[K+1];ax[0]=X;

    REP(i,K){
        a0[i+1]=a0[i]+(r[i+1]-r[i])*(i%2==0 ? -1:1);
        a0[i+1]=max(0LL,a0[i+1]);
        a0[i+1]=min(X,a0[i+1]);

    }

    REP(i,K){
        ax[i+1]=ax[i]+(r[i+1]-r[i])*(i%2==0 ? -1:+1);
        ax[i+1]=max(0LL,ax[i+1]);
        ax[i+1]=min(X,ax[i+1]);
    }

    int q;cin>>q;
    REP(i,q){
        LL t,a;cin>>t>>a;
        LL ans=0;
        int k = upper_bound(r,r+K+1,t)-r -1;
        if(a>range[k].first&&a<range[k].second)ans = a - sum[k];
        else if(a<=range[k].first)ans = a0[k];
        else ans = ax[k];

        ans += (t-r[k])*(k%2 ==0 ? -1:1);
        ans = max(0LL,ans);
        ans = min(X,ans);

        cout<<ans<<endl;

    }

    return 0;
}