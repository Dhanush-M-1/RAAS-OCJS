#include <bits/stdc++.h>
using namespace std;

#define rep(i,n) for(int i = 0; i < (n); ++i)
#define ll long long
#define P pair<ll,ll>
#define all(v) v.begin(),v.end()
const ll mod = 1e9+7;
const ll INF = 1e18;
const double pi = acos(-1.0);

int main(void)
{
   
    ll n; cin>>n;
    map<pair<char,ll>,bool> mp;
    rep(i,n){
        char c; ll a;
        cin>>c>>a;
        mp[make_pair(c,a)]=true;
    }
    char im[]={'S','H','C','D'};
    map<char,ll> ans;
    rep(i,4)rep(j,13){
        if(!mp[{im[i],j+1}]) cout<<im[i]<<" "<<j+1<<endl;
    }
    return 0;
}
