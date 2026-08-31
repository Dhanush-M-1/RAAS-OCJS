#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll a, b, c, d;

ll gcd(ll a, ll b){
    return a == 0 ? b : gcd(b % a, a);
}

bool solve(ll a, ll b, ll c, ll d){
    if(d < b || a < b) return false;
    if(c >= b) return true;
    ll g = gcd(b, d);
    ll rem = g - a % g;
    return (b - c) <= rem;
}

int main(){
    int T;
    cin >> T;
    while(T--){
        cin >> a >> b >> c >> d;
        if(solve(a, b, c, d)) printf("Yes\n");
        else printf("No\n");
    }

}