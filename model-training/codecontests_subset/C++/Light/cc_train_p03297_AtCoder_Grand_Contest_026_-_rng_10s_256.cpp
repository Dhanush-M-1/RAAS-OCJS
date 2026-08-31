#include<bits/stdc++.h>
using namespace std;
using ll = int64_t;
ll gcd(ll a, ll b){return b ? gcd(b, a % b) : a;}
int main(){
    ll T;
    cin >> T;
    for(ll query = 0; query < T; query++){
        ll A, B, C, D;
        cin >> A >> B >> C >> D;
        if(A < B || B > D){
            cout << "No";
        }else if(C >= B){
            cout << "Yes";
        }else{
            ll g = gcd(B, D);
            if(B - g + A % g <= C) cout << "Yes";
            else cout << "No";
        }
        cout << endl;
    }
    return 0;
}
