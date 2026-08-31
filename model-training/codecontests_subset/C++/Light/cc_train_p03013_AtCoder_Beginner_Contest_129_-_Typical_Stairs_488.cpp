#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll mod=1e9+7;
int main()
{
    bool vis[100009]={};
    ll a[100009]={1,1,2};
    ll n,k,x;
    cin>>k>>n;
    for(int i=1;i<=n;i++)
    {
        cin>>x;
        vis[x]=true;
    }
    for(int i=1;i<=k;i++)
    {
        if(vis[i]) a[i]=0;
        else a[i]=(a[i-1]%mod+(i>=2?a[i-2]:0)%mod)%mod;
    }
    cout<<a[k];
}
