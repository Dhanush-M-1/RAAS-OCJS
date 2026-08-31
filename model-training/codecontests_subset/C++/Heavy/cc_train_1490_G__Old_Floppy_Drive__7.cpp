#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define loop(a,b) for(ll i=a;i<b;i++)
#define pii pair<ll,ll>
#define F first
#define S second
#define mp make_pair
#define pb push_back
ll t,n,m,x,y,bal,MX;
vector<ll>a,pre,mx;
ll tell(ll x){
    ll st=1,en=n,md,ans=0;
    while(st<=en){
        md=(st+en)/2;
        if(mx[md]>=x) ans=md,en=md-1;
        else st=md+1;
    }
    return ans;
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    cin>>t;
    while(t--){
        cin>>n>>m;
        a=pre=mx=vector<ll>(n+2);
        for(ll i=1;i<=n;++i){
            cin>>a[i];
            pre[i]=pre[i-1]+a[i];
            mx[i]=max(mx[i-1],pre[i]);
        }
        bal=pre[n];
        MX=mx[n];
        for(ll i=1;i<=m;++i){
            cin>>x;
            if(x-MX<=0) cout<<tell(x)-1<<' ';
            else if(bal<=0) cout<<-1<<' ';
            else{
                y=ceil(((x-MX)*1.0)/bal);
                cout<<y*n+tell(x-y*bal)-1<<' ';
            }
        }
        cout<<'\n';
    }

    return 0;
}
