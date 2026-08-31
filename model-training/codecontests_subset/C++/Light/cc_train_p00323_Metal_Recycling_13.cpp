#include "bits/stdc++.h"
using namespace std;
typedef long long ll;
typedef vector<ll> V;
typedef pair<ll,ll> P;
typedef map<ll,ll> M;

#define REP(i,n) for(ll (i) = 0; (i) < (n); ++(i))


signed main(){
    ll n;
    cin >> n;
    V a(n);
    V b(n);

    queue<ll> que;
    V v(400000, 0);

    REP(i,n){
        cin >> a[i] >> b[i];
        ++v[a[i] + b[i]];
    }
    REP(i,400000){
        REP(j, 30){
            if(!j)continue;
            if(v[i] <= 1)break;
            if(v[i] & (1<<j))
                que.emplace(i + j);
        }
        v[i] %= 2;
    }

    while(!que.empty()){
        ll i = que.front();
        que.pop();

        v[i]++;

        REP(j, 30){
            if(!j)continue;
            if(v[i] <= 1)break;
            if(v[i] & (1<<j))
                que.emplace(i + j);
        }
        v[i] %= 2;
    }
    REP(i,400000){
        if(v[i])
            cout << i << " " << 0 << endl;
    }

}

