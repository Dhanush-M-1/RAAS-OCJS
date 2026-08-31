#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;

ll gcd(ll a, ll b) {
    if (a < b) swap(a, b);
    return b ? gcd(b, a % b) : a;
}

int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; ++i){
        ll a, b, c, d;
        cin >> a >> b >> c >> d;
        if (b > d || a < b) cout << "No" << endl;
        else {
            ll g = gcd(b, d);
            ll p = c + g - (c - a % g + g) % g;
            cout << (p - b >= 0 ? "Yes" : "No") << endl;
        }
    }
    return 0;
}

