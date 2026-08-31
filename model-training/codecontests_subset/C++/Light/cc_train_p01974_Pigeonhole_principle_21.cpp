#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
typedef pair<int,int> pii;
#define rep(i,n) for(ll i=0;i<(ll)(n);i++)
#define all(a) (a).begin(),(a).end()
#define pb emplace_back
#define INF (1e9+1)

int main(){
    int n;
    cin>>n;
    
    vector<int> v(n);
    rep(i,n)cin>>v[i];
    
    rep(i,n){
        rep(j,n){
            if(i==j)continue;
            if(abs(v[i]-v[j])%(n-1)==0){
                cout<<v[i]<<" "<<v[j]<<endl;
                return 0;
            }
        }
    }
}

