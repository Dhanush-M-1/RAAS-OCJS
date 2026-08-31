#include <bits/stdc++.h>
using namespace std;
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define rep(i,n)   FOR(i,0,n)
#define pb emplace_back
typedef long long ll;
typedef pair<ll,ll> pint;

pint a[1001];
int main(){
    int n,ai;
    cin>>n;
    rep(i,n){
        cin>>ai;
        a[i]={ai%(n-1),ai};
    }
    sort(a,a+n);
    FOR(i,1,n){
        if(a[i].first==a[i-1].first){
            cout<<a[i].second<<" "<<a[i-1].second<<endl;
            return 0;
        }
    }
    return 0;
}
