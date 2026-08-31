#include <bits/stdc++.h>
using namespace std;
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define rep(i,n)   FOR(i,0,n)
#define pb emplace_back
typedef long long ll;
typedef pair<int,int> pint;

int a[101];
int main(){
    int n;
    cin>>n;
    rep(i,n) cin>>a[i];
    int cnt=0;
    rep(i,n){
        int t=min_element(a+i,a+n)-a;
        if(i!=t) swap(a[i],a[t]),++cnt;
    }
    rep(i,n)cout<<a[i]<<(i==n-1?"":" ");
    cout<<endl;
    cout<<cnt<<endl;
    return 0;
}
