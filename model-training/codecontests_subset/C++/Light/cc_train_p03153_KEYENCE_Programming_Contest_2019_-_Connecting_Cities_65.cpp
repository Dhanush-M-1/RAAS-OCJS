#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef double D;
typedef pair<ll,ll> P;
#define M 1000000007
#define F first
#define S second
#define PB push_back
#define INF 100000000000000000
ll n,d,ans,a[200005],ml[200005],mr[200005];
int main(void){
    cin>>n>>d;
    ans=d*(n-1);
    for(int i=0;i<n;i++){
        cin>>a[i];
        ans+=a[i];
    }
    for(int i=0;i<n;i++)mr[i]=INF,ml[i]=INF;
    ml[0]=a[0];
    for(ll i=1;i<n;i++){
        ml[i]=min(ml[i-1],a[i]-i*d);
    }
    mr[n-1]=a[n-1]+d*(n-1);
    for(ll i=n-2;i>=0;i--){
        mr[i]=min(mr[i+1],a[i]+i*d);
    }
    for(ll i=1;i+1<n;i++){
        ans+=min(i*d+ml[i],mr[i]-i*d);
    }
    cout<<ans<<endl;
}
